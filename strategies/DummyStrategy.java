package gomoku.strategies;

import gomoku.*;

public class DummyStrategy implements ComputerStrategy {

	@Override
	public Location getMove(SimpleBoard board, int player) {
		// let's operate on 2-d array
		int[][] b = board.getBoard();
		int[] position=new int[2];
                Minimax1 minimax1=new Minimax1();
                minimax1.board=b;
                position=minimax1.getnextb();
             
                return new Location(position[0], position[1]);
	}

	@Override
	public String getName() {
		return "Dummy strategy";
	}
	
}
