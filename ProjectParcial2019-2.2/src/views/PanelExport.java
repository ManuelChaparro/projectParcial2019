package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.Commands;
import controller.Controller;
import handler.HandlerLanguage;

public class PanelExport extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PanelObject north, center, south, containerButtons;
	private Departments departments;
	private ButtonObject json, binary, text, reportOne, reportTwo, reportThree,
	reportFour, reportFive, reportSix, reportSeven, reportEigth, reportNine, reportTen;
	private JTable table;
	private DefaultTableModel tableModel;
	private JScrollPane scroll;
	private int sizeImage, optionAux;

	public PanelExport(Controller controller) {
		sizeImage = (int) (Constants.WIDTH*0.03);
		setPreferredSize(new Dimension(Constants.WIDTH, Constants.HEIGTH));
		setLayout(new BorderLayout());
		setBackground(Color.YELLOW);
		initComponents(controller);
	}

	private void initComponents(Controller controller) {
	
		//Containers
		createPanels();

		//Buttons
		createButtons(controller);
		
		//Table
		createTable();
		
		//Add info to containers
		
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
		
		center.add(scroll);
		
		south.add(json);
		south.add(binary);
		south.add(text);
		
		add(north, BorderLayout.NORTH);
		add(center, BorderLayout.CENTER);
		add(south, BorderLayout.SOUTH);
		
	}

	private void createTable() {
		tableModel = new DefaultTableModel();
		table = new JTable(tableModel);
		table.setBackground(Color.WHITE);
		table.setFont(Constants.DEFAULT_FONT_MIN);
		table.getTableHeader().setFont(Constants.DEFAULT_FONT_MIN);
		table.setEditingRow(500);
		table.getTableHeader().setBackground(Constants.DEFAULT_COLOR);
		table.getTableHeader().setForeground(Color.WHITE);
		table.getTableHeader().setFont(Constants.DEFAULT_FONT_MIN);
		table.setEnabled(false);
		table.setRowHeight(25);
		table.setSelectionBackground(Color.CYAN.darker().darker());
		table.setSelectionForeground(Color.WHITE);
		scroll = new JScrollPane(table);
		table.getTableHeader().setReorderingAllowed(false);
	}



	private void createPanels() {
		north = new PanelObject(new BorderLayout(), Constants.ORANGE_COLOR);
		north.setPreferredSize(new Dimension(Constants.WIDTH, (int) (Constants.HEIGTH*0.2)));
		
		containerButtons = new PanelObject(new FlowLayout(), Constants.ORANGE_COLOR);
		containerButtons.setLayout(new GridLayout(2, 5, 10, 10));
		containerButtons.setPreferredSize(new Dimension(Constants.WIDTH, (int) (Constants.HEIGTH*0.19)));
		containerButtons.setBorder(new EmptyBorder(2, 20, 12, 20));
		
		center = new PanelObject(new BorderLayout(), Color.BLACK);
		center.setPreferredSize(new Dimension(Constants.WIDTH, (int) (Constants.HEIGTH*0.55)));
		
		south = new PanelObject(new FlowLayout(), Color.WHITE);
		south.setPreferredSize(new Dimension(Constants.WIDTH, (int) (Constants.HEIGTH*0.2)));
		south.setVisible(false);;
		
	}

	private void createButtons(Controller controller) {
		departments = new Departments(controller);
		
		Image iconJson = new ImageIcon(getClass().getResource(Constants.PATH_ICON_JSON)).getImage();
		Icon rescaledJson = new ImageIcon(iconJson.getScaledInstance(sizeImage, sizeImage, Image.SCALE_SMOOTH));
		json = new ButtonObject(HandlerLanguage.languageProperties.getProperty(Constants.BUTTON_JSON), Constants.DEFAULT_COLOR, rescaledJson,
				controller, Commands.BUTTON_JSON.name(), Constants.DEFAULT_FONT);
		
		Image iconBinary = new ImageIcon(getClass().getResource(Constants.PATH_ICON_BINARY)).getImage();
		Icon rescaledBinary = new ImageIcon(iconBinary.getScaledInstance(sizeImage, sizeImage, Image.SCALE_SMOOTH));
		binary = new ButtonObject(HandlerLanguage.languageProperties.getProperty(Constants.BUTTON_BINARY), Constants.DEFAULT_COLOR, rescaledBinary,
				controller, Commands.BUTTON_BINARY.name(), Constants.DEFAULT_FONT);
		
		Image iconText = new ImageIcon(getClass().getResource(Constants.PATH_ICON_TEXT)).getImage();
		Icon rescaledText = new ImageIcon(iconText.getScaledInstance(sizeImage, sizeImage, Image.SCALE_SMOOTH));
		text = new ButtonObject(HandlerLanguage.languageProperties.getProperty(Constants.BUTTON_TEXT), Constants.DEFAULT_COLOR, rescaledText,
				controller, Commands.BUTTON_TEXT.name(), Constants.DEFAULT_FONT);
		
		
		reportOne = new ButtonObject(HandlerLanguage.languageProperties.getProperty(Constants.BUTTON_REPORT_ONE), Constants.DEFAULT_COLOR,
				controller, Commands.REPORT_ONE.name(), Constants.DEFAULT_FONT);
		
		
		reportTwo = new ButtonObject(HandlerLanguage.languageProperties.getProperty(Constants.BUTTON_REPORT_TWO), Constants.DEFAULT_COLOR,
				controller, Commands.REPORT_TWO.name(), Constants.DEFAULT_FONT);
		
		
		reportThree = new ButtonObject(HandlerLanguage.languageProperties.getProperty(Constants.BUTTON_REPORT_THREE), Constants.DEFAULT_COLOR,
				controller, Commands.REPORT_THREE.name(), Constants.DEFAULT_FONT);
		
		
		reportFour = new ButtonObject(HandlerLanguage.languageProperties.getProperty(Constants.BUTTON_REPORT_FOUR), Constants.DEFAULT_COLOR,
				controller, Commands.REPORT_FOUR.name(), Constants.DEFAULT_FONT);
		
		
		reportFive = new ButtonObject(HandlerLanguage.languageProperties.getProperty(Constants.BUTTON_REPORT_FIVE), Constants.DEFAULT_COLOR,
				controller, Commands.REPORT_FIVE.name(), Constants.DEFAULT_FONT);
		
		
		reportSix = new ButtonObject(HandlerLanguage.languageProperties.getProperty(Constants.BUTTON_REPORT_SIX), Constants.DEFAULT_COLOR,
				controller, Commands.REPORT_SIX.name(), Constants.DEFAULT_FONT);
		
		
		reportSeven = new ButtonObject(HandlerLanguage.languageProperties.getProperty(Constants.BUTTON_REPORT_SEVEN), Constants.DEFAULT_COLOR,
				controller, Commands.REPORT_SEVEN.name(), Constants.DEFAULT_FONT);
		
		
		reportEigth = new ButtonObject(HandlerLanguage.languageProperties.getProperty(Constants.BUTTON_REPORT_EIGHT), Constants.DEFAULT_COLOR,
				controller, Commands.REPORT_EIGHT.name(), Constants.DEFAULT_FONT);
		
		
		reportNine = new ButtonObject(HandlerLanguage.languageProperties.getProperty(Constants.BUTTON_REPORT_NINE), Constants.DEFAULT_COLOR,
				controller, Commands.REPORT_NINE.name(), Constants.DEFAULT_FONT);
		
		
		reportTen = new ButtonObject(HandlerLanguage.languageProperties.getProperty(Constants.BUTTON_REPORT_TEN), Constants.DEFAULT_COLOR,
				controller, Commands.REPORT_TEN.name(), Constants.DEFAULT_FONT);
		
	}

	public void changeLanguage() {
		json.setText(HandlerLanguage.languageProperties.getProperty(Constants.BUTTON_JSON));
		binary.setText(HandlerLanguage.languageProperties.getProperty(Constants.BUTTON_BINARY));
		text.setText(HandlerLanguage.languageProperties.getProperty(Constants.BUTTON_TEXT));
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
		changeLanguageHeaders();
	}
	
	private void changeLanguageHeaders() {
		if (optionAux==1) {
			String[] header = {HandlerLanguage.languageProperties.getProperty(Constants.H_DEPARTMENT),
					HandlerLanguage.languageProperties.getProperty(Constants.H_HECTARE)};
			tableModel.setColumnIdentifiers(header);
		}else if (optionAux == 2) {
			String[] header = {HandlerLanguage.languageProperties.getProperty(Constants.H_DEPARTMENT),
					HandlerLanguage.languageProperties.getProperty(Constants.H_BENEFICIARIES)};
			tableModel.setColumnIdentifiers(header);
		}else if (optionAux == 3) {
			String[] header = {HandlerLanguage.languageProperties.getProperty(Constants.H_DEPARTMENT),
					HandlerLanguage.languageProperties.getProperty(Constants.H_INVESTMENT)};
			tableModel.setColumnIdentifiers(header);
		}else if (optionAux == 4) {
			String[] header = {HandlerLanguage.languageProperties.getProperty(Constants.H_DEPARTMENT),
					HandlerLanguage.languageProperties.getProperty(Constants.H_AGE_GROUP)};
			tableModel.setColumnIdentifiers(header);
		}else if (optionAux == 5) {
			String[] header = {HandlerLanguage.languageProperties.getProperty(Constants.H_NATIONAL),
					HandlerLanguage.languageProperties.getProperty(Constants.H_HECTARE)};
			tableModel.setColumnIdentifiers(header);
		}else if (optionAux == 6) {
			String[] header = {HandlerLanguage.languageProperties.getProperty(Constants.H_NATIONAL),
					HandlerLanguage.languageProperties.getProperty(Constants.H_BENEFICIARIES)};
			tableModel.setColumnIdentifiers(header);
		}else if (optionAux == 7) {
			String[] header = {HandlerLanguage.languageProperties.getProperty(Constants.H_NATIONAL),
					HandlerLanguage.languageProperties.getProperty(Constants.H_INVESTMENT)};
			tableModel.setColumnIdentifiers(header);
		}else if (optionAux == 8) {
			String[] header = {HandlerLanguage.languageProperties.getProperty(Constants.H_NATIONAL),
					HandlerLanguage.languageProperties.getProperty(Constants.H_AGE_GROUP)};
			tableModel.setColumnIdentifiers(header);
		}else if (optionAux == 9) {
			String[] header = {HandlerLanguage.languageProperties.getProperty(Constants.H_NATIONAL),
					HandlerLanguage.languageProperties.getProperty(Constants.H_GENDER)};
			tableModel.setColumnIdentifiers(header);
		}else if (optionAux == 10) {
			String[] header = { HandlerLanguage.languageProperties.getProperty(Constants.NAME),
					HandlerLanguage.languageProperties.getProperty(Constants.H_DEPARTMENT),
					HandlerLanguage.languageProperties.getProperty(Constants.H_HECTARE),
					HandlerLanguage.languageProperties.getProperty(Constants.H_INVESTMENT),
					HandlerLanguage.languageProperties.getProperty(Constants.H_BENEFICIARIES),
					HandlerLanguage.languageProperties.getProperty(Constants.H_AGE_GROUP),
					HandlerLanguage.languageProperties.getProperty(Constants.H_SISBEN_SCORE)};
			tableModel.setColumnIdentifiers(header);
		}
		
		
	}

	public void setNewTable(Object[][] newFruitData) {
		tableModel.getDataVector().removeAllElements();
		tableModel.fireTableDataChanged();
		for (int i = 0; i < newFruitData.length; i++) {
			tableModel.addRow(newFruitData[i]);
		}
	}
	
	public void setVisibleButtonsExport(boolean option) {
		south.setVisible(option);
	}

	public void changeReport(Object[][] newData, int option, boolean visible) {
		optionAux = option;
		changeLanguageHeaders();
		setNewTable(newData);
		departments.setVisible(visible);
	}
	
	
	public String getDepartment() {
		return (String) departments.getSelectedItem();
	}

	public void changeReport(String[][] data) {
		// TODO Auto-generated method stub
		
	}

}
