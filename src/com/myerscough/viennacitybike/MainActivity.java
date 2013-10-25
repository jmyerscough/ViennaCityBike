package com.myerscough.viennacitybike;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import com.myerscough.viennacitybike.data.BikeStation;
import com.myerscough.viennacitybike.db.*;
import com.myerscough.viennacitybike.handlers.ReportStatusHandler;
import com.myerscough.viennacitybike.tasks.ViennaCityBikeXMLRunnable;
import com.myerscough.viennacitybike.views.BikeStationInfoWindow;

/**
 * Application's main activity.
 * @author Jason Myerscough
 *
 */
public class MainActivity extends Activity
{
	private static final String LOG_DESCRIPTION = "MainActivity";
	private static final LatLng VIENNA = new LatLng(48.208202, 16.377182);
	private static final int DEFAULT_ZOOM = 10;
	private ArrayList<BikeStation> bikeStations = new ArrayList<BikeStation>();

    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ReportStatusHandler handler = new ReportStatusHandler(this);
        Thread t = new Thread(new ViennaCityBikeXMLRunnable(handler));
        t.start();
        
        setDefaultMapPosition();
    }
    
    /**
     * Centers the map around vienna.
     */
    private void setDefaultMapPosition()
    {
    	GoogleMap map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
    	
    	if (map != null)
    	{
    		Log.v(LOG_DESCRIPTION, "map object available.");
    		
    		// set vienna as the center point of the map
    		CameraUpdate camUpdate = CameraUpdateFactory.newLatLngZoom(VIENNA, DEFAULT_ZOOM);
    		map.animateCamera(camUpdate);
    	}
    	else
    		Log.v(LOG_DESCRIPTION, "No map object available");
    }

   @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
   
   public void addBikeStationToMap(BikeStation bikeStation)
   {
	   GoogleMap map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
	   float percent = (float)(((float)bikeStation.getFreeBikes() / (float)bikeStation.getTotalBoxes()) * 100.0);
	   float markerColour = BitmapDescriptorFactory.HUE_GREEN;
	   
	   
	   if (map != null)
	   {
		   Log.d("MainActivity", bikeStation.getLocation().toString());
		   
		   MarkerOptions marker = new MarkerOptions();
		   marker.position(bikeStation.getLocation());
		   marker.title(bikeStation.getName());
		   marker.snippet(String.format("Bike Station: %s\nDescription: %s\nTotal Boxes: %d\nFree Boxes: %d\nFree Bikes: %d",
				   bikeStation.getName(), bikeStation.getDescription(), bikeStation.getTotalBoxes(),
				   bikeStation.getFreeBoxes(), bikeStation.getFreeBikes(), percent));
		   
		   // set the icon colour
		   if (percent <= 20)
			   markerColour = BitmapDescriptorFactory.HUE_RED;
		   else if (percent <= 60)
			   markerColour = BitmapDescriptorFactory.HUE_YELLOW;
		   marker.icon(BitmapDescriptorFactory.defaultMarker(markerColour));
		   
		   map.setInfoWindowAdapter(new BikeStationInfoWindow(this.getLayoutInflater()));
		   map.addMarker(marker);
	   }
   }
   
   public void addBikeStation(BikeStation station)
   {
	   bikeStations.add(station);
   }
    
}
