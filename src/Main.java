public class Main {
	public static void main(String[] args) {
		//args[0]: Hier soll das Puzzle, mit Komma als Trennzeichen oder direkt als int[][]-Array, �bergeben werden k�nnen.
		//			( z.B.: 1,2,3,4,5,6,7,8,0 )
		//args[1]: Dieser Parameter soll den Suchalgorithmus variieren. 
		//			(1: greedy, 2: A* mit h(n) = falsch platzierten Kacheln, 3: A*  mit h(n) = Manhattan-Distanzen)
		//args[2]: �ber einen Debugging-Parameter soll gew�hlt werden k�nnen, ob eine vollst�ndige Ausgabe der Suchschritte stattfindet. 
		//			(0: nein, 1: ja)

		Puzzle goal = new Puzzle(new int[][]{{1, 2, 3}, {8, 0, 4}, {7, 6, 5}});
		PuzzleSolver puzzleSolver = new PuzzleSolver(goal, args[0]);
		
		int heuristic = Integer.parseInt(args[1]);
		boolean debug = args[2].equals("1");
		
		switch(heuristic) {
			case 1:
				puzzleSolver.greedy(heuristic, debug);
				break;
			case 2: 
				puzzleSolver.aStar(heuristic, debug);
				break;
			case 3:
				puzzleSolver.aStar(heuristic, debug);
				break;
		}
	}
}
