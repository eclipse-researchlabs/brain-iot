/*******************************************************************************
 * Copyright (C) 2021 LINKS Foundation
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
package eu.brain.iot.warehouse.events;

import eu.brain.iot.robot.api.Coordinate;

/*
 * Response of warehouse backend with the new picking point info to Robot Behavior
*/

public class NewPickPointResponse extends WarehouseCommand{
	
	public boolean hasNewPoint = false;
	
	public Coordinate pickPoint;
	
	

}
