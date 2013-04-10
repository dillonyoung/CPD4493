package ca.dillonyoung.tracare;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class PreferencesDataSource {

	private SQLiteDatabase database;
	private MySQLiteHelper dbHelper;
	private String[] allColumns = { "weight", "sleep", "energy_level", "quality_of_sleep", "fitness", "nutrition", "symptom" };
	
	public PreferencesDataSource(Context context) {
		this.dbHelper = new MySQLiteHelper(context);
	}
	
	public void open() throws SQLException {
		this.database = this.dbHelper.getWritableDatabase();
	}
	
	public void close() {
		this.dbHelper.close();
	}
	
	public Preferences readPreferences() {
		Preferences preferences = new Preferences();
		Cursor cursor = database.query("preferences", allColumns, null, null, null, null, null);
		
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
		Log.v("TraCare", "Load Preferences");
		
		return preferences;
	}
	
	public void savePreferences(Preferences preferences) {
		ContentValues values = new ContentValues();
		
		values.put("weight", preferences.getWeight());
		values.put("sleep", preferences.getSleep());
		values.put("energy_level", preferences.getEnergyLevel());
		values.put("quality_of_sleep", preferences.getQualityOfSleep());
		values.put("fitness", preferences.getFitness());
		values.put("nutrition", preferences.getNutrition());
		values.put("symptom", preferences.getSymptom());
		
		database.update("preferences", values, null, null);
		Log.v("TraCare", "Save Preferences");
	}
}
