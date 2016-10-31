package com.orcaron.nfc_taperr;




import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.parse.ParseAnalytics;
import com.parse.ParseUser;

public class MainActivity extends Activity {
	
	public static final String TAG = MainActivity.class.getSimpleName();
	
	protected Button mReadButton;
	protected Button mWriteButton;
	protected Button mShareButton;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		/**
		 * Finding the button views by ID
		 * on the layout
		 */
		mReadButton = (Button) findViewById(R.id.btn_1);
		mWriteButton = (Button) findViewById(R.id.btn_2);
		mShareButton = (Button) findViewById(R.id.btn_3);
		
		readTagScreen();
		writeTagScreen();
		shareTagScreen();
		
		/**
		 * analytics to keep track of the app
		 * in the backend
		 */
		ParseAnalytics.trackAppOpened(getIntent());
		
		/**
		 * This intent is use to clear the stack
		 * of activities
		 * 
		 */
		ParseUser currentUser = ParseUser.getCurrentUser();
		if (currentUser == null) {
			navigateToSignin();
		}else {
			Log.i(TAG, currentUser.getUsername());
		}


	}
	
	public void readTagScreen() {
		mReadButton.setOnClickListener( new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent readintent = new Intent(MainActivity.this, ReadTagActivity.class);
				startActivity(readintent);
				
			}
		});
	}
	
	public void writeTagScreen() {
		mWriteButton.setOnClickListener( new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent writeintent = new Intent(MainActivity.this, WriterPadActivity.class);
				startActivity(writeintent);
				
			}
		});
	}
	
	public void shareTagScreen() {
		mShareButton.setOnClickListener( new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent sharedintent = new Intent(MainActivity.this, ShareTagActivity.class);
				startActivity(sharedintent);
				
			}
		});
	}

	private void navigateToSignin() {
		Intent mainintent = new Intent(this, SigninActivity.class);
		mainintent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		mainintent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
		startActivity(mainintent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int itemId = item.getItemId();
		if (itemId == R.id.action_signout) {
			ParseUser.logOut();
			navigateToSignin();
		}
		return super.onOptionsItemSelected(item);
	}



	

}
