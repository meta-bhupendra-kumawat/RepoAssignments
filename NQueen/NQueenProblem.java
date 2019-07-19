
/* This is a component class.
 * This class consists of functions to find the solution of n-Queen Problem if exist.
 * The method used works on recursive approach.
 * @author Bhupendra
 */
public class NQueenProblem {

	/* This method checks whether the current position is under attack with some other queen
	 * already placed on chess board.
	 * @param board chess board matrix.
	 * @param currentQueenRow the current row position to check.
	 * @param currentQueenColumn the current column position to check.
	 * @param n Dimensions of Chess Board
	 * @return true if given row and column is safe to place current Queen, false otherwise.
	 */
	public boolean isSafe(int board[][], int currentQueenRow, int currentQueenColumn, int n) {
		// Checking columns
		for (int row = 0; row < currentQueenRow; row++) {
			if (board[row][currentQueenColumn] == 1)
				return false;
		}

		// Check for left diagonal
		int x = currentQueenRow;
		int y = currentQueenColumn;
		while (x >= 0 && y >= 0) {
			if (board[x][y] == 1)
				return false;
			x--;
			y--;
		}

		// Check for right diagonal
		x = currentQueenRow;
		y = currentQueenColumn;
		while (x >= 0 && y < n) {
			if (board[x][y] == 1)
				return false;
			x--;
			y++;
		}
		return true;
	}

	/* This method solves the N-Queen Problem. If the solution exists for given n number of Queens,
	 * and places 1 at every position where Queen can be placed. The solution matrix will be 
	 * displayed on the console. 
	 * This method uses recursive approach to solve the given problem.
	 * @param board represents chess board.
	 * @param row the row at which Queen is to be placed.
	 * @param n Dimension of the chess board.
	 * @return true if the solution for given n number of queens exists, false otherwise.
	 */
	public boolean SolveNQueen(int board[][], int row, int n) {
		// Base case
		if (row == n) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(board[i][j] + "   ");
				}
				System.out.println("\n");
			}
			return true;
		}

		for (int col = 0; col < n; col++) {
			
			// To check whether next Queen can be placed or not at given row and column!
			if (isSafe(board, row, col, n)) {
				
				// Placing the queen on the chess board matrix.
				board[row][col] = 1;
				boolean canPlaceNextQueen = SolveNQueen(board, row + 1, n);

				// If the next Queen's position is safe to place.
				if (canPlaceNextQueen)
					return true;
			}
			
			/* The placement of queen is not favourable so, backtrack and reset the chess board 
			 * matrix to its previous state.
			 */
			board[row][col] = 0;
		}
		return false;
	}
}
