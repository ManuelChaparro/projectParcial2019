package views;

import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.border.EmptyBorder;
import controller.Controller;

public class Departments extends JComboBox<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Departments(Controller controller) {
		createItems();
		setFont(Constants.DEFAULT_FONT_MIN);
		setBackground(Constants.AQUA_COLOR);
		addActionListener(controller);
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setForeground(Color.BLACK);
	}

	private void createItems() {
		addItem(Constants.ANTIOQUIA);
		addItem(Constants.BOLIVAR);
		addItem(Constants.BOYACA);
		addItem(Constants.CALDAS);
		addItem(Constants.CAUCA);
		addItem(Constants.CORDOBA);
		addItem(Constants.CUNDINAMARCA);
		addItem(Constants.HUILA);
		addItem(Constants.PUTUMAYO);
		addItem(Constants.TOLIMA);
	}
	
}
