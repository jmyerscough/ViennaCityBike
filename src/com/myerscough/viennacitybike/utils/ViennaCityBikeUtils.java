package com.myerscough.viennacitybike.utils;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class ViennaCityBikeUtils 
{
	/**
	 * Iterates all network infos and returns true if one of them is available for
	 * sending data.
	 * @param activity
	 * @return true if a network connection exists. Otherwise, flase is returned.
	 * @author Jason Myerscough
	 */
	public static boolean isDeviceOnline(Activity activity)
	{
		ConnectivityManager cm = (ConnectivityManager)activity.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo [] netInfo = cm.getAllNetworkInfo();
		
		if (netInfo != null)
		{
			for (int i=0; i < netInfo.length; i++)
			{
				if (netInfo[i].isConnected())
					return true;
			}
		}
		return false;
	}
}
