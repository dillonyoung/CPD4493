package ca.dillonyoung.tracare;

public class Entries {

	private int id;
	private long dateentered;
	private float location;
	private float weight;
	private float hours_sleep;
	private float energy_level;
	private float quality_of_sleep;
	private String fitness;
	private String nutrition;
	private float symptom;
	private String symptom_description;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getDateEntered() {
		return dateentered;
	}
	public void setDateEntered(long dateentered) {
		this.dateentered = dateentered;
	}
	public float getLocation() {
		return location;
	}
	public void setLocation(float location) {
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
	public float getEnergyLevel() {
		return energy_level;
	}
	public void setEnergyLevel(float energy_level) {
		this.energy_level = energy_level;
	}
	public float getQualityOfSleep() {
		return quality_of_sleep;
	}
	public void setQualityOfSleep(float quality_of_sleep) {
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
	public float getSymptom() {
		return this.symptom;
	}
	public void setSymptom(float symptom) {
		this.symptom = symptom;
	}
	public String getSymptomDescription() {
		return symptom_description;
	}
	public void setSymptomDescription(String symptom_description) {
		this.symptom_description = symptom_description;
	}
	
	
}
