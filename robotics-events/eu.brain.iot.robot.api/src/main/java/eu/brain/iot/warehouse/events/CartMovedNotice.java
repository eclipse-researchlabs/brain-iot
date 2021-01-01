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
 * Robot behaviour Notices the warehouse backend the cart at the picking point has been moved. 
The backend will updat the table property 'isAssigned' from True to False 
 * */

public class CartMovedNotice extends WarehouseCommand{

	public Coordinate pickPoint;
}
