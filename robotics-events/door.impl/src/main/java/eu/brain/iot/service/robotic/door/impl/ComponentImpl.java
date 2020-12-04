package eu.brain.iot.service.robotic.door.impl;

import static eu.brain.iot.service.robotic.door.api.DoorStatusRequest.State.CLOSED;
import static eu.brain.iot.service.robotic.door.api.DoorStatusRequest.State.OPEN;
import static org.osgi.service.component.annotations.ConfigurationPolicy.REQUIRE;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

import eu.brain.iot.service.robotic.door.api.DoorStatusRequest;
import eu.brain.iot.service.robotic.door.api.DoorStatusRequest.State;
import eu.brain.iot.service.robotic.door.api.DoorStatusResponse;

import eu.brain.iot.eventing.annotation.SmartBehaviourDefinition;
import eu.brain.iot.eventing.api.EventBus;
import eu.brain.iot.eventing.api.SmartBehaviour;

@Component(configurationPid="eu.brain.iot.example.robot.Door",
		configurationPolicy=REQUIRE,
		service = {})

@SmartBehaviourDefinition(consumed = {DoorStatusRequest.class},
author = "UGA", name = "Smart Door",
description = "Implements a remote Smart Door.")

public class ComponentImpl implements SmartBehaviour<DoorStatusRequest> {

	private Command cmd =new Command();

	@ObjectClassDefinition
	public static @interface Config {
		@AttributeDefinition(description="The IP of the door")
		String host();
		@AttributeDefinition(description="The Port of the door")
		int port();
		
		@AttributeDefinition(description="The identifier for the door")
		String id();
		
		@AttributeDefinition(description="The URL resource for the door")
		String path();
	}
	
	@Reference
	EventBus eventBus;
	
	private Config config;
	
	private ServiceRegistration<?> reg;
	
	private ExecutorService worker;
	
	private DoorDigitalTwin door = new DoorDigitalTwin();
	
	@Activate
	void start(BundleContext context, Config config, Map<String, Object> props) {
		this.config = config;
		
		worker = Executors.newSingleThreadExecutor();
		
		worker.execute(() -> {
			cmd.writeCloseDoor(config.host(), config.port(), config.path());
			door.setOpen(false);
		});
		
		Dictionary<String, Object> serviceProps = new Hashtable<>(props.entrySet().stream()
			.filter(e -> !e.getKey().startsWith("."))
			.collect(Collectors.toMap(Entry::getKey, Entry::getValue)));
		
		serviceProps.put(SmartBehaviourDefinition.PREFIX_ + "filter", 
				String.format("(|(doorId=%s)(doorId=%s))", config.id(), DoorStatusRequest.ALL_DOORS));
		
		reg = context.registerService(SmartBehaviour.class, this, serviceProps);
		
	}
	
	@Deactivate
	void stop() {
		reg.unregister();
		worker.shutdown();
		try {
			worker.awaitTermination(1, TimeUnit.SECONDS);
		} catch (InterruptedException ie) {
			// Propagate the interrupt
			Thread.currentThread().interrupt();
		}
	}
	
	
	public void notify(DoorStatusRequest event) {
		
		switch(event.targetState) {
		case CLOSED:
			worker.execute(() -> {
				
				if(door.isOpen()) {
					cmd.writeCloseDoor(config.host(), config.port(), config.path());
					door.setOpen(false);
				}
				
				sendResponse(CLOSED);
			});
			break;
		case OPEN:
			worker.execute(() -> {
				
				if(!door.isOpen()) {
					cmd.writeOpenDoor(config.host(), config.port(), config.path());
					door.setOpen(true);
				}
				
				sendResponse(OPEN);
			});
			break;
		case QUERY:
			worker.execute(() -> {
				sendResponse(door.isOpen() ? OPEN : CLOSED);
			});
			break;
		default:
			System.out.println("Argh! Received an unknown door status request " + event.targetState);
			break;
		
		}
	}

	private void sendResponse(State currentState) {
		DoorStatusResponse response = new DoorStatusResponse();
		response.doorId = config.id();
		response.currentState = currentState;
		eventBus.deliver(response);
	}
	

    
}
