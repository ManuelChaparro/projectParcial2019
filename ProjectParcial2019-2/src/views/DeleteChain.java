package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controller.Commands;
import controller.Controller;
import handler.HandlerLanguage;

public class DeleteChain extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel container, north, center, south, titlePanel, containerOptions;
	private LabelObject title, titleTown, titlePeriod, idDepartment, department,
		idTown, town, swonArea, harvestedArea, production, performance, 
		physicalState, period, infoIdDepartment, infoDepartment,
		infoIdTown, infoTown, infoSwonArea, infoHarvestedArea, infoProduction, infoPerformance, 
		infoPhysicalState, infoPeriod;
	private TextFieldObject writeTown, writePeriod;
	private ButtonObject accept, cancel;
	
	public DeleteChain(Controller controller) {
		setTitle(HandlerLanguage.languageProperties.getProperty(Constants.TITLE_DELETE_CHAIN));
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setResizable(false);
		setLocation(50, 100);
		setMinimumSize(new Dimension(600, 500));
		setUndecorated(false);
		Image imageIcon = new ImageIcon(getClass().getResource(Constants.PATH_ICON_FRAME)).getImage();
		setIconImage(imageIcon);
		initComponents(controller);
		setVisible(false);
	}

	private void initComponents(Controller controller) {
		createPanels();
		createTitles();
		createTextFields(controller);
		createComponentsNorth();
		createComponentsCenter();
		createComponentsSouth(controller);
	}
	
	private void createTextFields(Controller controller) {
		writeTown = new TextFieldObject();
		writeTown.setActionCommand(Commands.SEARCH_DELETE.name());
		writeTown.addActionListener(controller);
		
		writePeriod = new TextFieldObject();
		writePeriod.setActionCommand(Commands.SEARCH_DELETE.name());
		writePeriod.addActionListener(controller);
	}

	private void createComponentsSouth(Controller controller) {
		Image imageAccept = new ImageIcon(getClass().getResource(Constants.PATH_ICON_ACCEPT)).getImage();
		Icon rescaledAccept= new ImageIcon(imageAccept.getScaledInstance(35, 35, Image.SCALE_SMOOTH));
		accept = new ButtonObject("", Color.WHITE, rescaledAccept, controller, Commands.ACCEPT_BUTTON_DELETE.name());
		
		Image imageCancel = new ImageIcon(getClass().getResource(Constants.PATH_ICON_CANCEL)).getImage();
		Icon rescaledCancel = new ImageIcon(imageCancel.getScaledInstance(35, 35, Image.SCALE_SMOOTH));
		cancel = new ButtonObject("", Color.WHITE, rescaledCancel, controller, Commands.CANCEL_BUTTON_DELETE.name());
		
		south.add(accept, BorderLayout.EAST);
		south.add(cancel, BorderLayout.WEST);
	}

	private void createComponentsCenter() {
		center.add(idDepartment);
		center.add(infoIdDepartment);
		center.add(department);
		center.add(infoDepartment);
		center.add(idTown);
		center.add(infoIdTown);
		center.add(town);
		center.add(infoTown);
		center.add(swonArea);
		center.add(infoSwonArea);
		center.add(harvestedArea);
		center.add(infoHarvestedArea);
		center.add(production);
		center.add(infoProduction);
		center.add(performance);
		center.add(infoPerformance);
		center.add(physicalState);
		center.add(infoPhysicalState);
		center.add(period);
		center.add(infoPeriod);
	}

	private void createComponentsNorth() {
		titlePanel.setLayout(new FlowLayout(0, 225, 8));
		titlePanel.setBackground(Constants.RED_COLOR);
		titlePanel.add(title);
		
		north.setLayout(new FlowLayout(0, 35, 5));
		north.setBackground(Constants.RED_COLOR);
		north.add(titleTown);
		writeTown.setPreferredSize(new Dimension(150, 25));
		north.add(writeTown);
		north.add(titlePeriod);
		writePeriod.setPreferredSize(new Dimension(150, 25));
		north.add(writePeriod);
		
		containerOptions.add(titlePanel, BorderLayout.NORTH);
		containerOptions.add(north, BorderLayout.CENTER);
	}

	private void createTitles() {
		title = new LabelObject(HandlerLanguage.languageProperties.getProperty(Constants.TITLE_DELETE_CHAIN), Color.WHITE, Color.WHITE, Constants.DEFAULT_FONT);
		titleTown = new LabelObject(HandlerLanguage.languageProperties.getProperty(Constants.TOWN), Color.WHITE, Color.WHITE, Constants.DEFAULT_FONT);
		titlePeriod = new LabelObject(HandlerLanguage.languageProperties.getProperty(Constants.PERIOD), Color.WHITE, Color.WHITE, Constants.DEFAULT_FONT);
		
		idDepartment = new LabelObject(HandlerLanguage.languageProperties.getProperty(Constants.H_ID_DEPARTMENT), Color.WHITE, Color.BLACK, Constants.DEFAULT_FONT);
		department = new LabelObject(HandlerLanguage.languageProperties.getProperty(Constants.H_DEPARTMENT), Color.WHITE, Color.BLACK, Constants.DEFAULT_FONT);
		idTown = new LabelObject(HandlerLanguage.languageProperties.getProperty(Constants.H_ID_TOWN), Color.WHITE, Color.BLACK, Constants.DEFAULT_FONT);
		town = new LabelObject(HandlerLanguage.languageProperties.getProperty(Constants.H_TOWN), Color.WHITE, Color.BLACK, Constants.DEFAULT_FONT);
		swonArea = new LabelObject(HandlerLanguage.languageProperties.getProperty(Constants.H_SOWN_AREA), Color.WHITE, Color.BLACK, Constants.DEFAULT_FONT);
		harvestedArea = new LabelObject(HandlerLanguage.languageProperties.getProperty(Constants.H_HARVESTED_AREA), Color.WHITE, Color.BLACK, Constants.DEFAULT_FONT);
		production = new LabelObject(HandlerLanguage.languageProperties.getProperty(Constants.H_PRODUCTION), Color.WHITE, Color.BLACK, Constants.DEFAULT_FONT);
		performance = new LabelObject(HandlerLanguage.languageProperties.getProperty(Constants.H_PERFORMANCE), Color.WHITE, Color.BLACK, Constants.DEFAULT_FONT);
		physicalState = new LabelObject(HandlerLanguage.languageProperties.getProperty(Constants.H_PHYSICAL_STATE), Color.WHITE, Color.BLACK, Constants.DEFAULT_FONT);
		period = new LabelObject(HandlerLanguage.languageProperties.getProperty(Constants.H_PERIOD), Color.WHITE, Color.BLACK, Constants.DEFAULT_FONT);	
	
		infoIdDepartment = new LabelObject("...", Color.WHITE, Constants.RED_COLOR, Constants.DEFAULT_FONT);
		infoDepartment = new LabelObject("...", Color.WHITE, Constants.RED_COLOR, Constants.DEFAULT_FONT);
		infoIdTown = new LabelObject("...", Color.WHITE, Constants.RED_COLOR, Constants.DEFAULT_FONT);
		infoTown = new LabelObject("...", Color.WHITE, Constants.RED_COLOR, Constants.DEFAULT_FONT);
		infoSwonArea = new LabelObject("...", Color.WHITE, Constants.RED_COLOR, Constants.DEFAULT_FONT);
		infoHarvestedArea = new LabelObject("...", Color.WHITE, Constants.RED_COLOR, Constants.DEFAULT_FONT);
		infoProduction = new LabelObject("...", Color.WHITE, Constants.RED_COLOR, Constants.DEFAULT_FONT);
		infoPerformance = new LabelObject("...", Color.WHITE, Constants.RED_COLOR, Constants.DEFAULT_FONT);
		infoPhysicalState = new LabelObject("...", Color.WHITE, Constants.RED_COLOR, Constants.DEFAULT_FONT);
		infoPeriod = new LabelObject("...", Color.WHITE, Constants.RED_COLOR, Constants.DEFAULT_FONT);
	}

	private void createPanels() {
		container = new JPanel();
		container.setLayout(new BorderLayout());
		
		titlePanel = new JPanel();
		
		north = new JPanel();
		
		center = new JPanel();
		center.setLayout(new GridLayout(10, 2));
		center.setBorder(new EmptyBorder(10, 20, 0, 0));
		center.setBackground(Color.WHITE);
		
		south = new JPanel();
		south.setLayout(new FlowLayout(0, 170, 8));
		south.setBackground(Constants.RED_COLOR);
		
		containerOptions = new JPanel();
		containerOptions.setLayout(new BorderLayout());
		containerOptions.setBackground(Constants.RED_COLOR);

		
		container.add(containerOptions, BorderLayout.NORTH);
		container.add(center, BorderLayout.CENTER);
		container.add(south, BorderLayout.SOUTH);
		
		add(container);
	}

	public Object[] getInfoDelete() {
		String[] data = new String[2];
		data[0] = writeTown.getText();
		data[1] = writePeriod.getText();
		return data;
	}

	public void setTextDelete(Object[] itemToDelete) {
		infoIdDepartment.setText(String.valueOf(itemToDelete[0]));
		infoDepartment.setText((String) itemToDelete[1]);
		infoIdTown.setText(String.valueOf(itemToDelete[2]));
		infoTown.setText((String) itemToDelete[3]);
		infoSwonArea.setText(String.valueOf(itemToDelete[4]));
		infoHarvestedArea.setText(String.valueOf(itemToDelete[5]));
		infoProduction.setText(String.valueOf(itemToDelete[6]));
		infoPerformance.setText(String.valueOf(itemToDelete[7]));
		infoPhysicalState.setText((String) itemToDelete[8]);
		infoPeriod.setText(String.valueOf(itemToDelete[9]));
	}
	
	public void clearData() {
		writeTown.setText("");
		writePeriod.setText("");
		infoIdDepartment.setText("...");
		infoDepartment.setText("...");
		infoIdTown.setText("...");
		infoTown.setText("...");
		infoSwonArea.setText("...");
		infoHarvestedArea.setText("...");
		infoProduction.setText("...");
		infoPerformance.setText("...");
		infoPhysicalState.setText("...");
		infoPeriod.setText("...");
	}

}
