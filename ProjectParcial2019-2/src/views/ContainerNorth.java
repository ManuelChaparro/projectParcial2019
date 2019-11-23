package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

import controller.Commands;
import controller.Controller;
import handler.HandlerLanguage;

public class ContainerNorth extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenu archiveMenu, changeLenguageMenu;
	private JMenuBar menuBar;
	private JMenuItem spanishItem, englishItem, addAvocadoItem, showGraphicItem, deleteItem;

	public ContainerNorth(Controller controller) {
		setLayout(new FlowLayout(0, 15, 0));
		setSize(new Dimension(20, 20));
		setBorder(new EmptyBorder(3,0,3,0));
		setBackground(Constants.DEFAULT_COLOR);
		initComponents(controller);
		setVisible(true);
	}

	private void initComponents(Controller controller) {
		//Creation of MenuBar
		menuBar = new JMenuBar();
		menuBar.setBackground(Constants.DEFAULT_COLOR);
		
		//Creation of MenuFile
		archiveMenu = new JMenu(HandlerLanguage.languageProperties.getProperty(Constants.OPTION_FILE));
		archiveMenu.setFont(Constants.DEFAULT_FONT);
		archiveMenu.setForeground(Color.WHITE);
		
		//MenuFile Items
		addAvocadoItem = new JMenuItem(HandlerLanguage.languageProperties.getProperty(Constants.OPTION_FILE_ADD_AVOCADO));
		addAvocadoItem.addActionListener(controller);
		addAvocadoItem.setActionCommand(Commands.ADD_AVOCADO.name());
		addAvocadoItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));
		
		showGraphicItem = new JMenuItem(HandlerLanguage.languageProperties.getProperty(Constants.OPTION_FILE_SHOW_GRAPHIC));
		showGraphicItem.addActionListener(controller);
		showGraphicItem.setActionCommand(Commands.SHOW_GRAPHIC.name());
		showGraphicItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_DOWN_MASK));
		
		deleteItem = new JMenuItem(HandlerLanguage.languageProperties.getProperty(Constants.OPTION_DELETE_ITEM));
		deleteItem.addActionListener(controller);
		deleteItem.setActionCommand(Commands.DELETE_CHAIN.name());
		deleteItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK));
		
		//Creation of MenuLanguage
		changeLenguageMenu = new JMenu(HandlerLanguage.languageProperties.getProperty(Constants.OPTION_CHANGE_LANGUAGE));
		changeLenguageMenu.setFont(Constants.DEFAULT_FONT);
		changeLenguageMenu.setForeground(Color.WHITE);
		
		//MenuLanguage Items
		spanishItem = new JMenuItem(HandlerLanguage.languageProperties.getProperty(Constants.OPTION_CHANGE_L_SPANISH));
		spanishItem.addActionListener(controller);
		spanishItem.setActionCommand(Commands.C_ES_LANGUAGE.name());
		spanishItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		
		englishItem = new JMenuItem(HandlerLanguage.languageProperties.getProperty(Constants.OPTION_CHANGE_L_ENGLISH));
		englishItem.setActionCommand(Commands.C_EN_LANGUAGE.name());
		englishItem.addActionListener(controller);
		englishItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));
		
		//Add Items to Menus
		archiveMenu.add(addAvocadoItem);
		archiveMenu.add(showGraphicItem);
		archiveMenu.add(deleteItem);
		
		changeLenguageMenu.add(spanishItem);
		changeLenguageMenu.add(englishItem);
		
		//AddMenus to Bar
		menuBar.add(archiveMenu);
		menuBar.add(changeLenguageMenu);
		
		//Add MenuBar to Panel
		add(menuBar);
	}

	public void changeLanguage() {
		archiveMenu.setText(HandlerLanguage.languageProperties.getProperty(Constants.OPTION_FILE));
		addAvocadoItem.setText(HandlerLanguage.languageProperties.getProperty(Constants.OPTION_FILE_ADD_AVOCADO));
		showGraphicItem.setText(HandlerLanguage.languageProperties.getProperty(Constants.OPTION_FILE_SHOW_GRAPHIC));
		deleteItem.setText(HandlerLanguage.languageProperties.getProperty(Constants.OPTION_DELETE_ITEM));
		changeLenguageMenu.setText(HandlerLanguage.languageProperties.getProperty(Constants.OPTION_CHANGE_LANGUAGE));
		spanishItem.setText(HandlerLanguage.languageProperties.getProperty(Constants.OPTION_CHANGE_L_SPANISH));
		englishItem.setText(HandlerLanguage.languageProperties.getProperty(Constants.OPTION_CHANGE_L_ENGLISH));
	}

}
