public class Puzzle {
	int [][] puzzle;
	
	public Puzzle(int[][] puzzle){
		this.puzzle = puzzle;		
	}
	
	//TODO Further methods
	
	@Override
	public String toString() {
		StringBuilder output = new StringBuilder();
		for (int[] ints : this.puzzle) {
			for (int anInt : ints) {
				output.append(anInt).append(" ");
			}
			output.append("\n");
		}
		output.append("-----");
		return output.toString();
	}
}