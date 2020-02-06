import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.*;

public class Game {
	public static boolean isX;
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		isX = true;

		URL iconURL = Game.class.getResource("tictactoe.png");
		ImageIcon icon = new ImageIcon(iconURL);
		frame.setIconImage(icon.getImage());

		GridLayout layout = new GridLayout(0, 3);
		panel.setLayout(layout);
		for (int i = 0; i < 9; i++) {
			JButton button = new JButton();
			panel.add(button);
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(isX) {
						button.setText("X");
						isX = false;
					} else {
						button.setText("O");
						isX = true;
					}
				}
			});
		}

		frame.getContentPane().add(panel);
		frame.pack();
		frame.setTitle("Tic Tac Toe");
		frame.setSize(400, 400);
		frame.setVisible(true);

	}

}
