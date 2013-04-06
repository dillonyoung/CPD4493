package ca.dillonyoung.tracare;

import java.sql.Date;
import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class EntriesDataSource {

	private SQLiteDatabase database;
	private MySQLiteHelper dbHelper;
	private String[] allColumns = { "id", "dateentered", "location", "weight", "hours_sleep", "energy_level", "quality_of_sleep", "fitness", "nutrition", "symptom", "symptom_description" };
	
	public EntriesDataSource(Context context) {
		this.dbHelper = new MySQLiteHelper(context);
	}
	
	public void open() throws SQLException {
		this.database = this.dbHelper.getWritableDatabase();
	}
	
	public void close() {
		this.dbHelper.close();
	}
	
	public ArrayList<Entries> getEntries() {
		
		ArrayList<Entries> entries = new ArrayList<Entries>();
		
		Cursor cursor = database.query("entries", allColumns, null, null, null, null, null);
		
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			
			Entries entry = new Entries();
			entry.setId(cursor.getInt(0));
			//long msTime = System.currentTimeMillis();
			//Date curDate = new Date(msTime);
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
			
			entries.add(entry);
			cursor.moveToNext();
		}
		cursor.close();
		Log.v("TraCare", "Load Entries List");
		System.err.println(entries.size());
		return entries;
	}
	
	public long addEntry(Entries entry) {
		
		ContentValues values = new ContentValues();
		
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
		
		long insertId = database.insert("entries", null, values);
		
		return insertId;
	}
}
