package views;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import controller.Controller;

public class PanelCardLayout extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PanelHome home;
	private PanelExport export;
	private PanelGraphics graphics;
	private PanelTable table;
	private NewFileDialog newFile;
	private DeleteChain deleteFile;
	
	public PanelCardLayout(Controller controller) {
		setLayout(new CardLayout());
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(Constants.WIDTH, (int) (Constants.HEIGTH)));
		initComponents(controller);
	}

	private void initComponents(Controller controller) {
		home = new PanelHome(Constants.PATH_IMAGE_HOME);
		add(home, "Panel one");
		
		export = new PanelExport();
		add(home, "Panel two");
		
		graphics = new PanelGraphics();
		add(home, "Panel three");
		
		table = new PanelTable(controller);
		add(home, "Panel four");
		
		newFile = new NewFileDialog(controller);
		add(newFile, "Panel five");
		
		deleteFile = new DeleteChain(controller);
		add(deleteFile);
	}

	public Component getPanelHome() {
		return this.home;
	}
	
	public Component getPanelExport() {
		return this.export;
	}
	
	public Component getPanelGraphics() {
		return this.graphics;
	}
	
	public Component getPanelTable() {
		return this.table;
	}
	
	public Component getNewFile() {
		return this.newFile;
	}

	public void setNewTable(Object[][] strawberryData) {
		table.setNewTable(strawberryData);
		deleteFile.setNewTable(strawberryData);
	}

	public void changeLenguage() {
		table.changeLenguage();	
		newFile.changeLanguage();
		deleteFile.changeLanguage();
	}

	public void setNewHome(String pathImageBanana) {
		home = new PanelHome(Constants.PATH_IMAGE_BANANA);
	}

	public Object[] getDataFruit() {
		return newFile.getDataFruit();
		
	}

	public void setVisibleNotice(boolean b) {
		newFile.setVisibleNotice(b);
	}

	public void clearData() {
		newFile.clearData();
		
	}

	public Component getPanelDelete() {
		return this.deleteFile;
	}

	public Object[] getInfoDelete() {
		return deleteFile.getInfoDelete();
	}

	public void setVisibleDelete() {
		deleteFile.setVisibleDelete();
		
	}
	
	
	
	
	
	

}
