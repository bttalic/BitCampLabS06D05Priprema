package TicTacToe;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TestClass {

	public static void expectedEnd(boolean over, TicTacToe t, String place) {
		if (over == true) {
			System.out.println("Over! " + place + " Winner is : "
					+ t.getWinner());
			t.printTable();
			t.clear();
		} else {
			System.out.println("Problem");
		}
	}

	public static void main(String[] args) {

		TicTacToe t = new TicTacToe(3);
		t.printTable();

		// tie
		boolean over = false;
		over = t.setCell(0, 0);
		over = t.setCell(0, 2);
		over = t.setCell(0, 1);

		over = t.setCell(1, 0);
		over = t.setCell(1, 2);
		over = t.setCell(1, 1);

		over = t.setCell(2, 0);
		over = t.setCell(2, 1);
		over = t.setCell(2, 2);

		expectedEnd(over, t, "Tie");
		over = false;
		// row
		over = t.setCell(0, 0);
		over = t.setCell(1, 0);
		over = t.setCell(0, 1);
		over = t.setCell(1, 1);
		over = t.setCell(0, 2);
		expectedEnd(over, t, "Row");
		over = false;

		// column
		over = t.setCell(0, 0);
		over = t.setCell(0, 1);
		over = t.setCell(1, 0);
		over = t.setCell(1, 1);
		over = t.setCell(2, 0);
		expectedEnd(over, t, "Column");
		over = false;

		// diagonal
		over = t.setCell(0, 0);
		over = t.setCell(1, 0);
		over = t.setCell(1, 1);
		over = t.setCell(1, 2);
		over = t.setCell(2, 2);
		expectedEnd(over, t, "Diagonal");
		over = false;

		// condiagonal
		over = t.setCell(1, 0);
		over = t.setCell(0, 2);
		over = t.setCell(0, 1);
		over = t.setCell(1, 1);
		over = t.setCell(2, 1);
		over = t.setCell(2, 0);
		expectedEnd(over, t, "Con Diagonal");
		over = false;

		System.out.println("==========Graphics=============");
		

		String s = (String) JOptionPane.showInputDialog(new JFrame(),
				"Enter game field size: ",
				"Tic Tac Toe size", JOptionPane.PLAIN_MESSAGE);
		try {
			int size = Integer.parseInt(s);
			TicTacToeGUI g = new TicTacToeGUI(size);
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
	}

}
