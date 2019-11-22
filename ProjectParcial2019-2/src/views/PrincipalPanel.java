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
	
	public PrincipalPanel(ArrayList<String> list, Controller controller) {
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);
		
		north = new ContainerNorth(controller);
		add(north, BorderLayout.NORTH);
		
		center = new PanelTable(null);
		add(center, BorderLayout.CENTER);
		
		setVisible(true);
	}

	public void changeLanguage() {
		north.changeLanguage();
		
	}

	public void setNewAvocado(Object[] data) {
		center.setNewAvocado(data);
		
	}

}
