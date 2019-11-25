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

	public Puzzle parseInput(String input) {
		String[] numberAsString = input.split(",");

		int[] numberAsInt = new int[numberAsString.length];

		for (int i = 0; i < numberAsString.length; i++) {
			numberAsInt[i] = Integer.parseInt(numberAsString[i]);
		}

		int[][] cube = new int[3][3];
		int counter =0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				cube[i][j] = numberAsInt[counter];
				counter++;
			}
		}
		Puzzle p = new Puzzle(new int [3][3]);
		for (int i=0; i<3;i++){
			System.arraycopy(cube[i], 0, p.puzzle[i], 0, 3);
		}

		return p;
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
		Puzzle p = null;
		return p;
	}

	public Puzzle aStar(int heuristic, boolean debug) {
		Puzzle p = null;
		return p;
	}
}