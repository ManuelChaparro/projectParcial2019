package views;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class LabelObject extends JLabel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public LabelObject(String text, Color background, Color foreground, Font font) {
		setText(text);
		setBackground(background);
		setFont(font);
		setForeground(foreground);
	}

}
