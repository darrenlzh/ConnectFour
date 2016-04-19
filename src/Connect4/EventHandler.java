package Connect4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventHandler implements ActionListener {

	private Game _game;

	public EventHandler(Game game){
		
		_game = game;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object source = e.getSource();
		_game.trackPlayer();
		_game.place(source);
		_game.update();
		_game.checkWinHorizontal();	
		_game.checkWinVertical();
		_game.checkWinDiagonal();
	}

}