package com.whiteclarke.autoparking.exceptions;
/**
 * PositionOutOfBoundariesException
 * Exception to rise when the Position is out of boundaries.
 * The boundaries are between:
 * 		[0-BOUNDARY_Y]
 * and
 * 		[0-BOUNDARY_X]
 *  
 * @author vhblasco
 */

public class PositionOutOfBoundariesException extends AutoParkingException{

	private static final long serialVersionUID = -6292906838198445017L;	
	
	public PositionOutOfBoundariesException(String message) {
		super(message);
	}

}
