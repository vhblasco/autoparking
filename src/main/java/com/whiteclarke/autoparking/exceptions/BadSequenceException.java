package com.whiteclarke.autoparking.exceptions;
/**
 * BadSequenceException. 
 * Exception to rise when the sequence is not the expected.
 * Expected sequence:
 *       [LFR]+
 *       
 * @author vhblasco
 */

public class BadSequenceException extends AutoParkingException{

	private static final long serialVersionUID = 1776653458238437390L;
	
	
	public BadSequenceException(String message) {
		super(message);
	}

}
