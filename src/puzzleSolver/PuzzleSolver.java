package puzzleSolver;

public class PuzzleSolver {
    Puzzle start;
    Puzzle goal;

    public PuzzleSolver(Puzzle goal, String input) {
        this.goal = goal;

        if(checkInput(input)) {
            start = parseInput(input);
        }
    }

    public boolean checkInput(String input) {
        if(input.length() != 17) return false;
        if(input.contains(" ")) return false;
        for(int i = 0; i < 9; i++) {
            if(!input.contains(String.valueOf(i))) {
                return false;
            }
        }
        return true;
    }

    private Puzzle parseInput(String input) {
        String[] arr = input.split(",");
        int[][] ret = new int[3][3];

        int x = 0;
        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ret[i][j] = Integer.parseInt(arr[x]);
                x++;
            }
        }
        return new Puzzle(ret);
    }

    public int heuristic(Puzzle puzzle) {
        int incorrect = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(this.goal.puzzle[i][j] != puzzle.puzzle[i][j]) incorrect++;
            }
        }
        return incorrect;
    }

    public Puzzle greedy(int heuristic, boolean debug) {
        //TODO
        //...
        Puzzle p = null;
        return p;
    }

    public Puzzle aStar(int heuristic, boolean debug) {
        //TODO
        //...
        Puzzle p = null;
        return p;
    }
}