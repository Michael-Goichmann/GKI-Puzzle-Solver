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
		//TODO
		// ...
		if (input.length() != 17){
			return false;
		}

		if (input.contains(" ")){
			return false;
		}

		for (int i=0; i<9; i++){
			if (!input.contains(Integer.toString(i))){
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

//		p = null;
		return p;
	}

	public static int heuristic(Puzzle start){
		int heurNew =0;
		int[][] goal = new int[][]{{1, 2, 3}, {8, 0, 4}, {7, 6, 5}};
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (start.puzzle[i][j] != goal[i][j]){
					heurNew++;
				}
			}
		}
				return heurNew;
	}

	public int[][] newStates(Puzzle recent){
		int[][] shuffle = new int[3][3];
		for (int i=0; i<3;i++){
			System.arraycopy(shuffle[i], 0, recent.puzzle[i], 0, 3);
		}
////		String[] pos = {"mid","midLeft","midRight","midTop","midBot","topLeft","botLeft","topRight","botRight"};
//		int [] pos = {1,2,3,4,5,6,7,8,9};
//
//		switch (pos){
//			case pos[1]:
//		}









		return shuffle;
	}

	public Puzzle greedy(int heuristic, boolean debug) {

		Puzzle p = null;
		return p;
	}
	
	public Puzzle aStar(int heuristic, boolean debug) {
		//TODO
		//...
		Puzzle p = null;
		return p;
	}
	
	// TODO Further methods...
}