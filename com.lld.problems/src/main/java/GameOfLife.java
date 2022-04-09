
public class GameOfLife {

	public final static int DEAD = 0;

	public final static int LIVE = 1;

	public static void main(String[] args) {
		GameOfLife d = new GameOfLife();
		d.start(5);
	}
    
    private void start(int iterations) {
		int[][] board = { { DEAD, DEAD, LIVE, DEAD, DEAD }, 
						  { DEAD, DEAD, DEAD, LIVE, DEAD },
		                  { DEAD, LIVE, LIVE, LIVE, DEAD }, 
		                  { DEAD, DEAD, DEAD, DEAD ,DEAD },
		                  { DEAD, DEAD, DEAD, DEAD, DEAD } 
		                };

		System.out.println("Initial state of the board");
		printBoard(board);
		
		  for (int i = 0 ; i < iterations ; i++) {
	            System.out.println();
	            System.out.println("Next state of the board");
	            board = getNextBoardView(board);
	            printBoard(board);
	        }

    }

	private void printBoard(int[][] board) {
		for (int i = 0; i < board.length; i++) {

			for (int j = 0; j < board[i].length; j++) {
				System.out.print(Integer.toString(board[i][j]));
			}
			System.out.println();
		}
	}
	
	private int[][] getNextBoardView(int[][] board) {

		if (board.length == 0 || board[0].length == 0) {
			throw new IllegalArgumentException("Board must have some elements.");
		}
		
		int row = board.length;
		int col = board[0].length;

		// temporary board to store updated values
		int[][] tempBoard = new int[row][col];

		for (int i = 0; i < row; i++) {

			for (int j = 0; j < col; j++) {
				tempBoard[i][j] = getNewCellState(board[i][j], getLiveNeighbours(i, j, board));
			}
		}
		return tempBoard;
	}

	private int getLiveNeighbours(int row, int col, int[][] board) {

		int liveNeighbours = 0;
		int rowEnd = Math.min(board.length, row + 2);
		int colEnd = Math.min(board[0].length, col + 2);

		for (int i = Math.max(0, row - 1); i < rowEnd; i++) {
			for (int j = Math.max(0, col - 1); j < colEnd; j++) {
				// exclude the cell itself from calculation
				if ((i != row || j != col) && board[i][j] == LIVE) {
					liveNeighbours++;
				}
			}
		}
		return liveNeighbours;
	}

	private int getNewCellState(int curState, int liveNeighbours) {

		int newState = curState;

		switch (curState) {
		case LIVE:

			// Any live cell with fewer than two live neighbors dies as if caused by underpopulation.
			if (liveNeighbours < 2) {
				newState = DEAD;
			}

			// Any live cell with two or three live neighbours lives on to the next generation.
			if (liveNeighbours == 2 || liveNeighbours == 3) {
				newState = LIVE;
			}

			// Any live cell with more than three live neighbours dies, as if by overcrowding.
			if (liveNeighbours > 3) {
				newState = DEAD;
			}
			break;

		case DEAD:
			// Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
			if (liveNeighbours == 3) {
				newState = LIVE;
			}
			break;

		default:
			throw new IllegalArgumentException("State of cell must be either LIVE or DEAD");
		}
		return newState;
	}

}
