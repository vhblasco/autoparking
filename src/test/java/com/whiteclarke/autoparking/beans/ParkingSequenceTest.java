package com.whiteclarke.autoparking.beans;
/**
 * ParkingSequenceTest
 * Class to run the Unit Test for ParkingSequence class
 * 
 * @author vhblasco
 */
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.whiteclarke.autoparking.exceptions.BadInitialPositionException;
import com.whiteclarke.autoparking.exceptions.BadSequenceException;
import com.whiteclarke.autoparking.exceptions.PositionOutOfBoundariesException;
import com.whiteclarke.autoparking.utils.CardinalDirection;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ParkingSequenceTest {

	private ParkingSequence ps;
	
	@Before
	public void setup() {
		try {
			ps = new ParkingSequence("5,5","RFLFRFLF", CardinalDirection.NORD, 15, 15);
		} catch (BadSequenceException | BadInitialPositionException | PositionOutOfBoundariesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void constructorTest() {
		assertEquals("(5,5)", ps.getInitialPosition());
		assertEquals("(5,5)", ps.getCurrentPosition());
		assertEquals("RFLFRFLF", ps.getSequence());
	}
	
	@Test
	public void moveForwardTest() {
		try {
			ps.setDirection(CardinalDirection.NORD);
			ps.moveForward();
			assertEquals("(6,5)", ps.getCurrentPosition());
			
			ps.setDirection(CardinalDirection.EAST);
			ps.moveForward();
			assertEquals("(6,6)", ps.getCurrentPosition());
			
			ps.setDirection(CardinalDirection.SOUTH);
			ps.moveForward();
			assertEquals("(5,6)", ps.getCurrentPosition());
			
			ps.setDirection(CardinalDirection.WEST);
			ps.moveForward();
			assertEquals("(5,5)", ps.getCurrentPosition());
			
		} catch (PositionOutOfBoundariesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void calculateFinalPositionTest() {
		try {
			ps.calculateFinalPosition();
			
			assertEquals("(5,5)", ps.getInitialPosition());
			assertEquals("(7,7)", ps.getCurrentPosition());
			assertEquals("RFLFRFLF", ps.getSequence());
			
		} catch (PositionOutOfBoundariesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
