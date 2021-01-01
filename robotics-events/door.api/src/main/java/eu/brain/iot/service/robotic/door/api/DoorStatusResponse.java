/*******************************************************************************
 * Copyright (C) 2021 LINKS Foundation
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
package eu.brain.iot.service.robotic.door.api;

import eu.brain.iot.service.robotic.door.api.DoorStatusRequest.State;

import eu.brain.iot.eventing.api.BrainIoTEvent;

public class DoorStatusResponse extends BrainIoTEvent {

	public String doorId;
	
	public State currentState;
	
}
