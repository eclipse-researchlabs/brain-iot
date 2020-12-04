package eu.brain.iot.robot.events;

/* 
 * ROS Edge Node report if it has been initialized for connecting with robot 
 * After receiving this event, Robot Behaviour can start to ask warehouse backend for a new picking point for the first iteration 
 */
public class RobotReadyResponse extends RobotCommand {
	
	public boolean isReady;
}
