package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Commands;
import controller.Controller;
import handler.HandlerLanguage;

public class PanelGraphics extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Departments departments;
	private JPanelStandardAgeBars panelBars;
	private JPanelCake cakePanel;
	private PanelObject north, center, south, containerButtons;
	private ButtonObject reportOne, reportTwo, reportThree, reportFour, reportFive, reportSix, reportSeven, reportEigth,
			reportNine, reportTen;

	public PanelGraphics(Controller controller) {
		setPreferredSize(new Dimension(Constants.WIDTH, Constants.HEIGTH));
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);
		initComponents(controller);
	}

	private void initComponents(Controller controller) {
		// Containers
		createPanels();

		// Buttons
		createButtons(controller);
		
		containerButtons.add(reportOne);
		containerButtons.add(reportTwo);
		containerButtons.add(reportThree);
		containerButtons.add(reportFour);
		containerButtons.add(reportFive);
		containerButtons.add(reportSix);
		containerButtons.add(reportSeven);
		containerButtons.add(reportEigth);
		containerButtons.add(reportNine);
		containerButtons.add(reportTen);
		
		north.add(departments, BorderLayout.NORTH);
		north.add(containerButtons, BorderLayout.CENTER);

		add(north, BorderLayout.NORTH);
		add(center, BorderLayout.CENTER);
	}

	private void createButtons(Controller controller) {
		departments = new Departments(controller);
		
		reportOne = new ButtonObject(HandlerLanguage.languageProperties.getProperty(Constants.BUTTON_REPORT_ONE), Constants.DEFAULT_COLOR,
				controller, Commands.GRAPHIC_ONE.name(), Constants.DEFAULT_FONT);
		
		
		reportTwo = new ButtonObject(HandlerLanguage.languageProperties.getProperty(Constants.BUTTON_REPORT_TWO), Constants.DEFAULT_COLOR,
				controller, Commands.GRAPHIC_TWO.name(), Constants.DEFAULT_FONT);
		
		
		reportThree = new ButtonObject(HandlerLanguage.languageProperties.getProperty(Constants.BUTTON_REPORT_THREE), Constants.DEFAULT_COLOR,
				controller, Commands.GRAPHIC_THREE.name(), Constants.DEFAULT_FONT);
		
		
		reportFour = new ButtonObject(HandlerLanguage.languageProperties.getProperty(Constants.BUTTON_REPORT_FOUR), Constants.DEFAULT_COLOR,
				controller, Commands.GRAPHIC_FOUR.name(), Constants.DEFAULT_FONT);
		
		
		reportFive = new ButtonObject(HandlerLanguage.languageProperties.getProperty(Constants.BUTTON_REPORT_FIVE), Constants.DEFAULT_COLOR,
				controller, Commands.GRAPHIC_FIVE.name(), Constants.DEFAULT_FONT);
		
		
		reportSix = new ButtonObject(HandlerLanguage.languageProperties.getProperty(Constants.BUTTON_REPORT_SIX), Constants.DEFAULT_COLOR,
				controller, Commands.GRAPHIC_SIX.name(), Constants.DEFAULT_FONT);
		
		
		reportSeven = new ButtonObject(HandlerLanguage.languageProperties.getProperty(Constants.BUTTON_REPORT_SEVEN), Constants.DEFAULT_COLOR,
				controller, Commands.GRAPHIC_SEVEN.name(), Constants.DEFAULT_FONT);
		
		
		reportEigth = new ButtonObject(HandlerLanguage.languageProperties.getProperty(Constants.BUTTON_REPORT_EIGHT), Constants.DEFAULT_COLOR,
				controller, Commands.GRAPHIC_EIGHT.name(), Constants.DEFAULT_FONT);
		
		
		reportNine = new ButtonObject(HandlerLanguage.languageProperties.getProperty(Constants.BUTTON_REPORT_NINE), Constants.DEFAULT_COLOR,
				controller, Commands.GRAPHIC_NINE.name(), Constants.DEFAULT_FONT);
		
		
		reportTen = new ButtonObject(HandlerLanguage.languageProperties.getProperty(Constants.BUTTON_REPORT_TEN), Constants.DEFAULT_COLOR,
				controller, Commands.GRAPHIC_TEN.name(), Constants.DEFAULT_FONT);
		
	}

	private void createPanels() {
		north = new PanelObject(new BorderLayout(), Constants.ORANGE_COLOR);
		north.setPreferredSize(new Dimension(Constants.WIDTH, (int) (Constants.HEIGTH*0.2)));
		
		containerButtons = new PanelObject(new FlowLayout(), Constants.ORANGE_COLOR);
		containerButtons.setLayout(new GridLayout(2, 5, 10, 10));
		containerButtons.setPreferredSize(new Dimension(Constants.WIDTH, (int) (Constants.HEIGTH*0.19)));
		containerButtons.setBorder(new EmptyBorder(2, 20, 12, 20));

		center = new PanelObject(new BorderLayout(), Color.WHITE);
		center.setPreferredSize(new Dimension(Constants.WIDTH, (int) (Constants.HEIGTH * 0.55)));

		south = new PanelObject(new FlowLayout(), Color.WHITE);
		south.setPreferredSize(new Dimension(Constants.WIDTH, (int) (Constants.HEIGTH * 0.2)));
		south.setVisible(false);

	}
	
	public void createGraphic(String[][] matrix, boolean visible) {
		center.removeAll();
		cakePanel = new JPanelCake(matrix);
		center.add(cakePanel);
		departments.setVisible(visible);
		center.repaint();
	}
	
	public void createGraphicBar(String[][] matrix, boolean visible) {
		center.removeAll();
		panelBars = new JPanelStandardAgeBars(matrix);
		center.add(panelBars);
		departments.setVisible(visible);
		center.repaint();
	}

	public String getDepartment() {
		return (String) departments.getSelectedItem();
	}
	
	public void changeLanguage() {
		reportOne.setText(HandlerLanguage.languageProperties.getProperty(Constants.BUTTON_REPORT_ONE));
		reportTwo.setText(HandlerLanguage.languageProperties.getProperty(Constants.BUTTON_REPORT_TWO));
		reportThree.setText(HandlerLanguage.languageProperties.getProperty(Constants.BUTTON_REPORT_THREE));
		reportFour.setText(HandlerLanguage.languageProperties.getProperty(Constants.BUTTON_REPORT_FOUR));
		reportFive.setText(HandlerLanguage.languageProperties.getProperty(Constants.BUTTON_REPORT_FIVE));
		reportSix.setText(HandlerLanguage.languageProperties.getProperty(Constants.BUTTON_REPORT_SIX));
		reportSeven.setText(HandlerLanguage.languageProperties.getProperty(Constants.BUTTON_REPORT_SEVEN));
		reportEigth.setText(HandlerLanguage.languageProperties.getProperty(Constants.BUTTON_REPORT_EIGHT));
		reportNine.setText(HandlerLanguage.languageProperties.getProperty(Constants.BUTTON_REPORT_NINE));
		reportTen.setText(HandlerLanguage.languageProperties.getProperty(Constants.BUTTON_REPORT_TEN));
	}

}
