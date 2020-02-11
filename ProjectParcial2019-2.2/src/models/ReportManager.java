package models;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;

public class ReportManager {
	
	ArrayList<Fruit> localList;
	
	public ArrayList<Fruit> getList(){
		return localList;
	}

	public ReportManager(ArrayList<Fruit> fruitList) {
		for (int i = 0; i <= fruitList.size(); i++) {
			fruitList.sort(new Comparator<Fruit>() {
				public int compare(Fruit o1, Fruit o2) {
					return o1.getDepartment().compareTo(o2.getDepartment());
				}

			});
		}
		localList = fruitList;
	}

	public String[][] generateReportOfHectaresPerDepartament(String departament) {
		ArrayList<Fruit> fruitsPerDepartament = agroupFruitsByDepartament(departament);
		ArrayList<Fruit> fruitsBytown = agroupFruitsByTown(fruitsPerDepartament);
		String[][] hectaresPerDepartament = new String[fruitsBytown.size()][2];
		for (int i = 0; i < hectaresPerDepartament.length; i++) {
			hectaresPerDepartament[i][0] = fruitsBytown.get(i).getTown();
			hectaresPerDepartament[i][1] = "" + fruitsBytown.get(i).getHectare();
		}
		return hectaresPerDepartament;
	}

	public String[][] generateReportOfInvestmentPerDepartament(String departament) {
		ArrayList<Fruit> fruitsPerDepartament = agroupFruitsByDepartament(departament);
		ArrayList<Fruit> fruitsBytown = agroupFruitsByTown(fruitsPerDepartament);
		String[][] investmentPerDepartament = new String[fruitsBytown.size()][2];
		for (int i = 0; i < investmentPerDepartament.length; i++) {
			investmentPerDepartament[i][0] = fruitsBytown.get(i).getTown();
			investmentPerDepartament[i][1] = "" + fruitsBytown.get(i).getInvestment();
		}
		return investmentPerDepartament;
	}

	public String[][] generateReportOfBeneficiariesPerDepartament(String departament) {
		ArrayList<Fruit> fruitsPerDepartament = agroupFruitsByDepartament(departament);
		ArrayList<Fruit> fruitsBytown = agroupFruitsByTown(fruitsPerDepartament);
		String[][] beneficiariesPerDepartament = new String[fruitsBytown.size()][2];
		for (int i = 0; i < beneficiariesPerDepartament.length; i++) {
			beneficiariesPerDepartament[i][0] = fruitsBytown.get(i).getTown();
			beneficiariesPerDepartament[i][1] = "" + fruitsBytown.get(i).getBeneficiaries();
		}
		return beneficiariesPerDepartament;
	}

	public String[][] generateReportOfAetaricPerDepartament(String departament) {
		ArrayList<Fruit> fruitsPerDepartament = agroupFruitsByDepartament(departament);
		ArrayList<Fruit> fruitsBytown = agroupFruitsByTown(fruitsPerDepartament);
		String[][] aetaricPerDepartament = new String[fruitsBytown.size()][2];
		for (int i = 0; i < aetaricPerDepartament.length; i++) {
			aetaricPerDepartament[i][0] = fruitsBytown.get(i).getTown();
			aetaricPerDepartament[i][1] = fruitsBytown.get(i).getAgeGroup();
		}
		return aetaricPerDepartament;
	}

	public String[][] generateReportOfGenderPerDepartament(String departament) {
		ArrayList<Fruit> fruitsPerDepartament = agroupFruitsByDepartament(departament);
		ArrayList<Fruit> fruitsBytown = agroupFruitsByTown(fruitsPerDepartament);
		String[][] genderPerDepartament = new String[fruitsBytown.size()][2];
		for (int i = 0; i < genderPerDepartament.length; i++) {
			genderPerDepartament[i][0] = fruitsBytown.get(i).getTown();
			genderPerDepartament[i][1] = fruitsBytown.get(i).getGender();
		}
		return genderPerDepartament;
	}

