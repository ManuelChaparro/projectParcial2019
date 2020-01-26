package controller;

import views.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import handler.HandlerLanguage;
import models.Fruit;
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

	public Controller() {
		viewsUtilities = new ViewsUtilities();
//		writeFile();
		chain = new Chain();
		config = null;
		loadConfiguration();
		
		
//		newFileDialog = new NewFileDialog(this);
		graphicDialog = new GraphicDialog(this);
//		deleteChain = new DeleteChain(this);
		initWindow();
		manageChangeLanguageES();
	}

	private void initWindow() {
		Object[][] blackberryData = JsonFileManager.readFile(Constants.PATH_LOCAL_FILE_BLACKBERRY);
		Object[][] strawberryData = JsonFileManager.readFile(Constants.PATH_LOCAL_FILE_STRAWBERRY);
		Object[][] luloData = JsonFileManager.readFile(Constants.PATH_LOCAL_FILE_LULO);
		Object[][] bananaData = JsonFileManager.readFile(Constants.PATH_LOCAL_FILE_BANANA);
		Object[][] passionFruitData = JsonFileManager.readFile(Constants.PATH_LOCAL_FILE_PASSION_FRUIT);
		Object[][] peachData = JsonFileManager.readFile(Constants.PATH_LOCAL_FILE_PEACH);

		uploadFruits(blackberryData);
		uploadFruits(strawberryData);
		uploadFruits(luloData);
		uploadFruits(bananaData);
		uploadFruits(passionFruitData);
		uploadFruits(peachData);

		window = new PrincipalWindow(blackberryData, this);
	}

	private void uploadFruits(Object[][] fruits) {
		Fruit fruit = null;
		for (int i = 0; i < fruits.length; i++) {
			fruit = new Fruit((String) fruits[i][0], (String) fruits[i][1], (String) fruits[i][2], Integer.parseInt((String) fruits[i][3]) ,
					(String) fruits[i][4], (String) fruits[i][5], Integer.parseInt((String) fruits[i][6]), Double.parseDouble((String) fruits[i][7]),
					Double.parseDouble((String) fruits[i][8]));
			chain.setList(fruit);
		}
	}

	private void writeFile() {
		writeBlackberry();
		writeStrawberry();
		writeLulo();
		writeBanana();
		writePassionFruit();
		writePeach();
	}

	private void writePeach() {
		try {
			viewsUtilities.showMessage(Constants.WRITING_PEACH);
			Utilities.writeFile(Constants.PATH_LOCAL_FILE_PEACH, Constants.PATH_URL_FILE_PEACH);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void writePassionFruit() {
		try {
			viewsUtilities.showMessage(Constants.WRITING_PASSION_FRUIT);
			Utilities.writeFile(Constants.PATH_LOCAL_FILE_PASSION_FRUIT, Constants.PATH_URL_FILE_PASSION_FRUIT);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void writeBanana() {
		try {
			viewsUtilities.showMessage(Constants.WRITING_BANANA);
			Utilities.writeFile(Constants.PATH_LOCAL_FILE_BANANA, Constants.PATH_URL_FILE_BANANA);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void writeLulo() {
		try {
			viewsUtilities.showMessage(Constants.WRITING_LULO);
			Utilities.writeFile(Constants.PATH_LOCAL_FILE_LULO, Constants.PATH_URL_FILE_LULO);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void writeStrawberry() {
		try {
			viewsUtilities.showMessage(Constants.WRITING_STRAWBERRY);
			Utilities.writeFile(Constants.PATH_LOCAL_FILE_STRAWBERRY, Constants.PATH_URL_FILE_STRAWBERRY);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void writeBlackberry() {
		try {
			viewsUtilities.showMessage(Constants.WRITING_BLACKBERRY);
			Utilities.writeFile(Constants.PATH_LOCAL_FILE_BLACKBERRY, Constants.PATH_URL_FILE_BLACKBERRY);
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
//			addNewAvocado();
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
//			searchDelete();
			break;
		case BLACKBERRY_BUTTON:
			Object[][] blackberryData = JsonFileManager.readFile(Constants.PATH_LOCAL_FILE_BLACKBERRY);
			window.setNewTable(blackberryData);
			break;
		case STRAWBERRY_BUTTON:
			Object[][] strawberryData = JsonFileManager.readFile(Constants.PATH_LOCAL_FILE_STRAWBERRY);
			window.setNewTable(strawberryData);
			break;
		case LULO_BUTTON:
			Object[][] luloData = JsonFileManager.readFile(Constants.PATH_LOCAL_FILE_LULO);
			window.setNewTable(luloData);
			break;
		case BANANA_BUTTON:
			Object[][] bananaData = JsonFileManager.readFile(Constants.PATH_LOCAL_FILE_BANANA);
			window.setNewTable(bananaData);
			break;
		case PASSION_FRUIT_BUTTON:
			Object[][] passionFruitData = JsonFileManager.readFile(Constants.PATH_LOCAL_FILE_PASSION_FRUIT);
			window.setNewTable(passionFruitData);
			break;
		case PEACH_BUTTON:
			Object[][] peachData = JsonFileManager.readFile(Constants.PATH_LOCAL_FILE_PEACH);
			window.setNewTable(peachData);
			break;
		default:
			break;
		}

	}

//	private void searchDelete() {
//		ArrayList<Fruit> avocadosList = chain.getAvocadosList();
//		Fruit itemFound = null;
//		Object[] data = deleteChain.getInfoDelete();
//		Object[] itemToDelete = new Object[10];
//		String town = "";
//		int period = 0;
//		for (int i = 0; i < avocadosList.size(); i++) {
//			town = (String) data[0];
//			period = Integer.parseInt((String) data[1]);
//			if (period==avocadosList.get(i).getPeriod() &&
//					town.equals(avocadosList.get(i).getTown())) {
//					itemFound = avocadosList.get(i);
//					itemToDelete = itemFound.toMatrixObject(itemFound);
//					deleteChain.setTextDelete(itemToDelete);
//					break;
//			}
//		}
//
//	}

//	private void addNewAvocado() {
//		try {
//			Object[] newAvocado = newFileDialog.getDataAvocado();
//			if ((int) newAvocado[4] < (int) newAvocado[5]) {
//				viewsUtilities.showErrorArea();
//				
//			}else {
//				avocado = new Fruit((int)newAvocado[0], (String) newAvocado[1],(int) newAvocado[2],
//						(String) newAvocado[3], (int) newAvocado[4],(int) newAvocado[5],
//						(int) newAvocado[6],(int) newAvocado[7], (String) newAvocado[8],
//						(int)newAvocado[9]);
//				Object[] data = avocado.toMatrixObject(avocado);
//				window.setNewAvocadoInTable(data);
//				newFileDialog.clearData();
//			}
//		} catch (NumberFormatException e) {
//			viewsUtilities.showErrorString();
//		}
//		
//		
//	}

	private void calculatePerformance() {
		int[] data = new int[2];
		int performance = 0;
		try {
			data = newFileDialog.getDataPerformance();
			performance = chain.calculatePerformance(data);
		} catch (ArithmeticException e) {
			viewsUtilities.showErrorByZero();
		} catch (Exception e) {
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
