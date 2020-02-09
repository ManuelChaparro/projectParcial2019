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
	private PrincipalWindow window;
	private GraphicDialog graphicDialog;
	private ViewsUtilities viewsUtilities;
	private Chain chain;
	private String fruitSelected;

	public Controller() {
		viewsUtilities = new ViewsUtilities();
//		writeFile();
		chain = new Chain();
		config = null;
		loadConfiguration();
//		newFileDialog = new NewFileDialog(this);
//		graphicDialog = new GraphicDialog(this);
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

		window = new PrincipalWindow(this);
	}

	private void uploadFruits(Object[][] fruits) {
		Fruit fruit = null;
		for (int i = 0; i < fruits.length; i++) {
			fruit = new Fruit((String) fruits[i][0], (String) fruits[i][1], (String) fruits[i][2],
					Integer.parseInt((String) fruits[i][3]), (String) fruits[i][4], (String) fruits[i][5],
					(String) fruits[i][6], Integer.parseInt((String) fruits[i][7]),
					Double.parseDouble((String) fruits[i][8]), Double.parseDouble((String) fruits[i][9]));
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
		case ADD_FRUIT:
			window.getPanelCardLayout().removeAll();
			window.getPanelCardLayout().add(window.getNewFile());
			window.getPanelCardLayout().repaint();
			window.getPanelCardLayout().revalidate();
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

		case ACCEPT_BUTTON_CHAIN:
			addNewFruit();
			break;

		case CANCEL_BUTTON_CHAIN:
			window.clearData();
			window.getPanelCardLayout().removeAll();
			window.getPanelCardLayout().add(window.getPanelTable());
			window.getPanelCardLayout().repaint();
			window.getPanelCardLayout().revalidate();
			break;

		case DELETE_CHAIN:
			window.getPanelCardLayout().removeAll();
			window.getPanelCardLayout().add(window.getPanelDelete());
			window.getPanelCardLayout().repaint();
			window.getPanelCardLayout().revalidate();

			break;

		case ACCEPT_BUTTON_DELETE:

			break;

		case CANCEL_BUTTON_DELETE:
			window.getPanelCardLayout().removeAll();
			window.getPanelCardLayout().add(window.getPanelTable());
			window.getPanelCardLayout().repaint();
			window.getPanelCardLayout().revalidate();

			break;

		case SEARCH_DELETE:
			searchDelete();
			break;
		case BLACKBERRY_BUTTON:
			Object[][] blackberryData = chain.getBlackberryList();
			window.getPanelCardLayout().removeAll();
			window.getPanelCardLayout().add(window.getPanelTable());
			window.getPanelCardLayout().repaint();
			window.getPanelCardLayout().revalidate();
			window.setNewTable(blackberryData);
			fruitSelected = Constants.BLACKBERRY;
			break;
		case STRAWBERRY_BUTTON:
			Object[][] strawberryData = chain.getStrawberryList();
			window.getPanelCardLayout().removeAll();
			window.getPanelCardLayout().add(window.getPanelTable());
			window.getPanelCardLayout().repaint();
			window.getPanelCardLayout().revalidate();
			window.setNewTable(strawberryData);
			fruitSelected = Constants.STRAWBERRY;
			break;
		case LULO_BUTTON:
			Object[][] luloData = chain.getLuloList();
			window.getPanelCardLayout().removeAll();
			window.getPanelCardLayout().add(window.getPanelTable());
			window.getPanelCardLayout().repaint();
			window.getPanelCardLayout().revalidate();
			window.setNewTable(luloData);
			fruitSelected = Constants.LULO;
			break;
		case BANANA_BUTTON:
			Object[][] bananaData = chain.getBananaList();
			window.getPanelCardLayout().removeAll();
			window.getPanelCardLayout().add(window.getPanelTable());
			window.getPanelCardLayout().repaint();
			window.getPanelCardLayout().revalidate();
			window.setNewTable(bananaData);
			fruitSelected = Constants.BANANA;
			break;
		case PASSION_FRUIT_BUTTON:
			Object[][] passionFruitData = chain.getPassionFruitList();
			window.getPanelCardLayout().removeAll();
			window.getPanelCardLayout().add(window.getPanelTable());
			window.getPanelCardLayout().repaint();
			window.getPanelCardLayout().revalidate();
			window.setNewTable(passionFruitData);
			fruitSelected = Constants.PASSION_FRUIT;
			break;
		case PEACH_BUTTON:
			Object[][] peachData = chain.getPeachList();
			window.getPanelCardLayout().removeAll();
			window.getPanelCardLayout().add(window.getPanelTable());
			window.getPanelCardLayout().repaint();
			window.getPanelCardLayout().revalidate();
			window.setNewTable(peachData);
			fruitSelected = Constants.PEACH;
			break;
		case BUTTON_CHANGE_HOME:
			window.getPanelCardLayout().removeAll();
			window.getPanelCardLayout().add(window.getPanelHome());
			window.getPanelCardLayout().repaint();
			window.getPanelCardLayout().revalidate();
			break;
		case BUTTON_CHANGE_EXPORT:
			window.getPanelCardLayout().removeAll();
			window.getPanelCardLayout().add(window.getPanelExport());
			window.getPanelCardLayout().repaint();
			window.getPanelCardLayout().revalidate();
			break;
		case BUTTON_CHANGE_GRAPHICS:
			window.getPanelCardLayout().removeAll();
			window.getPanelCardLayout().add(window.getPanelGraphics());
			window.getPanelCardLayout().repaint();
			window.getPanelCardLayout().revalidate();
			break;
		default:
			break;
		}

	}

	private void addNewFruit() {
		Object[] fruit = window.getDataFruit();
		if (fruit.length != 0) {
			String name = (String) fruit[0];
			if (chain.validateObject(fruit)) {
				String ageGroup = viewsUtilities.setToForNumbersAge(fruit[5], fruit[6]);
				String sisbenScore = viewsUtilities.setToForNumbersSisben(fruit[7], fruit[8]);
				Fruit newFruit = new Fruit(name, (String) fruit[1], (String) fruit[2], (int) fruit[3],
						(String) fruit[4], ageGroup, sisbenScore, (int) fruit[9], Double.valueOf((double) fruit[10]),
						Double.valueOf((double) fruit[11]));
				chain.setList(newFruit);
				Object[][] bananaData = chain.getBananaList();
				window.getPanelCardLayout().removeAll();
				window.getPanelCardLayout().add(window.getPanelTable());
				window.getPanelCardLayout().repaint();
				window.getPanelCardLayout().revalidate();
				window.setNewTable(bananaData);
				window.clearData();
			}
		} else {
			window.setVisibleNotice(true);
		}
	}

	private void searchDelete() {
		ArrayList<Fruit> fruitList = chain.getFruitsList();
		try {
			Object[] data = window.getInfoDelete();
			Object[][] itemToDelete = new Object[fruitList.size()][10];
			int idTown = Integer.parseInt((String) data[0]);
			String gender = (String) data[1];
			String ageGroup = viewsUtilities.setToForNumbersAge(data[2], data[3]);
			String sisbenScore = viewsUtilities.setToForNumbersSisben(data[4], data[5]);
			int beneficiaries = Integer.parseInt((String) data[6]);
			double investment = Double.parseDouble((String) data[7]);
			double hectare = Double.parseDouble((String) data[8]);

			int count = 0;
			for (int i = 0; i < fruitList.size(); i++) {
				if (idTown == fruitList.get(i).getIdTown() 
						&& fruitList.get(i).getGender().equalsIgnoreCase(gender)
						&& ageGroup.equalsIgnoreCase(fruitList.get(i).getAgeGroup())
						&& sisbenScore.equalsIgnoreCase(fruitList.get(i).getSisbenScore())
						&& beneficiaries == fruitList.get(i).getBeneficiaries()
						&& investment == fruitList.get(i).getInvestment() 
						&& hectare == fruitList.get(i).getHectare()) {

					itemToDelete[count][0] = fruitList.get(i).getName();
					itemToDelete[count][1] = fruitList.get(i).getDepartment();
					itemToDelete[count][2] = fruitList.get(i).getIdTown();
					itemToDelete[count][3] = fruitList.get(i).getTown();
					itemToDelete[count][4] = fruitList.get(i).getGender();
					itemToDelete[count][5] = fruitList.get(i).getAgeGroup();
					itemToDelete[count][6] = fruitList.get(i).getSisbenScore();
					itemToDelete[count][7] = fruitList.get(i).getBeneficiaries();
					itemToDelete[count][8] = fruitList.get(i).getInvestment();
					itemToDelete[count][9] = fruitList.get(i).getHectare();
					count++;
				}
			}
			if (itemToDelete[0][0]!=null) {
				window.setNewTable(itemToDelete);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

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
//		graphicDialog.changeLanguage();
//		newFileDialog.changeLanguage();

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
