package ca.dillonyoung.tracare;

/**
 * Filename: PreferencesDataSource.java
 * Author..: Dillon Young (C0005790)
 */

// Include required imports
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class PreferencesDataSource {

	// Declare references
	private SQLiteDatabase database;
	private MySQLiteHelper dbHelper;
	
	// Declare variables
	private String[] allColumns = { "weight", "sleep", "energy_level", "quality_of_sleep", "fitness", "nutrition", "symptom" };
	
	
	/**
	 * The constructor for the PreferencesDataSource class
	 * @param context The context for the class
	 */
	public PreferencesDataSource(Context context) {
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
	 * Reads the preferences data from the database
	 * @return Returns an object containing the preference data
	 */
	public Preferences readPreferences() {
		
		// Declare a new instance of the Preferences class
		Preferences preferences = new Preferences();
		
		// Create a query for the database
		Cursor cursor = database.query("preferences", allColumns, null, null, null, null, null);
		
		// Read the preferences from the database
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			preferences.setWeight((cursor.getInt(0) != 0));
			preferences.setSleep((cursor.getInt(1) != 0));
			preferences.setEnergyLevel((cursor.getInt(2) != 0));
			preferences.setQualityOfSleep((cursor.getInt(3) != 0));
			preferences.setFitness((cursor.getInt(4) != 0));
			preferences.setNutrition((cursor.getInt(5) != 0));
			preferences.setSymptom((cursor.getInt(6) != 0));
			cursor.moveToNext();
		}
		cursor.close();
		
		// Return the preferences
		return preferences;
	}
	
	
	/**
	 * Save the preferences to the database
	 * @param preferences The object containing the preferences
	 */
	public void savePreferences(Preferences preferences) {
		
		// Declare variables
		ContentValues values = new ContentValues();
		
		// Update the values with the values from the supplied object
		values.put("weight", preferences.getWeight());
		values.put("sleep", preferences.getSleep());
		values.put("energy_level", preferences.getEnergyLevel());
		values.put("quality_of_sleep", preferences.getQualityOfSleep());
		values.put("fitness", preferences.getFitness());
		values.put("nutrition", preferences.getNutrition());
		values.put("symptom", preferences.getSymptom());
		
		// Update the database
		database.update("preferences", values, null, null);
	}
}
