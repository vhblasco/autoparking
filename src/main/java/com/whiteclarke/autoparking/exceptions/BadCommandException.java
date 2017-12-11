package com.whiteclarke.autoparking.exceptions;
/**
 * BadCommandException. 
 * Exception to rise when the input is not the expected.
 * Expected input:
 *       [0-BOUNDARY_Y],[0-BOUNDARY_X]:[LFR]+
 * 
 * @author vhblasco
 */

public class BadCommandException extends AutoParkingException{

	private static final long serialVersionUID = -6817322630855570L;
	
	
	public BadCommandException(String message) {
		super(message);
	}


}
