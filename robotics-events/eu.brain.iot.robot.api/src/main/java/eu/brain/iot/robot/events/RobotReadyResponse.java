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

/* 
 * ROS Edge Node report if it has been initialized for connecting with robot 
 * After receiving this event, Robot Behaviour can start to ask warehouse backend for a new picking point for the first iteration 
 */
public class RobotReadyResponse extends RobotCommand {
	
	public boolean isReady;
}
