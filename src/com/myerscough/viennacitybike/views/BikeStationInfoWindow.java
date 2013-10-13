package com.myerscough.viennacitybike.views;

import android.view.View;

import com.google.android.gms.maps.GoogleMap.InfoWindowAdapter;
import com.google.android.gms.maps.model.Marker;

import com.myerscough.viennacitybike.R;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

/**
 * 
 * @author Jason Myerscough
 */
public class BikeStationInfoWindow implements InfoWindowAdapter
{
	private LayoutInflater inflater;
	
	public BikeStationInfoWindow(LayoutInflater inflater)
	{
		this.inflater = inflater;
	}

	@Override
	public View getInfoContents(Marker marker) 
	{
		return null;
	}

	@Override
	public View getInfoWindow(Marker marker) 
	{
		View popup = inflater.inflate(R.layout.station_popup, null);
		
		TextView txt = (TextView)popup.findViewById(R.id.bikeStationInfoTxt);
		txt.setText(marker.getSnippet());
		
		return popup;
	}

}
