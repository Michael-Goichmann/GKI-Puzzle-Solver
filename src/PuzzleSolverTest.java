//import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PuzzleSolverTest {

	@Test
	void checkInputTest() {
		Puzzle goal = new Puzzle(new int[][]{{1, 2, 3}, {8, 0, 4}, {7, 6, 5}});
		PuzzleSolver ps = new PuzzleSolver(goal, "1,2,3,4,5,6,7,8,9,0");
		String inOrder = "1,2,3,4,5,6,7,8,0";
		String notInOrder = "1,5,6,8,0,7,4,3,2";
		String missingCommas = "1 2,3,4,5,6,7,8,0";
		String missingNumber = "1,2,3,4,5,6,7";
		String wrongNumber = "1,2,3,4,5,11,4,6";
		String duplicateNumber = "1,1,1,1,1,1,1,1,1";
		String tooManyNumbers = "1,2,3,4,5,6,7,8,0,11,12";
		assertTrue(ps.checkInput(inOrder));
		assertTrue(ps.checkInput(notInOrder));
		assertFalse(ps.checkInput(missingNumber));
		assertFalse(ps.checkInput(wrongNumber));
		assertFalse(ps.checkInput(duplicateNumber));
		assertFalse(ps.checkInput(tooManyNumbers));
		assertFalse(ps.checkInput(missingCommas));
	}

	/**
	 * Example test case for correct input parsing (not yet implemented)
	 */

	@Test
	void heuristicsTest(){
		Puzzle ps1 = new Puzzle(new int[][]{{7, 3, 2}, {8, 0, 4}, {1, 6, 5}});
		Puzzle ps2 = new Puzzle(new int[][]{{8, 1, 2}, {0, 7, 3}, {6, 6, 4}});
		Puzzle ps3 = new Puzzle(new int[][]{{5, 3, 1}, {0, 4, 8}, {7, 6, 2}});
		Puzzle ps4 = new Puzzle(new int[][]{{1, 2, 3}, {8, 0, 4}, {7, 6, 5}});
		Puzzle ps5 = new Puzzle(new int[][]{{8, 1, 2}, {7, 3, 5}, {6, 5, 4}});
		assertEquals(4, PuzzleSolver.heuristic(ps1));
		assertEquals(8, PuzzleSolver.heuristic(ps2));
		assertEquals(7, PuzzleSolver.heuristic(ps3));
		assertEquals(0, PuzzleSolver.heuristic(ps4));
		assertEquals(9, PuzzleSolver.heuristic(ps5));
	}

	@Test 
	void parseInputTest() {
		Puzzle goal = new Puzzle(new int[][]{{1, 2, 3}, {8, 0, 4}, {7, 6, 5}});
		PuzzleSolver ps = new PuzzleSolver(goal, "1,2,3,8,0,4,7,6,5");
		for (int i = 0; i < goal.puzzle.length; i++) {
			assertArrayEquals(goal.puzzle[i], ps.start.puzzle[i]);
		}
	}
	
	// TODO more test cases
}