package ca.dillonyoung.tracare;

/**
 * Filename: EntriesListActivity.java
 * Author..: Dillon Young (C0005790)
 */

// Include required imports
import java.sql.Date;
import java.util.ArrayList;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Gallery;
import android.widget.TableRow;
import android.widget.TextView;

@SuppressWarnings("deprecation")
public class EntryListActivity extends Activity {

	public static ArrayList<Entries> entries;

	private Gallery galleryEntries;
	private TextView txtEntryWeight;
	private TextView txtEntryHoursSleep;
	private TextView txtEntryQualitySleep;
	private TextView txtEntryEnergyLevel;
	private TextView txtEntryFitness;
	private TextView txtEntryNutrition;
	private TextView txtEntrySymptom;
	private TextView txtEntrySymptomDescription;
	
	private int entryIndex;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// Set the layout for the activity
		setContentView(R.layout.entrylist);

		galleryEntries = (Gallery) findViewById(R.id.galleryEntries);
		txtEntryWeight = (TextView) findViewById(R.id.txtEntryWeight);
		txtEntryHoursSleep = (TextView) findViewById(R.id.txtEntryHoursSleep);
		txtEntryQualitySleep = (TextView) findViewById(R.id.txtEntryQualitySleep);
		txtEntryEnergyLevel = (TextView) findViewById(R.id.txtEntryEnergyLevel);
		txtEntryFitness = (TextView) findViewById(R.id.txtEntryFitness);
		txtEntryNutrition = (TextView) findViewById(R.id.txtEntryNutrition);
		txtEntrySymptom = (TextView) findViewById(R.id.txtEntrySymptom);
		txtEntrySymptomDescription = (TextView) findViewById(R.id.txtEntrySymptomDescription);
	}

	public void onResume() {

		super.onResume();

		galleryEntries.setAdapter(null);
		galleryEntries.setOnItemSelectedListener(null);

		entries = Main.datasourceEntries.getEntries();
		ArrayList<String> entryDate = new ArrayList<String>();

		for (int i = 0; i < entries.size(); i++) {
			Date curDate = new Date(entries.get(i).getDateEntered());
			entryDate.add(DateFormat
					.format("MMMM d, yyyy hh:mm:ss aa", curDate).toString());
		}

		if (entries.size() == 0) {
			txtEntryWeight.setText("There are currently no entries");
		}

		ArrayAdapter arrayAdapter = new ArrayAdapter(this,
				android.R.layout.simple_gallery_item, entryDate.toArray());

		galleryEntries.setAdapter(arrayAdapter);
		galleryEntries.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {

				// Get the arrays of strings
				entryIndex = arg2;
				String[] hourssleep = getResources().getStringArray(
						R.array.hours_of_sleep);
				String[] qualityofsleep = getResources().getStringArray(
						R.array.quality_of_sleep);
				String[] energylevel = getResources().getStringArray(
						R.array.energy_level);
				String[] symptom = getResources().getStringArray(
						R.array.symptom_type);

				// Check to see if the weight was tracked for the entry
				if (entries.get(entryIndex).getWeight() == -1 || entries.size() == 0) {
					TableRow row = (TableRow) findViewById(R.id.rowEntryWeight);
					row.setVisibility(View.GONE);
				} else {
					TableRow row = (TableRow) findViewById(R.id.rowEntryWeight);
					row.setVisibility(View.VISIBLE);
					txtEntryWeight.setText("Weight: "
							+ String.format("%f", entries.get(entryIndex)
									.getWeight()));
				}

				// Check to see if the hours of sleep was tracked for the entry
				if (entries.get(entryIndex).getHoursSleep() == -1 || entries.size() == 0) {
					TableRow row = (TableRow) findViewById(R.id.rowEntryHoursSleep);
					row.setVisibility(View.GONE);
				} else {
					TableRow row = (TableRow) findViewById(R.id.rowEntryHoursSleep);
					row.setVisibility(View.VISIBLE);
					txtEntryHoursSleep.setText(hourssleep[(int) entries.get(
							entryIndex).getHoursSleep()]);
				}

				// Check to see if the quality of sleep was tracked for the
				// entry
				if (entries.get(entryIndex).getQualityOfSleep() == -1 || entries.size() == 0) {
					TableRow row = (TableRow) findViewById(R.id.rowEntryQualitySleep);
					row.setVisibility(View.GONE);
				} else {
					TableRow row = (TableRow) findViewById(R.id.rowEntryQualitySleep);
					row.setVisibility(View.VISIBLE);
					txtEntryQualitySleep.setText(qualityofsleep[(int) entries
							.get(entryIndex).getQualityOfSleep()]);
				}

				// Check to see if the energy level was tracked for the entry
				if (entries.get(entryIndex).getEnergyLevel() == -1 || entries.size() == 0) {
					TableRow row = (TableRow) findViewById(R.id.rowEntryEnergyLevel);
					row.setVisibility(View.GONE);
				} else {
					TableRow row = (TableRow) findViewById(R.id.rowEntryEnergyLevel);
					row.setVisibility(View.VISIBLE);
					txtEntryEnergyLevel.setText(energylevel[(int) entries.get(
							entryIndex).getEnergyLevel()]);
				}

				// Check to see if the fitness activity was tracked for the
				// entry
				if (entries.get(entryIndex).getFitness().equals("<{[blank]}>") || entries.size() == 0) {
					TableRow row = (TableRow) findViewById(R.id.rowEntryFitness);
					row.setVisibility(View.GONE);
				} else {
					TableRow row = (TableRow) findViewById(R.id.rowEntryFitness);
					row.setVisibility(View.VISIBLE);
					txtEntryFitness.setText(entries.get(entryIndex).getFitness());
				}

				// Check to see if the nutrition was tracked for the entry
				if (entries.get(entryIndex).getNutrition()
						.equals("<{[blank]}>") || entries.size() == 0) {
					TableRow row = (TableRow) findViewById(R.id.rowEntryNutrition);
					row.setVisibility(View.GONE);
				} else {
					TableRow row = (TableRow) findViewById(R.id.rowEntryNutrition);
					row.setVisibility(View.VISIBLE);
					txtEntryNutrition
							.setText(entries.get(entryIndex).getNutrition());
				}

				// Check to see if the symptoms was tracked for the entry
				if (entries.get(entryIndex).getSymptom() == -1 || entries.size() == 0) {
					TableRow row1 = (TableRow) findViewById(R.id.rowEntrySymptom);
					row1.setVisibility(View.GONE);
					TableRow row2 = (TableRow) findViewById(R.id.rowEntrySymptomDescription);
					row2.setVisibility(View.GONE);
				} else {
					TableRow row1 = (TableRow) findViewById(R.id.rowEntrySymptom);
					row1.setVisibility(View.VISIBLE);
					TableRow row2 = (TableRow) findViewById(R.id.rowEntrySymptomDescription);
					row2.setVisibility(View.VISIBLE);
					txtEntrySymptom.setText(symptom[(int) entries.get(entryIndex)
							.getSymptom()]);
					txtEntrySymptomDescription.setText(entries.get(entryIndex)
							.getSymptomDescription());
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}

		}); // new GalleryOnItemSelectedListener());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);

		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.entries, menu);

		return true;
	}

	public boolean onPrepareOptionsMenu(Menu menu) {

		// Check to see if the delete option should be shown
		if (entries.size() > 0) {
			MenuItem item = menu.findItem(R.id.deleteEntry);
			item.setVisible(true);
		} else {
			MenuItem item = menu.findItem(R.id.deleteEntry);
			item.setVisible(false);
		}
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		System.err.println(item.getItemId());
		switch (item.getItemId()) // switch based on selected MenuItem's ID
		{
		case R.id.addEntry:
			
			// create an Intent to launch the AddEntryActivity
			Intent addEntry = new Intent(this, AddEntryActivity.class);

			// Start the activity
			startActivity(addEntry);
			return true;
		case R.id.deleteEntry:
			
			// Build the alert dialog
			AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
					this);

			// Set dialog title
			alertDialogBuilder.setTitle("Delete Entry");

			// Set the dialog message
			alertDialogBuilder
					.setMessage(
							"Are you sure you want to delete the current entry?")
					.setCancelable(false)
					.setPositiveButton("Yes",
							new DialogInterface.OnClickListener() {
						
								@Override
								public void onClick(DialogInterface dialog, int which) {

									Main.datasourceEntries.deleteEntry(entries.get(entryIndex).getId());
									
									// Clear the contents of the text fields
									txtEntryWeight.setText("");
									txtEntryHoursSleep.setText("");
									txtEntryQualitySleep.setText("");
									txtEntryEnergyLevel.setText("");
									txtEntryFitness.setText("");
									txtEntryNutrition.setText("");
									txtEntrySymptom.setText("");
									txtEntrySymptomDescription.setText("");
									
									onResume();
								}
							})
					.setNegativeButton("No",
							new DialogInterface.OnClickListener() {
								
								@Override
								public void onClick(DialogInterface dialog, int which) {
									
									
								}
							});

			// Create the alert dialog
			AlertDialog alertDialog = alertDialogBuilder.create();

			// Display the alert dialog
			alertDialog.show();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		} 
	}}
