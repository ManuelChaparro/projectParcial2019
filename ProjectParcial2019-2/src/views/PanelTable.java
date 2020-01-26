package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import handler.HandlerLanguage;

public class PanelTable extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	private TableModelObject tableModel;
	private DefaultTableModel tableModel;
	private JTable table;
	private JScrollPane scroll;
	
	public PanelTable(Object[][] blackberryData) {
		setBackground(Color.WHITE);
		setLayout(new BorderLayout());
		initComponents(blackberryData);
		setVisible(true);
	}

	private void initComponents(Object[][] blackberryData) {		
		tableModel = new DefaultTableModel(blackberryData, generateHeader());
		System.out.println(22);
		changeLenguage();
		table = new JTable(tableModel);
		table.setVisible(true);
		table.setBackground(Color.GRAY);
		table.setBackground(Color.WHITE);
		table.setFont(Constants.DEFAULT_FONT_MIN);
		table.getTableHeader().setFont(Constants.DEFAULT_FONT_MIN);
		table.setEditingRow(500);
		table.getColumnModel().getColumn(0).setPreferredWidth(5);
		table.setRowHeight(25);
		table.setSelectionBackground(Color.CYAN.darker().darker());
		table.setSelectionForeground(Color.WHITE);
		scroll = new JScrollPane(table);
		table.getTableHeader().setReorderingAllowed(false);
		add(scroll);
	}

	public void setNewAvocado(Object[] data) {
		tableModel.addRow(data);
	}
	
	private Object[] generateHeader() {
		String[] HEADERS = { HandlerLanguage.languageProperties.getProperty(Constants.NAME),
				HandlerLanguage.languageProperties.getProperty(Constants.H_DEPARTMENT),
				HandlerLanguage.languageProperties.getProperty(Constants.H_TOWN),
				HandlerLanguage.languageProperties.getProperty(Constants.H_ID_TOWN),
				HandlerLanguage.languageProperties.getProperty(Constants.H_GENDER),
				HandlerLanguage.languageProperties.getProperty(Constants.H_AGE_GROUP),
				HandlerLanguage.languageProperties.getProperty(Constants.H_BENEFICIARIES),
				HandlerLanguage.languageProperties.getProperty(Constants.H_INVESTMENT),
				HandlerLanguage.languageProperties.getProperty(Constants.H_HECTARE)};
		return HEADERS;
	}

	public void changeLenguage() {
		String[] HEADERS = { HandlerLanguage.languageProperties.getProperty(Constants.NAME),
				HandlerLanguage.languageProperties.getProperty(Constants.H_DEPARTMENT),
				HandlerLanguage.languageProperties.getProperty(Constants.H_TOWN),
				HandlerLanguage.languageProperties.getProperty(Constants.H_ID_TOWN),
				HandlerLanguage.languageProperties.getProperty(Constants.H_GENDER),
				HandlerLanguage.languageProperties.getProperty(Constants.H_AGE_GROUP),
				HandlerLanguage.languageProperties.getProperty(Constants.H_BENEFICIARIES),
				HandlerLanguage.languageProperties.getProperty(Constants.H_INVESTMENT),
				HandlerLanguage.languageProperties.getProperty(Constants.H_HECTARE)};
		tableModel.setColumnIdentifiers(HEADERS);
	}

	public void setNewTable(Object[][] newFruitData) {
		tableModel.getDataVector().removeAllElements();
		tableModel.fireTableDataChanged();
		for (int i = 0; i < newFruitData.length; i++) {
			tableModel.addRow(newFruitData[i]);
		}
	}
}
