package gomoku.strategies;

import gomoku.*;

/**
 * Important!
 * This is an example strategy class.
 * You should not overwrite this.
 * Instead make your own class, for example:
 * public class AgoStrategy implements ComputerStrategy
 * 
 * and add all the logic there. The created strategy
 * should be visible under player selection automatically.
 * 
 * This file here might be overwritten in future versions.
 *
 */

public class JoonasStrategy implements ComputerStrategy {

     int label=0;
     
	@Override
        
	public Location getMove(SimpleBoard board, int player) {
		// let's operate on 2-d array
		int[][] b = board.getBoard();
                int[] position=new int[2];
                Minimax2 minimax2=new Minimax2();
                minimax2.board=b;
               
               if(label==0)
               {
                   label=1;
                   return new Location(5,5);
               }
               position= minimax2.getnexta();
		return new Location(position[0], position[1]);
	}

	@Override
	public String getName() {
		return "Tudengi nimi";
	}

}
