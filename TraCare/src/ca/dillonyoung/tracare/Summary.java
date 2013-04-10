package ca.dillonyoung.tracare;

/**
 * Filename: Summary.java
 * Author..: Dillon Young (C0005790)
 */

public class Summary {

	private long startDate;
	private long endDate;
    private long lowestDate;
    private long highestDate;
    private float lowestWeight;
    private float highestWeight;
    private float averageWeight;
    private int count;
    
    public Summary() {
    	this.lowestWeight = Float.MAX_VALUE;
    	this.highestWeight = Float.MIN_VALUE;
    	this.count = 0;
    }
    

	public long getStartDate() {
		return startDate;
	}

	public void setStartDate(long startDate) {
		this.startDate = startDate;
	}

	public long getEndDate() {
		return endDate;
	}

	public void setEndDate(long endDate) {
		this.endDate = endDate;
	}
    
	public long getLowestDate() {
		return lowestDate;
	}

	public void setLowestDate(long lowestDate) {
		this.lowestDate = lowestDate;
	}

	public long getHighestDate() {
		return highestDate;
	}

	public void setHighestDate(long highestDate) {
		this.highestDate = highestDate;
	}
    
	public float getLowestWeight() {
		return lowestWeight;
	}
	public void setLowestWeight(float lowestWeight) {
		this.lowestWeight = lowestWeight;
	}
	public float getHighestWeight() {
		return highestWeight;
	}
	public void setHighestWeight(float highestWeight) {
		this.highestWeight = highestWeight;
	}
	public float getAverageWeight() {
		return averageWeight;
	}
	public void setAverageWeight(float averageWeight) {
		this.averageWeight = averageWeight;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}



    
}
