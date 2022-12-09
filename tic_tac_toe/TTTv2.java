/**		 	API
 * ============================
 * 		    TTTv2()
 * 	boolean place(int position)
 *    int[] checkWin()
 *	   void printBoard()
 *   char[] getBoard()
 *      int getTurn()
 */

import java.util.Scanner;
import java.util.InputMismatchException;

 public class TTTv2
 {
    char[] board;
    int turn;

    public TTTv2()
    {
        this.board = new char[9];
        for (int i = 0; i < 9; i++) {
            this.board[i] = 32;
        }
        this.turn = 0;
    }

    public boolean place(int position)
    {
        // X is placed
		if (this.turn % 2 == 0) {
            if (board[position] == ' ') {
                board[position] = 'X';
                this.turn++;
                return true;
            }
        }
        // O is placed
        else {
            if (board[position] == ' ') {
                board[position] = 'O';
                this.turn++;
                return true;
            }
        }
        return false; // client tried to place on occupied position
    }

    public int[] checkWin()
    {
		int[] winner = new int[3];

		// look for a win along the rows of the board
		for (int row = 0; row < 9; row = row+3) {
            if ((this.board[row] != 32) && (this.board[row] == this.board[row+1]) && (this.board[row] == this.board[row+2])) {
				winner[0] = row+0;
				winner[1] = row+1;
				winner[2] = row+2;
				return winner;
			}
		}

		// look for a win along the columns of the board
		for (int col = 0; col < 3; col++) {
            if ((this.board[col] != 32) && (this.board[col] == this.board[col+3]) && (this.board[col] == this.board[col+6])) {
				winner[0] = col;
				winner[1] = col+3;
				winner[2] = col+6;
				return winner;
			}
		}

		// look for a win accross the board
		if ((this.board[0] != 32) && (this.board[0] == this.board[4]) && (this.board[0] == this.board[8])) {
			winner[0] = 0;
			winner[1] = 4;
			winner[2] = 8;
			return winner;
		}
		if ((this.board[2] != 32) && (this.board[2] == this.board[4]) && (this.board[2] == this.board[6])) {
			winner[0] = 2;
			winner[1] = 4;
			winner[2] = 6;
			return winner;
		}

		return null;
    }

    public void printBoard()
    {
		System.out.println(this.board[0] + "|" + this.board[1] + "|" + this.board[2]);
		System.out.println("-+-+-");
		System.out.println(this.board[3] + "|" + this.board[4] + "|" + this.board[5]);
		System.out.println("-+-+-");
		System.out.println(this.board[6] + "|" + this.board[7] + "|" + this.board[8]);
    }

    public char[] getBoard()
    {
        return this.board;
    }

    public int getTurn()
    {
        return this.turn;
    }

    public static void main(String[] args)
    {
        TTTv2 game = new TTTv2();
        game.printBoard();
        Scanner positionScanner = new Scanner(System.in);
        while ((game.checkWin() == null) && (game.getTurn() < 9)) {
            try { 
                System.out.println("Where would you like to play? [1-9]");
                int position = positionScanner.nextInt();
                if (!game.place(position-1)) {
                    System.out.println("Please enter an integer between 1 and 9");
                    positionScanner.nextLine();
                }
            } 
            catch(InputMismatchException e) {
                System.out.println("Please enter an integer between 1 and 9");
                positionScanner.nextLine();
            }
            game.printBoard();
        }

		// Declare winner
        int[] winningTripple = game.checkWin();
        if (winningTripple == null) {
            System.out.println("\nDraw!");
        }
        else {
            char[] board = game.getBoard();
            char winner = board[winningTripple[0]];
            System.out.println("\n" + winner + " wins!");
        }
        positionScanner.close();
    }
 }