package com.whiteclarke.autoparking.utils;
/**
 * CardinalDirectionTest
 * Class to run the Unit Test for CardinalDirection class
 * 
 * @author vhblasco
 */

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CardinalDirectionTest {
	
	@Test		
	public void turnLeftTest() {
		CardinalDirection cd = CardinalDirection.NORD;
		CardinalDirection newCd = cd.turnLeft();
		assertEquals(CardinalDirection.WEST, newCd);
	
		cd = CardinalDirection.WEST;
		newCd = cd.turnLeft();
		assertEquals(CardinalDirection.SOUTH, newCd);
		
		cd = CardinalDirection.SOUTH;
		newCd = cd.turnLeft();
		assertEquals(CardinalDirection.EAST, newCd);
		
		cd = CardinalDirection.EAST;
		newCd = cd.turnLeft();
		assertEquals(CardinalDirection.NORD, newCd);
	}
	
	@Test
	public void turnRightTest() {
		CardinalDirection cd = CardinalDirection.NORD;
		CardinalDirection newCd = cd.turnRight();
		assertEquals(CardinalDirection.EAST, newCd);
	
		cd = CardinalDirection.EAST;
		newCd = cd.turnRight();
		assertEquals(CardinalDirection.SOUTH, newCd);
		
		cd = CardinalDirection.SOUTH;
		newCd = cd.turnRight();
		assertEquals(CardinalDirection.WEST, newCd);
		
		cd = CardinalDirection.WEST;
		newCd = cd.turnRight();
		assertEquals(CardinalDirection.NORD, newCd);
	}

}
