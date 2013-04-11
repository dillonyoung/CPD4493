package ca.dillonyoung.tracare;

/**
 * Filename: Main.java
 * Author..: Dillon Young (C0005790)
 */

// Include required imports
import java.util.ArrayList;
import android.app.AlertDialog;
import android.app.TabActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

@SuppressWarnings("deprecation")
public class Main extends TabActivity {

	// Declare the reference
	public static TabHost tabHost;
	
	// Declare the preferences data source and class
	public static PreferencesDataSource datasourcePreferences;
	public static Preferences preferences;

	// Declare the user details data source and class
	public static UserDetailsDataSource dataSourceUserDetails;
	public static UserDetails userdetails;
	
	// Declare the entries data source and class
	public static EntriesDataSource datasourceEntries;
	public static ArrayList<Entries> entries;

	
	/**
	 * The onCreate method for the Main class
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// Set the layout for the activity
		setContentView(R.layout.main);

		// Set the preference data source and load the data
		try {
			datasourcePreferences = new PreferencesDataSource(this);
			datasourcePreferences.open();
			preferences = datasourcePreferences.readPreferences();
		} catch (Exception ex) {
			System.err.println("Exception " + ex.getMessage());
		}

		// Set the user detail data source and load the data
		try {
			dataSourceUserDetails = new UserDetailsDataSource(this);
			dataSourceUserDetails.open();
			userdetails = dataSourceUserDetails.readUserDetails();
		} catch (Exception ex) {
			System.err.println("Exception " + ex.getMessage());
		}
		
		// Set the entries data source and load the data
		try {
			datasourceEntries = new EntriesDataSource(this);
			datasourceEntries.open();
			entries = datasourceEntries.getEntries();
		} catch (Exception ex) {
			System.err.println("Exception " + ex.getMessage());
		}

		tabHost = getTabHost();

		// Tab for Entry List
		TabSpec specEntryList = tabHost.newTabSpec("Entries");
		// setting Title and Icon for the Tab
		specEntryList.setIndicator("Entries",
				getResources().getDrawable(R.drawable.entries));
		Intent entryListIntent = new Intent(this, EntryListActivity.class);
		specEntryList.setContent(entryListIntent);

		// Tab for Summary
		TabSpec specSummary = tabHost.newTabSpec("Summary");
		specSummary.setIndicator("Summary",
				getResources().getDrawable(R.drawable.summary));
		Intent summaryIntent = new Intent(this, SummaryActivity.class);
		specSummary.setContent(summaryIntent);

		// Tab for Preferences
		TabSpec specPreferences = tabHost.newTabSpec("Settings");
		specPreferences.setIndicator("Settings",
				getResources().getDrawable(R.drawable.preferences));
		Intent preferencesIntent = new Intent(this, PreferencesActivity.class);
		specPreferences.setContent(preferencesIntent);

		// Adding all TabSpec to TabHost
		tabHost.addTab(specEntryList);
		tabHost.addTab(specSummary);
		tabHost.addTab(specPreferences);

		// Check to see if it is the first time running the application
		if (MySQLiteHelper.firstRun) {
			
			// Build the alert dialog
			AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

			// Set dialog title
			alertDialogBuilder.setTitle("First Run");

			// Set the dialog message
			alertDialogBuilder
					.setMessage("Since this is the first time running the application please configure the user details.")
					.setCancelable(false)
					.setPositiveButton("OK",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {

								}
							});

			// Create the alert dialog
			AlertDialog alertDialog = alertDialogBuilder.create();

			// Display the alert dialog
			alertDialog.show();

			// Set the current tab to the settings tab
			tabHost.setCurrentTab(2);
		}
	}

	
	/**
	 * The onResume method for the Main class
	 */
	protected void onResume() {

		// Open the data sources when the activity resumes
		datasourcePreferences.open();
		dataSourceUserDetails.open();
		super.onResume();
	}

	
	/**
	 * The onPause method for the Main class
	 */
	protected void onPause() {

		// Close the data sources when the activity is paused
		datasourcePreferences.close();
		dataSourceUserDetails.close();
		super.onPause();
	}
}
