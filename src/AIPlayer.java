
public class AIPlayer implements Player{
//do not change the line above	
	
	//Define your fields here
	int playerID, row, col;
	Board gameboard2;
	
	//constructor takes the player id for this player, and the number of 
	// rows and columns of the board we're playing on
	public AIPlayer(int playerID, int row, int col){
		this.playerID = playerID;
		this.row = row;
		this.col = col;
		gameboard2 = new Board(row, col);
	}
	
	//used to notify your AI player of the other players last move
	public void lastMove(int c) {
		for (int i = row-1; i>=0; i--) {
			if (gameboard2.getToken(i, c) == ' ') {
				gameboard2.play(1,c);
				break;
			}
		}
	}
	
	//returns column of where to play a token
	public int playToken(){
		//Getting Win
		//Testing for horizontal win
		for (int i = row-1; i>=0; i--) {
			for (int j = 0; j<col-3; j++) {
				if (gameboard2.getToken(i,j) == gameboard2.getPlayerTwo() && gameboard2.getToken(i,j+1) == gameboard2.getPlayerTwo()
				&& gameboard2.getToken(i,j+2) == gameboard2.getPlayerTwo() && gameboard2.getToken(i,j+3) == ' ' && gameboard2.getToken(i+1, j+3) != ' ') {
					gameboard2.play(playerID, j+3);
					return j+3;
				}
			}//end inner for
		}//end outer for
		for (int i = row-1; i>=0; i--) {
			for (int j = 1; j<col-3; j++) {
				if (gameboard2.getToken(i,j) == gameboard2.getPlayerTwo() && gameboard2.getToken(i,j+1) == gameboard2.getPlayerTwo()
				&& gameboard2.getToken(i,j+2) == gameboard2.getPlayerTwo() && gameboard2.getToken(i,j+3) == ' ' && gameboard2.getToken(i+1, j-1) != ' ') {
					gameboard2.play(playerID, j-1);
					return j-1;
				}
			}//end inner for
		}//end outer for
		
		//Testing for vertical win
		for (int j = 0; j<col; j++) {
			for (int i = row-1; i>2; i--) {	
				if (gameboard2.getToken(i,j) == gameboard2.getPlayerTwo() && gameboard2.getToken(i-1,j) == gameboard2.getPlayerTwo() 
				&& gameboard2.getToken(i-2,j) == gameboard2.getPlayerTwo() && gameboard2.getToken(i-3,j) == ' ') {
					gameboard2.play(playerID, j);
					return j;
				}
			}//end inner for
		}//end outer for
		
		//Testing for upright diagonal win
		for (int i = row-1; i>2; i--) {
			for (int j = 0; j<col-3; j++) {
				if (gameboard2.getToken(i,j) == gameboard2.getPlayerTwo() && gameboard2.getToken(i-1,j+1) == gameboard2.getPlayerTwo() 
				&& gameboard2.getToken(i-2,j+2) == gameboard2.getPlayerTwo() && gameboard2.getToken(i-3, j+3) == ' '
				&& (gameboard2.getToken(i-4, j+3) == gameboard2.getPlayerTwo() || gameboard2.getToken(i-4, j+3) == gameboard2.getPlayerTwo())) {
					gameboard2.play(playerID, j+3);
					return j+3;
				}
			}//end inner for
		}//end outer for
		
		//Testing for downright diagonal win
		for (int i = 0; i<row-3; i++) {
			for (int j = 0; j<col-3; j++) {
				if (gameboard2.getToken(i,j) == gameboard2.getPlayerTwo() && gameboard2.getToken(i+1,j+1) == gameboard2.getPlayerTwo() 
				&& gameboard2.getToken(i+2,j+2) == gameboard2.getPlayerTwo() && gameboard2.getToken(i+3, j+3) == ' '
				&& (gameboard2.getToken(i+4, j+3) == gameboard2.getPlayerTwo() || gameboard2.getToken(i+4, j+3) == gameboard2.getPlayerTwo())) {
					gameboard2.play(playerID, j+3);
					return j+3;
				}
			}//end inner for
		}//end outer for
		
		
		
		//Blocking Wins
		//Testing for horizontal block
		for (int i = row-1; i>=0; i--) {
			for (int j = 0; j<col-3; j++) {
				if (gameboard2.getToken(i,j) == gameboard2.getPlayerOne() && gameboard2.getToken(i,j+1) == gameboard2.getPlayerOne()
				&& gameboard2.getToken(i,j+2) == gameboard2.getPlayerOne() && gameboard2.getToken(i,j+3) == ' ' && gameboard2.getToken(i+1, j+3) != ' ') {
					gameboard2.play(playerID, j+3);
					return j+3;
				}
			}//end inner for
		}//end outer for
		for (int i = row-1; i>=0; i--) {
			for (int j = 1; j<col-3; j++) {
				if (gameboard2.getToken(i,j) == gameboard2.getPlayerOne() && gameboard2.getToken(i,j+1) == gameboard2.getPlayerOne()
				&& gameboard2.getToken(i,j+2) == gameboard2.getPlayerOne() && gameboard2.getToken(i,j-1) == ' ' && gameboard2.getToken(i+1, j-1) != ' ') {
					gameboard2.play(playerID, j-1);
					return j-1;
				}
			}//end inner for
		}//end outer for
		for (int i = row-1; i>=0; i--) {
			for (int j = 0; j<col-3; j++) {
				if (gameboard2.getToken(i,j) == gameboard2.getPlayerOne() && gameboard2.getToken(i,j+1) == gameboard2.getPlayerOne()
				&& gameboard2.getToken(i,j+2) == ' ') {
					gameboard2.play(playerID, j+3);
					return j+3;
				}
			}//end inner for
		}//end outer for
		
		//Testing for vertical block
		for (int j = 0; j<col; j++) {
			for (int i = row-1; i>2; i--) {	
				if (gameboard2.getToken(i,j) == gameboard2.getPlayerOne() && gameboard2.getToken(i-1,j) == gameboard2.getPlayerOne() 
				&& gameboard2.getToken(i-2,j) == gameboard2.getPlayerOne() && gameboard2.getToken(i-3,j) == ' ') {
					gameboard2.play(playerID, j);
					return j;
				}
			}//end inner for
		}//end outer for
		for (int j = 0; j<col; j++) {
			for (int i = row-1; i>2; i--) {	
				if (gameboard2.getToken(i,j) == gameboard2.getPlayerOne() && gameboard2.getToken(i-1,j) == gameboard2.getPlayerOne() 
				&& gameboard2.getToken(i-2,j) == ' ') {
					gameboard2.play(playerID, j);
					return j;
				}
			}//end inner for
		}//end outer for
		
		//Testing for upright diagonal block
		for (int i = row-1; i>2; i--) {
			for (int j = 0; j<col-3; j++) {
				if (gameboard2.getToken(i,j) == gameboard2.getPlayerOne() && gameboard2.getToken(i-1,j+1) == gameboard2.getPlayerOne() 
				&& gameboard2.getToken(i-2,j+2) == gameboard2.getPlayerOne() && gameboard2.getToken(i-3, j+3) == ' '
				&& gameboard2.getToken(i-4, j+3) != ' ') {
					gameboard2.play(playerID, j+3);
					return j+3;
				}
			}//end inner for
		}//end outer for
		
		//Testing for downright diagonal block
		for (int i = 0; i<row-3; i++) {
			for (int j = 0; j<col-3; j++) {
				if (gameboard2.getToken(i,j) == gameboard2.getPlayerOne() && gameboard2.getToken(i+1,j+1) == gameboard2.getPlayerOne() 
				&& gameboard2.getToken(i+2,j+2) == gameboard2.getPlayerOne() && gameboard2.getToken(i+3, j+3) == ' '
				&& gameboard2.getToken(i-4, j+3) != ' ') {
					gameboard2.play(playerID, j+3);
					return j+3;
				}
			}//end inner for
		}//end outer for
		
		for(int i = 0; i<col;) {
			if (gameboard2.getToken(row-1, i)==gameboard2.getPlayerTwo() && gameboard2.getToken(row-1, i+1) == ' ') {
				gameboard2.play(playerID, i+1);
				return i+1;
			}
			else if(gameboard2.getToken(row-1, i)==gameboard2.getPlayerTwo() && gameboard2.getToken(row-1, i-1) == ' ') {
				gameboard2.play(playerID, i-1);
			return i-1;
			}
			else
				break;
		}
		for (int i = 0; i<col; i++) {
			if (gameboard2.getToken(row-1, i) == ' ') {
				gameboard2.play(2, i);
				return i;
			}
		}
		for (int i = 0; i<col; i++) {
			if (gameboard2.getToken(row-2, i) == ' ') {
				gameboard2.play(2, i);
				return i;
			}
		}
		gameboard2.play(2, col/2);
		return col/2;
	}
	
	//get this player's id
	public int getPlayerID(){
		return this.playerID;
	}
	
	//resets the state of the player in preparation for a new game
	public void reset(){
		gameboard2 = new Board(this.row, this.col);
	}
}