package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;
import controller.Controller;

public class PrincipalPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ContainerNorth north;
	private PanelTable center;
	
	public PrincipalPanel(Object[][] blackberryData, Controller controller) {
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);
		
		north = new ContainerNorth(controller);
		add(north, BorderLayout.NORTH);
		
		center = new PanelTable(blackberryData);
		add(center, BorderLayout.CENTER);
		
		setVisible(true);
	}

	public void changeLanguage() {
		north.changeLanguage();
		center.changeLenguage();
	}

	public void setNewAvocado(Object[] data) {
		center.setNewAvocado(data);
		
	}

	public void setNewTable(Object[][] strawberryData) {
		center.setNewTable(strawberryData);
		
	}



}