	public String[][] generateReportOfNationalHectares() {
		ArrayList<Fruit> fruitsByDepartament = crateFruitsByDepartamentArray(localList);
		String[][] hectaresPerDepartament = new String[fruitsByDepartament.size()][2];
		for (int i = 0; i < hectaresPerDepartament.length; i++) {
			hectaresPerDepartament[i][0] = fruitsByDepartament.get(i).getDepartment();
			hectaresPerDepartament[i][1] = "" + fruitsByDepartament.get(i).getHectare();
		}
		return hectaresPerDepartament;
	}

	public String[][] generateReportOfNationalInvestment() {
		ArrayList<Fruit> fruitsByDepartament = crateFruitsByDepartamentArray(localList);
		String[][] investmentPerDepartament = new String[fruitsByDepartament.size()][2];
		for (int i = 0; i < investmentPerDepartament.length; i++) {
			investmentPerDepartament[i][0] = fruitsByDepartament.get(i).getDepartment();
			investmentPerDepartament[i][1] = "" + fruitsByDepartament.get(i).getInvestment();
		}
		return investmentPerDepartament;
	}

	public String[][] generateReportOfNationalBeneficiaries() {
		ArrayList<Fruit> fruitsByDepartament = crateFruitsByDepartamentArray(localList);
		String[][] beneficiariesPerDepartament = new String[fruitsByDepartament.size()][2];
		for (int i = 0; i < beneficiariesPerDepartament.length; i++) {
			beneficiariesPerDepartament[i][0] = fruitsByDepartament.get(i).getDepartment();
			beneficiariesPerDepartament[i][1] = "" + fruitsByDepartament.get(i).getBeneficiaries();
		}
		return beneficiariesPerDepartament;
	}

	public String[][] generateReportOfNationalAetaric() {
		ArrayList<Fruit> fruitsByDepartament = crateFruitsByDepartamentArray(localList);
		String[][] aetaricPerDepartament = new String[fruitsByDepartament.size()][2];
		for (int i = 0; i < aetaricPerDepartament.length; i++) {
			aetaricPerDepartament[i][0] = fruitsByDepartament.get(i).getDepartment();
			aetaricPerDepartament[i][1] = "" + fruitsByDepartament.get(i).getAgeGroup();
		}
		return aetaricPerDepartament;
	}

	public String[][] generateReportOfNationalGender() {
		ArrayList<Fruit> fruitsByDepartament = crateFruitsByDepartamentArray(localList);
		String[][] genderPerDepartament = new String[fruitsByDepartament.size()][2];
		for (int i = 0; i < genderPerDepartament.length; i++) {
			genderPerDepartament[i][0] = fruitsByDepartament.get(i).getDepartment();
			genderPerDepartament[i][1] = fruitsByDepartament.get(i).getGender();
		}
		return genderPerDepartament;
	}

	private ArrayList<Fruit> agroupFruitsByDepartament(String departament) {
		ArrayList<Fruit> fruitsPerDepartament = new ArrayList<Fruit>();
		ArrayList<String> departamentList = new ArrayList<String>();
		for (Fruit fruit : localList) {
			if (isUniqueInList(departamentList,fruit.getDepartment())) {
				departamentList.add(fruit.getDepartment());
			}
			if (fruit.getDepartment().equals(departament)) {
				fruitsPerDepartament.add(fruit);
			}
		}
		return fruitsPerDepartament;
	}
	private boolean isUniqueInList(ArrayList<String> departamentsList, String departament) {
		boolean isInList = true;
		for (String string : departamentsList) {
			if (string.equals(departament)) {
				isInList = false;
			}
		}
		return isInList;
	}

