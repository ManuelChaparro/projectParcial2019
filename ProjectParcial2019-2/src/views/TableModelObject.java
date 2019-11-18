package views;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import handler.HandlerLanguage;

public class TableModelObject extends JTable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultTableModel model;
	
	public TableModelObject(Object[][] data) {
		model = new DefaultTableModel(data, generateHeaders());
		changeLenguage();
	}

	private Object[] generateHeaders() {
		String[] HEADERS = { HandlerLanguage.languageProperties.getProperty(Constants.H_ID_DEPARTMENT),
				HandlerLanguage.languageProperties.getProperty(Constants.H_DEPARTMENT),
				HandlerLanguage.languageProperties.getProperty(Constants.H_ID_TOWN),
				HandlerLanguage.languageProperties.getProperty(Constants.H_TOWN),
				HandlerLanguage.languageProperties.getProperty(Constants.H_SOWN_AREA),
				HandlerLanguage.languageProperties.getProperty(Constants.H_HARVESTED_AREA),
				HandlerLanguage.languageProperties.getProperty(Constants.H_PRODUCTION),
				HandlerLanguage.languageProperties.getProperty(Constants.H_PERFORMANCE),
				HandlerLanguage.languageProperties.getProperty(Constants.H_PHYSICAL_STATE),
				HandlerLanguage.languageProperties.getProperty(Constants.H_PERIOD)};
		return HEADERS;
	}

	private void changeLenguage() {
		
		
	}

}
