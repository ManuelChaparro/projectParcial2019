package models;

import java.util.ArrayList;

public class Chain {
	
	private ArrayList<Avocado> avocadosList;
	
	public Chain() {
		avocadosList = new ArrayList<Avocado>();
	}
	
	public void setList(Avocado avocado) {
		avocadosList.add(avocado);
	}
	
	public Object[][] toMatrixObject(){
		Object[][] allData = new Object[avocadosList.size()][10];
		for (int i = 0; i < avocadosList.size(); i++) {
			allData[i][0] = avocadosList.get(i).getIdDepartment();
			allData[i][1] = avocadosList.get(i).getDepartment();
			allData[i][2] = avocadosList.get(i).getIdTown();
			allData[i][3] = avocadosList.get(i).getTown();
			allData[i][4] = avocadosList.get(i).getSownArea();
			allData[i][5] = avocadosList.get(i).getHarvestedArea();
			allData[i][6] = avocadosList.get(i).getProduction();
			allData[i][7] = avocadosList.get(i).getPerformance();
			allData[i][8] = avocadosList.get(i).getPhysicalState();
			allData[i][9] = avocadosList.get(i).getPeriod();
		}
		return allData;
	}

	public int calculatePerformance(int[] data) {
		return data[1]/data[0];
	}
	
	public int getArrayListSize() {
		return avocadosList.size();
	}
	
	public ArrayList<Avocado> getAvocadosList() {
		return avocadosList;
	}

}
