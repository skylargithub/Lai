package tictactoe;

public class mainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Board  board = new Board(3);
	//	board.addToken("X", 0, 0);
	//	board.addToken("X", 0, 1);
		//board.addToken("X", 1, 1);
		//board.addToken("X", 1, 0);
		//board.printBoard();
		//System.out.print(board.isFull());
		while(board.isFull()) {
			
			try {
				board.computerMove();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		}
		board.printBoard();

	}

}
