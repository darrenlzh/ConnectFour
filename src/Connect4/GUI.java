package Connect4;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GUI implements Runnable {

	@Override
	public void run() {
		
//		JFrame frame2 = new JFrame("Enter Players");
//		frame2.setSize(400, 200);
//		frame2.setVisible(true);
//		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		JPanel fieldPanel = new JPanel();
//		fieldPanel.setLayout(new BoxLayout(fieldPanel, BoxLayout.Y_AXIS));
//		JTextField field1 = new JTextField(10);
//		JTextField field2 = new JTextField(10);
//		fieldPanel.add(new JLabel("Player 1's Name:"));
//		fieldPanel.add(field1);
//		fieldPanel.add(new JLabel("Player 2's Name:"));
//		fieldPanel.add(field2);
//		frame2.add(fieldPanel);
//		
//		String p1Name = field1.getText();
//		String p2Name = field2.getText();
	
//		Scanner kbd = new Scanner(System.in);
//		System.out.print("Player 1's Name: ");
		String p1Name = JOptionPane.showInputDialog("Player 1's Name");
		
//		System.out.print("Player 2's Name: ");
		String p2Name = JOptionPane.showInputDialog("Player 2's Name");		
		
		JFrame frame = new JFrame("Connect Four");	
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel statusPanel = new JPanel();
		JLabel status = new JLabel("START");
		JPanel resetPanel = new JPanel();
		JButton reset = new JButton("Reset Game");
		JPanel btnPanel = new JPanel();
		JPanel imgPanel = new JPanel();
		btnPanel.setLayout(new GridLayout(1, 7));
		imgPanel.setLayout(new GridLayout(6, 7));
		jp1.setLayout(new BoxLayout(jp1, BoxLayout.Y_AXIS));
		jp2.setLayout(new BoxLayout(jp2, BoxLayout.Y_AXIS));

		ArrayList<JButton> btnList = new ArrayList<JButton>();
		ArrayList<ArrayList<JLabel>> table = new ArrayList<ArrayList<JLabel>>();
		
		Player player1 = new Player(new ImageIcon("images/darkblue.png"),
				p2Name+"'s turn");
		Player player2 = new Player(new ImageIcon("images/lightblue.png"),
				p1Name+"'s turn");
		ImageIcon blank = new ImageIcon("images/blank.png");

		Game game = new Game(player1, player2, p1Name, p2Name, status, table, btnList, blank, reset, resetPanel);
		
		EventHandler event = new EventHandler(game);
		int colNum = 1;
		for (int c = 1; c <= 7; c++) {
			JButton colButton = new JButton("" + colNum);
			colButton.setPreferredSize(new Dimension(10,55));
			btnPanel.add(colButton);
			colButton.addActionListener(event);
			btnList.add(colButton);
			colNum++;
		}

		for (int row = 1; row <= 6; row++) {
			ArrayList<JLabel> imgList = new ArrayList<JLabel>();
			for (int col = 1; col <= 7; col++) {
				JLabel colLabel = new JLabel();
				colLabel.setIcon(blank);
				imgPanel.add(colLabel);
				imgList.add(colLabel);
			}
			table.add(imgList);
		}
		
		reset.addActionListener(new EventHandler2(table, blank));
		statusPanel.add(status);
		jp1.add(statusPanel, BorderLayout.NORTH);
		jp1.add(btnPanel, BorderLayout.CENTER);
		jp1.add(imgPanel, BorderLayout.SOUTH);
		jp2.add(resetPanel);
		frame.add(jp1, BorderLayout.NORTH);
		frame.add(jp2, BorderLayout.SOUTH);
		//frame.pack();
		frame.setSize(400, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}