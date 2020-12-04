package eu.brain.iot.warehouse.events;

import eu.brain.iot.eventing.api.BrainIoTEvent;

public class WarehouseCommand extends BrainIoTEvent {
	
	public static final int ALL_ROBOT_BEHAVIOURS = -1;
	
	public int robotID;

}
