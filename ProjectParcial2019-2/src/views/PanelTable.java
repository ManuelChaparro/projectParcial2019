package views;

import java.awt.BorderLayout;
import java.awt.Color;

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
	
	public PanelTable(Object[][] data) {
		setBackground(Color.WHITE);
		setLayout(new BorderLayout());
		initComponents(data);
		setVisible(true);
	}

	private void initComponents(Object[][] list) {
		tableModel = new DefaultTableModel(list, generateHeader());
		changeLenguage();
		table = new JTable(tableModel);
		table.setVisible(true);
		table.setBackground(Color.GRAY);
		table.setBackground(Color.WHITE);
		table.setFont(Constants.DEFAULT_FONT);
		table.getTableHeader().setFont(Constants.DEFAULT_FONT);
		table.setEditingRow(500);
		table.getColumnModel().getColumn(0).setPreferredWidth(5);
		table.setRowHeight(25);
		table.setSelectionBackground(Color.BLUE.darker().darker());
		table.setSelectionForeground(Color.WHITE);
		scroll = new JScrollPane(table);
		table.getTableHeader().setReorderingAllowed(false);
		add(scroll);
	}

	public void setNewAvocado(Object[] data) {
		tableModel.addRow(data);
	}
	
	private Object[] generateHeader() {
		String[] HEADERS = { HandlerLanguage.languageProperties.getProperty(Constants.H_ID_DEPARTMENT),
				HandlerLanguage.languageProperties.getProperty(Constants.H_DEPARTMENT),
				HandlerLanguage.languageProperties.getProperty(Constants.H_ID_TOWN),
				HandlerLanguage.languageProperties.getProperty(Constants.H_TOWN),
				HandlerLanguage.languageProperties.getProperty(Constants.H_SOWN_AREA),
				HandlerLanguage.languageProperties.getProperty(Constants.H_HARVESTED_AREA),
				HandlerLanguage.languageProperties.getProperty(Constants.H_PRODUCTION),
				HandlerLanguage.languageProperties.getProperty(Constants.H_PERFORMANCE),
				HandlerLanguage.languageProperties.getProperty(Constants.H_PHYSICAL_STATE),
				HandlerLanguage.languageProperties.getProperty(Constants.H_PERIOD) };
		return HEADERS;
	}

	public void changeLenguage() {
		String[] HEADERS = { HandlerLanguage.languageProperties.getProperty(Constants.H_ID_DEPARTMENT),
				HandlerLanguage.languageProperties.getProperty(Constants.H_DEPARTMENT),
				HandlerLanguage.languageProperties.getProperty(Constants.H_ID_TOWN),
				HandlerLanguage.languageProperties.getProperty(Constants.H_TOWN),
				HandlerLanguage.languageProperties.getProperty(Constants.H_SOWN_AREA),
				HandlerLanguage.languageProperties.getProperty(Constants.H_HARVESTED_AREA),
				HandlerLanguage.languageProperties.getProperty(Constants.H_PRODUCTION),
				HandlerLanguage.languageProperties.getProperty(Constants.H_PERFORMANCE),
				HandlerLanguage.languageProperties.getProperty(Constants.H_PHYSICAL_STATE),
				HandlerLanguage.languageProperties.getProperty(Constants.H_PERIOD) };
		tableModel.setColumnIdentifiers(HEADERS);
	}

}
