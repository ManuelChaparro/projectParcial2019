package views;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JPanel;

import controller.Controller;

public class PanelCardLayout extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PanelHome homeSpanish;
	private PanelExport export;
	private PanelGraphics graphics;
	private PanelTable table;
	private NewFileDialog newFile;
	private DeleteChain deleteFile;
	
	public PanelCardLayout(Controller controller) {
		setLayout(new CardLayout());
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension((int) (Constants.WIDTH*0.8), (int) (Constants.HEIGTH)));
		initComponents(controller);
	}

	private void initComponents(Controller controller) {
		homeSpanish = new PanelHome(Constants.PATH_IMAGE_HOME);
		add(homeSpanish, "Panel one");
		
		export = new PanelExport(controller);
		add(export, "Panel two");
		
		graphics = new PanelGraphics(controller);
		add(graphics, "Panel three");
		
		table = new PanelTable(controller);
		add(table, "Panel four");
		
		newFile = new NewFileDialog(controller);
		add(newFile, "Panel five");
		
		deleteFile = new DeleteChain(controller);
		add(deleteFile);
	}

	public Component getPanelHome() {
		return this.homeSpanish;
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
		export.changeLanguage();
		graphics.changeLanguage();
	}

	public void setNewHome(String pathImageBanana) {
		homeSpanish = new PanelHome(Constants.PATH_IMAGE_BANANA);
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

	public void setVisibleButtonsExport(boolean option) {
		export.setVisibleButtonsExport(option);
	}


	public void changeReport(Object[][] newData, int  option, boolean visible) {
		export.changeReport(newData, option, visible);
	}

	public void createGraphic(String[][] matrix, boolean visible) {
		graphics.createGraphic(matrix, visible);
		graphics.repaint();
	}

	public String getDepartment(boolean option) {
		if (option) {
			return export.getDepartment();
		}else {
			return graphics.getDepartment();
		}

		
	}
	
	public void deletePanel() {

	}

	public void createGraphicBar(String[][] matrix, boolean visible) {
		graphics.createGraphicBar(matrix, visible);
		graphics.repaint();
	}


	
	
	
	
	

}
