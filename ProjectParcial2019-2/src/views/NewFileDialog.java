package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Controller;
import handler.HandlerLanguage;

public class NewFileDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private NewFileContainer container;
	private JLabel description;
	private Image imageIcon;
	
	public NewFileDialog(Controller controller) {
		setTitle(HandlerLanguage.languageProperties.getProperty(Constants.TITLE_DIALOG_NEW));
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setResizable(false);
		setLocation(50, 100);
		setMinimumSize(new Dimension(600, 500));
//		setUndecorated(true);
		imageIcon = new ImageIcon(getClass().getResource(Constants.PATH_ICON_FRAME)).getImage();
		setIconImage(imageIcon);
		initComponents(controller);
		setVisible(false);
	}

	private void initComponents(Controller controller) {
		JPanel northLabel = new JPanel();
		System.out.println(HandlerLanguage.languageProperties.getProperty(Constants.TITLE_ADD_NEW_CHAIN));
		description = new JLabel(HandlerLanguage.languageProperties.getProperty(Constants.TITLE_ADD_NEW_CHAIN));
		northLabel.setBackground(Color.WHITE);
		description.setFont(Constants.DEFAULT_FONT);
		northLabel.setLayout(new FlowLayout(0, 200, 7));
		northLabel.add(description);
		add(northLabel, BorderLayout.NORTH);
		
		container = new NewFileContainer(controller);
		add(container, BorderLayout.CENTER);
	}

	public void changeLanguage() {
		setTitle(HandlerLanguage.languageProperties.getProperty(Constants.TITLE_DIALOG_NEW));
		description.setText(HandlerLanguage.languageProperties.getProperty(Constants.TITLE_ADD_NEW_CHAIN));
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

	public Object[] getDataAvocado() {
		return container.getDataAvocado();
	}

	public void clearData() {
		container.clearData();
		
	}

}
