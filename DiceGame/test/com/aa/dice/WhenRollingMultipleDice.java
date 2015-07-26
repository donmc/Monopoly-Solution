package com.aa.dice;

import static org.junit.Assert.*;

import org.junit.Test;

public class WhenRollingMultipleDice {

	@Test
	public void shouldReturnCorrectFaceValueFor4Dice() {
		Cup cup = new Cup(4);
		cup.shake();
		assertTrue(cup.getTotalValue() >= 4);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void shouldNotAcceptLessThanOneDie() {
		new Cup(0);
	}
	
	@Test
	public void shouldNotAcceptLessThanOneDie2() {
		try {
			new Cup(0);
			fail("Should throw Exception!");
		}catch(IllegalArgumentException e) {
			
		}catch(Exception e) {
			fail();
		}
	}

}
