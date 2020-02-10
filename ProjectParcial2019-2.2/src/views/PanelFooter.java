package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Commands;
import controller.Controller;
import handler.HandlerLanguage;

public class PanelFooter extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel containerTwo, containerThree, containerButtons;
	private LabelObject country, cellphone, aboutUs, titleFooter;
	private ButtonObject facebook, instagram, youtube;
	
	public PanelFooter(Controller controller) {
		setPreferredSize(new Dimension((int) (Constants.WIDTH*0.8), (int) (Constants.HEIGTH*0.2)));
		setBackground(Constants.DEFAULT_COLOR);
		setLayout(new BorderLayout());
		setBorder(new EmptyBorder(20, 100, 0, 100));
		initComponents(controller);
	}

	private void initComponents(Controller controller) {
		try {
			//Creation of Container
		
			containerTwo = new JPanel();
			containerTwo.setLayout(new FlowLayout());
			
			containerThree = new JPanel();
			containerThree.setLayout(new FlowLayout());
			
			containerButtons = new JPanel();
			containerButtons.setLayout(new FlowLayout());
			
			//Creation JLabels
			titleFooter = new LabelObject(HandlerLanguage.languageProperties.getProperty(Constants.FOOTER_TITLE), Color.BLACK,
					Color.WHITE, Constants.DEFAULT_FONT_MAX);
			country = new LabelObject(HandlerLanguage.languageProperties.getProperty(Constants.FOOTER_COUNTRY), Color.BLACK,
					Color.WHITE, Constants.DEFAULT_FONT_MIN);
			cellphone = new LabelObject(HandlerLanguage.languageProperties.getProperty(Constants.FOOTER_CELLPHONE), Color.BLACK,
					Color.WHITE, Constants.DEFAULT_FONT_MIN);
			aboutUs = new LabelObject(HandlerLanguage.languageProperties.getProperty(Constants.FOOTER_ABOUT_US), Color.BLACK,
					Color.WHITE, Constants.DEFAULT_FONT_MIN);
			
			//Creation buttons
			Image imageFacebook = new ImageIcon(getClass().getResource(Constants.PATH_ICON_FACEBOOK)).getImage();
			Icon rescaledFacebook = new ImageIcon(imageFacebook.getScaledInstance((int) (Constants.WIDTH * 0.03),
					(int) (Constants.WIDTH * 0.03), Image.SCALE_SMOOTH));
			facebook = new ButtonObject("", Color.BLACK, rescaledFacebook, controller,
					Commands.BUTTON_FACEBOOK.name(), Constants.DEFAULT_FONT);
			
			Image imageInstagram = new ImageIcon(getClass().getResource(Constants.PATH_ICON_INSTAGRAM)).getImage();
			Icon rescaledInstagram = new ImageIcon(imageInstagram.getScaledInstance((int) (Constants.WIDTH * 0.03),
					(int) (Constants.WIDTH * 0.03), Image.SCALE_SMOOTH));
			instagram = new ButtonObject("", Color.BLACK, rescaledInstagram, controller,
					Commands.BUTTON_INSTAGRAM.name(), Constants.DEFAULT_FONT, Constants.PATH_URL_INSTAGRAM);
			
			Image imageYoutube = new ImageIcon(getClass().getResource(Constants.PATH_ICON_YOUTUBE)).getImage();
			Icon rescaledYoutube = new ImageIcon(imageYoutube.getScaledInstance((int) (Constants.WIDTH * 0.03),
					(int) (Constants.WIDTH * 0.03), Image.SCALE_SMOOTH));
			youtube = new ButtonObject("", Color.BLACK, rescaledYoutube, controller,
					Commands.BUTTON_YOUTUBE.name(), Constants.DEFAULT_FONT, Constants.PATH_URL_YOUTUBE);
			
			//Add info to Containers
			containerButtons.add(facebook);
			containerButtons.add(instagram);
			containerButtons.add(youtube);
			containerButtons.setBackground(Constants.DEFAULT_COLOR);
			
			
			containerTwo.add(cellphone);			containerTwo.add(country);
			containerTwo.add(aboutUs);
			containerTwo.setBackground(Constants.DEFAULT_COLOR);
			
			containerThree.add(titleFooter);
			containerThree.setBackground(Constants.DEFAULT_COLOR);
			
			//Add Containers to Panel
			add(containerThree, BorderLayout.NORTH);
			add(containerButtons, BorderLayout.CENTER);
			add(containerTwo, BorderLayout.SOUTH);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void changeLanguage() {
		country.setText(HandlerLanguage.languageProperties.getProperty(Constants.FOOTER_COUNTRY));
		cellphone.setText(HandlerLanguage.languageProperties.getProperty(Constants.FOOTER_CELLPHONE));
		aboutUs.setText(HandlerLanguage.languageProperties.getProperty(Constants.FOOTER_ABOUT_US));
		titleFooter.setText(HandlerLanguage.languageProperties.getProperty(Constants.FOOTER_TITLE));
	}
	

}
