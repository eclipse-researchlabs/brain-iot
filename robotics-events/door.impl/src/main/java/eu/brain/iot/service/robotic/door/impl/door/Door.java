/*******************************************************************************
 * Copyright (C) 2021 LINKS Foundation
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
package eu.brain.iot.service.robotic.door.impl.door;

public class Door {

	double data;
	
	public Door() {
		
	}
	
	public Door(double data) {
		
		this.data = data;
	}

	public double getData() {
		return data;
	}

	public void setData(double data) {
		this.data = data;
	}

}
