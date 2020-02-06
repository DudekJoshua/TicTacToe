import java.awt.GridLayout;
import java.net.URL;

import javax.swing.*;

public class Game {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		
		URL iconURL = Game.class.getResource("tictactoe.png");
		ImageIcon icon = new ImageIcon(iconURL);
		frame.setIconImage(icon.getImage());
		
		JButton button = new JButton("testknopf");
		GridLayout layout = new GridLayout(0, 3);
		panel.setLayout(layout);
		panel.add(button);
		panel.add(new JButton("testknopf 2"));
		panel.add(new JButton("testknopf 3"));
		panel.add(new JButton("testknopf 4"));
		panel.add(new JButton("testknopf 5"));
		panel.add(new JButton("testknopf 5"));
		panel.add(new JButton("testknopf 5"));
		panel.add(new JButton("testknopf 5"));
		panel.add(new JButton("testknopf 5"));
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setTitle("Tic Tac Toe");
		frame.setSize(400, 400);
		frame.setVisible(true);
		
		
	}

}
