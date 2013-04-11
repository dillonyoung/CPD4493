package ca.dillonyoung.tracare;

/**
 * Filename: Preferences.java
 * Author..: Dillon Young (C0005790)
 */

public class Preferences {

	// Declare variables
	private boolean weight;
	private boolean sleep;
	private boolean energy_level;
	private boolean quality_of_sleep;
	private boolean fitness;
	private boolean nutrition;
	private boolean symptom;
	
	
	/**
	 * Get whether the weight entry is tracked
	 * @return Returns the weight value
	 */
	public boolean getWeight() {
		return weight;
	}
	
	
	/**
	 * Sets whether the weight entry is tracked
	 * @param weight The value to be set as the weight value
	 */
	public void setWeight(boolean weight) {
		this.weight = weight;
	}	
	
	
	/**
	 * Gets whether the sleep entry is tracked
	 * @return Returns the sleep value
	 */
	public boolean getSleep() {
		return sleep;
	}
	
	
	/**
	 * Sets whether the sleep entry is tracked
	 * @param sleep The value to be set as the sleep value
	 */
	public void setSleep(boolean sleep) {
		this.sleep = sleep;
	}
	
	
	/**
	 * Gets whether the energy level entry is tracked
	 * @return Returns the energy level value
	 */
	public boolean getEnergyLevel() {
		return energy_level;
	}
	
	
	/**
	 * Sets whether the energy level is tracked
	 * @param energy_level The value to be set as the energy level value
	 */
	public void setEnergyLevel(boolean energy_level) {
		this.energy_level = energy_level;
	}
	
	
	/**
	 * Gets whether the quality of sleep entry is tracked
	 * @return Returns the quality of sleep value
	 */
	public boolean getQualityOfSleep() {
		return quality_of_sleep;
	}
	
	
	/**
	 * Sets whether the quality of sleep entry is tracked
	 * @param quality_of_sleep The value to be set as the quality of sleep value
	 */
	public void setQualityOfSleep(boolean quality_of_sleep) {
		this.quality_of_sleep = quality_of_sleep;
	}
	
	
	/**
	 * Gets whether the fitness activity entry is tracked
	 * @return Returns the current fitness value
	 */
	public boolean getFitness() {
		return fitness;
	}
	
	
	/**
	 * Sets whether the fitness activity entry is tracked
	 * @param fitness The value to be set as the fitness activity value
	 */
	public void setFitness(boolean fitness) {
		this.fitness = fitness;
	}
	
	
	/**
	 * Gets whether the nutrition entry is tracked
	 * @return Returns the current nutrition value
	 */
	public boolean getNutrition() {
		return nutrition;
	}
	
	
	/**
	 * Sets whether the nutrition entry is tracked
	 * @param nutrition The value to be set as the nutrition value
	 */
	public void setNutrition(boolean nutrition) {
		this.nutrition = nutrition;
	}
	
	
	/**
	 * Gets whether the symptom entry is tracked
	 * @return Returns the current symptom value
	 */
	public boolean getSymptom() {
		return symptom;
	}
	
	
	/**
	 * Sets whether the symptom entry is tracked
	 * @param symptom The value to be set as the symptom value
	 */
	public void setSymptom(boolean symptom) {
		this.symptom = symptom;
	}
}
