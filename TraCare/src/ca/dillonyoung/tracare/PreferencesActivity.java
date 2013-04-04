package ca.dillonyoung.tracare;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

public class PreferencesActivity extends Activity {

	private PreferencesDataSource datasource;
	private Preferences preferences;
	
	// Create the references for the widgets
	private EditText txtUserName;
	private EditText txtUserWeight;
	private RadioButton radMale;
	private RadioButton radFemale;
	private Switch switchWeight;
	private Switch switchSleep;
	private Switch switchEnergyLevel;
	private Switch switchFitness;
	private Switch switchNutrition;
	private Switch switchSymptom;
	private Button btnSave;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.preferences);
		
		// Set the preference data source for the view and load the data
		try {
			datasource = new PreferencesDataSource(this);
			datasource.open();
			preferences = datasource.readPreferences();
		} catch (Exception ex) {
			System.out.println("Exception " + ex.getMessage());
		}
		
		// Associate the widgets with the references
		txtUserName = (EditText)findViewById(R.id.txtUserName);
		txtUserWeight = (EditText)findViewById(R.id.txtUserWeight);
		radMale = (RadioButton)findViewById(R.id.radMale);
		radFemale = (RadioButton)findViewById(R.id.radFemale);
		switchWeight = (Switch)findViewById(R.id.switchWeight);
		switchSleep = (Switch)findViewById(R.id.switchSleep);
		switchEnergyLevel = (Switch)findViewById(R.id.switchEnergyLevel);
		switchFitness = (Switch)findViewById(R.id.switchFitness);
		switchNutrition = (Switch)findViewById(R.id.switchNutrition);
		switchSymptom = (Switch)findViewById(R.id.switchSymptom);
		btnSave = (Button)findViewById(R.id.btnSave);
		
		// Update the check state for the switches
		switchWeight.setChecked(preferences.getWeight());
		switchSleep.setChecked(preferences.getSleep());
		switchEnergyLevel.setChecked(preferences.getEnergyLevel());
		switchFitness.setChecked(preferences.getFitness());
		switchNutrition.setChecked(preferences.getNutrition());
		switchSymptom.setChecked(preferences.getSymptom());
		
		// Set the on click listener for the save button
		btnSave.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				// Gather the preference information
				Preferences preferences = new Preferences();
				preferences.setWeight(switchWeight.isChecked());
				preferences.setSleep(switchSleep.isChecked());
				preferences.setEnergyLevel(switchEnergyLevel.isChecked());
				preferences.setFitness(switchFitness.isChecked());
				preferences.setNutrition(switchNutrition.isChecked());
				preferences.setSymptom(switchSymptom.isChecked());
				
				// Save the preferences
				datasource.savePreferences(preferences);
				
				// Create a toast message to inform the user the settings have been saved
				Toast.makeText(getBaseContext(), "The settings have been saved", Toast.LENGTH_SHORT).show();
			}
		});
	}
	
	protected void onResume() {
		datasource.open();
		super.onResume();
	}
	
	protected void onPause() {
		datasource.close();
		super.onPause();
		Log.v("TraCare", "Pause");
	}
}
