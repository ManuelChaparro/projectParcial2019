package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

import controller.Commands;
import controller.Controller;
import handler.HandlerLanguage;

public class NewFileContainer extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Departments departaments;
	private Fruits fruits;
	private Gender gender;
	private PhysicalState physicalState;
	private JSpinner ageOne, ageTwo, sisbenOne, sisbenTwo;
	private SpinnerNumberModel ageOneModel, ageTwoModel, sisbenOneModel, sisbenTwoModel;
	private LabelObject toAge, toSisben, LName, LDepartaments, LIdTown, LTown, LAgeGroup, LSisbenScore, LGender, LBeneficiaries,
			LInvestment, LHectare;
	private TextFieldObject town, idTown, beneficiaries, investment, hectare;
	private PanelObject containerAgeGroup, containerSisbenScore;
	private ButtonObject accept, cancel;
	private PanelObject containerButtons;

	public NewFileContainer(Controller controller) {
		setPreferredSize(new Dimension(1000, 450));
		setLayout(new GridLayout(6, 4, 40, 20));
		setBackground(Constants.AQUA_COLOR);
		setBorder(new EmptyBorder(20, 20, 20, 20));
		departaments = new Departments(controller);
		fruits = new Fruits(controller);
		initComponents(controller);
	}

	private void initComponents(Controller controller) {

		// Components Name
		LName = new LabelObject(HandlerLanguage.languageProperties.getProperty(Constants.NAME), Color.WHITE,
				Color.WHITE, Constants.DEFAULT_FONT);
		add(LName);

		add(fruits);

		LDepartaments = new LabelObject(HandlerLanguage.languageProperties.getProperty(Constants.DEPARTMENT),
				Color.WHITE, Color.WHITE, Constants.DEFAULT_FONT);
		add(LDepartaments);

		add(departaments);

		LIdTown = new LabelObject(HandlerLanguage.languageProperties.getProperty(Constants.ID_TOWN), Color.WHITE,
				Color.WHITE, Constants.DEFAULT_FONT);
		add(LIdTown);

		idTown = new TextFieldObject();
		add(idTown);

		LTown = new LabelObject(HandlerLanguage.languageProperties.getProperty(Constants.TOWN), Color.WHITE,
				Color.WHITE, Constants.DEFAULT_FONT);
		add(LTown);

		town = new TextFieldObject();
		add(town);

		LGender = new LabelObject(HandlerLanguage.languageProperties.getProperty(Constants.GENDER), Color.WHITE,
				Color.WHITE, Constants.DEFAULT_FONT);
		add(LGender);

		gender = new Gender(controller);
		add(gender);

		LAgeGroup = new LabelObject(HandlerLanguage.languageProperties.getProperty(Constants.AGE_GROUP), Color.WHITE,
				Color.WHITE, Constants.DEFAULT_FONT);

		add(LAgeGroup);

		containerAgeGroup = new PanelObject(new FlowLayout(), Color.WHITE);
		containerAgeGroup.setBackground(Constants.AQUA_COLOR);
		ageOne = new JSpinner();
		ageOneModel = new SpinnerNumberModel();
		ageOneModel.setMinimum(15);
		ageOneModel.setMaximum(100);
		ageOneModel.setValue(25);
		ageOneModel.setStepSize(5);
		ageOne.setFont(Constants.DEFAULT_FONT);
		ageOne.setModel(ageOneModel);

		ageTwo = new JSpinner();
		ageTwoModel = new SpinnerNumberModel();
		ageTwoModel.setMinimum(19);
		ageTwoModel.setMaximum(100);
		ageTwoModel.setValue(29);
		ageTwoModel.setStepSize(5);
		ageTwo.setFont(Constants.DEFAULT_FONT);
		ageTwo.setModel(ageTwoModel);

		toAge = new LabelObject(HandlerLanguage.languageProperties.getProperty(Constants.TO), Color.WHITE, Color.WHITE,
				Constants.DEFAULT_FONT);

		containerAgeGroup.add(ageOne);
		containerAgeGroup.add(toAge);
		containerAgeGroup.add(ageTwo);

		add(containerAgeGroup);

		LBeneficiaries = new LabelObject(HandlerLanguage.languageProperties.getProperty(Constants.BENEFICIARIES),
				Color.WHITE, Color.WHITE, Constants.DEFAULT_FONT);

		add(LBeneficiaries);

		beneficiaries = new TextFieldObject();
		add(beneficiaries);

		LInvestment = new LabelObject(HandlerLanguage.languageProperties.getProperty(Constants.INVESTMENT), Color.WHITE,
				Color.WHITE, Constants.DEFAULT_FONT);
		add(LInvestment);

		investment = new TextFieldObject();
		add(investment);

		LHectare = new LabelObject(HandlerLanguage.languageProperties.getProperty(Constants.HECTARE), Color.WHITE,
				Color.WHITE, Constants.DEFAULT_FONT);
		add(LHectare);

		hectare = new TextFieldObject();
		add(hectare);
		
		LSisbenScore = new LabelObject(HandlerLanguage.languageProperties.getProperty(Constants.SISBEN_SCORE), Color.WHITE,
				Color.WHITE, Constants.DEFAULT_FONT);
		
		add(LSisbenScore);
		
		containerSisbenScore = new PanelObject(new FlowLayout(), Color.WHITE);
		containerSisbenScore.setBackground(Constants.AQUA_COLOR);
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

		add(containerSisbenScore);

		// Buttons accept and cancel
		Image imageAccept = new ImageIcon(getClass().getResource(Constants.PATH_ICON_ACCEPT)).getImage();
		Icon rescaledAccept = new ImageIcon(imageAccept.getScaledInstance((int) (Constants.WIDTH * 0.03),
				(int) (Constants.WIDTH * 0.03), Image.SCALE_SMOOTH));
		accept = new ButtonObject("", Color.WHITE, rescaledAccept, controller, Commands.ACCEPT_BUTTON_CHAIN.name(),
				Constants.DEFAULT_FONT);

		Image imageCancel = new ImageIcon(getClass().getResource(Constants.PATH_ICON_CANCEL)).getImage();
		Icon rescaledCancel = new ImageIcon(imageCancel.getScaledInstance((int) (Constants.WIDTH * 0.03),
				(int) (Constants.WIDTH * 0.03), Image.SCALE_SMOOTH));
		cancel = new ButtonObject("", Color.WHITE, rescaledCancel, controller, Commands.CANCEL_BUTTON_CHAIN.name(),
				Constants.DEFAULT_FONT);
		
		add(accept);
		
		add(cancel);
	}

	public void changeLanguage() {
		LName.setText(HandlerLanguage.languageProperties.getProperty(Constants.NAME));
		LDepartaments.setText(HandlerLanguage.languageProperties.getProperty(Constants.DEPARTMENT));
		LIdTown.setText(HandlerLanguage.languageProperties.getProperty(Constants.ID_TOWN));
		LTown.setText(HandlerLanguage.languageProperties.getProperty(Constants.TOWN));
		LGender.setText(HandlerLanguage.languageProperties.getProperty(Constants.GENDER));
		LAgeGroup.setText(HandlerLanguage.languageProperties.getProperty(Constants.AGE_GROUP));
		LSisbenScore.setText(HandlerLanguage.languageProperties.getProperty(Constants.SISBEN_SCORE));
		toAge.setText(HandlerLanguage.languageProperties.getProperty(Constants.TO));
		LBeneficiaries.setText(HandlerLanguage.languageProperties.getProperty(Constants.BENEFICIARIES));
		LInvestment.setText(HandlerLanguage.languageProperties.getProperty(Constants.INVESTMENT));
		LHectare.setText(HandlerLanguage.languageProperties.getProperty(Constants.HECTARE));
	}

	public Object[] getDataFruit() {
		String fruit = "";
		String department = "";
		int idTown = 0;
		String town = "";
		String gender = "";
		int ageOne = 0;
		int ageTwo = 0;
		int sisbenOne = 0;
		int sisbenTwo = 0;
		int beneficiaries = 0;
		double investment = 0;
		double hectare = 0;

		fruit = (String) fruits.getSelectedItem();
		department = (String) departaments.getSelectedItem();
		try {
			idTown = Integer.parseInt(this.idTown.getText());
			town = this.town.getText();
			gender = (String) this.gender.getSelectedItem();
			ageOne = (int) this.ageOne.getValue();
			ageTwo = (int) this.ageTwo.getValue();
			sisbenOne = (int) this.sisbenOne.getValue();
			sisbenTwo = (int) this.sisbenTwo.getValue();
			beneficiaries = Integer.parseInt(this.beneficiaries.getText());
			investment = Double.valueOf(this.investment.getText());
			hectare = Double.valueOf(this.hectare.getText());
		} catch (Exception e) {
			return new Object[] {};
		}
		return new Object[] { fruit, department, town, idTown, gender, ageOne, ageTwo, sisbenOne, sisbenTwo, beneficiaries, investment,
				hectare };
	}

	public void clearData() {
		idTown.setText("");
		town.setText("");
		beneficiaries.setText("");
		investment.setText("");
		hectare.setText("");
	}

}
