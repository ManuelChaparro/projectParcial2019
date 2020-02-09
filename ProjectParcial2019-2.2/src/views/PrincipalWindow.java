package views;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import controller.Controller;
import handler.HandlerLanguage;

public class PrincipalWindow extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PrincipalPanel principalPanelObject;
	private Image imageIcon;
	private JScrollPane scroll;
	
	public PrincipalWindow(Controller controller) {
		setTitle(HandlerLanguage.languageProperties.getProperty(Constants.TITLE_WINDOW));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setResizable(true);
		setExtendedState(MAXIMIZED_BOTH);
		setMinimumSize(new Dimension(Constants.M_WIDTH_SIZE, Constants.M_HEIGHT_SIZE));
		imageIcon = new ImageIcon(getClass().getResource(Constants.PATH_ICON_FRAME)).getImage();
		setIconImage(imageIcon);
		initComponents(controller);
		setVisible(true);
	}
	
	private void initComponents(Controller controller) {
		principalPanelObject = new PrincipalPanel(controller);
		scroll = new JScrollPane(principalPanelObject);
		add(scroll);
	}

	public void changeLanguage() {
		principalPanelObject.changeLanguage();
		setTitle(HandlerLanguage.languageProperties.getProperty(Constants.TITLE_WINDOW));
		
	}

	public void setNewFruitInTable(Object[] data) {
		principalPanelObject.setNewFruit(data);
		
	}

	public void setNewTable(Object[][] strawberryData) {
		principalPanelObject.setNewTable(strawberryData);
		
	}

	public PanelCardLayout getPanelCardLayout() {
		return principalPanelObject.getPanelCardLayout();
		
	}

	public Component getPanelHome() {
		return principalPanelObject.getPanelHome();
	}

	public Component getPanelExport() {
		return principalPanelObject.getPanelExport();
	}

	public Component getPanelGraphics() {
		return principalPanelObject.getPanelGraphics();
	}

	public Component getPanelTable() {
		return principalPanelObject.getPanelTable();
	}

	public Component getNewFile() {
		return principalPanelObject.getNewFile();
	}

	public void setNewHome(String pathImageBanana) {
		principalPanelObject.setNewHome(pathImageBanana);
		
	}

	public Object[] getDataFruit() {
		return principalPanelObject.getDataFruit();
		
	}

	public void setVisibleNotice(boolean b) {
		principalPanelObject.setVisibleNotice(b);
	}

	public void clearData() {
		principalPanelObject.clearData();
		
	}

	public Component getPanelDelete() {
		return principalPanelObject.getPanelDelete();
	}

	public Object[] getInfoDelete() {
		return principalPanelObject.getInfoDelete();
	}

}
