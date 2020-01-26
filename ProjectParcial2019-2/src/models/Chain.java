package models;

import java.util.ArrayList;

public class Chain {
	
	private ArrayList<Fruit> fruitsList;
	
	public Chain() {
		fruitsList = new ArrayList<Fruit>();
	}
	
	public void setList(Fruit fruit) {
		fruitsList.add(fruit);
	}
	
	public Object[][] toMatrixObject(){
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
	
	

	public int calculatePerformance(int[] data) {
		return data[8]/data[6];
	}
	
	public int getArrayListSize() {
		return fruitsList.size();
	}
	
	public ArrayList<Fruit> getFruitsList() {
		return fruitsList;
	}

}
