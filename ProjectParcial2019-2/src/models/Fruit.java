package models;

public class Avocado {
	
	private int idDepartment;
	private String department;
	private int idTown;
	private String town;
	private int sownArea;
	private int harvestedArea;
	private int production;
	private double performance;
	private String physicalState;
	private int period;
	
	public Avocado(int idDepartment, String department, int idTown, String town,
			int sownArea, int harvestedArea, int production,
			double performance, String physicalState, int period) {
		
		this.idDepartment = idDepartment;
		this.department = department;
		this.idTown = idTown;
		this.town = town;
		this.sownArea = sownArea;
		this.harvestedArea = harvestedArea;
		this.production = production;
		this.performance = performance;
		this.physicalState = physicalState;
		this.period = period;
	}
	
	public void setIdDepartment(int idDepartment) {
		this.idDepartment = idDepartment;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	public void setIdTown(int idTown) {
		this.idTown = idTown;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public void setSwonArea(int sownArea) {
		this.sownArea = sownArea;
	}
	public void setHarvestedArea(int harvestedArea) {
		this.harvestedArea = harvestedArea;
	}
	public void setProduction(int production) {
		this.production = production;
	}
	public void setPerformance(int performance) {
		this.performance = performance;
	}
	public void setPhysicalState(String physicalState) {
		this.physicalState = physicalState;
	}
	public void setPeriod(int period) {
		this.period = period;
	}
	
	
	public int getIdDepartment() {
		return idDepartment;
	}
	public String getDepartment() {
		return department;
	}
	public int getIdTown() {
		return idTown;
	}
	public String getTown() {
		return town;
	}
	public int getSownArea() {
		return sownArea;
	}
	public int getHarvestedArea() {
		return harvestedArea;
	}
	public int getProduction() {
		return production;
	}
	public String getPhysicalState() {
		return physicalState;
	}
	public double getPerformance() {
		return performance;
	}
	public int getPeriod() {
		return period;
	}
	
	public Object[] toMatrixObject(Avocado avocado) {
		return new Object[] {avocado.getIdDepartment(), avocado.department,
				avocado.getIdTown(), avocado.getTown(), avocado.getSownArea(),
				avocado.getHarvestedArea(), avocado.getProduction(),
				avocado.getPerformance(), avocado.getPhysicalState(),
				avocado.getPeriod()};
	}

}
