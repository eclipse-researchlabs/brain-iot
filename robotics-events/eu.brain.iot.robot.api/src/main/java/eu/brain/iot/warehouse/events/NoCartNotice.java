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
 * Notice the warehouse backend there is not any cart at the picking point
 *  for updating the place 'isAsigned' from True to False
 * */
public class NoCartNotice extends WarehouseCommand{

	public Coordinate pickPoint;
}
