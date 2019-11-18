package views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class ButtonObject extends JButton{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public ButtonObject(String text, Color background) {
		setText(text);
		setBackground(background);
	}
	
	public ButtonObject(String text, Color background, Icon rescaledHousing, ActionListener actionListener, String Command) {
		setText(text);
		setBackground(background);
		setIcon(rescaledHousing);
		setOpaque(false);
		setBorder(null);
		setContentAreaFilled(false);
		setHorizontalTextPosition( SwingConstants.CENTER );
		setVerticalTextPosition( SwingConstants.BOTTOM );
		setCursor(new Cursor(12));
		setActionCommand(Command);
		addActionListener(actionListener);
	}

}
