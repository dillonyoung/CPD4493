package ca.dillonyoung.tracare;

/**
 * Filename: UserDetails.java
 * Author..: Dillon Young (C0005790)
 */

public class UserDetails {

	// Declare variables
	private String name;
	private int gender;
	private float weight;
	
	
	/**
	 * Get the user's name
	 * @return Returns the user's name
	 */
	public String getName() {
		return name;
	}
	
	
	/**
	 * Sets the user's name
	 * @param name The name to be set for the user
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
	/**
	 * Get the user's gender
	 * @return Returns the user's gender
	 */
	public int getGender() {
		return gender;
	}
	
	
	/**
	 * Sets the user's gender
	 * @param gender The gender value to be set for the user
	 */
	public void setGender(int gender) {
		this.gender = gender;
	}
	
	
	/**
	 * Gets the user's weight
	 * @return Returns the users weight
	 */
	public float getWeight() {
		return weight;
	}
	
	
	/**
	 * Sets the user's weight
	 * @param weight The weight value to be set for the user
	 */
	public void setWeight(float weight) {
		this.weight = weight;
	}
}
