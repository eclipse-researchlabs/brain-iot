package eu.brain.iot.warehouse.events;

import eu.brain.iot.robot.api.Coordinate;

/*
 * Robot behaviour Notices the warehouse backend the cart at the picking point has been moved. 
The backend will updat the table property 'isAssigned' from True to False 
 * */

public class CartMovedNotice extends WarehouseCommand{

	public Coordinate pickPoint;
}
