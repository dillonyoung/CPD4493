package ca.dillonyoung.tracare;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class UserDetailsDataSource {

	private SQLiteDatabase database;
	private MySQLiteHelper dbHelper;
	private String[] allColumns = { "name", "gender", "weight" };
	
	public UserDetailsDataSource(Context context) {
		this.dbHelper = new MySQLiteHelper(context);
	}
	
	public void open() throws SQLException {
		this.database = this.dbHelper.getWritableDatabase();
	}
	
	public void close() {
		this.dbHelper.close();
	}
	
	public UserDetails readUserDetails() {
		UserDetails userdetails = new UserDetails();
		Cursor cursor = database.query("user_details", allColumns, null, null, null, null, null);
		
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			userdetails.setName(cursor.getString(0));
			userdetails.setGender(cursor.getInt(1));
			userdetails.setWeight(cursor.getFloat(2));
			cursor.moveToNext();
		}
		cursor.close();
		Log.v("TraCare", "Load User Details");
		
		return userdetails;
	}
	
	public void saveUserDetails(UserDetails userdetails) {
		ContentValues values = new ContentValues();
		
		values.put("name", userdetails.getName());
		values.put("gender", userdetails.getGender());
		values.put("weight", userdetails.getWeight());
		
		database.update("user_details", values, null, null);
		Log.v("TraCare", "Save User Details");
	}
}
