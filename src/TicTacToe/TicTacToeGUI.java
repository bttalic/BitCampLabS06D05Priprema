package TicTacToe;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TicTacToeGUI extends JFrame {

	TicTacToe logic;
	Container content;

	public TicTacToeGUI(int size) {
		logic = new TicTacToe(size);
		initJFrame(size);
	}

	private void initJFrame(int size) {
		// set windows title
		setTitle("BitCamp Tic Tac Toe");
		// set width and height for window
		setSize(500, 500);
		// what happens when we hit the close button
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		content = getContentPane();
		// set background color, this is rgba, we could also use Color.purple
		content.setBackground(new Color(93, 232, 174, 200));

		content.setLayout(new GridLayout(size, size));
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				JButton newButton = new JButton();
				newButton.setName(i + "," + j);
				newButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e){
						System.out.println(e.getSource());
					}
				});
				content.add(newButton);
			}
		}

		setVisible(true);
	}

	public void clearField() {
		int componentCount = content.getComponentCount();
		System.out.println("Component count: "+componentCount);
		for (int i = 0; i < componentCount; i++) {
			Component unknownComponent = content.getComponent(i);
			try {
				JButton button = (JButton) unknownComponent;
				if (button.getText().equals("X")
						|| button.getText().equals("O")) {
					button.setText("");
				}
			} catch (Exception e){
				System.out.println(e.getMessage());
				continue;
			}
		}
	}

	// this is our implementation of the ActionListener interface
	private class ButtonHandler implements ActionListener {

		// the action we are looking for is the click action
		public void actionPerformed(ActionEvent e) {
			// if game is over we want to ignore the click
			if (logic.getGameOver() == true)
				return;
			JButton pressed = (JButton) (e.getSource());
			System.out.println(pressed.getName());
			String[] coordinates = pressed.getName().split(",");
			int x = Integer.parseInt(coordinates[0]);
			int y = Integer.parseInt(coordinates[1]);
			boolean gameOver = logic.setCell(x, y);
			pressed.setText(logic.getPreviousPlayer());
			if (gameOver) {
				JOptionPane.showMessageDialog(new JFrame(), "The winner is: "
						+ logic.getWinner(), "Game Over",
						JOptionPane.INFORMATION_MESSAGE);
				logic.clear();
				clearField();
			}

		}
	}

}