	public ArrayList<Fruit> agroupFruitsByTown(ArrayList<Fruit> generalFruitList) {

		ArrayList<Fruit> fruitsByTown = new ArrayList<Fruit>();
		String town = generalFruitList.get(0).getTown();
		int idTown = generalFruitList.get(0).getIdTown();
		double hectare = 0;
		int beneficiaries = 0;
		double investment = 0;
		int aetaricCounter25to29 = 0;
		int aetaricCounter30to34 = 0;
		int aetaricCounter35to39 = 0;
		int aetaricCounter40to44 = 0;
		int aetaricCounter45to49 = 0;
		int aetaricCounter50to54 = 0;
		int aetaricCounter55to59 = 0;
		int aetaricCounter60to64 = 0;
		int aetaricCounter65to69 = 0;
		int aetaricCounter70to74 = 0;
		int aetaricCounter75to79 = 0;
		int aetaricCounter80ymas = 0;
		int womanGroups = 0;
		int menGroups = 0;
		for (Fruit fruit : generalFruitList) {	
			if (fruit.getTown().equals(town)) {
				hectare += fruit.getHectare();
				beneficiaries += fruit.getBeneficiaries();
				investment += fruit.getInvestment();
				if (fruit.getAgeGroup().equals("25 A 29")) {
					aetaricCounter25to29++;
				}
				if (fruit.getAgeGroup().equals("30 A 34")) {
					aetaricCounter30to34++;
				}
				if (fruit.getAgeGroup().equals("35 A 39")) {
					aetaricCounter35to39++;
				}
				if (fruit.getAgeGroup().equals("40 A 44")) {
					aetaricCounter40to44++;
				}
				if (fruit.getAgeGroup().equals("45 A 49")) {
					aetaricCounter45to49++;
				}
				if (fruit.getAgeGroup().equals("50 A 54")) {
					aetaricCounter50to54++;
				}
				if (fruit.getAgeGroup().equals("55 A 59")) {
					aetaricCounter55to59++;
				}
				if (fruit.getAgeGroup().equals("60 A 64")) {
					aetaricCounter60to64++;
				}
				if (fruit.getAgeGroup().equals("65 A 69")) {
					aetaricCounter65to69++;
				}
				if (fruit.getAgeGroup().equals("70 A 74")) {
					aetaricCounter70to74++;
				}
				if (fruit.getAgeGroup().equals("75 A 79")) {
					aetaricCounter75to79++;
				}
				if (fruit.getAgeGroup().equals("80 Y MÁS")) {
					aetaricCounter80ymas++;
				}
				if (fruit.getGender().contentEquals("MUJER")) {
					womanGroups++;
				}
				if (fruit.getGender().contentEquals("HOMBRE")) {
					menGroups++;
				}
			} else {
				@SuppressWarnings("unused")
				String gender = getMaxGender(womanGroups, menGroups);
				@SuppressWarnings("unused")
				String agegroup = getMaxAge(aetaricCounter25to29, aetaricCounter30to34, aetaricCounter35to39,
						aetaricCounter40to44, aetaricCounter45to49, aetaricCounter50to54, aetaricCounter55to59,
						aetaricCounter60to64, aetaricCounter65to69, aetaricCounter70to74, aetaricCounter75to79,
						aetaricCounter80ymas);
				town = fruit.getTown();
				hectare = fruit.getHectare();
				beneficiaries = fruit.getBeneficiaries();
				investment = fruit.getInvestment();
				idTown = fruit.getIdTown();
				Fruit fruitAux= new Fruit(fruit.getName(), fruit.getDepartment(), town, idTown, fruit.getGender(), fruit.getAgeGroup(),
						beneficiaries, investment, hectare);
				fruitsByTown.add(fruitAux);
				aetaricCounter25to29 = 0;
				aetaricCounter30to34 = 0;
				aetaricCounter35to39 = 0;
				aetaricCounter40to44 = 0;
				aetaricCounter45to49 = 0;
				aetaricCounter50to54 = 0;
				aetaricCounter55to59 = 0;
				aetaricCounter60to64 = 0;
				aetaricCounter65to69 = 0;
				aetaricCounter70to74 = 0;
				aetaricCounter75to79 = 0;
				aetaricCounter80ymas = 0;
				womanGroups = 0;
				menGroups = 0;
			}
		}
		return fruitsByTown;
	}
	


