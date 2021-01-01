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

public class NewStoragePointResponse extends WarehouseCommand{

	public int markerID;  // cart marker ID, is used to identify the Place position.
	
	public boolean hasNewPoint = false;
	
	public Coordinate storagePoint;
	
	// fixed point in the picking side in front of Door where robot will stop here for checking the door is open or not, on the way to storage area  
	public Coordinate storageAuxliaryPoint;
	
}
