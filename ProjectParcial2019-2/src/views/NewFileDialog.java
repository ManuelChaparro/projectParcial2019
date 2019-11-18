package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JDialog;

import controller.Controller;
import handler.HandlerLanguage;

public class NewFileDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private NewFileContainer container;
	private Image imageIcon;

	public NewFileDialog(Controller controller) {
		setTitle(HandlerLanguage.languageProperties.getProperty(Constants.TITLE_DIALOG_NEW));
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setResizable(false);
		setMinimumSize(new Dimension(600, 450));
		imageIcon = new ImageIcon(getClass().getResource(Constants.PATH_ICON_FRAME)).getImage();
		setIconImage(imageIcon);
		initComponents(controller);
		setVisible(false);
	}

	private void initComponents(Controller controller) {
		container = new NewFileContainer(controller);
		add(container, BorderLayout.CENTER);
	}

	public void changeLanguage() {
		setTitle(HandlerLanguage.languageProperties.getProperty(Constants.TITLE_DIALOG_NEW));
		container.changeLanguage();
	}

	public void setIdDepartment() {
		container.setIdDepartment();
	}
	
	public int[] getDataPerformance() {
		return container.getDataPerformance();
	}

	public void setPerformance(int performance) {
		container.setPerformance(performance);
		
	}

}
