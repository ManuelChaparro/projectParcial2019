package models;

import java.util.ArrayList;

import views.Constants;

public class Chain {

	private ArrayList<Fruit> fruitsList;

	public Chain() {
		fruitsList = new ArrayList<Fruit>();
	}

	public void setList(Fruit fruit) {
		fruitsList.add(fruit);
	}

	public Object[][] toMatrixObjectList() {
		Object[][] allData = new Object[fruitsList.size()][9];
		for (int i = 0; i < fruitsList.size(); i++) {
			allData[i][0] = fruitsList.get(i).getName();
			allData[i][1] = fruitsList.get(i).getDepartment();
			allData[i][3] = fruitsList.get(i).getTown();
			allData[i][2] = fruitsList.get(i).getIdTown();
			allData[i][4] = fruitsList.get(i).getGender();
			allData[i][5] = fruitsList.get(i).getAgeGroup();
			allData[i][6] = fruitsList.get(i).getBeneficiaries();
			allData[i][8] = fruitsList.get(i).getInvestment();
			allData[i][7] = fruitsList.get(i).getHectare();
		}
		return allData;
	}

	public boolean validateObject(Object[] fruit) {
		@SuppressWarnings("unused")
		boolean verification;
		try {
			fruit[0] = null;
			String town = (String) fruit[2];
			for (char c : town.toCharArray()) {
				if (Character.isDigit(c) || !Character.isUpperCase(c)) {
					return verification = false;
				}
			}
			return verification = true;
		} catch (Exception e) {
			return verification = false;
		}
	}

	public int getArrayListSize() {
		return fruitsList.size();
	}

	public ArrayList<Fruit> getFruitsList() {
		return fruitsList;
	}

	public Object[][] getBlackberryList() {
		ArrayList<Fruit> blackberryList = new ArrayList<Fruit>();
		for (int i = 0; i < fruitsList.size(); i++) {
			if (fruitsList.get(i).getName().equalsIgnoreCase(Constants.BLACKBERRY)) {
				blackberryList.add(fruitsList.get(i));
			}
		}
		return toMatrixObject(blackberryList);
	}

	public Object[][] getStrawberryList() {
		ArrayList<Fruit> blackberryList = new ArrayList<Fruit>();
		for (int i = 0; i < fruitsList.size(); i++) {
			if (fruitsList.get(i).getName().equalsIgnoreCase(Constants.STRAWBERRY)) {
				blackberryList.add(fruitsList.get(i));
			}
		}
		return toMatrixObject(blackberryList);
	}

	public Object[][] getBananaList() {
		ArrayList<Fruit> blackberryList = new ArrayList<Fruit>();
		for (int i = 0; i < fruitsList.size(); i++) {
			if (fruitsList.get(i).getName().equalsIgnoreCase(Constants.BANANA)) {
				blackberryList.add(fruitsList.get(i));
			}
		}
		return toMatrixObject(blackberryList);
	}

	public Object[][] getLuloList() {
		ArrayList<Fruit> blackberryList = new ArrayList<Fruit>();
		for (int i = 0; i < fruitsList.size(); i++) {
			if (fruitsList.get(i).getName().equalsIgnoreCase(Constants.LULO)) {
				blackberryList.add(fruitsList.get(i));
			}
		}
		return toMatrixObject(blackberryList);
	}

	public Object[][] getPassionFruitList() {
		ArrayList<Fruit> blackberryList = new ArrayList<Fruit>();
		for (int i = 0; i < fruitsList.size(); i++) {
			if (fruitsList.get(i).getName().equalsIgnoreCase(Constants.PASSION_FRUIT)) {
				blackberryList.add(fruitsList.get(i));
			}
		}
		return toMatrixObject(blackberryList);
	}

	public Object[][] getPeachList() {
		ArrayList<Fruit> blackberryList = new ArrayList<Fruit>();
		for (int i = 0; i < fruitsList.size(); i++) {
			if (fruitsList.get(i).getName().equalsIgnoreCase(Constants.PEACH)) {
				blackberryList.add(fruitsList.get(i));
			}
		}
		return toMatrixObject(blackberryList);
	}

	public Object[][] toMatrixObject(ArrayList<Fruit> fruitList) {
		Object[][] allData = new Object[fruitList.size()][10];
		for (int i = 0; i < fruitList.size(); i++) {
			allData[i][0] = fruitList.get(i).getName();
			allData[i][1] = fruitList.get(i).getDepartment();
			allData[i][3] = fruitList.get(i).getTown();
			allData[i][2] = fruitList.get(i).getIdTown();
			allData[i][4] = fruitList.get(i).getGender();
			allData[i][5] = fruitList.get(i).getAgeGroup();
			allData[i][6] = fruitList.get(i).getSisbenScore();
			allData[i][7] = fruitList.get(i).getBeneficiaries();
			allData[i][8] = fruitList.get(i).getInvestment();
			allData[i][9] = fruitList.get(i).getHectare();
		}
		return allData;
	}

	public void deleteFruit(int counter) {
		fruitsList.remove(counter);
	}

	public Object[][] getFruitListWithName(String fruitName) {
		Object[][] fruitList = null;
		if (fruitName.equalsIgnoreCase(Constants.BLACKBERRY)) {
			fruitList =  getBlackberryList();
		}else if (fruitName.equalsIgnoreCase(Constants.STRAWBERRY)) {
			fruitList =  getStrawberryList();
		}else if (fruitName.equalsIgnoreCase(Constants.BANANA)) {
			fruitList =  getBananaList();
		}else if (fruitName.equalsIgnoreCase(Constants.LULO)) {
			fruitList =  getLuloList();
		}else if (fruitName.equalsIgnoreCase(Constants.PEACH)) {
			fruitList =  getPeachList();
		}else if (fruitName.equalsIgnoreCase(Constants.PASSION_FRUIT)) {
			fruitList =  getPassionFruitList();
		}
		return fruitList;
	}

}
