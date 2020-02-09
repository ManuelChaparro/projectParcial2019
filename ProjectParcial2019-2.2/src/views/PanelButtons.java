package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.nio.ByteOrder;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

import controller.Commands;
import controller.Controller;
import handler.HandlerLanguage;

public class PanelButtons extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ButtonObject home, export, showGraphics;
	private JMenu fruitMenu;
	private JMenuBar menuBar;
	private JMenuItem bananaItem, blackberryItem, luloItem, passionFruitItem, peachItem, strawberryItem;
	private JPanel west, east, panelLanguage;
	private ButtonObject es, en;
	
	public PanelButtons(Controller controller, LayoutManager layout, Color background, int width, int height) {
		setLayout(layout);
		setBackground(background);
		setPreferredSize(new Dimension((int) (width*Constants.PERCENTAGE_WIDTH), (int) (height*0.1)));
		setBorder(new EmptyBorder(0, 0, 0, 0));
		initComponents(controller);
	}
	
	public void changeLanguage() {
		home.setText(HandlerLanguage.languageProperties.getProperty(Constants.BUTTON_HOME));
		export.setText(HandlerLanguage.languageProperties.getProperty(Constants.BUTTON_EXPORT));
		showGraphics.setText(HandlerLanguage.languageProperties.getProperty(Constants.BUTTON_GRAPHICS));
		fruitMenu.setText(HandlerLanguage.languageProperties.getProperty(Constants.OPTION_CHANGE_FRUIT));
		bananaItem.setText(HandlerLanguage.languageProperties.getProperty(Constants.OPTION_CHANGE_BANANA));
		blackberryItem.setText(HandlerLanguage.languageProperties.getProperty(Constants.OPTION_CHANGE_BLACKBERRY));
		luloItem.setText(HandlerLanguage.languageProperties.getProperty(Constants.OPTION_CHANGE_LULO));
		strawberryItem.setText(HandlerLanguage.languageProperties.getProperty(Constants.OPTION_CHANGE_STRAWBERRY));
		passionFruitItem.setText(HandlerLanguage.languageProperties.getProperty(Constants.OPTION_CHANGE_PASSION_FRUIT));
		peachItem.setText(HandlerLanguage.languageProperties.getProperty(Constants.OPTION_CHANGE_PEACH));
	}

	private void initComponents(Controller controller) {
		//Creation Buttons
		home = new ButtonObject(HandlerLanguage.languageProperties.getProperty(Constants.BUTTON_HOME), Constants.DEFAULT_COLOR.brighter(), controller, Commands.BUTTON_CHANGE_HOME.name(), Constants.DEFAULT_FONT);
		home.setBorder(new EmptyBorder(5, 50, 5, 50));
		home.setFont(Constants.DEFAULT_FONT);
		export = new ButtonObject(HandlerLanguage.languageProperties.getProperty(Constants.BUTTON_EXPORT), Constants.DEFAULT_COLOR.brighter(), controller, Commands.BUTTON_CHANGE_EXPORT.name(), Constants.DEFAULT_FONT);
		export.setBorder(new EmptyBorder(5, 50, 5, 50));
		export.setFont(Constants.DEFAULT_FONT);
		showGraphics = new ButtonObject(HandlerLanguage.languageProperties.getProperty(Constants.BUTTON_GRAPHICS), Constants.DEFAULT_COLOR.brighter(), controller, Commands.BUTTON_CHANGE_GRAPHICS.name(), Constants.DEFAULT_FONT);
		showGraphics.setBorder(new EmptyBorder(5, 50, 5, 50));
		showGraphics.setFont(Constants.DEFAULT_FONT);
		
		//Creation of MenuBar
		menuBar = new JMenuBar();
		menuBar.setBackground(Constants.DEFAULT_COLOR);
		
		//Creation of fruitMenu
		fruitMenu = new JMenu(HandlerLanguage.languageProperties.getProperty(Constants.OPTION_CHANGE_FRUIT));
		fruitMenu.setFont(Constants.DEFAULT_FONT);
		fruitMenu.setForeground(Color.WHITE);
		
		//FruitMenu Items
		bananaItem = new JMenuItem(HandlerLanguage.languageProperties.getProperty(Constants.OPTION_CHANGE_BANANA));
		bananaItem.addActionListener(controller);
		bananaItem.setActionCommand(Commands.BANANA_BUTTON.name());
		bananaItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));
		
		
		blackberryItem = new JMenuItem(HandlerLanguage.languageProperties.getProperty(Constants.OPTION_CHANGE_BLACKBERRY));
		blackberryItem.addActionListener(controller);
		blackberryItem.setActionCommand(Commands.BLACKBERRY_BUTTON.name());
		blackberryItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_DOWN_MASK));		
		
		luloItem = new JMenuItem(HandlerLanguage.languageProperties.getProperty(Constants.OPTION_CHANGE_LULO));
		luloItem.addActionListener(controller);
		luloItem.setActionCommand(Commands.LULO_BUTTON.name());
		luloItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_DOWN_MASK));
		
		passionFruitItem = new JMenuItem(HandlerLanguage.languageProperties.getProperty(Constants.OPTION_CHANGE_PASSION_FRUIT));
		passionFruitItem.addActionListener(controller);
		passionFruitItem.setActionCommand(Commands.PASSION_FRUIT_BUTTON.name());
		passionFruitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_DOWN_MASK));
		
		peachItem = new JMenuItem(HandlerLanguage.languageProperties.getProperty(Constants.OPTION_CHANGE_PEACH));
		peachItem.addActionListener(controller);
		peachItem.setActionCommand(Commands.PEACH_BUTTON.name());
		peachItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));
		
		strawberryItem = new JMenuItem(HandlerLanguage.languageProperties.getProperty(Constants.OPTION_CHANGE_STRAWBERRY));
		strawberryItem.addActionListener(controller);
		strawberryItem.setActionCommand(Commands.STRAWBERRY_BUTTON.name());
		strawberryItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		
		fruitMenu.add(bananaItem);
		fruitMenu.add(blackberryItem);
		fruitMenu.add(luloItem);
		fruitMenu.add(passionFruitItem);
		fruitMenu.add(peachItem);
		fruitMenu.add(strawberryItem);
		
		//AddMenus to Bar
		menuBar.add(fruitMenu);
		
		panelLanguage = new JPanel();
		panelLanguage.setLayout(new FlowLayout());
		panelLanguage.setBackground(Constants.DEFAULT_COLOR);
		panelLanguage.setPreferredSize(new Dimension(100, 300));
		panelLanguage.setBackground(Constants.DEFAULT_COLOR);
		
		es = new ButtonObject("ES", Constants.DEFAULT_COLOR.brighter(), controller, Commands.C_ES_LANGUAGE.name(), Constants.DEFAULT_FONT);
		en = new ButtonObject("EN", Constants.DEFAULT_COLOR.brighter(), controller, Commands.C_EN_LANGUAGE.name(), Constants.DEFAULT_FONT);
		
		panelLanguage.add(es);
		panelLanguage.add(en);
		
		//Add MenuBar to Panel
		west = new JPanel();
		west.setLayout(new FlowLayout());
		west.setBackground(Constants.DEFAULT_COLOR);
		west.setBorder(new EmptyBorder(0, 30, 0, 0));
		west.add(home);
		west.add(export);
		west.add(showGraphics);
		west.add(menuBar);
		
		east = new JPanel();
		east.setLayout(new FlowLayout());
		east.setBackground(Constants.DEFAULT_COLOR);
		east.add(panelLanguage);
		
		add(west, BorderLayout.WEST);
		add(east, BorderLayout.EAST);
		
