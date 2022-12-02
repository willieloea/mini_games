/**		 	API
 * ============================
 * 		    TTTv1()
 * 	boolean place(int position)
 * 	   char checkWin()
 *	   void printBoard()
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * 	  PUBLIC VARIABLES
 * ============================
 * 	char[][] board
 * 		 int turn
 */
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * A game of Tic Tac Toe
 */
public class TTTv1
{
	/**
	 * The board on which the game is played
	 */
	public char[][] board;
	/**
	 * Takes account of whose turn it is
	 */
	public int turn;
	
	/**
	 * Constructor method
	 * Initializes the board with space characters, and sets the turn to 0.
	 */
	public TTTv1()
	{
		this.board = new char[][]{
				{' ', ' ', ' '},
				{' ', ' ', ' '},
				{' ', ' ', ' '}
			};
		this.turn = 0;
	}

	/**
	 * Puts X or O on the board
	 * 
	 * @param position - the place on the board where an X or O should be placed
	 * @return boolean - true if X or O was placed on board at given position
	 */
	public boolean place(int position)
	{
		if (this.turn % 2 == 0) {
			switch(position) {
			case 1:
				if (board[0][0] == ' ') {
					board[0][0] = 'X';
				} else {
					return false;
				}
				break;
			case 2:
				if (board[0][1] == ' ') {
					board[0][1] = 'X';
				} else {
					return false;
				}
				break;
			case 3:
				if (board[0][2] == ' ') {
					board[0][2] = 'X';
				} else {
					return false;
				}
				break;
			case 4:
				if (board[1][0] == ' ') {
					board[1][0] = 'X';
				} else {
					return false;
				}
				break;
			case 5:
				if (board[1][1] == ' ') {
					board[1][1] = 'X';
				} else {
					return false;
				}
				break;
			case 6:
				if (board[1][2] == ' ') {
					board[1][2] = 'X';
				} else {
					return false;
				}
				break;
			case 7:
				if (board[2][0] == ' ') {
					board[2][0] = 'X';
				} else {
					return false;
				}
				break;
			case 8:
				if (board[2][1] == ' ') {
					board[2][1] = 'X';
				} else {
					return false;
				}
				break;
			case 9:
				if (board[2][2] == ' ') {
					board[2][2] = 'X';
				} else {
					return false;
				}
				break;
			default:
				return false;
			}
			this.turn++;
			return true;
		} 
		else {
			switch(position) {
			case 1:
				if (board[0][0] == ' ') {
					board[0][0] = 'O';
				} else {
					return false;
				}
				break;
			case 2:
				if (board[0][1] == ' ') {
					board[0][1] = 'O';
				} else {
					return false;
				}
				break;
			case 3:
				if (board[0][2] == ' ') {
					board[0][2] = 'O';
				} else {
					return false;
				}
				break;
			case 4:
				if (board[1][0] == ' ') {
					board[1][0] = 'O';
				} else {
					return false;
				}
				break;
			case 5:
				if (board[1][1] == ' ') {
					board[1][1] = 'O';
				} else {
					return false;
				}
				break;
			case 6:
				if (board[1][2] == ' ') {
					board[1][2] = 'O';
				} else {
					return false;
				}
				break;
			case 7:
				if (board[2][0] == ' ') {
					board[2][0] = 'O';
				} else {
					return false;
				}
				break;
			case 8:
				if (board[2][1] == ' ') {
					board[2][1] = 'O';
				} else {
					return false;
				}
				break;
			case 9:
				if (board[2][2] == ' ') {
					board[2][2] = 'O';
				} else {
					return false;
				}
				break;
			default:
				return false;
		}
			this.turn++;
			return true;
		}
	}

	/**
	 * Sees if there there are three X's or three O's in a row
	 * 
	 * @return char - X if there are three X's in a row
	 * 				  O if there are three O's in a row
	 * 				 ' ' otherwise
	 */
	public char checkWin()
	{
		char winner = ' ';
		char players[] = {'X', 'O'};

		for (char player: players)
		{
			// look for a win along the rows of the board
			for (int row = 0; row < 3; row++) {
				for (int col = 0; col < 3; col++) {
					if (this.board[row][col] != player) {
						break;
					} else if (col == 2) {
						return winner = player;
					} else {
						continue;
					}
				}
			}
			// look for a win along the columns of the board
			for (int col = 0; col < 3; col++) {
				for (int row = 0; row < 3; row++) {
					if (this.board[row][col] != player) {
						break;
					} else if (row == 2) {
						return winner = player;
					} else {
						continue;
					}
				}
			}
			// look for a win diagonally on the board
			for (int i = 0; i < 3; i++) {
				if (this.board[i][i] != player) {
					break;
				} else if (i == 2) {
					return winner = player;
				} else {
					continue;
				}
			}
			for (int j = 0; j < 3; j++) {
				if (this.board[j][2-j] != player) {
					break;
				} else if (j == 2) {
					return winner = player;
				} else {
					continue;
				}
			}
		}

		return winner;
	}

	/**
	 * Prints the board
	 */
	public void printBoard()
	{
		System.out.println(this.board[0][0] + "|" + this.board[0][1] + "|" + this.board[0][2]);
		System.out.println("-+-+-");
		System.out.println(this.board[1][0] + "|" + this.board[1][1] + "|" + this.board[1][2]);
		System.out.println("-+-+-");
		System.out.println(this.board[2][0] + "|" + this.board[2][1] + "|" + this.board[2][2]);
	}

	/**
	 * Makes sure the position is a number between 1 and 9
	 * 
	 * @return boolean - true if the position is a number between 1 and 9
	 */
	private static boolean validPosition(int position)
	{
		if ((position < 1) || (position > 9)) {
			return false;
		}
		else {
			return true;
		}
	}

	public static void main(String[] args)
	{
		TTTv1 game = new TTTv1();

		int position = 0;
		game.printBoard();

		while ((game.checkWin() == ' ') && (game.turn < 9)) {
			Scanner userInput = new Scanner(System.in);
			try {
				System.out.println("Where would you like to play? [1-9]");
				position = userInput.nextInt();
				if (validPosition(position)) {
					game.place(position);
				}
			}
			catch(InputMismatchException e) {
				System.out.println("Please enter an integer between 1 and 9");
			}
			game.printBoard();
		}

		if (game.checkWin() == 'X') {
			System.out.println("X wins!");
		}
		else if (game.checkWin() == 'O') {
			System.out.println("O wins!");
		}
		else {
			System.out.println("It's a tie!");
		}
	}
}