	public ArrayList<Fruit> crateFruitsByDepartamentArray(ArrayList<Fruit> generalFruitList) {
		ArrayList<Fruit> fruitsByTown = new ArrayList<Fruit>();
		String departament = generalFruitList.get(0).getDepartment();
		String town = generalFruitList.get(0).getTown();
		int idTown = generalFruitList.get(0).getIdTown();
		double hectare = 0;
		int beneficiaries = 0;
		double investment = 0;
		int aetaricCounter25to29 = 0;
		int aetaricCounter30to34 = 0;
		int aetaricCounter35to39 = 0;
		int aetaricCounter40to44 = 0;
		int aetaricCounter45to49 = 0;
		int aetaricCounter50to54 = 0;
		int aetaricCounter55to59 = 0;
		int aetaricCounter60to64 = 0;
		int aetaricCounter65to69 = 0;
		int aetaricCounter70to74 = 0;
		int aetaricCounter75to79 = 0;
		int aetaricCounter80ymas = 0;
		int womanGroups = 0;
		int menGroups = 0;
		for (Fruit fruit : generalFruitList) {
			if (fruit.getDepartment().equals(departament)) {
				hectare += fruit.getHectare();
				beneficiaries += fruit.getBeneficiaries();
				investment += fruit.getInvestment();
				if (fruit.getAgeGroup().equals("25 A 29")) {
					aetaricCounter25to29++;
				}
				if (fruit.getAgeGroup().equals("30 A 34")) {
					aetaricCounter30to34++;
				}
				if (fruit.getAgeGroup().equals("35 A 39")) {
					aetaricCounter35to39++;
				}
				if (fruit.getAgeGroup().equals("40 A 44")) {
					aetaricCounter40to44++;
				}
				if (fruit.getAgeGroup().equals("45 A 49")) {
					aetaricCounter45to49++;
				}
				if (fruit.getAgeGroup().equals("50 A 54")) {
					aetaricCounter50to54++;
				}
				if (fruit.getAgeGroup().equals("55 A 59")) {
					aetaricCounter55to59++;
				}
				if (fruit.getAgeGroup().equals("60 A 64")) {
					aetaricCounter60to64++;
				}
				if (fruit.getAgeGroup().equals("65 A 69")) {
					aetaricCounter65to69++;
				}
				if (fruit.getAgeGroup().equals("70 A 74")) {
					aetaricCounter70to74++;
				}
				if (fruit.getAgeGroup().equals("75 A 79")) {
					aetaricCounter75to79++;
				}
				if (fruit.getAgeGroup().equals("80 Y MÁS")) {
					aetaricCounter80ymas++;
				}
				if (fruit.getGender().contentEquals("MUJER")) {
					womanGroups++;
				}
				if (fruit.getGender().contentEquals("HOMBRE")) {
					menGroups++;
				}
			} else {
				String gender = getMaxGender(womanGroups, menGroups);
				String agegroup = getMaxAge(aetaricCounter25to29, aetaricCounter30to34, aetaricCounter35to39,
						aetaricCounter40to44, aetaricCounter45to49, aetaricCounter50to54, aetaricCounter55to59,
						aetaricCounter60to64, aetaricCounter65to69, aetaricCounter70to74, aetaricCounter75to79,
						aetaricCounter80ymas);
				fruitsByTown.add(new Fruit("total de frutas", departament, town, idTown, gender, agegroup,
						beneficiaries, investment, hectare));
				hectare = fruit.getHectare();
				beneficiaries = fruit.getBeneficiaries();
				investment = fruit.getInvestment();
				town = fruit.getTown();
				idTown = fruit.getIdTown();
				departament = fruit.getDepartment();
				aetaricCounter25to29 = 0;
				aetaricCounter30to34 = 0;
				aetaricCounter35to39 = 0;
				aetaricCounter40to44 = 0;
				aetaricCounter45to49 = 0;
				aetaricCounter50to54 = 0;
				aetaricCounter55to59 = 0;
				aetaricCounter60to64 = 0;
				aetaricCounter65to69 = 0;
				aetaricCounter70to74 = 0;
				aetaricCounter75to79 = 0;
				aetaricCounter80ymas = 0;
				womanGroups = 0;
				menGroups = 0;
			}
		}
		return fruitsByTown;
	}

	private String getMaxGender(int womansGroup, int mensGroup) {
		String result = "";
		if (womansGroup >= mensGroup)
			result = "MUJERES";
		if(womansGroup < mensGroup)
			result = "HOMBRES";
		
		return result;
	}

