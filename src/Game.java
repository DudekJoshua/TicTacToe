import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.*;

public class Game {
	public static boolean isX;
	public static int[][] coordinates = new int[3][3];
	public static JButton[][] buttonLocation = new JButton[3][3];

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		isX = true;

		URL iconURL = Game.class.getResource("tictactoe.png");
		ImageIcon icon = new ImageIcon(iconURL);
		frame.setIconImage(icon.getImage());

		GridLayout layout = new GridLayout(0, 3);
		panel.setLayout(layout);
		for (int h = 0; h < 3; h++) {
			for (int i = 0; i < 3; i++) {
				JButton button = new JButton();
				buttonLocation[h][i] = button;
				panel.add(button);
				final int x = h;
				final int y = i;
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (isX) {
							button.setText("X");
							isX = false;
							coordinates[x][y] = 1;
						} else {
							button.setText("O");
							isX = true;
							coordinates[x][y] = -1;
						}
						button.setEnabled(false);
						int winner = whoWon();
						if (winner == 1 || winner == -1) {
							announcement("Winner Announcement",
									"The winner of this round is: " + (winner == 1 ? "X" : "O"));
						} else if (isTie()) {
							announcement("It's a tie!", "No one won this round!");
						}
					}
				});
			}
		}
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setTitle("Tic Tac Toe");
		frame.setSize(400, 400);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static int whoWon() {
		for (int x = 0; x < 3; x++) {
			int sumHoriz = 0;
			int sumVert = 0;
			for (int y = 0; y < 3; y++) {
				sumHoriz += coordinates[x][y];
				sumVert += coordinates[y][x];
			}
			if (sumHoriz == 3 || sumVert == 3) {
				return 1;
			}
			if (sumHoriz == -3 || sumVert == -3) {
				return -1;
			}
		}
		int sumDiagonalRL = coordinates[2][0] + coordinates[1][1] + coordinates[0][2];
		int sumDiagonalLR = coordinates[0][0] + coordinates[1][1] + coordinates[2][2];
		if (sumDiagonalRL == 3 || sumDiagonalLR == 3) {
			return 1;
		}
		if (sumDiagonalRL == -3 || sumDiagonalLR == -3) {
			return -1;
		}

		return 0;
	}

	public static boolean isTie() {

		for (int x = 0; x < 3; x++) {

			for (int y = 0; y < 3; y++) {
				if (coordinates[x][y] == 0) {
					return false;
				}

			}
		}

		return true;
	}

	public static void announcement(String title, String body) {
		JDialog winnerAnnouncement = new JDialog();
		winnerAnnouncement.setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		JPanel buttonPanel = new JPanel();
		new BoxLayout(buttonPanel, BoxLayout.X_AXIS);
		panel.setSize(400, 200);
		BorderLayout layout = new BorderLayout();
		layout.setHgap(10);
		layout.setVgap(10);

		panel.setLayout(layout);
		winnerAnnouncement.setTitle(title);
		JLabel label = new JLabel(body);
		label.setFont(new Font(label.getFont().getName(), Font.BOLD, 16));
		JButton reset = new JButton("Reset");
		JButton quit = new JButton("Quit");
		quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coordinates = new int[3][3];
				
				for(int x = 0; x < 3; x++) {
					for(int y = 0; y < 3; y++) {
						buttonLocation[x][y].setText("");
						buttonLocation[x][y].setEnabled(true);
					}
				}
				
				winnerAnnouncement.dispose();
			}
		});
		
		buttonPanel.add(reset);
		buttonPanel.add(quit);
		panel.add(label, BorderLayout.CENTER);
		panel.add(buttonPanel, BorderLayout.SOUTH);
		
		winnerAnnouncement.add(panel);
		winnerAnnouncement.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		winnerAnnouncement.setSize(400, 200);
		winnerAnnouncement.setModal(true);
		winnerAnnouncement.setResizable(false);
		winnerAnnouncement.setVisible(true);

	}
}
