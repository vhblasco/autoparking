package com.whiteclarke.autoparking.exceptions;
/**
 * BadInitialPositionException.
 * Exception to rise when the Initial Position is not the expected.
 * The expected Initial Position is:
 * 		[0-BOUNDARY_Y],[0-BOUNDARY_X] 
 * 
 * @author vhblasco
 */

public class BadInitialPositionException extends AutoParkingException{

	private static final long serialVersionUID = 6102291342737471014L;

	public BadInitialPositionException(String message) {
		super(message);
	}	
}
