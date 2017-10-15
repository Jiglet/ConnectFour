public class ConnectFour{
	
	
	public static void main(String[] args){
		
		//Create new board object
		Board gameboard3 = new Board();
		CFGUI gui = new CFGUI(gameboard3,ChipColor.RED,ChipColor.BLUE);
		//Set player tokens for player 1 and player 2
		gameboard3.setPlayerOne('a');
		gameboard3.setPlayerTwo('b');
		
		//Create Player objects
		
		//Note, the code below works because of the interface Player. All classes that "implement" Player can be
		// typed as Player. Makes switching from Human to AI Players really easy. For a challenge, you might
		// consider:
		//		1. asking the user whether he/she wants to play against a human or a computer
		//		2. implementing multiple AI players (easy, med, hard) that the user can choose to play against
		
		Player p1 = new HumanPlayer(1,6,7);
		//Player p2 = new HumanPlayer(1,6,7); //comment this line when testing AIPlayer
		
		Player p2 = new AIPlayer(2,6,7); //uncomment this line when testing AIPlayer
		
		
		//Print your empty board
		for (int i = 0; i<gameboard3.row; i++) {
			for (int j = 0; j<gameboard3.col; j++) {
				System.out.print(gameboard3.getToken(i, j));
				if (j == gameboard3.col-1)
					System.out.println();
			}
		}
		
		//WHILE the board is still playable
		//	get a column to play from player 1
		//	play that token on the board
		//  print the board
		//		has anyone won yet?
		// do the above for player 2
		while(gameboard3.canPlay() == true) {
			int x = p1.playToken();
			gameboard3.play(1, x);
			p2.lastMove(x);
			gui.redraw();
			for (int i = 0; i<gameboard3.row; i++) {
				for (int j = 0; j<gameboard3.col; j++) {
					System.out.print(gameboard3.getToken(i, j));
					if (j == gameboard3.col-1)
						System.out.println();
				}
			}
			if(gameboard3.isFinished() == 1) 
				break;
			
			int y = p2.playToken();
			gameboard3.play(2, y);
			gui.redraw();
			for (int i = 0; i<gameboard3.row; i++) {
				for (int j = 0; j<gameboard3.col; j++) {
					System.out.print(gameboard3.getToken(i, j));
					if (j == gameboard3.col-1)
						System.out.println();
				}
			}
			if(gameboard3.isFinished() == 2) 
				break;
		}
		
		// Get the status code from the board (isFinished())
		int winner = gameboard3.isFinished();
		// Print out the results of the game
		if(winner == 1) {
			System.out.print("Player 1 wins!");
			gui.gameOver(1);
		}
		else if (winner == 2) {
			System.out.print("Player 2 wins!");
			gui.gameOver(2);
		}
		else if (winner == 0) {
			System.out.print("It's a tie.");
			gui.gameOver(-1);
		}
	}
	
}