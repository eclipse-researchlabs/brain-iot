package eu.brain.iot.robot.events;

import eu.brain.iot.robot.api.Command;

public class PickCart extends RobotCommand {
	
	/* 
	 * Used for matching with the command of QueryStateValueReturn received by Robot Behaviour 
	 * who will know the QueryStateValueReturn is the response of which robot command(WriteGoTo, pickCart, placeCart) 
	 */
	public Command command = Command.PICK;
	
	public int markerID;   // from the cart marker ID, ROS Edge Node will get the cart name to be used in the ROS service
}
