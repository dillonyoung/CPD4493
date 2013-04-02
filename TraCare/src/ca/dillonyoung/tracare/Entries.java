package ca.dillonyoung.tracare;

public class Entries {

	private int id;
	private int dateentered;
	private int location;
	private float weight;
	private float hours_sleep;
	private int energy_level;
	private int quality_of_sleep;
	private String fitness;
	private String nutrition;
	private int symptom;
	private String symptom_description;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDateEntered() {
		return dateentered;
	}
	public void setDateEntered(int dateentered) {
		this.dateentered = dateentered;
	}
	public int getLocation() {
		return location;
	}
	public void setLocation(int location) {
		this.location = location;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public float getHoursSleep() {
		return hours_sleep;
	}
	public void setHoursSleep(float hours_sleep) {
		this.hours_sleep = hours_sleep;
	}
	public int getEnergyLevel() {
		return energy_level;
	}
	public void setEnergyLevel(int energy_level) {
		this.energy_level = energy_level;
	}
	public int getQualityOfSleep() {
		return quality_of_sleep;
	}
	public void setQualityOfSleep(int quality_of_sleep) {
		this.quality_of_sleep = quality_of_sleep;
	}
	public String getFitness() {
		return fitness;
	}
	public void setFitness(String fitness) {
		this.fitness = fitness;
	}
	public String getNutrition() {
		return nutrition;
	}
	public void setNutrition(String nutrition) {
		this.nutrition = nutrition;
	}
	public int getSymptom() {
		return symptom;
	}
	public void setSymptom(int symptom) {
		this.symptom = symptom;
	}
	public String getSymptomDescription() {
		return symptom_description;
	}
	public void setSymptomDescription(String symptom_description) {
		this.symptom_description = symptom_description;
	}
	
	
}
