package eu.brain.iot.warehouse.events;

import eu.brain.iot.robot.api.Coordinate;

/*
 * The dockAuxliaryPoint field is fixed point for a specific robot in the storage side in front of Door on the way to docking area. 
 * Robot will stop here waiting for checking marker  cmd or new GoTo event if door is open.
 * */

public class DockingResponse extends WarehouseCommand{
	
	public Coordinate dockingPoint;

	
	public Coordinate dockAuxliaryPoint;
}
