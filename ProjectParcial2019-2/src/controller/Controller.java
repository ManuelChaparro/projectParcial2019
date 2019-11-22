package controller;

import views.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import handler.HandlerLanguage;
import models.Avocado;
import models.Calculations;
import persistence.JsonFileManager;

public class Controller implements ActionListener {

	private HandlerLanguage config;
	private PrincipalWindow window;
	private GraphicDialog graphicDialog;
	private NewFileDialog newFileDialog;
	private ViewsUtilities viewsUtilities;
	private Calculations calculations;
	private Avocado avocado;

	public Controller() {
		viewsUtilities = new ViewsUtilities();
		calculations = new Calculations();
		config = null;
		loadConfiguration();
		newFileDialog = new NewFileDialog(this);
		graphicDialog = new GraphicDialog(this);
		window = new PrincipalWindow(JsonFileManager.readFile(Constants.PATH_LOCAL_FILE), this);

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
			
		case ACCEPT_BUTTON:
			addNewAvocado();
			newFileDialog.setVisible(false);
			break;
			
		case CANCEL_BUTTON:
			newFileDialog.setVisible(false);
			newFileDialog.clearData();
			break;
			
		default:
			break;
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
			performance = calculations.calculatePerformance(data);
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
