package puzzleSolver;

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

    @Test
    void parseInputTest() {
        Puzzle goal = new Puzzle(new int[][]{{1, 2, 3}, {8, 0, 4}, {7, 6, 5}});
        PuzzleSolver ps = new PuzzleSolver(goal, "1,2,3,8,0,4,7,6,5");
        for (int i = 0; i < goal.puzzle.length; i++) {
            assertArrayEquals(goal.puzzle[i], ps.start.puzzle[i]);
        }
    }

    @Test
    void heuristicText() {
        Puzzle goal = new Puzzle(new int[][]{{1, 2, 3}, {8, 0, 4}, {7, 6, 5}});
        PuzzleSolver ps = new PuzzleSolver(goal, "1,2,3,8,0,4,7,6,5");
        assertEquals(0, ps.heuristic(goal));

        Puzzle allIncorrect = new Puzzle(new int[][]{{2, 3, 1}, {4, 8, 0}, {6, 5, 7}});
        assertEquals(9, ps.heuristic(allIncorrect));
    }
}