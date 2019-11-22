package views;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import controller.Controller;

public class PrincipalPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ContainerNorth north;
	private PanelTable center;
	
	public PrincipalPanel(Object[][] objects, Controller controller) {
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);
		
		north = new ContainerNorth(controller);
		add(north, BorderLayout.NORTH);
		
		center = new PanelTable(objects);
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


}
