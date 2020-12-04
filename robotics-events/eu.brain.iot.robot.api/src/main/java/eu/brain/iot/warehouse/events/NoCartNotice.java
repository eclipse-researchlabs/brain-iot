package eu.brain.iot.warehouse.events;

import eu.brain.iot.robot.api.Coordinate;
/*
 * Notice the warehouse backend there is not any cart at the picking point
 *  for updating the place 'isAsigned' from True to False
 * */
public class NoCartNotice extends WarehouseCommand{

	public Coordinate pickPoint;
}
