package views;

import java.awt.Color;
import javax.swing.JComboBox;
import handler.HandlerLanguage;

public class PhysicalState extends JComboBox<String>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PhysicalState() {
		setFont(Constants.DEFAULT_FONT_MIN);
		setBackground(Color.WHITE);
		createItems();
	}

	private void createItems() {
		addItem(HandlerLanguage.languageProperties.getProperty(Constants.STATE_FRUIT_EXCELENT));
		addItem(HandlerLanguage.languageProperties.getProperty(Constants.STATE_FRUIT_BAD));
	}
	
	public void changeLanguage() {
		
	}

}







