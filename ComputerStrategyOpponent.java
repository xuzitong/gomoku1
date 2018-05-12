package gomoku;


public class ComputerStrategyOpponent implements ComputerStrategy {

	public static final int WEAK = 1;
	public static final int ADVANCED = 2;
	public static final int WINNER = 3;
	private int strength = 0;
	@Override
	public String getName() {
		if (strength == WEAK) {
			return "Weak strategy";
		} else if (strength == ADVANCED) {
			return "Strong strategy";
		} else if (strength == WINNER) {
			return "Winner 2013 strategy";
		}
		return "null";
	}

	private ComputerStrategyOpponent opponent;

	public ComputerStrategyOpponent(int strength) {
		this.strength = strength;
		if (strength == WEAK) {
			opponent = new ComputerStrategyOpponent(ComputerStrategyOpponent.WEAK);
		} else if (strength == ADVANCED) {
			opponent = new ComputerStrategyOpponent(ComputerStrategyOpponent.ADVANCED);
		} else if (strength == WINNER) {
			opponent = new ComputerStrategyOpponent(ComputerStrategyOpponent.WINNER);
		}
	}
	@Override
	public Location getMove(SimpleBoard board, int player) {
		int[][] b = board.getBoard();
		for (int row = 0; row < b.length; row++) {
			for (int col = 0; col < b[0].length; col++) {
				b[row][col] = b[row][col] == SimpleBoard.PLAYER_WHITE ? 2
						: (b[row][col] == SimpleBoard.PLAYER_BLACK ? 1 : 0);
			}
		}
                
		return  opponent.getMove(new gomoku.SimpleBoard(b), player == SimpleBoard.PLAYER_WHITE ? 2 : 1);
		
	}

}
