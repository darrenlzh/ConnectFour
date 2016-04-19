package Connect4;

import javax.swing.ImageIcon;

public class Player {

	private ImageIcon _image;
	private String _s;

	public Player(ImageIcon image, String s) {

		_image = image;
		_s = s;
	}

	public ImageIcon getDisc() {
		return _image;
	}
	
	public String getString(){
		return _s;
	}
}

