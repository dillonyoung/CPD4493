package ca.dillonyoung.tracare;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteHelper extends SQLiteOpenHelper {

	private static final String DATABASE_NAME = "tracare.db";
	private static final int DATABASE_VERSION = 1;
	
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
		String sqlQuery = "CREATE TABLE preferences (weight INT NOT NULL, sleep INT NOT NULL, energy_level INT NOT NULL, quality_of_sleep INT NOT NULL, fitness INT NOT NULL, nutrition INT NOT NULL, symptom INT NOT NULL, default_unit INT NOT NULL)";
		database.execSQL(sqlQuery);
		
		sqlQuery = "CREATE TABLE symptom_types (id INT NOT NULL, PRIMARY KEY (id), description VARCHAR(200) NOT NULL)";
		database.execSQL(sqlQuery);
		
		sqlQuery = "CREATE TABLE locations (id INT NOT NULL, PRIMARY KEY (id), latitude FLOAT NOT NULL, longitude FLOAT NOT NULL)";
		database.execSQL(sqlQuery);
		
		sqlQuery = "CREATE TABLE entries (id INT NOT NULL, PRIMARY KEY (id), dateentered DATETIME NOT NULL DEFAULT NOW(''), location INT NOT NULL, weight FLOAT, hours_sleep FLOAT, energy_level INT, quality_of_sleep INT, fitness VARCHAR(MAX), nutrition VARCHAR(MAX), symptom INT, symptom_description VARCHAR(MAX))";
		database.execSQL(sqlQuery);
	}
	
	private void dropTables(SQLiteDatabase database) {
		String sqlQuery = "DROP TABLE IF EXISTS preferences";
		database.execSQL(sqlQuery);
		
		sqlQuery = "DROP TABLE IF EXISTS symptom_types";
		database.execSQL(sqlQuery);
		
		sqlQuery = "DROP TABLE IF EXISTS locations";
		database.execSQL(sqlQuery);
		
		sqlQuery = "DROP TABLE IF EXISTS entries";
		database.execSQL(sqlQuery);
	}
}