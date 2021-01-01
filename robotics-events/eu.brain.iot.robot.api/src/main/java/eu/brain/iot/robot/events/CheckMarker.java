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

public class CheckMarker extends RobotCommand {

	/* 
	 * after received this command, robot will scan the QR Code its camera can see, 
	 * ROS Edge Node will reply with the 'CheckValueReturn' with the scanned marker ID.
	 * 
	 */
}
