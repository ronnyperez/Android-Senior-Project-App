package com.orcaron.nfc_taperr;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;


public class LoadingActivity extends Activity {
	/**
	 * Assigns six milliseconds to the variable
	 * we're going to be using for the load screen
	 */
	private final int DISPLAY_LOAD_SCREEN = 6000;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
		setContentView(R.layout.activity_loading);

	       loadScreen();
	}
	
	/**
	 * Method for loading the next screen
	 */
	public void loadScreen() {
		setProgressBarIndeterminateVisibility(true);
		/**
		 * New Handler to start the MainScreenActivity 
		 * Then closes this LoadActivity after 6 seconds
		 */
		new Handler().postDelayed(new Runnable() {
			/**
			 * Creates the Intent that will start the MainScreenActivity
			 */
			@Override
			public void run() {
				Intent loadintent = new Intent(LoadingActivity.this, SigninActivity.class);
				LoadingActivity.this.startActivity(loadintent);
				LoadingActivity.this.finish();
				
			}
		}, DISPLAY_LOAD_SCREEN);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.loading, menu);
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
