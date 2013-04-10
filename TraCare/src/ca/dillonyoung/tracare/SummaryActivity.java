package ca.dillonyoung.tracare;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

public class SummaryActivity extends Activity {

	// Declare variables
	private int startDateYear;
	private int startDateMonth;
	private int startDateDay;
	private int endDateYear;
	private int endDateMonth;
	private int endDateDay;
	static final int START_DATE_DIALOG_ID = 0;
	static final int END_DATE_DIALOG_ID = 1;
	
	// Declare references
	private Button btnRunReport;
	private Button btnStartDate;
	private Button btnEndDate;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.summary);
		
		// Create a reference to the run report button
		btnRunReport = (Button) findViewById(R.id.btnRunReport);
		
		// Create a reference to the start date button
		btnStartDate = (Button) findViewById(R.id.btnStartDate);
		
		// Create a reference to the end date button
		btnEndDate = (Button) findViewById(R.id.btnEndDate);
		
		// Create an instance of the calendar class
		Calendar c = Calendar.getInstance();
		
		// Get the date values for the end date and store them in the variables
		endDateYear = c.get(Calendar.YEAR);
		endDateMonth = c.get(Calendar.MONTH);
		endDateDay = c.get(Calendar.DAY_OF_MONTH);
		btnEndDate.setText(formatDate(endDateMonth, endDateDay, endDateYear));
		
		// Get the date values for the start date and store them in the variables
		c.add(Calendar.DATE, -7);
		startDateYear = c.get(Calendar.YEAR);
		startDateMonth = c.get(Calendar.MONTH);
		startDateDay = c.get(Calendar.DAY_OF_MONTH);
		btnStartDate.setText(formatDate(startDateMonth, startDateDay, startDateYear));
		
		// Create and associate the start date button on click listener
		btnStartDate.setOnClickListener(new View.OnClickListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				// Show the date dialog
				showDialog(START_DATE_DIALOG_ID);
			}
		});
		
		// Create and associate the end date button on click listener
		btnEndDate.setOnClickListener(new View.OnClickListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				// Show the date dialog
				showDialog(END_DATE_DIALOG_ID);
			}
		});
		
		// Create and associate the run report button on click listener
		btnRunReport.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
                
			   // Declare variable
			   int count = 0;
			   int rvalue = -1;
			   float total = 0;
			   
			   Calendar startCal = Calendar.getInstance();
			   startCal.set(Calendar.MONTH, startDateMonth);
			   startCal.set(Calendar.DAY_OF_MONTH, startDateDay);
			   startCal.set(Calendar.YEAR, startDateYear);
			   Date newStart = startCal.getTime();
			   
			   Calendar endCal = Calendar.getInstance();
			   endCal.set(Calendar.MONTH, endDateMonth);
			   endCal.set(Calendar.DAY_OF_MONTH, endDateDay);
			   endCal.set(Calendar.YEAR, endDateYear);
			   Date newEnd = endCal.getTime();
			   
			   java.sql.Date startDate = new java.sql.Date(newStart.getTime());
			   java.sql.Date endDate = new java.sql.Date(newEnd.getTime());
			
			   Summary report = new Summary();
			   
			   // Declare query statement
			   String query = "SELECT * FROM tracare_entries WHERE userid = ? AND datetime BETWEEN ? AND ?";
			           
			   try {
			
			       // Create the prepared statement and fill in the values
			       PreparedStatement pstmt = conn.prepareStatement(query);
			       pstmt.setInt(1, userid);
			       pstmt.setDate(2, startDate);
			       pstmt.setDate(3, endDate);
			       
			       // Execute the statement
			       ResultSet rs = pstmt.executeQuery();
			       ResultSetMetaData rsmd = rs.getMetaData();
			       while (rs.next()) {
			
			           if (rs.getFloat(4) < report.getLowestWeight()) {
			               report.setLowestWeight(rs.getFloat(4));
			               report.setLowestDate(rs.getDate(3));
			           }
			           if (rs.getFloat(4) > report.getHighestWeight()) {
			               report.setHighestWeight(rs.getFloat(4));
			               report.setHighestDate(rs.getDate(3));
			           }
			           
			           count++;
			           total += rs.getFloat(4);
			       }
			
			       report.setAverageWeight(total / count);
			       
			       if (count == 0) {
			           report.setHighestDate(end);
			           report.setLowestDate(start);
			           report.setHighestWeight(0);
			           report.setLowestWeight(0);
			           report.setAverageWeight(0);
			       }
			
			   } catch (SQLException ex) {
			       rvalue = -3;
			   }
			}
		});
	}
	

	protected Dialog onCreateDialog(int id) {
		
		// Check to see which dialog to display
		switch (id) {
		case START_DATE_DIALOG_ID:

				// Display the start date picker dialog
				return new DatePickerDialog(this, summaryStartDate, startDateYear, startDateMonth, startDateDay);

		case END_DATE_DIALOG_ID:
			
			// Display the end date picker dialog
			return new DatePickerDialog(this, summaryEndDate, endDateYear, endDateMonth, endDateDay);			
		}
		return null;
	}
	
	private DatePickerDialog.OnDateSetListener summaryStartDate = 
			new DatePickerDialog.OnDateSetListener() {
				
				@Override
				public void onDateSet(DatePicker view, int year, int monthOfYear,
						int dayOfMonth) {
					// TODO Auto-generated method stub

					// Update the text on the button for the start date picker
					btnStartDate.setText(formatDate(monthOfYear, dayOfMonth, year));
				}
	};
	
	private DatePickerDialog.OnDateSetListener summaryEndDate = 
			new DatePickerDialog.OnDateSetListener() {
				
				@Override
				public void onDateSet(DatePicker view, int year, int monthOfYear,
						int dayOfMonth) {
					// TODO Auto-generated method stub

					// Update the text on the button for the end date picker
					btnEndDate.setText(formatDate(monthOfYear, dayOfMonth, year));
				}
	};
	
	private String formatDate(int month, int day, int year) {
		
		Calendar c = Calendar.getInstance();
		c.set(Calendar.MONTH, month);
		c.set(Calendar.DAY_OF_MONTH, day);
		c.set(Calendar.YEAR, year);
		
		String value = c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US) +
				" " + day + ", " + year;
		
		return value;
	}
}
