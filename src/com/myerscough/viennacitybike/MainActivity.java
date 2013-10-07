package com.myerscough.viennacitybike;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;

import com.myerscough.viennacitybike.db.*;

public class MainActivity extends Activity
{
	private static final String LOG_DESCRIPTION = "MainActivity";
	private static final LatLng VIENNA = new LatLng(48.208202, 16.377182);
	private static final int DEFAULT_ZOOM = 10;

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
        
        setDefaultMapPosition();
    }
    
    private void setDefaultMapPosition()
    {
    	GoogleMap map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
    	
    	if (map != null)
    	{
    		Log.v(LOG_DESCRIPTION, "map object available.");
    		
    		// set vienna as the center point of the map
    		map.moveCamera(CameraUpdateFactory.newLatLngZoom(VIENNA, DEFAULT_ZOOM));
    		//map.animateCamera(CameraUpdateFactory.zoomIn());
    		
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
    
}
