package views;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import controller.Controller;

public class PrincipalPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ContainerNorth north;
	private PanelTable center;
	private PanelFooter footer;
	private PanelCardLayout cardLayout;
	private JScrollPane scroll;
	private int height, width;
	
	public PrincipalPanel(Controller controller) {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		width = (int) dimension.getWidth();
		height = (int) dimension.getHeight();
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);
		
		north = new ContainerNorth(controller, width, height);
		add(north, BorderLayout.NORTH);
		
		cardLayout = new PanelCardLayout(controller);
		cardLayout.setBorder(new EmptyBorder(10, 100, 10, 100));
		scroll = new JScrollPane(cardLayout);
		add(scroll, BorderLayout.CENTER);
		
		footer = new PanelFooter();
		add(footer, BorderLayout.SOUTH);
		
		setVisible(true);
	}

	public void changeLanguage() {
		north.changeLanguage();
		cardLayout.changeLenguage();
		footer.changeLanguage();
	}

	public void setNewFruit(Object[] data) {
		center.setNewFruit(data);
		
	}

	public void setNewTable(Object[][] strawberryData) {
		cardLayout.setNewTable(strawberryData);
		
	}

	public PanelCardLayout getPanelCardLayout() {
		return this.cardLayout;
		
	}

	public Component getPanelHome() {
		return cardLayout.getPanelHome();
	}
	
	public Component getPanelExport() {
		return cardLayout.getPanelExport();
	}
	
	public Component getPanelGraphics() {
		return cardLayout.getPanelGraphics();
	}
	
	public Component getPanelTable() {
		return cardLayout.getPanelTable();
	}

	public Component getNewFile() {
		return cardLayout.getNewFile();
	}

	public void setNewHome(String pathImageBanana) {
		cardLayout.setNewHome(pathImageBanana);
		
	}

	public Object[] getDataFruit() {
		return cardLayout.getDataFruit();
		
	}

	public void setVisibleNotice(boolean b) {
		cardLayout.setVisibleNotice(b);
	}

	public void clearData() {
		cardLayout.clearData();
		
	}

	public Component getPanelDelete() {
		return cardLayout.getPanelDelete();
	}

	public Object[] getInfoDelete() {
		return cardLayout.getInfoDelete();
	}
	
}
