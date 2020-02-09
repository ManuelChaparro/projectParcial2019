package views;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;

import controller.Controller;

public class PanelOptionsGraphics extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PanelOptionsGraphics(Controller controller) {
		setBackground(Constants.DEFAULT_COLOR);
		setLayout(new FlowLayout(0, 20, 10));
		setPreferredSize(new Dimension(1000, 29));
		initComponents(controller);
		setVisible(true);
	}

	private void initComponents(Controller controller) {
		// TODO Auto-generated method stub
		
	}

}
