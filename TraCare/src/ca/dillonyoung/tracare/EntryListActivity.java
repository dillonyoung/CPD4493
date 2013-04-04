package ca.dillonyoung.tracare;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Gallery;
import android.widget.TextView;

public class EntryListActivity extends Activity {

	String[] values = { "Test1", "Test2", "Test3" };
	
	private Gallery galleryEntries;
	private TextView txtDescription;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.entrylist);
		
		galleryEntries = (Gallery)findViewById(R.id.galleryEntries);
		txtDescription = (TextView)findViewById(R.id.txtDescription);
		
		ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_gallery_item, values);
		
		galleryEntries.setAdapter(arrayAdapter);
	}
}
