package ca.dillonyoung.tracare;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class AddEntryActivity extends Activity {

	private Spinner spinHours;
	private Spinner spinQualitySleep;
	private Spinner spinEnergyLevel;
	private Spinner spinSymptomType;
	private TextView txtWeight;
	private TextView txtFitness;
	private TextView txtNutrition;
	private TextView txtSymptomDescription;
	private Button btnSave;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.addentry);

		// Create a reference to the hour of sleep spinner and associate the string array
		spinHours = (Spinner)findViewById(R.id.spinHours);
		ArrayAdapter<CharSequence> adapterHours = ArrayAdapter.createFromResource(this, R.array.hours_of_sleep, android.R.layout.simple_spinner_item);
		adapterHours.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinHours.setAdapter(adapterHours);
		spinHours.setOnItemSelectedListener(new spinHoursOnItemSelectedListener());
		
		// Create a reference to the quality of sleep spinner and associate the string array
		spinQualitySleep = (Spinner)findViewById(R.id.spinQualityofSleep);
		ArrayAdapter<CharSequence> adapterQualitySleep = ArrayAdapter.createFromResource(this, R.array.quality_of_sleep, android.R.layout.simple_spinner_item);
		adapterQualitySleep.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinQualitySleep.setAdapter(adapterQualitySleep);
		spinQualitySleep.setOnItemSelectedListener(new spinQualitySleepOnItemSelectedListener());
		
		// Create a reference to the energy level spinner and associate the string array
		spinEnergyLevel = (Spinner)findViewById(R.id.spinEnergyLevel);
		ArrayAdapter<CharSequence> adapterEnergyLevel = ArrayAdapter.createFromResource(this, R.array.energy_level, android.R.layout.simple_spinner_item);
		adapterEnergyLevel.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinEnergyLevel.setAdapter(adapterEnergyLevel);
		spinEnergyLevel.setOnItemSelectedListener(new spinEnergyLevelOnItemSelectedListener());
		
		// Create a reference to the symptom type spinner and associate the string array
		spinSymptomType = (Spinner)findViewById(R.id.spinSymptom);
		ArrayAdapter<CharSequence> adapterSymptomType = ArrayAdapter.createFromResource(this, R.array.symptom_type, android.R.layout.simple_spinner_item);
		adapterSymptomType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinSymptomType.setAdapter(adapterSymptomType);
		spinSymptomType.setOnItemSelectedListener(new spinSymptomTypeOnItemSelectedListener());
		
		// Create a reference to the weight
		txtWeight = (TextView)findViewById(R.id.txtWeight);
		
		// Create a reference to the fitness activity text view
		txtFitness = (TextView)findViewById(R.id.txtFitness);
		
		// Create a reference to the nutrition activity text view
		txtNutrition = (TextView)findViewById(R.id.txtNutrition);
		
		// Create a reference to the symptom description activity text view
		txtSymptomDescription = (TextView)findViewById(R.id.txtSymptomDescription);
		
		// Create a reference to the save button
		btnSave = (Button)findViewById(R.id.btnSave);
		
		// Set the on click listener for the save button
		btnSave.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				// Check to see if the weight value has been entered
				if (txtWeight.getText().toString().length() == 0) {

					// Create a toast message to inform the user the weight is
					// not valid
					Toast.makeText(getBaseContext(),
							"The weight value is not valid",
							Toast.LENGTH_SHORT).show();
					return;
				}
				
				// Check to see if the weight has not been entered
				if (Float.parseFloat(txtWeight.getText().toString()) < 1.0) {

					// Create a toast message to inform the user the weight is
					// not valid
					Toast.makeText(getBaseContext(),
							"The weight value is not valid", Toast.LENGTH_SHORT)
							.show();
					return;
				}
				
				// Create a new entry object
				Entries entry = new Entries();
				
				entry.setDateEntered(System.currentTimeMillis());
				entry.setLocation(0);
				entry.setWeight(Float.parseFloat(txtWeight.getText().toString()));
				entry.setHoursSleep(spinHours.getSelectedItemPosition());
				entry.setQualityOfSleep(spinEnergyLevel.getSelectedItemId());
				entry.setFitness(txtFitness.getText().toString());
				entry.setNutrition(txtNutrition.getText().toString());
				entry.setSymptom(spinSymptomType.getSelectedItemId());
				entry.setSymptomDescription(txtSymptomDescription.getText().toString());
				
				Main.datasourceEntries.addEntry(entry);
				
				finish();
			}
		});
	}
}

class spinHoursOnItemSelectedListener implements OnItemSelectedListener {

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		Log.v("TraCare", arg0.getItemAtPosition(arg2).toString());
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
}

class spinQualitySleepOnItemSelectedListener implements OnItemSelectedListener {

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		Log.v("TraCare", arg0.getItemAtPosition(arg2).toString());
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
}

class spinEnergyLevelOnItemSelectedListener implements OnItemSelectedListener {

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		Log.v("TraCare", arg0.getItemAtPosition(arg2).toString());
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
}

class spinSymptomTypeOnItemSelectedListener implements OnItemSelectedListener {

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		Log.v("TraCare", arg0.getItemAtPosition(arg2).toString());
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
}
