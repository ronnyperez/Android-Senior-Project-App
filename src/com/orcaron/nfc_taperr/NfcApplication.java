package com.orcaron.nfc_taperr;

import com.parse.Parse;


import android.app.Application;

public class NfcApplication extends Application {
	
	@Override
	public void onCreate() {
		/**
		 * This method is use to connect the app
		 * to the back end
		 */
		super.onCreate();
		  Parse.initialize(this, "WQTpKm9iUybvyRMzW2x5bMN6MzxNYDH6bYgmi2cR", "T5YESA9qNclQbWXrMj7WAPAJRvRPf8fBi60mVT6u");
		  
		
		}

}
