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
 * The dockAuxliaryPoint field is fixed point for a specific robot in the storage side in front of Door on the way to docking area. 
 * Robot will stop here waiting for checking marker  cmd or new GoTo event if door is open.
 * */

public class DockingResponse extends WarehouseCommand{
	
	public Coordinate dockingPoint;

	
	public Coordinate dockAuxliaryPoint;
}
