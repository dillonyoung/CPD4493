package ca.dillonyoung.tracare;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;

public class PreferencesActivity extends Activity {

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
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.preferences);
		
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
		
	}
}
