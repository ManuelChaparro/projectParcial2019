package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import controller.Commands;
import controller.Controller;
import handler.HandlerLanguage;

public class NewFileContainer extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Departments departaments;
	private PhysicalState physicalState;
	private JSpinner period;
	private SpinnerNumberModel periodModel;
	private ButtonObject accept, cancel;
	private LabelObject LIdDepartament, LDepartaments, LIdTown, LTown,
	LPeriod, LSwonArea, LHarvestedArea, LProduction, LPerformance, LPhysycalState;
	private TextFieldObject idDepartment, idTown, town, sownArea, harvestedArea, production,
	performance;
	private PanelObject containerDepartment, PanelIdDepartament, PanelDepartament, 
	containerTown, PanelIdTown,	PanelTown, PanelPeriod, containerArea, PanelSwonArea, PanelHarvestedArea,
	PanelProduction, containerProduction, PanelPerformance, PanelPhysicalState, containerState, containerButtons;

	
	
	public NewFileContainer(Controller controller) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(Color.WHITE);
		departaments = new Departments(controller);
		initComponents(controller);
	}
	
	private void initComponents(Controller controller) {
		
		//Components department
		LIdDepartament = new LabelObject(HandlerLanguage.languageProperties.getProperty(Constants.ID_DEPARTMENT), Color.WHITE, Color.WHITE, Constants.DEFAULT_FONT);
		idDepartment = new TextFieldObject();
		idDepartment.setEnabled(false);
		setIdDepartment();
		PanelIdDepartament = new PanelObject(Constants.AQUA_COLOR, LIdDepartament, idDepartment);
		
		LDepartaments = new LabelObject(HandlerLanguage.languageProperties.getProperty(Constants.DEPARTMENT), Color.WHITE, Color.WHITE, Constants.DEFAULT_FONT);
		PanelDepartament = new PanelObject(Constants.AQUA_COLOR, LDepartaments, departaments);
		
		containerDepartment = new PanelObject(Constants.AQUA_COLOR, PanelIdDepartament, PanelDepartament);
		add(containerDepartment);
		
		//Components town
		LIdTown = new LabelObject(HandlerLanguage.languageProperties.getProperty(Constants.ID_TOWN), Color.WHITE, Color.WHITE, Constants.DEFAULT_FONT);
		idTown = new TextFieldObject();
		PanelIdTown = new PanelObject(Constants.AQUA_COLOR, LIdTown, idTown);		
		
		LTown = new LabelObject(HandlerLanguage.languageProperties.getProperty(Constants.TOWN), Color.WHITE, Color.WHITE, Constants.DEFAULT_FONT);
		town = new TextFieldObject();
		PanelTown = new PanelObject(Constants.AQUA_COLOR, LTown, town);
		PanelTown.setPreferredSize(new Dimension(300, 30));
		
		containerTown = new PanelObject(Constants.AQUA_COLOR, PanelIdTown, PanelTown);
		add(containerTown);
		
		//Components Area, Production and Performance
		LSwonArea = new LabelObject(HandlerLanguage.languageProperties.getProperty(Constants.SWON_AREA), Color.WHITE, Color.WHITE, Constants.DEFAULT_FONT);
		sownArea = new TextFieldObject();
		PanelSwonArea = new PanelObject(Constants.AQUA_COLOR, LSwonArea, sownArea);
		
		LHarvestedArea = new LabelObject(HandlerLanguage.languageProperties.getProperty(Constants.HARVESTED_AREA), Color.WHITE, Color.WHITE, Constants.DEFAULT_FONT);
		harvestedArea = new TextFieldObject();
		harvestedArea.setActionCommand(Commands.CALCULATE_PERFORMANCE.name());
		harvestedArea.addActionListener(controller);
		PanelHarvestedArea = new PanelObject(Constants.AQUA_COLOR, LHarvestedArea, harvestedArea);
		
		containerArea = new PanelObject(Constants.AQUA_COLOR, PanelSwonArea, PanelHarvestedArea);
		add(containerArea);
		
		LProduction = new LabelObject(HandlerLanguage.languageProperties.getProperty(Constants.PRODUCTION), Color.WHITE, Color.WHITE, Constants.DEFAULT_FONT);
		production = new TextFieldObject();
		production.setActionCommand(Commands.CALCULATE_PERFORMANCE.name());
		production.addActionListener(controller);
		PanelProduction = new PanelObject(Constants.AQUA_COLOR, LProduction, production);
		
		LPerformance = new LabelObject(HandlerLanguage.languageProperties.getProperty(Constants.PERFORMANCE), Color.WHITE, Color.WHITE, Constants.DEFAULT_FONT);
		performance = new TextFieldObject();
		performance.setEditable(false);
		PanelPerformance = new PanelObject(Constants.AQUA_COLOR, LPerformance, performance);

		containerProduction = new PanelObject(Constants.AQUA_COLOR, PanelProduction, PanelPerformance);
		add(containerProduction);
		
		//Components Physical State and Period
		
		LPhysycalState = new LabelObject(HandlerLanguage.languageProperties.getProperty(Constants.PHYSICAL_STATE), Color.WHITE, Color.WHITE, Constants.DEFAULT_FONT);
		physicalState = new PhysicalState();
		PanelPhysicalState = new PanelObject(Constants.AQUA_COLOR, LPhysycalState, physicalState);
		
		LPeriod = new LabelObject(HandlerLanguage.languageProperties.getProperty(Constants.PERIOD), Color.WHITE, Color.WHITE, Constants.DEFAULT_FONT);
		period = new JSpinner();
		periodModel = new SpinnerNumberModel();
		periodModel.setMinimum(2000);
		periodModel.setMaximum(2019);
		periodModel.setValue(2019);
		period.setFont(Constants.DEFAULT_FONT);
		period.setModel(periodModel);
		PanelPeriod = new PanelObject(Constants.AQUA_COLOR, LPeriod, period);
		
		containerState = new PanelObject(Constants.AQUA_COLOR, PanelPhysicalState, PanelPeriod);
		add(containerState);
		
		//Buttons accept and cancel
		Image imageAccept = new ImageIcon(getClass().getResource(Constants.PATH_ICON_ACCEPT)).getImage();
		Icon rescaledAccept= new ImageIcon(imageAccept.getScaledInstance(35, 35, Image.SCALE_SMOOTH));
		accept = new ButtonObject("", Color.WHITE, rescaledAccept, controller, Commands.ACCEPT_BUTTON_CHAIN.name());
		
		Image imageCancel = new ImageIcon(getClass().getResource(Constants.PATH_ICON_CANCEL)).getImage();
		Icon rescaledCancel = new ImageIcon(imageCancel.getScaledInstance(35, 35, Image.SCALE_SMOOTH));
		cancel = new ButtonObject("", Color.WHITE, rescaledCancel, controller, Commands.CANCEL_BUTTON_CHAIN.name());
		
		containerButtons = new PanelObject(Constants.AQUA_COLOR, accept, cancel);
		add(containerButtons);
	}


	public void changeLanguage() {
		LIdDepartament.setText(HandlerLanguage.languageProperties.getProperty(Constants.ID_DEPARTMENT));
		LDepartaments.setText(HandlerLanguage.languageProperties.getProperty(Constants.DEPARTMENT));
		LIdTown.setText(HandlerLanguage.languageProperties.getProperty(Constants.ID_TOWN));
		LTown.setText(HandlerLanguage.languageProperties.getProperty(Constants.TOWN));
		LPeriod.setText(HandlerLanguage.languageProperties.getProperty(Constants.PERIOD));
		LSwonArea.setText(HandlerLanguage.languageProperties.getProperty(Constants.SWON_AREA));
		LHarvestedArea.setText(HandlerLanguage.languageProperties.getProperty(Constants.HARVESTED_AREA));
		LProduction.setText(HandlerLanguage.languageProperties.getProperty(Constants.PRODUCTION));
		LPerformance.setText(HandlerLanguage.languageProperties.getProperty(Constants.PERFORMANCE));
		LPhysycalState.setText(HandlerLanguage.languageProperties.getProperty(Constants.PHYSICAL_STATE));
	}
	
	public int[] getDataPerformance() {
		return new int[] {Integer.parseInt(harvestedArea.getText()), Integer.parseInt(production.getText())};
	}


	public void setIdDepartment() {
		String item = departaments.getSelectedItem().toString();
		switch (item) {
		case "AMAZONAS":
			idDepartment.setText(Constants.ID_AMAZONAS);
			break;
		case "ANTIOQUIA":
			idDepartment.setText(Constants.ID_ANTIOQUIA);
			break;
		case "ARAUCA":
			idDepartment.setText(Constants.ID_ARAUCA);
			break;
		case "ATLANTICO" :
			idDepartment.setText(Constants.ID_ATLANTICO);
			break;
		case "BOGOTA DC":
			idDepartment.setText(Constants.ID_BOGOTA_DC);
			break;
		case "BOLIVAR":
			idDepartment.setText(Constants.ID_BOLIVAR);
			break;
		case "BOYACA":
			idDepartment.setText(Constants.ID_BOYACA);
			break;
		case "CALDAS":
			idDepartment.setText(Constants.ID_CALDAS);
			break;
		case "CAQUETA":
			idDepartment.setText(Constants.ID_CAQUETA);
			break;
		case "CASANARE":
			idDepartment.setText(Constants.ID_CASANARE);
			break;
		case "CAUCA":
			idDepartment.setText(Constants.ID_CAUCA);
			break;
		case "CESAR":
			idDepartment.setText(Constants.ID_CESAR);
			break;
		case "CHOCO":
			idDepartment.setText(Constants.ID_CHOCO);
			break;
		case "CORDOBA":
			idDepartment.setText(Constants.ID_CORDOBA);
			break;
		case "CUNDINAMARCA":
			idDepartment.setText(Constants.ID_CUNDINAMARCA);
			break;
		case "GUAINIA":
			idDepartment.setText(Constants.ID_GUAINIA);
			break;
		case "GUAVIARE":
			idDepartment.setText(Constants.ID_GUAVIARE);
			break;
		case "HUILA":
			idDepartment.setText(Constants.ID_HUILA);
			break;
		case "LA GUAJIRA":
			idDepartment.setText(Constants.ID_LA_GUAJIRA);
			break;
		case "MAGDALENA":
			idDepartment.setText(Constants.ID_MAGDALENA);
			break;
		case "META":
			idDepartment.setText(Constants.ID_META);
			break;
		case "NARIÑO":
			idDepartment.setText(Constants.ID_NARIÑO);
			break;
		case "NORTE DE SANTANDER":
			idDepartment.setText(Constants.ID_NORTE_DE_SANTANDER);
			break;
		case "PUTUMAYO":
			idDepartment.setText(Constants.ID_PUTUMAYO);
			break;
		case "QUNIDIO":
			idDepartment.setText(Constants.ID_QUNIDIO);
			break;
		case "RISARALDA":
			idDepartment.setText(Constants.ID_RISARALDA);
			break;
		case "SAN ANDRES":
			idDepartment.setText(Constants.ID_SAN_ANDRES);
			break;
		case "SANTANDER":
			idDepartment.setText(Constants.ID_SANTANDER);
			break;
		case "SUCRE":
			idDepartment.setText(Constants.ID_SUCRE);
			break;
		case "TOLIMA":
			idDepartment.setText(Constants.ID_TOLIMA);
			break;
		case "VALLE DEL CAUCA":
			idDepartment.setText(Constants.ID_VALLE_DEL_CAUCA);
			break;
		case "VAUPES":
			idDepartment.setText(Constants.ID_VAUPES);
			break;
		case "VICHADA":
			idDepartment.setText(Constants.ID_VICHADA);
			break;
		default:
			break;
		}
	}

	public void setPerformance(int performanceData) {
		String performanceString = String.valueOf(performanceData);
		performance.setText(performanceString);
	}

	public Object[] getDataAvocado() {
		int idDepartment =0;
		int idTown = 0;
		int sownArea = 0;
		int harvestedArea = 0;
		int production = 0;
		int performance = 0;
		int period = 0;
		String department = "";
		String town = "";
		String physicalState = "";
		idDepartment = Integer.parseInt(this.idDepartment.getText());
		department = (String) departaments.getSelectedItem();
		idTown = Integer.parseInt(this.idTown.getText());
		town = this.town.getText();
		sownArea = Integer.parseInt(this.sownArea.getText());
		harvestedArea = Integer.parseInt(this.harvestedArea.getText());
		production = Integer.parseInt(this.production.getText());
		performance = Integer.parseInt(this.performance.getText());
		physicalState = (String) this.physicalState.getSelectedItem();
		period = (int) this.period.getValue();
		return new Object[] {idDepartment, department, idTown, town,
				sownArea, harvestedArea, production, performance, physicalState, period};
	}

	public void clearData() {
		idTown.setText("");
		town.setText("");
		sownArea.setText("");
		harvestedArea.setText("");
		production.setText("");
		performance.setText("");
	}

}











