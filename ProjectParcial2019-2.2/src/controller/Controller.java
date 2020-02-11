package controller;

import views.*;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import handler.HandlerLanguage;
import models.Fruit;
import models.ReportManager;
import models.Chain;
import persistence.JsonFileManager;
import utilities.Utilities;

public class Controller implements ActionListener {

	private HandlerLanguage config;
	private PrincipalWindow window;
	private ViewsUtilities viewsUtilities;
	private Chain chain;
	private String fruitSelected;
	private int fruitDelete;
	private ReportManager reportManager;
	private URI uriFacebook, uriInstagram, uriYoutube;

	public Controller() {
		config = null;
		viewsUtilities = new ViewsUtilities();
		chain = new Chain();
		
		loadPages();
		writeFile();
		loadConfiguration();
		initWindow();
		manageChangeLanguageES();

	}

	private void loadPages() {
		try {
			uriFacebook = new URI(Constants.PATH_URL_FACEBOOK);
			uriInstagram = new URI(Constants.PATH_URL_INSTAGRAM);
			uriYoutube = new URI(Constants.PATH_URL_YOUTUBE);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
	}

	private void initWindow() {
		uploadFruits(JsonFileManager.readFile(Constants.PATH_LOCAL_FILE_BLACKBERRY));
		uploadFruits(JsonFileManager.readFile(Constants.PATH_LOCAL_FILE_STRAWBERRY));
		uploadFruits(JsonFileManager.readFile(Constants.PATH_LOCAL_FILE_LULO));
		uploadFruits(JsonFileManager.readFile(Constants.PATH_LOCAL_FILE_BANANA));
		uploadFruits(JsonFileManager.readFile(Constants.PATH_LOCAL_FILE_PASSION_FRUIT));
		uploadFruits(JsonFileManager.readFile(Constants.PATH_LOCAL_FILE_PEACH));
		window = new PrincipalWindow(this);
		reportManager = new ReportManager(chain.getFruitsList());
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
			chain.deleteFruit(fruitDelete);
			window.getPanelCardLayout().removeAll();
			window.getPanelCardLayout().add(window.getPanelTable());
			window.getPanelCardLayout().repaint();
			window.getPanelCardLayout().revalidate();
			window.setNewTable(chain.getFruitListWithName(fruitSelected));
			break;

		case CANCEL_BUTTON_DELETE:
			window.getPanelCardLayout().removeAll();
			window.getPanelCardLayout().add(window.getPanelTable());
			window.getPanelCardLayout().repaint();
			window.getPanelCardLayout().revalidate();
			window.setNewTable(chain.getFruitListWithName(fruitSelected));
			break;

		case SEARCH_DELETE:
			searchDelete();
			break;

		case BLACKBERRY_BUTTON:
			window.getPanelCardLayout().removeAll();
			window.getPanelCardLayout().add(window.getPanelTable());
			window.getPanelCardLayout().repaint();
			window.getPanelCardLayout().revalidate();
			window.setNewTable(chain.getBlackberryList());
			fruitSelected = Constants.BLACKBERRY;
			break;
		case STRAWBERRY_BUTTON:
			window.getPanelCardLayout().removeAll();
			window.getPanelCardLayout().add(window.getPanelTable());
			window.getPanelCardLayout().repaint();
			window.getPanelCardLayout().revalidate();
			window.setNewTable(chain.getStrawberryList());
			fruitSelected = Constants.STRAWBERRY;
			break;
		case LULO_BUTTON:
			window.getPanelCardLayout().removeAll();
			window.getPanelCardLayout().add(window.getPanelTable());
			window.getPanelCardLayout().repaint();
			window.getPanelCardLayout().revalidate();
			window.setNewTable(chain.getLuloList());
			fruitSelected = Constants.LULO;
			break;
		case BANANA_BUTTON:
			window.getPanelCardLayout().removeAll();
			window.getPanelCardLayout().add(window.getPanelTable());
			window.getPanelCardLayout().repaint();
			window.getPanelCardLayout().revalidate();
			window.setNewTable(chain.getBananaList());
			fruitSelected = Constants.BANANA;
			break;
		case PASSION_FRUIT_BUTTON:
			window.getPanelCardLayout().removeAll();
			window.getPanelCardLayout().add(window.getPanelTable());
			window.getPanelCardLayout().repaint();
			window.getPanelCardLayout().revalidate();
			window.setNewTable(chain.getPassionFruitList());
			fruitSelected = Constants.PASSION_FRUIT;
			break;
		case PEACH_BUTTON:
			window.getPanelCardLayout().removeAll();
			window.getPanelCardLayout().add(window.getPanelTable());
			window.getPanelCardLayout().repaint();
			window.getPanelCardLayout().revalidate();
			window.setNewTable(chain.getPeachList());
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
		case BUTTON_FACEBOOK:
			open(uriFacebook);
			break;
		case BUTTON_INSTAGRAM:
			open(uriInstagram);
			break;
		case BUTTON_YOUTUBE:
			open(uriYoutube);
			break;
		case REPORT_ONE:
			window.setVisibleButtonsExport(true);
			window.changeReport(reportManager.generateReportOfHectaresPerDepartament(window.getDepartment(true)), 1, true);
			break;
		case REPORT_TWO:
			window.setVisibleButtonsExport(false);
			window.changeReport(reportManager.generateReportOfBeneficiariesPerDepartament(window.getDepartment(true)), 2, true);
			break;
		case REPORT_THREE:
			window.setVisibleButtonsExport(false);
			window.changeReport(reportManager.generateReportOfInvestmentPerDepartament(window.getDepartment(true)), 3, true);
			break;
		case REPORT_FOUR:
			window.setVisibleButtonsExport(false);
			window.changeReport(reportManager.generateReportOfAetaricPerDepartament(window.getDepartment(true)), 4, true);
			break;
		case REPORT_FIVE:
			window.setVisibleButtonsExport(false);
			window.changeReport(reportManager.generateReportOfGenderPerDepartament(window.getDepartment(true)), 4, true);
			break;
		case REPORT_SIX:
			window.setVisibleButtonsExport(false);
			window.changeReport(reportManager.generateReportOfNationalHectares(), 5, false);
			break;
		case REPORT_SEVEN:
			window.setVisibleButtonsExport(false);
			window.changeReport(reportManager.generateReportOfNationalBeneficiaries(), 6, false);
			break;
		case REPORT_EIGHT:
			window.setVisibleButtonsExport(false);
			window.changeReport(reportManager.generateReportOfNationalInvestment(), 7, false);
			break;
		case REPORT_NINE:
			window.setVisibleButtonsExport(false);
			window.changeReport(reportManager.generateReportOfNationalAetaric(), 8, false);
			break;
		case REPORT_TEN:
			window.setVisibleButtonsExport(false);
			window.changeReport(reportManager.generateReportOfNationalGender(), 8, false);
			break;
		case GRAPHIC_ONE:
			window.createGraphic(reportManager.generateReportOfHectaresPerDepartament(window.getDepartment(false)), true);
			break;
		case GRAPHIC_TWO:
			window.createGraphic(reportManager.generateReportOfBeneficiariesPerDepartament(window.getDepartment(false)), true);
			break;
		case GRAPHIC_THREE:
			window.createGraphic(reportManager.generateReportOfInvestmentPerDepartament(window.getDepartment(false)), true);
			break;
		case GRAPHIC_FOUR:
			window.createGraphicBar(reportManager.generateReportOfAetaricPerDepartament(window.getDepartment(false)), true);
			break;
		case GRAPHIC_FIVE:
			window.createGraphicBar(reportManager.generateReportOfGenderPerDepartament(window.getDepartment(false)), true);
			break;
		case GRAPHIC_SIX:
			window.createGraphic(reportManager.generateReportOfNationalHectares(), false);
			break;
		case GRAPHIC_SEVEN:
			window.createGraphic(reportManager.generateReportOfNationalBeneficiaries(), false);
			break;
		case GRAPHIC_EIGHT:
			window.createGraphic(reportManager.generateReportOfNationalInvestment(), false);
			break;
		case GRAPHIC_NINE:
			window.createGraphicBar(reportManager.generateReportOfNationalAetaric(), false);
			break;
		case GRAPHIC_TEN:
			window.createGraphicBar(reportManager.generateReportOfNationalGender(), false);
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
				reportManager.setFruit(newFruit);
				window.getPanelCardLayout().removeAll();
				window.getPanelCardLayout().add(window.getPanelTable());
				window.getPanelCardLayout().repaint();
				window.getPanelCardLayout().revalidate();
				window.setNewTable(chain.getBananaList());
				window.clearData();
			}
		} else {
			window.setVisibleNotice(true);
		}
	}

	private void searchDelete() {
		ArrayList<Fruit> fruitList = chain.getFruitsList();
		int count = 0;
		int index = 0;
		try {
			Object[] data = window.getInfoDelete();
			Object[][] itemToDelete = new Object[fruitList.size()][10];
			String fruit = (String) data[0];
			int idTown = Integer.parseInt((String) data[1]);
			String gender = (String) data[2];
			String ageGroup = viewsUtilities.setToForNumbersAge(data[3], data[4]);
			String sisbenScore = viewsUtilities.setToForNumbersSisben(data[5], data[6]);
			int beneficiaries = Integer.parseInt((String) data[7]);
			double investment = Double.parseDouble((String) data[8]);
			double hectare = Double.parseDouble((String) data[9]);
			
			for (index = 0; index < fruitList.size(); index++) {
				if (fruit.equalsIgnoreCase(fruitList.get(index).getName()) && idTown == fruitList.get(index).getIdTown()
						&& fruitList.get(index).getGender().equalsIgnoreCase(gender)
						&& ageGroup.equalsIgnoreCase(fruitList.get(index).getAgeGroup())
						&& sisbenScore.equalsIgnoreCase(fruitList.get(index).getSisbenScore())
						&& beneficiaries == fruitList.get(index).getBeneficiaries()
						&& investment == fruitList.get(index).getInvestment()
						&& hectare == fruitList.get(index).getHectare()) {

					itemToDelete[count][0] = fruitList.get(index).getName();
					itemToDelete[count][1] = fruitList.get(index).getDepartment();
					itemToDelete[count][2] = fruitList.get(index).getIdTown();
					itemToDelete[count][3] = fruitList.get(index).getTown();
					itemToDelete[count][4] = fruitList.get(index).getGender();
					itemToDelete[count][5] = fruitList.get(index).getAgeGroup();
					itemToDelete[count][6] = fruitList.get(index).getSisbenScore();
					itemToDelete[count][7] = fruitList.get(index).getBeneficiaries();
					itemToDelete[count][8] = fruitList.get(index).getInvestment();
					itemToDelete[count][9] = fruitList.get(index).getHectare();
					count++;
					fruitDelete = index;
				}
			}
			if (itemToDelete[0][0] != null) {
				window.setNewTable(itemToDelete);
				window.setVisibleDelete();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
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
	
	private void open(URI uri) {
		if (Desktop.isDesktopSupported()) {
			try {
				Desktop.getDesktop().browse(uri);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

}
