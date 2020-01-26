package models;

public class Fruit {

	private String name;
	private String department;
	private String town;
	private int idTown;
	private String gender;
	private String ageGroup;
	private int beneficiaries;
	private double investment;
	private double hectare;

	public Fruit(String name, String department, String town, int idTown, String gender, String ageGroup,
			int beneficiaries, double investment, double hectare) {
		this.name = name;
		this.department = department;
		this.town = town;
		this.idTown = idTown;
		this.gender = gender;
		this.ageGroup = ageGroup;
		this.beneficiaries = beneficiaries;
		this.investment = investment;
		this.hectare = hectare;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public int getIdTown() {
		return idTown;
	}

	public void setIdTown(int idTown) {
		this.idTown = idTown;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAgeGroup() {
		return ageGroup;
	}

	public void setAgeGroup(String ageGroup) {
		this.ageGroup = ageGroup;
	}

	public int getBeneficiaries() {
		return beneficiaries;
	}

	public void setBeneficiaries(int beneficiaries) {
		this.beneficiaries = beneficiaries;
	}

	public double getInvestment() {
		return investment;
	}

	public void setInvestment(double investment) {
		this.investment = investment;
	}

	public double getHectare() {
		return hectare;
	}

	public void setHectare(double hectare) {
		this.hectare = hectare;
	}

	public Object[] toObjectVector(Fruit fruit) {
		return new Object[] { fruit.getName(), fruit.getDepartment(),fruit.getTown(), fruit.getIdTown(),
				fruit.getGender(), fruit.getAgeGroup(), fruit.getBeneficiaries(), fruit.getInvestment(),
				fruit.getHectare()};
	}

}