	private String getMaxAge(int age1, int age2, int age3, int age4, int age5, int age6, int age7, int age8, int age9,
			int age10, int age11, int age12) {
		String result = "";
		if (age1 > age2 || age1 > age3 || age1 > age4 || age1 > age5 || age1 > age6 || age1 > age7 || age1 > age8
				|| age1 > age9 || age1 > age10 || age1 > age11 || age1 > age12) {
			result = ("25 A 29");
		}
		if (age2 > age1 || age2 > age3 || age2 > age4 || age2 > age5 || age2 > age6 || age2 > age7 || age2 > age8
				|| age2 > age9 || age2 > age10 || age2 > age11 || age2 > age12) {
			result = ("30 A 34");
		}
		if (age3 > age2 || age3 > age1 || age3 > age4 || age3 > age5 || age3 > age6 || age3 > age7 || age3 > age8
				|| age3 > age9 || age3 > age10 || age3 > age11 || age3 > age12) {
			result = ("35 A 39");
		}
		if (age4 > age2 || age4 > age3 || age4 > age1 || age4 > age5 || age4 > age6 || age4 > age7 || age4 > age8
				|| age4 > age9 || age4 > age10 || age4 > age11 || age4 > age12) {
			result = ("40 A 44");
		}
		if (age5 > age2 || age5 > age3 || age5 > age4 || age5 > age1 || age5 > age6 || age5 > age7 || age5 > age8
				|| age5 > age9 || age5 > age10 || age5 > age11 || age5 > age12) {
			result = ("45 A 49");
		}
		if (age6 > age2 || age6 > age3 || age6 > age4 || age6 > age5 || age6 > age1 || age6 > age7 || age6 > age8
				|| age6 > age9 || age6 > age10 || age6 > age11 || age6 > age12) {
			result = ("50 A 54");
		}
		if (age7 > age2 || age7 > age3 || age7 > age4 || age7 > age5 || age7 > age6 || age7 > age1 || age7 > age8
				|| age7 > age9 || age7 > age10 || age7 > age11 || age7 > age12) {
			result = ("55 A 59");
		}
		if (age8 > age2 || age8 > age3 || age8 > age4 || age8 > age5 || age8 > age6 || age8 > age7 || age8 > age1
				|| age8 > age9 || age8 > age10 || age8 > age11 || age8 > age12) {
			result = ("60 A 64");
		}
		if (age9 > age2 || age9 > age3 || age9 > age4 || age9 > age5 || age9 > age6 || age9 > age7 || age9 > age8
				|| age9 > age1 || age9 > age10 || age9 > age11 || age9 > age12) {
			result = ("65 A 69");
		}
		if (age10 > age2 || age10 > age3 || age10 > age4 || age10 > age5 || age10 > age6 || age10 > age7 || age10 > age8
				|| age10 > age9 || age10 > age1 || age10 > age11 || age10 > age12) {
			result = ("70 A 74");
		}
		if (age11 > age2 || age11 > age3 || age11 > age4 || age11 > age5 || age11 > age6 || age11 > age7 || age11 > age8
				|| age11 > age9 || age11 > age10 || age11 > age1 || age11 > age12) {
			result = ("75 A 79");
		}
		if (age12 > age2 || age12 > age3 || age12 > age4 || age12 > age5 || age12 > age6 || age12 > age7 || age12 > age8
				|| age12 > age9 || age12 > age10 || age12 > age11 || age12 > age1) {
			result = ("80 Y MÁS");
		}
		return result;
	}

	public String[] generateVectorByMatrix(String[][] matrix, int pos) {
		String[] newVector = new String[matrix.length];
		for (int i = 0; i < matrix.length; i++) {
			newVector[i] = matrix[i][pos];
		}
		return newVector;
	}

	public String[] generateVectorHead(String[][] matrix) {
		return generateVectorByMatrix(matrix, 0);
	}

	public String[] generateVectorQueue(String[][] matrix) {
		return generateVectorByMatrix(matrix, 1);
	}
	
	public void setFruit(Fruit fruit) {
		localList.add(fruit);
	}

}
