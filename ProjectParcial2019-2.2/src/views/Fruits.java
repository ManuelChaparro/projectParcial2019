package views;

import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.border.EmptyBorder;
import controller.Controller;

public class Fruits extends JComboBox<String>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Fruits(Controller controller) {
		createItems();
		setFont(Constants.DEFAULT_FONT_MIN);
		setForeground(Color.WHITE);
		setBackground(Constants.AQUA_COLOR);
		addActionListener(controller);
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setForeground(Color.WHITE);
	}
	
	private void createItems() {
		addItem(Constants.STRAWBERRY);
		addItem(Constants.BLACKBERRY);
		addItem(Constants.BANANA);
		addItem(Constants.LULO);
		addItem(Constants.PASSION_FRUIT);
		addItem(Constants.PEACH);
	}

}
