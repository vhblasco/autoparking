package com.whiteclarke.autoparking.utils;
/**
 * @author vhblasco
 */

public enum CardinalDirection {

	NORD("N"),
	SOUTH("S"),
	EAST("E"),
	WEST("W");
	
	private String point;

	private CardinalDirection(String point) {
		this.point = point;
	}
	
	public String toString() {
		return point;
	}
	
	/**
	 * This method will return the next CardinalDirection anticlockwise
	 * @return CardinalDirection
	 */
	public CardinalDirection turnLeft() {
		
		switch (this) {
		case NORD: return CardinalDirection.WEST;
		case WEST: return CardinalDirection.SOUTH;
		case SOUTH: return CardinalDirection.EAST;
		default: return CardinalDirection.NORD;
		}
	}
	
	/**
	 * This method will return the next CardinalDirection clockwise
	 * @return CardinalDirection
	 */
	public CardinalDirection turnRight() {
		
		switch (this){
		case NORD: return CardinalDirection.EAST; 
		case EAST: return CardinalDirection.SOUTH;
		case SOUTH: return CardinalDirection.WEST;
		default: return CardinalDirection.NORD; 
		}				
	}
}
