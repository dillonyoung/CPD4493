package ca.dillonyoung.tracare;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Gallery;
import android.widget.TextView;

public class EntryListActivity extends Activity {

	String[] values = { "Test1", "Test2", "Test3" };

	private ArrayList<Entries> entries;
	
	private Gallery galleryEntries;
	private TextView txtDescription;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.entrylist);

		galleryEntries = (Gallery) findViewById(R.id.galleryEntries);
		txtDescription = (TextView) findViewById(R.id.txtDescription);
		
		entries = Main.datasourceEntries.getEntries();
		ArrayList<String> entryDate = new ArrayList<String>();
		
		for (int i = 0; i < entries.size(); i++) {
			Date curDate = new Date(entries.get(i).getDateEntered());
			DateFormat dateFormat = new DateFormat();
			System.err.println(dateFormat.format("MM/dd/yyyy hh:mm:ss aa", curDate));
			entryDate.add(dateFormat.format("MMMM d, yyyy hh:mm:ss aa", curDate).toString());
		}
		
		ArrayAdapter arrayAdapter = new ArrayAdapter(this,
				android.R.layout.simple_gallery_item, entryDate.toArray());

		galleryEntries.setAdapter(arrayAdapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.entries, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		System.err.println(item.getItemId());
		switch (item.getItemId()) // switch based on selected MenuItem's ID
		{
		case R.id.addEntry:
			// create an Intent to launch the AddEditContact Activity
			Intent addEntry = new Intent(this, AddEntryActivity.class);

			// pass the selected contact's data as extras with the Intent
//			addEditContact.putExtra(AddressBook.ROW_ID, rowID);
//			addEditContact.putExtra("name", nameTextView.getText());
//			addEditContact.putExtra("phone", phoneTextView.getText());
//			addEditContact.putExtra("email", emailTextView.getText());
//			addEditContact.putExtra("street", streetTextView.getText());
//			addEditContact.putExtra("city", cityTextView.getText());
			startActivity(addEntry); // start the Activity
			return true;
		default:
			return super.onOptionsItemSelected(item);
		} 
	} 
}
