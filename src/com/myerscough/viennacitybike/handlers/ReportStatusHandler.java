package com.myerscough.viennacitybike.handlers;

import com.myerscough.viennacitybike.MainActivity;
import com.myerscough.viennacitybike.data.BikeStation;

import android.os.Handler;
import android.os.Message;

/**
 * Processes the messages on a thread queue.
 * 
 * @author Jason Myerscough
 */
public class ReportStatusHandler extends Handler
{
	private static final String CLASS_TAG = "ReportStatusHandler";
	
	private MainActivity mainActivity;
	
	/**
	 * 
	 * @param mainActivity 
	 */
	public ReportStatusHandler(MainActivity mainActivity)
	{
		this.mainActivity = mainActivity;
	}
	
	@Override
	public void handleMessage(Message message)
	{
		super.handleMessage(message);
		BikeStation bikeStation;
		
		if (message.getData().containsKey("station"))
		{
			bikeStation = (BikeStation)message.getData().getParcelable("station");
			if (bikeStation != null)
				mainActivity.addBikeStationToMap(bikeStation);
		}
	}
}
