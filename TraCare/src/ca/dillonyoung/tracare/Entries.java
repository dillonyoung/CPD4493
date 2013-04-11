package ca.dillonyoung.tracare;

/**
 * Filename: Entries.java
 * Author..: Dillon Young (C0005790)
 */

public class Entries {

	// Declare variables
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
	
	
	/**
	 * Get the ID for the entry
	 * @return Returns the ID for the entry
	 */
	public int getId() {
		return id;
	}
	
	
	/**
	 * Sets the ID for the entry
	 * @param id The value to be set to the entry ID
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	
	/**
	 * Gets the date entered for the entry
	 * @return Returns the date entered for the entry
	 */
	public long getDateEntered() {
		return dateentered;
	}
	
	
	/**
	 * Sets the date entered for the entry
	 * @param dateentered The value to be set to the entry date entered
	 */
	public void setDateEntered(long dateentered) {
		this.dateentered = dateentered;
	}
	
	
	/**
	 * Gets the location for the entry
	 * @return Returns the location for the entry
	 */
	public float getLocation() {
		return location;
	}
	
	
	/**
	 * Sets the location for the entry
	 * @param location The value to be set to the entry location
	 */
	public void setLocation(float location) {
		this.location = location;
	}
	
	
	/**
	 * Gets the weight for the entry
	 * @return Returns the weight for the entry
	 */
	public float getWeight() {
		return weight;
	}
	
	
	/**
	 * Sets the weight for the entry
	 * @param weight The value to be set to the entry weight
	 */
	public void setWeight(float weight) {
		this.weight = weight;
	}
	
	
	/**
	 * Gets the hours of sleep for the entry
	 * @return Returns the hours of sleep for the entry
	 */
	public float getHoursSleep() {
		return hours_sleep;
	}
	
	
	/**
	 * Sets the hours of sleep for the entry
	 * @param hours_sleep The value to be set to the entry hours of sleep
	 */
	public void setHoursSleep(float hours_sleep) {
		this.hours_sleep = hours_sleep;
	}
	
	
	/**
	 * Gets the energy level for the entry
	 * @return Returns the energy level for the entry
	 */
	public float getEnergyLevel() {
		return energy_level;
	}
	
	
	/**
	 * Sets the energy level for the entry
	 * @param energy_level The value to be set to the entry energy level
	 */
	public void setEnergyLevel(float energy_level) {
		this.energy_level = energy_level;
	}
	
	
	/**
	 * Gets the quality of sleep for the entry
	 * @return Returns the quality of sleep for the entry
	 */
	public float getQualityOfSleep() {
		return quality_of_sleep;
	}
	
	
	/**
	 * Sets the quality of sleep for the entry
	 * @param quality_of_sleep The value to be set to the entry quality of sleep
	 */
	public void setQualityOfSleep(float quality_of_sleep) {
		this.quality_of_sleep = quality_of_sleep;
	}
	
	
	/**
	 * Gets the fitness activity for the entry
	 * @return Returns the fitness activity for the entry
	 */
	public String getFitness() {
		return fitness;
	}
	
	
	/**
	 * Sets the fitness activity for the entry
	 * @param fitness The value to be set to entry fitness activity
	 */
	public void setFitness(String fitness) {
		this.fitness = fitness;
	}
	
	
	/**
	 * Gets the nutrition for the entry
	 * @return Returns the nutrition for the entry
	 */
	public String getNutrition() {
		return nutrition;
	}
	
	
	/**
	 * Sets the nutrition for the entry
	 * @param nutrition The value to be set to the entry nutrition
	 */
	public void setNutrition(String nutrition) {
		this.nutrition = nutrition;
	}
	
	
	/**
	 * Gets the symptom type for the entry
	 * @return Returns the symptom type for the entry
	 */
	public float getSymptom() {
		return this.symptom;
	}
	
	
	/**
	 * Sets the symptom type for the entry
	 * @param symptom The value to be set to the entry symptom type
	 */
	public void setSymptom(float symptom) {
		this.symptom = symptom;
	}
	
	
	/**
	 * Gets the symptom description for the entry
	 * @return Returns the symptom description for the entry
	 */
	public String getSymptomDescription() {
		return symptom_description;
	}
	
	
	/**
	 * Sets the symptom description for the entry
	 * @param symptom_description The value to be set to the entry symptom description
	 */
	public void setSymptomDescription(String symptom_description) {
		this.symptom_description = symptom_description;
	}
}
