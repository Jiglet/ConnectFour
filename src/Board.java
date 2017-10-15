
public class Board {
	char board[][];
	int row;
	int col;
	static char p1char, p2char;
	
	public Board() {
		board = new char[6][7];
		row = 6;
		col = 7;
		for (int i = 5; i>=0; i--) {
			for (int j = 0; j<7; j++) {
				board[i][j] = ' ';
			}
		}
	}//end Board
	public Board(int row, int col) {
		board = new char[row][col];
		for (int i = row-1; i>=0; i--) {
			for (int j = 0; j<col; j++) {
				board[i][j] = ' ';
			}
		}
		this.row = row;
		this.col = col;
	}
	
	public int getNumRows() {
		return row;
	}
	public int getNumCols() {
		return col;
	}
	
	public char getPlayerOne() {
		return p1char;
	}
	public char getPlayerTwo() {
		return p2char;
	}
	
	public void setPlayerOne(char o) {
		p1char = o;
	}
	public void setPlayerTwo(char t) {
		p2char = t;
	}
	
	public char getToken(int row, int col) {
		if(row<this.row && row>=0 && col<this.col && col>=0) {
			if (board[row][col] == p1char) 
				return p1char;
			else if (board[row][col] == p2char) 
				return p2char;
			else
				return ' ';
		}
		else 
			return '\0';
	}
	
	public boolean canPlay() { 
		for (int i = row-1; i>=0; i--) {
			for (int j = 0; j<col; j++) {
				if (board[i][j] == ' ') 
					return true;
			}
		}
		return false;
	}
	
	public boolean play(int p, int c) {
		if ((p == 1 || p == 2) && c<col && c >=0) {
			for (int i = row-1; i>=0; i--) {
				if (board[i][c] == ' ') {
					if (p == 1)
						board[i][c] = p1char;
					else if(p == 2)
						board[i][c] = p2char;
					return true;
				}
			}
			return false;
		}
		else
			return false;
	}
	
	public int isFinished() {
		//Testing for horizontal win
		for (int i = row-1; i>=0; i--) {
			for (int j = 0; j<col-3; j++) {
				if (board[i][j] == p1char && board[i][j+1] == p1char && board[i][j+2] == p1char && board[i][j+3] == p1char) {
					return 1;
				}
				if (board[i][j] == p2char && board[i][j+1] == p2char && board[i][j+2] == p2char && board[i][j+3] == p2char) {
					return 2;
				}
			}//end inner for
		}//end outer for
		
		//Testing for vertical win
		for (int j = 0; j<col; j++) {
			for (int i = row-1; i>2; i--) {	
				if (board[i][j] == p1char && board[i-1][j] == p1char && board[i-2][j] == p1char && board[i-3][j] == p1char) {
					return 1;
				}
				if (board[i][j] == p2char && board[i-1][j] == p2char && board[i-2][j] == p2char && board[i-3][j] == p2char) {
					return 2;
				}
			}//end inner for
		}//end outer for
		
		//Testing for upright diagonal win
		for (int i = row-1; i>2; i--) {
			for (int j = 0; j<col-3; j++) {
				if (board[i][j] == p1char && board[i-1][j+1] == p1char && board[i-2][j+2] == p1char && board[i-3][j+3] == p1char) {
					return 1;
				}
				if (board[i][j] == p2char && board[i-1][j+1] == p2char && board[i-2][j+2] == p2char && board[i-3][j+3] == p2char) {
					return 2;
				}
			}//end inner for
		}//end outer for
		
		//Testing for downright diagonal win
		for (int i = 0; i<row-3; i++) {
			for (int j = 0; j<col-3; j++) {
				if (board[i][j] == p1char && board[i+1][j+1] == p1char && board[i+2][j+2] == p1char && board[i+3][j+3] == p1char) {
					return 1;
				}
				if (board[i][j] == p2char && board[i+1][j+1] == p2char && board[i+2][j+2] == p2char && board[i+3][j+3] == p2char) {
					return 2;
				}
			}//end inner for
		}//end outer for
		

		//Testing for no winner yet
		for (int i = row-1; i>=0; i--) {
			for (int j = 0; j<col; j++) {
				if (board[i][j] == ' ') 
					return -1;
			}
		}
		
		return 0;
	}//end isFinished
	
	public static void main(String[] args) {
		
	}
}
