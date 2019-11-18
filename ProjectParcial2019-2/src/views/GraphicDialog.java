package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JDialog;

import controller.Controller;
import handler.HandlerLanguage;

public class GraphicDialog extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PanelOptionsGraphics optionsGraphics;
	private PanelDataGraphic graphic;
	private Image imageIcon;
	
	public GraphicDialog(Controller controller) {
		setTitle(HandlerLanguage.languageProperties.getProperty(Constants.TITLE_DIALOG_GRAPHIC));
		setBackground(Color.WHITE);
		setMinimumSize(new Dimension(500, 500));
		setSize(new Dimension(1000, 500));
		imageIcon = new ImageIcon(getClass().getResource(Constants.PATH_ICON_FRAME)).getImage();
		setIconImage(imageIcon);
		initComponents(controller);
		setVisible(false);
	}

	private void initComponents(Controller controller) {
		optionsGraphics = new PanelOptionsGraphics(controller);
		add(optionsGraphics, BorderLayout.NORTH);
		
		graphic = new PanelDataGraphic(controller);
		add(graphic, BorderLayout.CENTER);
		
	}

	public void changeLanguage() {
		setTitle(HandlerLanguage.languageProperties.getProperty(Constants.TITLE_DIALOG_GRAPHIC));
	}

}
