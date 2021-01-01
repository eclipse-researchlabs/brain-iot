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

/*
 * Check current action is finished or not if Robot Behavior wants to explicitly check the status
 */
public class QueryState extends RobotCommand {

	 
	public Command command;
}
