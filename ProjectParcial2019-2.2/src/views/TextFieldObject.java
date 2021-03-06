package views;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class TextFieldObject extends JTextField{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TextFieldObject() {
		setCaretColor(Constants.DEFAULT_COLOR);
		setFont(Constants.DEFAULT_FONT);
		setSelectedTextColor(Color.WHITE);
		setSelectionColor(Constants.AQUA_COLOR);
		setBorder(new EmptyBorder(10, 10, 10, 10));
	}
	
}
