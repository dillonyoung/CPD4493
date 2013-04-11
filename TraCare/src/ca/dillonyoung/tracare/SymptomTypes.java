package ca.dillonyoung.tracare;

/**
 * Filename: SymptomTypes.java
 * Author..: Dillon Young (C0005790)
 */

public class SymptomTypes {

	// Declare variables
	private int id;
	private String description;
	
	
	/**
	 * Gets the symptom ID
	 * @return Returns the symptom ID
	 */
	public int getId() {
		return id;
	}
	
	
	/**
	 * Sets the symptom ID for the symptom type
	 * @param id The symptom ID to be set for the symptom type
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	
	/**
	 * Gets the description for the symptom type
	 * @return Returns the symptom type description
	 */
	public String getDescription() {
		return description;
	}
	
	
	/**
	 * Sets the description for the symptom type
	 * @param description The description to be set for the symptom type
	 */
	public void setDescription(String description) {
		this.description = description;
	}
}
