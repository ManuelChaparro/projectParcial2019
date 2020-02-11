package views;

import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.border.EmptyBorder;
import controller.Controller;

public class Gender extends JComboBox<String>{

	
	private static final long serialVersionUID = 1L;

	public Gender(Controller controller) {
		createItems();
		setFont(Constants.DEFAULT_FONT_MIN);
		setForeground(Color.WHITE);
		setBackground(Constants.AQUA_COLOR);
		addActionListener(controller);
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setForeground(Color.WHITE);
	}
	
	private void createItems() {
		addItem(Constants.WOMAN);
		addItem(Constants.MALE);
	}
}
