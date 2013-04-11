package ca.dillonyoung.tracare;

/**
 * Filename: EntriesDataSource.java
 * Author..: Dillon Young (C0005790)
 */

// Include required imports
import java.util.ArrayList;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class EntriesDataSource {

	// Declare references
	private SQLiteDatabase database;
	private MySQLiteHelper dbHelper;
	
	// Declare variables
	private String[] allColumns = { "id", "dateentered", "location", "weight", "hours_sleep", "energy_level", "quality_of_sleep", "fitness", "nutrition", "symptom", "symptom_description" };
	
	
	/**
	 * The constructor for the EntriesDataSource class
	 * @param context The context for the class
	 */
	public EntriesDataSource(Context context) {
		this.dbHelper = new MySQLiteHelper(context);
	}
	
	
	/**
	 * Opens the database connection
	 * @throws SQLException
	 */
	public void open() throws SQLException {
		this.database = this.dbHelper.getWritableDatabase();
	}
	
	
	/**
	 * Closes the database connection
	 */
	public void close() {
		this.dbHelper.close();
	}
	
	
	/**
	 * Gets the list of entries from the database
	 * @return Returns the list of entries from the database
	 */
	public ArrayList<Entries> getEntries() {
		
		// Declare a new array of the entries class
		ArrayList<Entries> entries = new ArrayList<Entries>();
		
		// Create a query for the database
		Cursor cursor = database.query("entries", allColumns, null, null, null, null, null);
		
		// Read the entries from the database
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			
			// Store the entry data in a temporary entries instance
			Entries entry = new Entries();
			entry.setId(cursor.getInt(0));
			entry.setDateEntered(cursor.getLong(1));
			entry.setLocation(cursor.getInt(2));
			entry.setWeight(cursor.getFloat(3));
			entry.setHoursSleep(cursor.getFloat(4));
			entry.setEnergyLevel(cursor.getInt(5));
			entry.setQualityOfSleep(cursor.getInt(6));
			entry.setFitness(cursor.getString(7));
			entry.setNutrition(cursor.getString(8));
			entry.setSymptom(cursor.getInt(9));
			entry.setSymptomDescription(cursor.getString(10));
			
			// Add the temporary entries instance to the array
			entries.add(entry);
			cursor.moveToNext();
		}
		cursor.close();

		// Return the entries
		return entries;
	}
	
	
	/**
	 * Adds a new entry to the database
	 * @param entry The object containing the entry details
	 * @return Returns the result status
	 */
	public long addEntry(Entries entry) {
		
		// Declare variables
		ContentValues values = new ContentValues();
		
		// Update the values with the values from the supplied object
		values.put("dateentered", entry.getDateEntered());
		values.put("location", entry.getLocation());
		values.put("weight", entry.getWeight());
		values.put("hours_sleep", entry.getHoursSleep());
		values.put("energy_level", entry.getEnergyLevel());
		values.put("quality_of_sleep", entry.getQualityOfSleep());
		values.put("fitness", entry.getFitness());
		values.put("nutrition", entry.getNutrition());
		values.put("symptom", entry.getSymptom());
		values.put("symptom_description", entry.getSymptomDescription());
		
		// Insert the new entry into the database
		long insertId = database.insert("entries", null, values);
		
		// Return the result
		return insertId;
	}
	
	
	/**
	 * Deletes an entry from the database
	 * @param id The id for the entry to be deleted
	 */
	public void deleteEntry(float id) {
		
		// Attempt to delete the entry from the database
		database.delete("entries", "id=" + id, null);
	}
}