//		//Create Buttons Fruits
//		Image iconBlackberry = new ImageIcon(getClass().getResource(Constants.PATH_IMAGE_BLACKBERRY)).getImage();
//		Icon rescaledBlackberry = new ImageIcon(iconBlackberry.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
//		blackberry = new ButtonObject("", Color.GREEN, rescaledBlackberry, controller, Commands.BLACKBERRY_BUTTON.name());
//		add(blackberry);
//		
//		Image iconStrawberry = new ImageIcon(getClass().getResource(Constants.PATH_IMAGE_STRAWBERRY)).getImage();
//		Icon rescaledStrawberry = new ImageIcon(iconStrawberry.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
//		strawberry = new ButtonObject("", Color.GREEN, rescaledStrawberry, controller, Commands.STRAWBERRY_BUTTON.name());
//		add(strawberry);
//		
//		Image iconLulo = new ImageIcon(getClass().getResource(Constants.PATH_IMAGE_LULO)).getImage();
//		Icon rescaledLulo = new ImageIcon(iconLulo.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
//		lulo = new ButtonObject("", Color.GREEN, rescaledLulo, controller, Commands.LULO_BUTTON.name());
//		add(lulo);
//		
//		Image iconBanana = new ImageIcon(getClass().getResource(Constants.PATH_IMAGE_BANANA)).getImage();
//		Icon rescaledBanana = new ImageIcon(iconBanana.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
//		banana = new ButtonObject("", Color.GREEN, rescaledBanana, controller, Commands.BANANA_BUTTON.name());
//		add(banana);
//		
//		Image iconPassionFruit = new ImageIcon(getClass().getResource(Constants.PATH_IMAGE_PASSION_FRUIT)).getImage();
//		Icon rescaledFruit = new ImageIcon(iconPassionFruit.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
//		passionFruit = new ButtonObject("", Color.GREEN, rescaledFruit, controller, Commands.PASSION_FRUIT_BUTTON.name());
//		add(passionFruit);
//		
//		Image iconPeach = new ImageIcon(getClass().getResource(Constants.PATH_IMAGE_PEACH)).getImage();
//		Icon rescaledPeach = new ImageIcon(iconPeach.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
//		peach = new ButtonObject("", Color.GREEN, rescaledPeach, controller, Commands.PEACH_BUTTON.name());
//		add(peach);
		
		
	}

}
