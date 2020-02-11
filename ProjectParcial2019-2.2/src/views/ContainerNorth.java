package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Controller;


public class ContainerNorth extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PanelButtons buttons;
	private PanelBanner banner;

	public ContainerNorth(Controller controller, int width, int height) {		
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension((int) (width*0.8), (int) (height*0.5)));
		setBorder(new EmptyBorder((int) (height*0.05), (int) (width*0.1),
				(int) (height*0.05), (int) (width*0.1)));
		setBackground(Color.WHITE);
		initComponents(controller, width, height);
		setVisible(true);
	}

	private void initComponents(Controller controller, int width, int height) {
		banner = new PanelBanner(width, height);
		add(banner, BorderLayout.NORTH);
		
		buttons = new PanelButtons(controller, new BorderLayout(), Constants.DEFAULT_COLOR, width, height);
		add(buttons, BorderLayout.CENTER);
		


	}

	public void changeLanguage() {
		buttons.changeLanguage();
	}

}
