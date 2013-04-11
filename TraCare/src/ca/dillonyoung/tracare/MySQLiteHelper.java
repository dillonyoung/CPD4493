package ca.dillonyoung.tracare;

/**
 * Filename: MySQLiteHelper.java
 * Author..: Dillon Young (C0005790)
 */

// Include required imports
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteHelper extends SQLiteOpenHelper {

	// Declare variables
	public static boolean firstRun = false;
	
	// Declare constants
	private static final String DATABASE_NAME = "tracare.db";
	private static final int DATABASE_VERSION = 7;
	
	
	/**
	 * The constructor for the MySQLiteHelper class
	 * @param context The context for the class
	 */
	public MySQLiteHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	
	/**
	 * The onCreate method for the MySQLiteHelper class
	 */
	@Override
	public void onCreate(SQLiteDatabase arg0) {
		// TODO Auto-generated method stub

		// Create the tables
		this.createTables(arg0);
	}

	
	/**
	 * The onUpgrade method for the MySQLiteHelper class
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

		// Drop the tables
		this.dropTables(db);
		
		// Create the tables
		this.createTables(db);
	}

	
	/**
	 * Creates the database tables
	 * @param database The reference to the SQLite database
	 */
	private void createTables(SQLiteDatabase database) {
		
		// Creates the preferences table
		String sqlQuery = "CREATE TABLE preferences (weight INT NOT NULL, sleep INT NOT NULL, energy_level INT NOT NULL, quality_of_sleep INT NOT NULL, fitness INT NOT NULL, nutrition INT NOT NULL, symptom INT NOT NULL)";
		database.execSQL(sqlQuery);
		
		// Creates the user details table
		sqlQuery = "CREATE TABLE user_details (name TEXT NOT NULL, gender INT NOT NULL, weight FLOAT NOT NULL)";
		database.execSQL(sqlQuery);
		
		// Creates the symptom types table
		sqlQuery = "CREATE TABLE symptom_types (id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT , symptom_description TEXT NOT NULL)";
		database.execSQL(sqlQuery);
		
		// Creates the locations table
		sqlQuery = "CREATE TABLE locations (id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, latitude FLOAT NOT NULL, longitude FLOAT NOT NULL)";
		database.execSQL(sqlQuery);
		
		// Creates the entries table
		sqlQuery = "CREATE TABLE entries (id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, dateentered LONG NOT NULL, location FLOAT NOT NULL, weight FLOAT, hours_sleep FLOAT, energy_level FLOAT, quality_of_sleep FLOAT, fitness TEXT, nutrition TEXT, symptom FLOAT, symptom_description TEXT)";
		database.execSQL(sqlQuery);
		
		// Insert a preference details
		sqlQuery = "INSERT INTO preferences (weight, sleep, energy_level, quality_of_sleep, fitness, nutrition, symptom) VALUES(1, 1, 1, 1, 1, 1, 1)";
		database.execSQL(sqlQuery);
		
		// Insert a default user details
		sqlQuery = "INSERT INTO user_details (name, gender, weight) VALUES('', 1, 0.0)";
		database.execSQL(sqlQuery);
		
		// Set that it is the first run
		firstRun = true;
	}
	
	
	/**
	 * Drop all of the tables from the database
	 * @param database The reference to the SQLite database
	 */
	private void dropTables(SQLiteDatabase database) {
		
		// Drop the preferences table
		String sqlQuery = "DROP TABLE IF EXISTS preferences";
		database.execSQL(sqlQuery);
		
		// Drop the user details table
		sqlQuery = "DROP TABLE IF EXISTS user_details";
		database.execSQL(sqlQuery);
		
		
		// Drop the symptom types table
		sqlQuery = "DROP TABLE IF EXISTS symptom_types";
		database.execSQL(sqlQuery);
		
		// Drop the locations table
		sqlQuery = "DROP TABLE IF EXISTS locations";
		database.execSQL(sqlQuery);
		
		// Drop the entries table
		sqlQuery = "DROP TABLE IF EXISTS entries";
		database.execSQL(sqlQuery);
	}
}
