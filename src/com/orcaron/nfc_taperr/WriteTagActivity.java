package com.orcaron.nfc_taperr;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class WriteTagActivity extends Activity {
	
	protected Button mWriterButton;
	protected Button mEraseButton;
	protected Button mLockButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_write_tag);
		writerButton(); 
	}
	
	public void writerButton() {
		mWriterButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent writerintent = new Intent(WriteTagActivity.this, WriterPadActivity.class);
				startActivity(writerintent);
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.write_tag, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}



}
