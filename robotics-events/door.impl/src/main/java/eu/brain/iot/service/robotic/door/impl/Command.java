/*******************************************************************************
 * Copyright (C) 2021 LINKS Foundation
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
package eu.brain.iot.service.robotic.door.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import eu.brain.iot.service.robotic.door.impl.door.Door;


public class Command {

	public  void  writeOpenDoor(String IP, int PORT, String path){

		
		String request = "http://"+IP+":"+PORT+path;  //"/door1/door_controller/command"
		Door d =new Door(1.0); 
		System.out.println(getJson(d));
		String jsonObject = postResponse(request, getJson(d));
		System.out.println(jsonObject);
	}
	public  void  writeCloseDoor(String IP, int PORT, String path){
		
		
		String request = "http://"+IP+":"+PORT+path;
		Door d =new Door(0.0); 
		System.out.println(getJson(d));
		String jsonObject = postResponse(request, getJson(d));
		System.out.println(jsonObject);
	}
	
	
	private static String postResponse(String request, String jsonObjectin) {
		String jsonObject ="";
		
		// Step2: Now pass JSON File Data to REST Service
		try {
			URL url = new URL(request);
			URLConnection connection = url.openConnection();
			connection.setDoOutput(true);
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);
			OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
			out.write(jsonObjectin.toString());
			out.close();

			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			jsonObject="";
			String str="";
			while ((str=in.readLine()) != null) {
				jsonObject+=str;
			}
			System.out.println("\nDOOR REST Service Invoked Successfully..");
			in.close();
		} catch (Exception e) {
			System.out.println("\nError while calling DOOR REST Service");
			System.out.println(e);
			e.printStackTrace(System.out);
		}
		
		return jsonObject;
	}
	
	private static String getJson(Object c){	

	  
		ObjectMapper mapper = new ObjectMapper();
  
	try {
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

		
		//Convert object to JSON string
		String 			jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(c);
		return jsonInString;
		
		
	} catch (JsonGenerationException e) {
		e.printStackTrace();
	} catch (JsonMappingException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	return "NULL";
	
	}
	
}
