package views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ButtonObject extends JButton{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public ButtonObject(String text, Color background) {
		setText(text);
		setBackground(background);
	}
	
	public ButtonObject(String text, Color background, Icon rescaled, ActionListener actionListener, String Command, Font font) {
		setText(text);
		setBackground(background);
		setIcon(rescaled);
		setOpaque(false);
		setBorder(null);
		setContentAreaFilled(false);
		setHorizontalTextPosition( SwingConstants.CENTER );
		setVerticalTextPosition( SwingConstants.BOTTOM );
		setCursor(new Cursor(12));
		setActionCommand(Command);
		addActionListener(actionListener);
		setFont(font);
		setForeground(Color.BLACK);
		setBorder(new EmptyBorder(10, 50, 10, 50));
	}
	public ButtonObject(String text, Color background, Icon rescaled, ActionListener actionListener, String Command, Font font, String url) {
		setText(text);
		setBackground(background);
		setIcon(rescaled);
		setOpaque(false);
		setBorder(null);
		setContentAreaFilled(false);
		setHorizontalTextPosition( SwingConstants.CENTER );
		setVerticalTextPosition( SwingConstants.BOTTOM );
		setCursor(new Cursor(12));
		setActionCommand(Command);
		addActionListener(actionListener);
		setFont(font);
		setToolTipText(url);
	}
	
	public ButtonObject(String text, Color background, ActionListener actionListener, String Command, Font font) {
		setText(text);
		setFont(font);
		setBackground(background);
		setOpaque(false);
		setBorder(null);
		setContentAreaFilled(false);
		setHorizontalTextPosition( SwingConstants.CENTER );
		setVerticalTextPosition( SwingConstants.BOTTOM );
		setCursor(new Cursor(12));
		setActionCommand(Command);
		addActionListener(actionListener);
		setForeground(Color.WHITE);
	}

}
