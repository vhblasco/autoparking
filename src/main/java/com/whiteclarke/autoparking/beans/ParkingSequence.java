package com.whiteclarke.autoparking.beans;
/**
 * ParkingSequence.
 * This class has the boundaries, the initial position, the sequence and is the one who 
 * calculates the final position. 
 * 
 * @author vhblasco
 */

import com.whiteclarke.autoparking.exceptions.BadInitialPositionException;
import com.whiteclarke.autoparking.exceptions.BadSequenceException;
import com.whiteclarke.autoparking.exceptions.PositionOutOfBoundariesException;
import com.whiteclarke.autoparking.utils.CardinalDirection;

public class ParkingSequence {
  
    
	public static final String VALID_INSTRUCTIONS = "FLR";
	
	/* Boundaries */
	private int boundary_x;
	private int boundary_y;
	
	/* Initial coordenates */
	private int initialX;
	private int initialY;
	
	/* Current direction */
	private CardinalDirection direction;
	
	/* Sequence of commands */
	private String sequence;
	
		
	/* Current coordenates */
	private int currentX;
	private int currentY;
	
	/* Constructor */
	public ParkingSequence(String initStr, String seq, CardinalDirection direction, int boundX, int boundY) 
			throws BadSequenceException, BadInitialPositionException, PositionOutOfBoundariesException {
		this.boundary_x = boundX;
		this.boundary_y = boundY;
		this.setInitialPosition(initStr);
		this.setSequence(seq);
		this.currentX = initialX;
		this.currentY = initialY;
		this.direction = direction;
	}
	
	
	/* Method to calculate the final position */
	public void calculateFinalPosition() throws PositionOutOfBoundariesException {

		for(int i = 0; i < sequence.length(); i++) {
			char c = sequence.charAt(i);
			
			//System.out.println(toPosition(currentX, currentY));
			//System.out.println( "Transformation: " + c);
			
			switch (c){
				case 'F': moveForward(); break;
				case 'R': setDirection(direction.turnRight()); break;
				case 'L': setDirection(direction.turnLeft()); break;
			}
			//System.out.println(toPosition(currentX, currentY));
		}
		
	}


	/* Getters & Setters */
	public int getInitialX() {
		return initialX;
	}
	
	public void setInitialX(int initialX) {
		this.initialX = initialX;
	}
	
	public int getInitialY() {
		return initialY;
	}
	
	public void setInitialY(int initialY) {
		this.initialY = initialY;
	}
	
	public String getSequence() {
		return sequence;
	}
	
	/* This method validates the input to ensure the sequence is valid */
	public void setSequence(String sequence) throws BadSequenceException {
		if (validSequence(sequence))
			this.sequence = sequence;
		else throw new BadSequenceException("The sequence contains illegal characters");
	}

	public String getInitialPosition() {
		return toPosition(initialY, initialX);
	}
	
	public String getCurrentPosition() {
		return toPosition(currentY, currentX);
	}
	
	public CardinalDirection getDirection() {
		return direction;
	}

	public void setDirection(CardinalDirection direction) {
		this.direction = direction;
	}


	/* Helpers */
	
	/** 
	 * Method to print the position. 
	 * The position is going to print in (Y,X) format 
	 **/
	private String toPosition(int y, int x) {
		return new StringBuffer()
				.append("(")
				.append(y)
				.append(",")
				.append(x)
				.append(")")
				.toString();			
	}
	
	/**
	 * Method to set the initial position.
	 * This method validates the position as well to be sure is valid.
	 * 
	 * @param initStr
	 * @throws BadInitialPositionException
	 * @throws PositionOutOfBoundariesException
	 */
	private void setInitialPosition(String initStr) throws BadInitialPositionException, PositionOutOfBoundariesException {
		try {
			String coords [] = initStr.split(",");
			this.setInitialX(Integer.valueOf(coords[0]));
			this.setInitialY(Integer.valueOf(coords[1]));
			checkBoundaries(initialX, initialY);
			
		} catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
			throw new BadInitialPositionException("Initial position format unexpected: " + initStr);
		} 
	}
	
	/**
	 * Method to validate the sequence.
	 * @param seq
	 * @return
	 */
	private boolean validSequence(String seq) {
		return seq.chars()
			.mapToObj(c -> (char) c)
			.allMatch(c -> VALID_INSTRUCTIONS.contains(String.valueOf(c)));
	}
	
	
	/**
	 * Method to move forward the position depending on the orientation 
	 * @throws PositionOutOfBoundariesException
	 */
	public void moveForward() throws PositionOutOfBoundariesException {

		switch(direction) {
		case NORD: currentY++;
				  checkBoundaries(currentX,currentY);
				  break;
				  
		case SOUTH: currentY--;
		  		  checkBoundaries(currentX,currentY);
		  		  break;
			
		case EAST: currentX++;
		  		  checkBoundaries(currentX,currentY);
		  		  break;
			
		case WEST: currentX--;
		  		  checkBoundaries(currentX,currentY);
		  		  break;
		}	
	}
	
	/**
	 * Method to check if the position is a valid one.
	 * @param x
	 * @param y
	 * @throws PositionOutOfBoundariesException
	 */
	private void checkBoundaries(int x, int y) throws PositionOutOfBoundariesException {
		if (x < 0 || x > boundary_x -1)
			throw new PositionOutOfBoundariesException("Component X out of boundaries: " + x);
		
		if (y < 0 || y > boundary_y -1)
			throw new PositionOutOfBoundariesException("Component Y out of boundaries: " + y);
	}

}
