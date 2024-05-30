package com.bowling;

import static org.junit.Assert.*;


import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance.Lifecycle;


@TestInstance(Lifecycle.PER_CLASS)
public class GameTest {
	Game g;
	@BeforeEach
	public void setUp() {
		g = new Game();
	}
	
	@Test
	@DisplayName("dummy game")
	public void testDummyGame() {
		
		g.roll(0);
		assertEquals(0, g.score());
	}
	
	@Test
	@DisplayName("one game")
	public void testCompleteGame() {
		
		for(int i = 0;i < 20;i++) 
			g.roll(1);
		assertEquals(20, g.score());
	}
	
	@Test
	@DisplayName("one spare game")
	public void testOneSpare() {
		
		g.roll(6);
		g.roll(4);
		g.roll(5);
		rollMany(18, 1);
		assertEquals(37, g.score());
	}
	
	@Test
	@DisplayName("one strike game") 
	public void testOneStrike() {
		g.roll(10);
		g.roll(1);
		g.roll(6);
		rollMany(18, 1);
		assertEquals(40, g.score());
	}
	
	@Test
	public void testGivenTestCase1() {
		rollMany(10,9);
		rollMany(10,0);
		assertEquals(90, g.score());
	}
	@Test
	public void testGivenTestCase2() {
		g.roll(10);
		g.roll(7);
		g.roll(3);
		g.roll(9);
		g.roll(0);
		g.roll(10);
		g.roll(0);
		g.roll(8);
		g.roll(8);
		g.roll(2);
		g.roll(0);
		g.roll(6);
		g.roll(10);
		g.roll(10);
		g.roll(10);
		g.roll(8);
		g.roll(1);

		//[7, 3] [9, 0] [10] [0, 8] [8, 2] [0, 6] [10] [10] [10], [8, 1] = 167
		assertEquals(167, g.score());
	}
	@Test
	public void testGivenTestCase3() {
		rollMany(21,5);
		
		assertEquals(150, g.score());
	}
	private void rollMany(int n, int pins) {
		for(int i = 1; i <= n; i++) {
			g.roll(pins);
		}
	}
}
