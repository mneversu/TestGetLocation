package com.project.savier.testgetlocation;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.widget.TextView;

public class GetLocation extends Activity {
TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_get_location);
		tv=(TextView)findViewById(R.id.tv);
		GetUserLocation();
	}
	
	//GetUserLocation
	public void GetUserLocation()
	{
		// Acquire a reference to the system Location Manager
		LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
//Location loc=locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);		
//loc.setProvider(LOCATION_SERVICE);
//tv.setText((CharSequence) locationManager.getProviders(true));
tv.setText("User Location Changed");
		
		// Define a listener that responds to location updates
		LocationListener locationListener = new LocationListener() {
		    public void onLocationChanged(Location location) {
		      // Called when a new location is found by the network location provider.
		    	tv.setText("User Location Changed");
		    	makeUseOfNewLocation(location);
		    }

		    public void onStatusChanged(String provider, int status, Bundle extras) {}

		    public void onProviderEnabled(String provider) {}

		    public void onProviderDisabled(String provider) {}
		  };

		// Register the listener with the Location Manager to receive location updates
		locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
	}
	public void makeUseOfNewLocation(Location location)
	{
		//TextView tv=new TextView(getApplicationContext());
		
	}

}
