package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.Commands;
import controller.Controller;
import handler.HandlerLanguage;

public class PanelTable extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	private TableModelObject tableModel;
	private DefaultTableModel tableModel;
	private JTable table;
	private JPanel buttonsContainer, addContainer, deleteContainer;
	private JScrollPane scroll;
	private ButtonObject addFruit, deleteFruit;
	
	public PanelTable(Controller controller) {
		setBackground(Color.WHITE);
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(Constants.WIDTH, Constants.HEIGTH));
		initComponents(controller);
		setVisible(true);
	}

	private void initComponents(Controller controller) {
		
		//Creation Buttons
		buttonsContainer = new JPanel();
		buttonsContainer.setLayout(new FlowLayout());
		buttonsContainer.setBackground(Color.WHITE);
		buttonsContainer.setBorder(new EmptyBorder(0, 10, 25, 10));
		
		addContainer = new JPanel();
		addContainer.setBackground(Constants.DEFAULT_COLOR.brighter());
		
		deleteContainer = new JPanel();
		deleteContainer.setBackground(Constants.RED_COLOR);
		
		addFruit = new ButtonObject(HandlerLanguage.languageProperties.getProperty(Constants.OPTION_FILE_ADD_FRUIT),
				Constants.DEFAULT_COLOR, controller, Commands.ADD_FRUIT.name(), Constants.DEFAULT_FONT);
		addFruit.setBorder(new EmptyBorder(0, 200, 0, 200));
		deleteFruit = new ButtonObject(HandlerLanguage.languageProperties.getProperty(Constants.OPTION_DELETE_ITEM),
				Constants.DEFAULT_COLOR, controller, Commands.DELETE_CHAIN.name(), Constants.DEFAULT_FONT);
		deleteFruit.setBorder(new EmptyBorder(0, 200, 0, 200));
		addContainer.add(addFruit);
		deleteContainer.add(deleteFruit);
		buttonsContainer.add(addContainer);
		buttonsContainer.add(deleteContainer);
		add(buttonsContainer, BorderLayout.NORTH);
		
		//Components Jtable
		tableModel = new DefaultTableModel();
		changeLenguage();
		table = new JTable(tableModel);
		table.setVisible(true);
		table.setBackground(Color.WHITE);
		table.setFont(Constants.DEFAULT_FONT_MIN);
		table.getTableHeader().setFont(Constants.DEFAULT_FONT_MIN);
		table.setEditingRow(500);
		table.getColumnModel().getColumn(0).setPreferredWidth(5);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getTableHeader().setBackground(Constants.DEFAULT_COLOR);
		table.getTableHeader().setForeground(Color.WHITE);
		table.getTableHeader().setFont(Constants.DEFAULT_FONT_MIN);
		table.setEnabled(false);
		table.setRowHeight(25);
		table.setSelectionBackground(Color.CYAN.darker().darker());
		table.setSelectionForeground(Color.WHITE);
		scroll = new JScrollPane(table);
		table.getTableHeader().setReorderingAllowed(false);
		add(scroll, BorderLayout.CENTER);		
	}

	public void setNewFruit(Object[] data) {
		tableModel.addRow(data);
	}
	
	public void changeLenguage() {
		String[] HEADERS = { HandlerLanguage.languageProperties.getProperty(Constants.NAME),
				HandlerLanguage.languageProperties.getProperty(Constants.H_DEPARTMENT),
				HandlerLanguage.languageProperties.getProperty(Constants.H_ID_TOWN),
				HandlerLanguage.languageProperties.getProperty(Constants.H_TOWN),
				HandlerLanguage.languageProperties.getProperty(Constants.H_GENDER),
				HandlerLanguage.languageProperties.getProperty(Constants.H_AGE_GROUP),
				HandlerLanguage.languageProperties.getProperty(Constants.H_SISBEN_SCORE),
				HandlerLanguage.languageProperties.getProperty(Constants.H_BENEFICIARIES),
				HandlerLanguage.languageProperties.getProperty(Constants.H_INVESTMENT),
				HandlerLanguage.languageProperties.getProperty(Constants.H_HECTARE)};
		addFruit.setText(HandlerLanguage.languageProperties.getProperty(Constants.OPTION_FILE_ADD_FRUIT));
		deleteFruit.setText(HandlerLanguage.languageProperties.getProperty(Constants.OPTION_DELETE_ITEM));
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
