package com.whiteclarke.autoparking.beans;
/**
 * AutoParking
 * Class to prepare the input, configure the boundaries and makes the error treatment. 
 * @author vhblasco
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.whiteclarke.autoparking.exceptions.BadCommandException;
import com.whiteclarke.autoparking.exceptions.BadInitialPositionException;
import com.whiteclarke.autoparking.exceptions.BadSequenceException;
import com.whiteclarke.autoparking.exceptions.PositionOutOfBoundariesException;
import com.whiteclarke.autoparking.utils.CardinalDirection;

@Component
public class AutoParking {

	
	/* Parking boundaries */
	public static final int BOUNDARY_X = 14;
	public static final int BOUNDARY_Y = 14;
	
	/* Error structure */
	private boolean error = false;
	private String errorMsg;
	
	/* Logger */
    private static final Logger logger = LoggerFactory.getLogger(AutoParking.class);

    /**
     * Method to prepare the ParkingSequence and calls to calculate the final position
     * @param args
     * @return ParkingSequence
     */
	public ParkingSequence calculateNewPosition(String args) {
		
		ParkingSequence ps;
		
		try {
			ps = createParkingSequenceFromInput(args);	
			ps.calculateFinalPosition();
			
			logger.info("*************");
	        logger.info("Initial position {} and sequence {}", ps.getInitialPosition(), ps.getSequence());	        
	        logger.info("Final Position {}", ps.getCurrentPosition());
	        
	        return ps;
		} catch (BadInitialPositionException | BadSequenceException | PositionOutOfBoundariesException
				| BadCommandException e) {
			this.setError(true);
			this.setErrorMsg(e.getMessage());
			
			logger.info("*************");	        
	        logger.info("Error {}", e.getMessage());
		}
		 
        
		return null;
	}


	/**
	 * Method to validate the input
	 * @param args
	 * @return
	 * @throws BadInitialPositionException
	 * @throws BadSequenceException
	 * @throws PositionOutOfBoundariesException
	 * @throws BadCommandException
	 */
	private ParkingSequence createParkingSequenceFromInput(String args) 
			throws BadInitialPositionException, BadSequenceException, PositionOutOfBoundariesException, BadCommandException {	
		ParkingSequence ps = null;
		try {
			String parts[] = args.split(":");
			String initStr = parts[0];
			String sequence = parts[1];
					
			ps = new ParkingSequence(initStr, sequence, CardinalDirection.NORD, BOUNDARY_X, BOUNDARY_Y);
		} catch (ArrayIndexOutOfBoundsException e){
			throw new BadCommandException("Command format unexpected: " + args);
		}
		return ps;
	}


	/* Getters & Setters */
	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
}
