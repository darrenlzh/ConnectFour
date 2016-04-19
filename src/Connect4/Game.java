package Connect4;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Game {

	private Player _player;
	private static int _playerTurn;
	private ImageIcon _playerDisc;
	private Player _player1;
	private Player _player2;
	private ArrayList<ArrayList<JLabel>> _table;
	private static JLabel _status;
	private ArrayList<JButton> _button;
	private ImageIcon _blank;
	private static JButton _reset;
	private static JPanel _resetPanel;
	private Object _source;
	private String _p1Name;
	private String _p2Name;

	public Game(Player player1, Player player2, String p1Name, String p2Name,
			JLabel status, ArrayList<ArrayList<JLabel>> table,
			ArrayList<JButton> button, ImageIcon blank, JButton reset,
			JPanel resetPanel) {
		_player1 = player1;
		_player2 = player2;
		_p1Name = p1Name;
		_p2Name = p2Name;
		_table = table;
		_status = status;
		_button = button;
		_blank = blank;
		_reset = reset;
		_resetPanel = resetPanel;
	}

	public ImageIcon getPlayerDisc() {
		return _playerDisc;
	}

	public void update() {
		_playerTurn++;
	}

	public void place(Object source) {

		_source = source;

		int r = 5;
		int c = getColumn();

		if (_table.get(r).get(c).getIcon() == _blank)
			_table.get(r).get(c).setIcon(this.getPlayerDisc());
		else if (_table.get(r - 1).get(c).getIcon() == _blank)
			_table.get(r - 1).get(c).setIcon(this.getPlayerDisc());
		else if (_table.get(r - 2).get(c).getIcon() == _blank)
			_table.get(r - 2).get(c).setIcon(this.getPlayerDisc());
		else if (_table.get(r - 3).get(c).getIcon() == _blank)
			_table.get(r - 3).get(c).setIcon(this.getPlayerDisc());
		else if (_table.get(r - 4).get(c).getIcon() == _blank)
			_table.get(r - 4).get(c).setIcon(this.getPlayerDisc());
		else if (_table.get(r - 5).get(c).getIcon() == _blank)
			_table.get(r - 5).get(c).setIcon(this.getPlayerDisc());
	}

	public void trackPlayer() {

		if ((_playerTurn % 2) == 0) {
			_playerDisc = _player1.getDisc();
			_player = _player1;
		} else {
			_playerDisc = _player2.getDisc();
			_player = _player2;
		}

		_status.setText(_player.getString());
	}

	public int getColumn() {
		int n = 0;

		if (_source == _button.get(0))
			n = 0;
		else if (_source == _button.get(1))
			n = 1;
		else if (_source == _button.get(2))
			n = 2;
		else if (_source == _button.get(3))
			n = 3;
		else if (_source == _button.get(4))
			n = 4;
		else if (_source == _button.get(5))
			n = 5;
		else if (_source == _button.get(6))
			n = 6;
		return n;
	}

	public JLabel checkWinHorizontal() {

		int counter = 0;
		for (int r = 5; r >= 0; r--) {
			for (int c = 0; c < 7; c++) {
				if (((_table.get(r).get(c)).getIcon())
						.equals(_player.getDisc())) {
					counter++;
				} else {
					counter = 0;
				}
				if (counter == 4) {
					_status.setText(this.deterWin());
					_resetPanel.add(_reset);
					break;
				}
			}
		}
		return _status;
	}

	public JLabel checkWinVertical() {
		int counter = 0;
		for (int c = 0; c < 7; c++) {
			for (int r = 5; r >= 0; r--) {
				if (((_table.get(r).get(c)).getIcon())
						.equals(_player.getDisc())) {
					counter++;
				} else {
					counter = 0;
				}
				if (counter == 4) {
					_status.setText(this.deterWin());
					_resetPanel.add(_reset);
					break;
				}
			}
		}
		return _status;

	}

	public JLabel checkWinDiagonal() {
		int counter = 0;
		int c = 0;

		for (int i = 0; i < 4; i++) {
			for (int r = 5; r >= 0; r--) {
				if (((_table.get(r).get(c)).getIcon())
						.equals(_player.getDisc())) {
					counter++;
					c++;
				} else {
					counter = 0;
				}
				if (counter == 4) {
					_status.setText(this.deterWin());
					_resetPanel.add(_reset);
					break;
				}
			}
			if (i == 0)
				c = 1;
			else if (i == 1)
				c = 2;
			else if (i == 2)
				c = 3;
		}
		c = 0;
		for (int i = 0; i < 2; i++) {
			int k = 4;

			if (i == 1)
				k = 3;

			for (int r = k; r >= 0; r--) {
				if (((_table.get(r).get(c)).getIcon())
						.equals(_player.getDisc())) {
					counter++;
					c++;
				} else {
					counter = 0;
				}
				if (counter == 4) {
					_status.setText(this.deterWin());
					_resetPanel.add(_reset);
					break;
				}
			}
			c = 0;
		}
		c = 6;
		for (int i = 0; i < 4; i++) {
			for (int r = 5; r >= 0; r--) {
				if (((_table.get(r).get(c)).getIcon())
						.equals(_player.getDisc())) {
					counter++;
					c--;
				} else {
					counter = 0;
				}
				if (counter == 4) {
					_status.setText(this.deterWin());
					_resetPanel.add(_reset);
					break;
				}
			}
			if (i == 0)
				c = 5;
			else if (i == 1)
				c = 4;
			else if (i == 2)
				c = 3;
		}
		c = 6;
		for (int i = 0; i < 2; i++) {
			int k = 4;

			if (i == 1)
				k = 3;

			for (int r = k; r >= 0; r--) {
				if (((_table.get(r).get(c)).getIcon())
						.equals(_player.getDisc())) {
					counter++;
					c--;
				} else {
					counter = 0;
				}
				if (counter == 4) {
					_status.setText(this.deterWin());
					_resetPanel.add(_reset);
					break;
				}
			}
			c = 6;
		}
		return _status;

	}

	public String deterWin() {
		if (_player == _player1)
			return _p1Name+" won!";
		else
			return _p2Name+" won!";
	}

	public static void resetGame() {
		_playerTurn = 0;
		_status.setText("START");
		_resetPanel.remove(_reset);
	}
}
