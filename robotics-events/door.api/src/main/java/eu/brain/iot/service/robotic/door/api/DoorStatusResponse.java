package eu.brain.iot.service.robotic.door.api;

import eu.brain.iot.service.robotic.door.api.DoorStatusRequest.State;

import eu.brain.iot.eventing.api.BrainIoTEvent;

public class DoorStatusResponse extends BrainIoTEvent {

	public String doorId;
	
	public State currentState;
	
}