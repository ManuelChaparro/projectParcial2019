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
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import controller.Commands;
import controller.Controller;
import handler.HandlerLanguage;

public class DeleteChain extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PanelTable table;
	private Gender gender;
	private Fruits fruit;
	private PanelObject containerAgeGroup, containerSisbenScore, containerNotice, containerButtons;
	private JSpinner ageOne, ageTwo, sisbenOne, sisbenTwo;
	private SpinnerNumberModel ageOneModel, ageTwoModel, sisbenOneModel, sisbenTwoModel;
	private JPanel containerFields, north, center, south, titlePanel;
	private LabelObject notice, toAge, toSisben, title, titleFruit, titleIdTown, titleGender, titleAgeGroup,
			titleSisbenScore, titleBeneficiaries, titleInvestment, titleHectare;
	private TextFieldObject  idTown, ageGroup, sisbenScore, beneficiaries, investment, hectare;
	private ButtonObject search, accept, cancel;


	public DeleteChain(Controller controller) {
		setPreferredSize(new Dimension(Constants.WIDTH, Constants.HEIGTH));
		setLocation(50, 100);
		setBackground(Color.WHITE);
		
		initComponents(controller);
		setVisible(false);
	}

	private void initComponents(Controller controller) {
		createPanels();
		createTitles(controller);
		createTextFields(controller);
		createComponentsNorth();
		createComponentsCenter(controller);
		createComponentsSouth(controller);
	}

	private void createTextFields(Controller controller) {	
		fruit = new Fruits(controller);
		fruit.setBorder(null);
		fruit.setBackground(Constants.RED_COLOR);
		
		idTown = new TextFieldObject();
		idTown.setText("0");
		
		gender = new Gender(controller);
		gender.setBorder(null);
		gender.setBackground(Constants.RED_COLOR);
		
		containerAgeGroup = new PanelObject(new FlowLayout(), Color.WHITE);
		containerAgeGroup.setBackground(Constants.RED_COLOR);
		ageOne = new JSpinner();
		ageOneModel = new SpinnerNumberModel();
		ageOneModel.setMinimum(15);
		ageOneModel.setMaximum(100);
		ageOneModel.setValue(15);
		ageOneModel.setStepSize(5);
		ageOne.setFont(Constants.DEFAULT_FONT);
		ageOne.setModel(ageOneModel);

		ageTwo = new JSpinner();
		ageTwoModel = new SpinnerNumberModel();
		ageTwoModel.setMinimum(15);
		ageTwoModel.setMaximum(100);
		ageTwoModel.setValue(19);
		ageTwoModel.setStepSize(5);
		ageTwo.setFont(Constants.DEFAULT_FONT);
		ageTwo.setModel(ageTwoModel);

		toAge = new LabelObject(HandlerLanguage.languageProperties.getProperty(Constants.TO), Color.WHITE, Color.WHITE,
				Constants.DEFAULT_FONT);

		containerAgeGroup.add(ageOne);
		containerAgeGroup.add(toAge);
		containerAgeGroup.add(ageTwo);
		
		containerSisbenScore = new PanelObject(new FlowLayout(), Color.WHITE);
		containerSisbenScore.setBackground(Constants.RED_COLOR);
		sisbenOne = new JSpinner();
		sisbenOneModel = new SpinnerNumberModel();
		sisbenOneModel.setMinimum(0);
		sisbenOneModel.setMaximum(100);
		sisbenOneModel.setValue(40);
		sisbenOneModel.setStepSize(10);
		sisbenOne.setFont(Constants.DEFAULT_FONT);
		sisbenOne.setModel(sisbenOneModel);

		sisbenTwo = new JSpinner();
		sisbenTwoModel = new SpinnerNumberModel();
		sisbenTwoModel.setMinimum(0);
		sisbenTwoModel.setMaximum(100);
		sisbenTwoModel.setValue(50);
		sisbenTwoModel.setStepSize(10);
		sisbenTwo.setFont(Constants.DEFAULT_FONT);
		sisbenTwo.setModel(sisbenTwoModel);
		
		toSisben = new LabelObject(HandlerLanguage.languageProperties.getProperty(Constants.TO), Color.WHITE, Color.WHITE,
				Constants.DEFAULT_FONT);


		containerSisbenScore.add(sisbenOne);
		containerSisbenScore.add(toSisben);
		containerSisbenScore.add(sisbenTwo);

		
		beneficiaries = new TextFieldObject();
		beneficiaries.setText("0");
		
		investment = new TextFieldObject();
		investment.setText("0");
		
		hectare = new TextFieldObject();
		hectare.setText("0");
	}

	private void createComponentsSouth(Controller controller) {		
		containerNotice = new PanelObject(new FlowLayout(), Constants.RED_COLOR);
		
		containerNotice.add(notice);
		
		south.add(containerNotice, BorderLayout.NORTH);
		south.add(accept, BorderLayout.EAST);
		south.add(cancel, BorderLayout.WEST);
		south.setVisible(false);
		add(south);
	}

	private void createComponentsCenter(Controller controller) {
		table = new PanelTable(controller);
		table.setPreferredSize(new Dimension((int) (Constants.WIDTH*0.85), (int) (Constants.HEIGTH*0.4)));
		center.add(table, BorderLayout.CENTER);
		add(center);
	}

	private void createComponentsNorth() {
		//Title
		titlePanel.setLayout(new FlowLayout());
		titlePanel.setBackground(Constants.RED_COLOR);
		titlePanel.add(title);
		
		//TextFields and Labels		
		containerFields.setLayout(new GridLayout(4, 4, 10,10));
		containerFields.setPreferredSize(new Dimension(Constants.WIDTH, (int) (Constants.HEIGTH*0.15)));
		containerFields.setBackground(Constants.RED_COLOR);
		
		containerFields.add(titleFruit);
		containerFields.add(fruit);
		containerFields.add(titleIdTown);
		containerFields.add(idTown);
		containerFields.add(titleGender);
		containerFields.add(gender);
		containerFields.add(titleAgeGroup);
		containerFields.add(containerAgeGroup);
		containerFields.add(titleSisbenScore);
		containerFields.add(containerSisbenScore);
		containerFields.add(titleBeneficiaries);
		containerFields.add(beneficiaries);
		containerFields.add(titleInvestment);
		containerFields.add(investment);
		containerFields.add(titleHectare);
		containerFields.add(hectare);

		north.setLayout(new BorderLayout());
		north.setPreferredSize(new Dimension(Constants.WIDTH, (int) (Constants.HEIGTH*0.38)));
		north.setBackground(Constants.RED_COLOR);
		north.setBorder(new EmptyBorder(10, 200, 10, 200));

		north.add(titlePanel, BorderLayout.NORTH);
		north.add(containerFields, BorderLayout.CENTER);
		north.add(search, BorderLayout.SOUTH);
		
		add(north);
	}

	private void createTitles(Controller controller) {
		title = new LabelObject(HandlerLanguage.languageProperties.getProperty(Constants.TITLE_DELETE_CHAIN),
				Color.WHITE, Color.WHITE, Constants.DEFAULT_FONT_MAX);
		titleFruit = new LabelObject(HandlerLanguage.languageProperties.getProperty(Constants.NAME),
				Color.WHITE, Color.WHITE, Constants.DEFAULT_FONT_MAX);
		titleIdTown = new LabelObject(HandlerLanguage.languageProperties.getProperty(Constants.ID_TOWN), Color.WHITE,
				Color.WHITE, Constants.DEFAULT_FONT);
		titleAgeGroup = new LabelObject(HandlerLanguage.languageProperties.getProperty(Constants.AGE_GROUP),
				Color.WHITE, Color.WHITE, Constants.DEFAULT_FONT);
		titleSisbenScore = new LabelObject(HandlerLanguage.languageProperties.getProperty(Constants.SISBEN_SCORE), Color.WHITE,
				Color.WHITE, Constants.DEFAULT_FONT);
		titleGender = new LabelObject(HandlerLanguage.languageProperties.getProperty(Constants.GENDER), Color.WHITE,
				Color.WHITE, Constants.DEFAULT_FONT);
		titleBeneficiaries = new LabelObject(HandlerLanguage.languageProperties.getProperty(Constants.BENEFICIARIES),
				Color.WHITE, Color.WHITE, Constants.DEFAULT_FONT);
		titleInvestment = new LabelObject(HandlerLanguage.languageProperties.getProperty(Constants.INVESTMENT),
				Color.WHITE, Color.WHITE, Constants.DEFAULT_FONT);
		titleHectare = new LabelObject(HandlerLanguage.languageProperties.getProperty(Constants.HECTARE), Color.WHITE,
				Color.WHITE, Constants.DEFAULT_FONT);
		
		notice = new LabelObject(HandlerLanguage.languageProperties.getProperty(Constants.NOTICE_DELETE_FILE), Constants.RED_COLOR,
				Color.WHITE, Constants.DEFAULT_FONT);
		
		// Button search
		Image imageSearch = new ImageIcon(getClass().getResource(Constants.PATH_ICON_SEARCH)).getImage();
		Icon rescaledSearch = new ImageIcon(imageSearch.getScaledInstance((int) (Constants.WIDTH * 0.03),
				(int) (Constants.WIDTH * 0.03), Image.SCALE_SMOOTH));
		search = new ButtonObject("", Color.WHITE, rescaledSearch, controller, Commands.SEARCH_DELETE.name(),
				Constants.DEFAULT_FONT);
		
		Image imageAccept = new ImageIcon(getClass().getResource(Constants.PATH_ICON_ACCEPT)).getImage();
		Icon rescaledAccept = new ImageIcon(imageAccept.getScaledInstance((int) (Constants.WIDTH * 0.03),
				(int) (Constants.WIDTH * 0.03), Image.SCALE_SMOOTH));
		accept = new ButtonObject("", Color.WHITE, rescaledAccept, controller, Commands.ACCEPT_BUTTON_DELETE.name(),
				Constants.DEFAULT_FONT);
		
		Image imageCancel = new ImageIcon(getClass().getResource(Constants.PATH_ICON_CANCEL)).getImage();
		Icon rescaledCancel = new ImageIcon(imageCancel.getScaledInstance((int) (Constants.WIDTH * 0.03),
				(int) (Constants.WIDTH * 0.03), Image.SCALE_SMOOTH));
		cancel = new ButtonObject("", Color.WHITE, rescaledCancel, controller, Commands.CANCEL_BUTTON_DELETE.name(),
				Constants.DEFAULT_FONT);
	}

	private void createPanels() {
		titlePanel = new JPanel();
		
		containerFields = new JPanel();
		
		north = new JPanel();

		center = new JPanel();
		center.setBackground(Color.WHITE);
		center.setLayout(new BorderLayout());

		south = new JPanel();
		south.setLayout(new FlowLayout());
		south.setBackground(Color.WHITE);

	}

	public Object[] getInfoDelete() {
		Object[] data = new Object[10];
		data[0] = fruit.getSelectedItem();
		data[1] = idTown.getText();
		data[2] = gender.getSelectedItem();
		data[3] = ageOne.getValue();
		data[4] = ageTwo.getValue();
		data[5] = sisbenOne.getValue();
		data[6] = sisbenTwo.getValue();
		data[7] = beneficiaries.getText();
		data[8] = investment.getText();
		data[9] = hectare.getText();
		return data;
	}

	public void changeLanguage() {
		title.setText(HandlerLanguage.languageProperties.getProperty(Constants.TITLE_DELETE_CHAIN));
		titleFruit.setText(HandlerLanguage.languageProperties.getProperty(Constants.NAME));
		titleIdTown.setText(HandlerLanguage.languageProperties.getProperty(Constants.ID_TOWN));
		titleAgeGroup.setText(HandlerLanguage.languageProperties.getProperty(Constants.AGE_GROUP));
		titleSisbenScore.setText(HandlerLanguage.languageProperties.getProperty(Constants.SISBEN_SCORE));
		titleGender.setText(HandlerLanguage.languageProperties.getProperty(Constants.GENDER));
		titleBeneficiaries.setText(HandlerLanguage.languageProperties.getProperty(Constants.BENEFICIARIES));
		titleInvestment.setText(HandlerLanguage.languageProperties.getProperty(Constants.INVESTMENT));
		titleHectare.setText(HandlerLanguage.languageProperties.getProperty(Constants.HECTARE));
		notice.setText(HandlerLanguage.languageProperties.getProperty(Constants.NOTICE_DELETE_FILE));
		table.changeLenguage();
	}

	public void setNewTable(Object[][] newFruitData) {
		table.setNewTable(newFruitData);
		
	}

	public void setVisibleDelete() {
		south.setVisible(true);
		
	}

}
