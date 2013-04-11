package ca.dillonyoung.tracare;

/**
 * Filename: UserDetailsDataSource.java
 * Author..: Dillon Young (C0005790)
 */

// Include required imports
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class UserDetailsDataSource {

	// Declare references
	private SQLiteDatabase database;
	private MySQLiteHelper dbHelper;
	
	// Declare variables
	private String[] allColumns = { "name", "gender", "weight" };
	
	
	/**
	 * The constructor for the UserDetailsDataSource class
	 * @param context The context for the class
	 */
	public UserDetailsDataSource(Context context) {
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
	 * Read the user details from the database
	 * @return Returns an object containing the user details
	 */
	public UserDetails readUserDetails() {
		
		// Declare a new instance of the UserDetails class
		UserDetails userdetails = new UserDetails();
		
		// Create a query for the database
		Cursor cursor = database.query("user_details", allColumns, null, null, null, null, null);
		
		// Read the user details from the database
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			userdetails.setName(cursor.getString(0));
			userdetails.setGender(cursor.getInt(1));
			userdetails.setWeight(cursor.getFloat(2));
			cursor.moveToNext();
		}
		cursor.close();

		// Return the user details
		return userdetails;
	}
	
	
	/**
	 * Save the user details to the database
	 * @param userdetails The object containing the user details
	 */
	public void saveUserDetails(UserDetails userdetails) {
		
		// Declare variables
		ContentValues values = new ContentValues();
		
		// Update the values with the values from the supplied object
		values.put("name", userdetails.getName());
		values.put("gender", userdetails.getGender());
		values.put("weight", userdetails.getWeight());
		
		// Update the database
		database.update("user_details", values, null, null);
	}
}
