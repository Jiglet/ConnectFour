public class HumanPlayer implements Player{
//do not change the line above	
	
	//Define your fields here
	int playerID;
    int row;
    int col;
	Board gameboard1;
	
	//constructor takes the player id for this player, and the number of 
	// rows and columns of the board we're playing on
	public HumanPlayer(int playerID, int row, int col){
		this.playerID = playerID;
		this.row = row;
		this.col = col;
		gameboard1 = new Board(this.row, this.col);
	}
	
	//used to notify your AI player of the other players last move
	public void lastMove(int c) {
		for (int i = row-1; i>=0; i--) {
			if (gameboard1.getToken(i, c) == ' ') {
				gameboard1.play(2,c);
				break;
			}
		}
	}
	
	//returns column of where to play a token
	public int playToken(){
		int playedCol = 0;
		while(true) {
			System.out.print("Enter column: ");
			playedCol = IO.readInt();
			if (playedCol >= 0 && playedCol < col && gameboard1.getToken(0, playedCol) == ' ') {
				gameboard1.play(playerID, playedCol);
				break;
			}
		}
		return playedCol;
	}
	
	//get this player's id
	public int getPlayerID(){
		return this.playerID;
	}
	
	//resets the state of the player in preparation for a new game
	public void reset(){
		gameboard1 = new Board(this.row, this.col);
	}
	
	public static void main(String[] args) {
		HumanPlayer x = new HumanPlayer(1,6,7); 
		System.out.println(x.playToken());
	}
}