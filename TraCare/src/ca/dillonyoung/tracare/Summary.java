package ca.dillonyoung.tracare;

/**
 * Filename: Summary.java
 * Author..: Dillon Young (C0005790)
 */

public class Summary {

	// Declare variables
	private long startDate;
	private long endDate;
    private long lowestDate;
    private long highestDate;
    private float lowestWeight;
    private float highestWeight;
    private float averageWeight;
    private int count;
    
    /**
     * The constructor for the Summary class
     */
    public Summary() {
    	this.lowestWeight = Float.MAX_VALUE;
    	this.highestWeight = Float.MIN_VALUE;
    	this.count = 0;
    }
    

    /**
     * Get the summary start date
     * @return Returns the summary start date
     */
	public long getStartDate() {
		return startDate;
	}

	
	/**
	 * Sets the summary start date
	 * @param startDate The date to be set as the summary start date
	 */
	public void setStartDate(long startDate) {
		this.startDate = startDate;
	}

	
	/**
	 * Gets the summary end date
	 * @return Returns the summary end date
	 */
	public long getEndDate() {
		return endDate;
	}

	
	/**
	 * Sets the summary end date
	 * @param endDate The date to be set as the summary end date
	 */
	public void setEndDate(long endDate) {
		this.endDate = endDate;
	}
    
	
	/**
	 * Gets the date of the lowest weight value
	 * @return Returns the date of the lowest weight value
	 */
	public long getLowestDate() {
		return lowestDate;
	}

	
	/**
	 * Sets the date of the lowest weight value
	 * @param lowestDate The date to be set as the lowest weight date
	 */
	public void setLowestDate(long lowestDate) {
		this.lowestDate = lowestDate;
	}

	
	/**
	 * Gets the date of the highest weight value
	 * @return Returns the date of the highest weight value
	 */
	public long getHighestDate() {
		return highestDate;
	}

	
	/**
	 * Sets the date of the highest weight value
	 * @param highestDate The date to be set as the highest weight date
	 */
	public void setHighestDate(long highestDate) {
		this.highestDate = highestDate;
	}
    
	
	/**
	 * Gets the lowest weight value
	 * @return Returns the lowest weight value
	 */
	public float getLowestWeight() {
		return lowestWeight;
	}
	
	
	/**
	 * Sets the lowest weight value
	 * @param lowestWeight The value to be set as the lowest weight value
	 */
	public void setLowestWeight(float lowestWeight) {
		this.lowestWeight = lowestWeight;
	}
	
	
	/**
	 * Gets the highest weight value
	 * @return Returns the highest weight value
	 */
	public float getHighestWeight() {
		return highestWeight;
	}
	
	
	/**
	 * Sets the highest weight value
	 * @param highestWeight The value to be set as the highest weight value
	 */
	public void setHighestWeight(float highestWeight) {
		this.highestWeight = highestWeight;
	}
	
	
	/**
	 * Gets the average weight value
	 * @return Returns the average weight value
	 */
	public float getAverageWeight() {
		return averageWeight;
	}
	
	
	/**
	 * Sets the average weight value
	 * @param averageWeight The value to be set as the average weight value
	 */
	public void setAverageWeight(float averageWeight) {
		this.averageWeight = averageWeight;
	}

	
	/**
	 * Gets the count of entries processed
	 * @return Returns the count of entries processed
	 */
	public int getCount() {
		return count;
	}

	
	/**
	 * Sets the count of entries processed
	 * @param count The count of entries processed to be set
	 */
	public void setCount(int count) {
		this.count = count;
	}
}
