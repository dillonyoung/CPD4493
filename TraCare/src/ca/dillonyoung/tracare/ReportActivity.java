package ca.dillonyoung.tracare;

/**
 * Filename: ReportActivity.java
 * Author..: Dillon Young (C0005790)
 */

// Include required imports
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Locale;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ReportActivity extends Activity {

	// Declare references
	private TextView txtStartDate;
	private TextView txtEndDate;
	private TextView txtLowestWeight;
	private TextView txtLowestDate;
	private TextView txtHighestWeight;
	private TextView txtHighestDate;
	private TextView txtAverageWeight;
	private Button btnBack;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// Set the layout for the activity
		setContentView(R.layout.report);
		
		// Associate the widgets with the references
		txtStartDate = (TextView) findViewById(R.id.txtReportStartDate);
		txtEndDate = (TextView) findViewById(R.id.txtReportEndDate);
		txtLowestWeight = (TextView) findViewById(R.id.txtReportLowestWeight);
		txtLowestDate = (TextView) findViewById(R.id.txtReportLowestDate);
		txtHighestWeight = (TextView) findViewById(R.id.txtReportHighestWeight);
		txtHighestDate = (TextView) findViewById(R.id.txtReportHighestDate);
		txtAverageWeight = (TextView) findViewById(R.id.txtReportAverageWeight);
		
		btnBack = (Button) findViewById(R.id.btnBack);
		
		// Create the number formatter
		DecimalFormat format = new DecimalFormat("###,##0.00");
		
		// Get the bundles information
		Bundle extras = getIntent().getExtras();
		
		// Update the report start and end date
		txtStartDate.setText(formatDate(extras.getLong("startdate")));
		txtEndDate.setText(formatDate(extras.getLong("enddate")));
		
		// Update the report lowest weight value and date
		txtLowestWeight.setText(format.format(extras.getFloat("lowestweight")));
		txtLowestDate.setText(formatDate(extras.getLong("lowestdate")));
		
		// Update the report highest weight value and date
		txtHighestWeight.setText(format.format(extras.getFloat("highestweight")));
		txtHighestDate.setText(formatDate(extras.getLong("highestdate")));
		
		// Update the report average weight
		txtAverageWeight.setText(format.format(extras.getFloat("averageweight")));
		
		// Create and associate the back button on click listener
		btnBack.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				// Close the current activity
				finish();
			}
		});
	}


	/**
	 * Builds a formatted string based on a month, day and year
	 * @param date The date value to be formatted
	 * @return Returns the formatted string
	 */
	private String formatDate(long date) {
		
		// Get a calendar based on the supplied day, month and year
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(date);
		
		// Build the formatted string
		String value = c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US) +
				" " + c.get(Calendar.DAY_OF_MONTH) + ", " + c.get(Calendar.YEAR);
		
		// Return the formatted string
		return value;
	}
}