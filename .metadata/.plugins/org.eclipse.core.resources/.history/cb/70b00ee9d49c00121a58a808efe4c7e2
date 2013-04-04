package ca.dillonyoung.tracare;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteHelper extends SQLiteOpenHelper {

	private static final String DATABASE_NAME = "tracare.db";
	private static final int DATABASE_VERSION = 3;
	
	public MySQLiteHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	@Override
	public void onCreate(SQLiteDatabase arg0) {
		// TODO Auto-generated method stub

		this.createTables(arg0);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

		this.dropTables(db);
		this.createTables(db);
	}

	private void createTables(SQLiteDatabase database) {
		String sqlQuery = "CREATE TABLE preferences (weight INT NOT NULL, sleep INT NOT NULL, energy_level INT NOT NULL, quality_of_sleep INT NOT NULL, fitness INT NOT NULL, nutrition INT NOT NULL, symptom INT NOT NULL)";
		database.execSQL(sqlQuery);
		
		sqlQuery = "CREATE TABLE user_details (name TEXT NOT NULL, gender INT NOT NULL, weight FLOAT NOT NULL)";
		database.execSQL(sqlQuery);
		
		sqlQuery = "CREATE TABLE symptom_types (id INT NOT NULL PRIMARY KEY, symptom_description TEXT NOT NULL)";
		database.execSQL(sqlQuery);
		
		sqlQuery = "CREATE TABLE locations (id INT NOT NULL PRIMARY KEY, latitude FLOAT NOT NULL, longitude FLOAT NOT NULL)";
		database.execSQL(sqlQuery);
		
		sqlQuery = "CREATE TABLE entries (id INT NOT NULL PRIMARY KEY, dateentered DATETIME NOT NULL, location INT NOT NULL, weight FLOAT, hours_sleep FLOAT, energy_level INT, quality_of_sleep INT, fitness TEXT, nutrition TEXT, symptom INT, symptom_description TEXT)";
		database.execSQL(sqlQuery);
		
		sqlQuery = "INSERT INTO preferences (weight, sleep, energy_level, quality_of_sleep, fitness, nutrition, symptom) VALUES(1, 1, 1, 1, 1, 1, 1)";
		database.execSQL(sqlQuery);
		
		sqlQuery = "INSERT INTO user_details (name, gender, weight) VALUES('User', 1, 100.0)";
		database.execSQL(sqlQuery);
		
		Log.v("TraCare", "Creating");
	}
	
	private void dropTables(SQLiteDatabase database) {
		String sqlQuery = "DROP TABLE IF EXISTS preferences";
		database.execSQL(sqlQuery);
		
		sqlQuery = "DROP TABLE IF EXISTS user_details";
		database.execSQL(sqlQuery);
		
		sqlQuery = "DROP TABLE IF EXISTS symptom_types";
		database.execSQL(sqlQuery);
		
		sqlQuery = "DROP TABLE IF EXISTS locations";
		database.execSQL(sqlQuery);
		
		sqlQuery = "DROP TABLE IF EXISTS entries";
		database.execSQL(sqlQuery);
		Log.v("TraCare", "Dropping");
	}
}
