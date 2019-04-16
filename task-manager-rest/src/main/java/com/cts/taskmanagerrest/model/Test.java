package com.cts.taskmanagerrest.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Test {
	private String val1;
	private String val2;

	public String getVal1() {
		return val1;
	}

	public void setVal1(String val1) {
		this.val1 = val1;
	}

	public String getVal2() {
		return val2;
	}

	public void setVal2(String val2) {
		this.val2 = val2;
	}
	
	@Override
	public String toString() {
		ObjectMapper om=new ObjectMapper();
		String value=null;
		try {
			value=om.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
		
	}

}
