/*******************************************************************************
 * Copyright (C) 2021 LINKS Foundation
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
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
