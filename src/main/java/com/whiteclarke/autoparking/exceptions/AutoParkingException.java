package com.whiteclarke.autoparking.exceptions;
/**
 * AutoParkingException abstract class.
 * This class is father of other AutoParkingExceptions
 * 
 * @author vhblasco
 */

public abstract class AutoParkingException extends Exception{

	private static final long serialVersionUID = -6292906838198445017L;
	private String message;
	
	
	public AutoParkingException(String message) {
		super();
		this.message = message;
	}


	public String getMessage() {
		return message;
	}

}
