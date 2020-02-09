package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import handler.HandlerLanguage;

public class PanelFooter extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel containerOne, containerTwo, containerThree;
	private LabelObject country, cellphone, aboutUs;
	
	public PanelFooter() {
		setPreferredSize(new Dimension(1000, 150));
		setBackground(Color.BLACK);
		setLayout(new BorderLayout());
		setBorder(new EmptyBorder(20, 100, 0, 100));
		initComponents();
	}

	private void initComponents() {
		//Creation of Container
		containerOne = new JPanel();
		containerTwo = new JPanel();
		containerThree = new JPanel();
		
		//Creation JLabels
		country = new LabelObject(HandlerLanguage.languageProperties.getProperty(Constants.FOOTER_COUNTRY), Color.BLACK,
				Color.WHITE, Constants.DEFAULT_FONT_MIN);
		cellphone = new LabelObject(HandlerLanguage.languageProperties.getProperty(Constants.FOOTER_CELLPHONE), Color.BLACK,
				Color.WHITE, Constants.DEFAULT_FONT_MIN);
		aboutUs = new LabelObject(HandlerLanguage.languageProperties.getProperty(Constants.FOOTER_ABOUT_US), Color.BLACK,
				Color.WHITE, Constants.DEFAULT_FONT_MIN);
		
		//Add Labels to Containers
		containerOne.add(country);
		containerOne.setBackground(Color.BLACK);
		containerTwo.add(cellphone);
		containerTwo.setBackground(Color.BLACK);
		containerThree.add(aboutUs);
		containerThree.setBackground(Color.BLACK);
		
		//Add Containers to Panel
		add(containerOne, BorderLayout.WEST);
		add(containerTwo, BorderLayout.CENTER);
		add(containerThree, BorderLayout.EAST);
	}
	
	public void changeLanguage() {
		country.setText(HandlerLanguage.languageProperties.getProperty(Constants.FOOTER_COUNTRY));
		cellphone.setText(HandlerLanguage.languageProperties.getProperty(Constants.FOOTER_CELLPHONE));
		aboutUs.setText(HandlerLanguage.languageProperties.getProperty(Constants.FOOTER_ABOUT_US));
	}

}
