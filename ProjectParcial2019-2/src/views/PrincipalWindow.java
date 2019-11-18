package views;

import java.awt.Dimension;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import controller.Controller;
import handler.HandlerLanguage;

public class PrincipalWindow extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PrincipalPanel principalPanelObject;
	private Image imageIcon;
	
	public PrincipalWindow(ArrayList<String> list, Controller controller) {
		setTitle(HandlerLanguage.languageProperties.getProperty(Constants.TITLE_WINDOW));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setResizable(true);
		setExtendedState(MAXIMIZED_BOTH);
		setMinimumSize(new Dimension(Constants.M_WIDTH_SIZE, Constants.M_HEIGHT_SIZE));
		imageIcon = new ImageIcon(getClass().getResource(Constants.PATH_ICON_FRAME)).getImage();
		setIconImage(imageIcon);
		initComponents(list, controller);
		setVisible(true);
	}
	
	private void initComponents(ArrayList<String> list, Controller controller) {
		principalPanelObject = new PrincipalPanel(list, controller);
		add(principalPanelObject);
	}

	public void changeLanguage() {
		principalPanelObject.changeLanguage();
		setTitle(HandlerLanguage.languageProperties.getProperty(Constants.TITLE_WINDOW));
		
	}

}
