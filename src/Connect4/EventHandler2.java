package Connect4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class EventHandler2 implements ActionListener{
	
	private ArrayList<ArrayList<JLabel>> _table;
	private ImageIcon _blank;

	public EventHandler2(ArrayList<ArrayList<JLabel>> table, ImageIcon blank){
		_table = table;
		_blank = blank;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		for (int r = 0; r < 6; r++){
			for (int c = 0; c < 7; c++){
				_table.get(r).get(c).setIcon(_blank);
			}
		}
		Game.resetGame();
		
	}

}
