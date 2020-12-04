package eu.brain.iot.warehouse.events;

import eu.brain.iot.robot.api.Coordinate;

public class NewStoragePointResponse extends WarehouseCommand{

	public int markerID;  // cart marker ID, is used to identify the Place position.
	
	public boolean hasNewPoint = false;
	
	public Coordinate storagePoint;
	
	// fixed point in the picking side in front of Door where robot will stop here for checking the door is open or not, on the way to storage area  
	public Coordinate storageAuxliaryPoint;
	
}