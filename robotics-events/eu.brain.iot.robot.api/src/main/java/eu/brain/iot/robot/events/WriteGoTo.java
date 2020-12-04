package eu.brain.iot.robot.events;

import eu.brain.iot.robot.api.Coordinate;
import eu.brain.iot.robot.api.Command;

public class WriteGoTo extends RobotCommand {
	
	/* 
	 * Used for matching with the mission of QueryStateValueReturn received by Robot Behaviour  
	 * who will know the QueryStateValueReturn is the response of which robot command(WriteGoTo, pickCart, placeCart)
	 */
	public Command command = Command.GOTO;  

	public Coordinate coordinate;
}
