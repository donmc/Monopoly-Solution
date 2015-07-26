package com.aa.dice;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DieTest {

	private Die die;
	private int value;

	@Before
	public void setup() {
		die = new Die();
 
		value = die.roll();
	}

	@Test
	public void testRoll_GreaterThan0() {
		assertTrue(value > 0);
	}

	@Test
	public void testRoll_LessThan7() {
		assertTrue(value < 7);
	}
	
	@Test
	public void testDie_NotZero() {
		Die die2 = new Die();
		assertFalse(die2.getFaceValue() == 0);
	}

}
