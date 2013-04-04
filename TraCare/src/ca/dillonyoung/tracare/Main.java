package ca.dillonyoung.tracare;


import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

@SuppressWarnings("deprecation")
public class Main extends TabActivity {

	// Declare the preferences data source and class
	public static PreferencesDataSource datasourcePreferences;
	public static Preferences preferences;
	
	// Declare the user details data source and class
	public static UserDetailsDataSource dataSourceUserDetails;
	public static UserDetails userdetails;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        
        TabHost tabHost = getTabHost();
 
        // Tab for Entry List
        TabSpec specEntryList = tabHost.newTabSpec("Entries");
        // setting Title and Icon for the Tab
        specEntryList.setIndicator("Entries", getResources().getDrawable(R.drawable.entries));
        Intent entryListIntent = new Intent(this, EntryListActivity.class);
        specEntryList.setContent(entryListIntent);
 
        // Tab for Summary
        TabSpec specSummary = tabHost.newTabSpec("Summary");
        specSummary.setIndicator("Summary", getResources().getDrawable(R.drawable.summary));
        Intent summaryIntent = new Intent(this, SummaryActivity.class);
        specSummary.setContent(summaryIntent);
 
        // Tab for Preferences
        TabSpec specPreferences = tabHost.newTabSpec("Settings");
        specPreferences.setIndicator("Settings", getResources().getDrawable(R.drawable.preferences));
        Intent preferencesIntent = new Intent(this, PreferencesActivity.class);
        specPreferences.setContent(preferencesIntent);
 
        // Adding all TabSpec to TabHost
        tabHost.addTab(specEntryList); 
        tabHost.addTab(specSummary); 
        tabHost.addTab(specPreferences);
    }

	protected void onResume() {
		
		// Open the data sources when the activity resumes
		datasourcePreferences.open();
		dataSourceUserDetails.open();
		super.onResume();
	}
	
	protected void onPause() {
		
		// Close the data sources when the activity is paused
		datasourcePreferences.close();
		dataSourceUserDetails.close();
		super.onPause();
		Log.v("TraCare", "Pause");
	}
}
