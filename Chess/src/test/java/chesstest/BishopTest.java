package chesstest;

import static org.junit.Assert.*;

import org.junit.Test;

import chess.Bishop;

public class BishopTest {

	@Test
	public void sameAllyTest() {
		Bishop b1 = new Bishop(1, 1, true, true);
		assertEquals(false, b1.checkMove(2,2));
	}
	
	@Test
	public void movementTest() {
		Bishop b1 = new Bishop(1, 1, true, false);
		assertEquals(false, b1.checkMove(2,3));
	}
	
	@Test
	public void simpleTest() {
		Bishop b1 = new Bishop(1, 1, true, true);
		assertEquals(false, b1.checkMove(2,2));
	}
}
