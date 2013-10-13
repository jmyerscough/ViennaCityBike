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
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import com.myerscough.viennacitybike.data.BikeStation;
import com.myerscough.viennacitybike.db.*;
import com.myerscough.viennacitybike.handlers.ReportStatusHandler;
import com.myerscough.viennacitybike.tasks.ViennaCityBikeXMLRunnable;

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //String [] resultColumns = new String [] {ViennaCityBikeDatabase.STATION_NAME};
        //ViennaCityBikeDBOpenHelper helper = new ViennaCityBikeDBOpenHelper(this); 
        //
        //SQLiteDatabase db = helper.getWritableDatabase();
        //Cursor cursor = db.query(ViennaCityBikeDBOpenHelper.STATIONS_TABLE, resultColumns, null, null, null, null, null);
        //
        //Toast.makeText(this, String.format("row count=%d", cursor.getCount()), 1000).show();
        
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
	   
	   if (map != null)
	   {
		   Log.d("MainActivity", bikeStation.getLocation().toString());
		   
		   MarkerOptions marker = new MarkerOptions();
		   marker.position(bikeStation.getLocation());
		   marker.title(bikeStation.getName());
		   map.addMarker(marker);
	   }
   }
   
   public void addBikeStation(BikeStation station)
   {
	   bikeStations.add(station);
   }
    
}
