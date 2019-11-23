package controller;

import views.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import handler.HandlerLanguage;
import models.Avocado;
import models.Chain;
import persistence.JsonFileManager;
import utilities.Utilities;

public class Controller implements ActionListener {

	private HandlerLanguage config;
	private DeleteChain deleteChain;
	private PrincipalWindow window;
	private GraphicDialog graphicDialog;
	private NewFileDialog newFileDialog;
	private ViewsUtilities viewsUtilities;
	private Chain chain;
	private Avocado avocado;

	public Controller() {
		writeFile();
		viewsUtilities = new ViewsUtilities();
		chain = new Chain();
		config = null;
		loadConfiguration();
		newFileDialog = new NewFileDialog(this);
		graphicDialog = new GraphicDialog(this);
		deleteChain = new DeleteChain(this);
		initWindow();
		manageChangeLanguageES();
	}

	private void initWindow() {
		Object[][] allData = JsonFileManager.readFile(Constants.PATH_LOCAL_FILE);
		Avocado avocado = null;
		for (int i = 0; i < allData.length; i++) {
			if (allData[i][9]==null) {
				avocado = new Avocado(Integer.parseInt((String) allData[i][0]), (String)allData[i][1],
						Integer.parseInt((String) allData[i][2]), (String)allData[i][3],
						Integer.parseInt((String) allData[i][4]), Integer.parseInt((String) allData[i][5]),
						Integer.parseInt((String) allData[i][6]), Double.parseDouble((String) allData[i][7]),
						(String)allData[i][8], 0);
				chain.setList(avocado);
			}else {
				avocado = new Avocado(Integer.parseInt((String) allData[i][0]), (String)allData[i][1],
						Integer.parseInt((String) allData[i][2]), (String)allData[i][3],
						Integer.parseInt((String) allData[i][4]), Integer.parseInt((String) allData[i][5]),
						Integer.parseInt((String) allData[i][6]), Double.parseDouble((String) allData[i][7]),
						(String)allData[i][8], Integer.parseInt((String) allData[i][9]));
				chain.setList(avocado);
			}
		}
		window = new PrincipalWindow(allData, this);
	}

	private void writeFile() {
		try {
			Utilities.writeFile(Constants.PATH_LOCAL_FILE, Constants.PATH_URL_FILE);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Commands.valueOf(e.getActionCommand())) {
		case ADD_AVOCADO:
			newFileDialog.setVisible(true);
			break;
		case SHOW_GRAPHIC:
			graphicDialog.setVisible(true);
			break;

		case C_ES_LANGUAGE:
			manageChangeLanguageES();
			break;

		case C_EN_LANGUAGE:
			manageChangeLanguageEN();
			break;
			
		case GET_ID_DEPARTMENT:
			manageIdDepartment();
			break;
			
		case CALCULATE_PERFORMANCE:
			calculatePerformance();
			break;
			
		case ACCEPT_BUTTON_CHAIN:
			addNewAvocado();
			newFileDialog.setVisible(false);
			break;
			
		case CANCEL_BUTTON_CHAIN:
			newFileDialog.setVisible(false);
			newFileDialog.clearData();
			break;
			
		case DELETE_CHAIN:
			deleteChain.setVisible(true);
			break;
			
		case ACCEPT_BUTTON_DELETE:
			
			break;
			
		case CANCEL_BUTTON_DELETE:
			deleteChain.setVisible(false);
			deleteChain.clearData();
			break;
		
		case SEARCH_DELETE:
			searchDelete();
			break;
		default:
			break;
		}

	}

	private void searchDelete() {
		ArrayList<Avocado> avocadosList = chain.getAvocadosList();
		Avocado itemFound = null;
		Object[] data = deleteChain.getInfoDelete();
		Object[] itemToDelete = new Object[10];
		String town = "";
		int period = 0;
		for (int i = 0; i < avocadosList.size(); i++) {
			town = (String) data[0];
			period = Integer.parseInt((String) data[1]);
			if (period==avocadosList.get(i).getPeriod() &&
					town.equals(avocadosList.get(i).getTown())) {
					itemFound = avocadosList.get(i);
					itemToDelete = itemFound.toMatrixObject(itemFound);
					deleteChain.setTextDelete(itemToDelete);
					break;
			}
		}

	}

	private void addNewAvocado() {
		try {
			Object[] newAvocado = newFileDialog.getDataAvocado();
			if ((int) newAvocado[4] < (int) newAvocado[5]) {
				viewsUtilities.showErrorArea();
				
			}else {
				avocado = new Avocado((int)newAvocado[0], (String) newAvocado[1],(int) newAvocado[2],
						(String) newAvocado[3], (int) newAvocado[4],(int) newAvocado[5],
						(int) newAvocado[6],(int) newAvocado[7], (String) newAvocado[8],
						(int)newAvocado[9]);
				Object[] data = avocado.toMatrixObject(avocado);
				window.setNewAvocadoInTable(data);
				newFileDialog.clearData();
			}
		} catch (NumberFormatException e) {
			viewsUtilities.showErrorString();
		}
		
		
	}

	private void calculatePerformance() {
		int[] data = new int[2];
		int performance = 0;
		try {
			data = newFileDialog.getDataPerformance();
			performance = chain.calculatePerformance(data);
		} catch(ArithmeticException e){
			viewsUtilities.showErrorByZero();
		}
		catch (Exception e) {
			viewsUtilities.showErrorToInt();
		}
		newFileDialog.setPerformance(performance);
	}

	private void manageIdDepartment() {
		newFileDialog.setIdDepartment();
	}

	private void loadConfiguration() {
		if (config == null) {
			config = new HandlerLanguage(Constants.NAME_FILE_CONFIG);
		}
		try {
			config.loadLanguage();
		} catch (IOException e) {
			viewsUtilities.showErrorFileNotFound();
		}
	}

	private void manageChangeLanguageEN() {
		try {
			changeToEnglish();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		manageChangeLanguage();

	}

	public void changeToEnglish() throws IOException {
		HandlerLanguage.language = Constants.PATH_HAN_LEN_ENGLISH;
		saveConfig();
		loadLanguage();
	}

	private void manageChangeLanguageES() {
		try {
			changeToSpanish();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		manageChangeLanguage();

	}

	public void changeToSpanish() throws IOException {
		HandlerLanguage.language = Constants.PATH_HAN_LEN_SPANISH;
		saveConfig();
		loadLanguage();
	}

	private void manageChangeLanguage() {
		window.changeLanguage();
		graphicDialog.changeLanguage();
		newFileDialog.changeLanguage();
	}

	public void saveConfig() throws IOException {
		try {
			new HandlerLanguage(Constants.NAME_FILE_CONFIG).saveLanguage();
		} catch (Exception e) {
		}
	}

	public void loadLanguage() throws IOException {
		try {
			config.loadLanguage();
		} catch (Exception e) {
		}
	}

}
