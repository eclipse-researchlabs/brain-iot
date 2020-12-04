package eu.brain.iot.robot.events;

import eu.brain.iot.robot.api.Command;

public class PlaceCart extends RobotCommand {

	/* 
	 * Used for matching with the command field of QueryStateValueReturn received by Robot Behaviour  
	 * who will know the QueryStateValueReturn is the response of which robot command(WriteGoTo, pickCart, placeCart)
	 */
	public Command command = Command.PLACE;
	
}
