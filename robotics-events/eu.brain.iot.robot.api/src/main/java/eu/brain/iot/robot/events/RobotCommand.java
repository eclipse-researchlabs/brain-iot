package eu.brain.iot.robot.events;

import eu.brain.iot.eventing.api.BrainIoTEvent;

public abstract class RobotCommand extends BrainIoTEvent {

	public static final int ALL_ROBOTS = -1;
	
	public int robotID;
}
