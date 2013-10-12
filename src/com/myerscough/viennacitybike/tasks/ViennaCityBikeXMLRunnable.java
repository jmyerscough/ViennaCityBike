package com.myerscough.viennacitybike.tasks;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import android.os.Bundle;
import android.os.Message;
import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import com.myerscough.viennacitybike.MainActivity;
import com.myerscough.viennacitybike.data.BikeStation;
import com.myerscough.viennacitybike.handlers.ReportStatusHandler;

/**
 * 
 * @author Jason Myerscough
 *
 */
public class ViennaCityBikeXMLRunnable implements Runnable
{
	private static final String CLASS_TAG = "ViennaCityBikeXMLRunnable";
	private ReportStatusHandler handler;
	
	public ViennaCityBikeXMLRunnable(ReportStatusHandler handler)
	{
		this.handler = handler;
	}

	@Override
	public void run()
	{
		String bikeFeed = "http://dynamisch.citybikewien.at/citybike_xml.php";

		informStart();		
		try
		{
			URL url = new URL(bikeFeed);
			
			URLConnection connection = url.openConnection();
			HttpURLConnection httpConnection = (HttpURLConnection)connection;
			int responseCode = httpConnection.getResponseCode();
			
			if (responseCode == HttpURLConnection.HTTP_OK)
			{
				parseXML(httpConnection.getInputStream());
			}
		}
		catch (MalformedURLException e)
		{
			Log.d(CLASS_TAG, String.format("%s", e.getMessage()));
		}
		catch (IOException ioe)
		{
			Log.d(CLASS_TAG, String.format("%s", ioe.getMessage()));
		}
		informFinish();
	}
	
	private void parseXML(InputStream in)
	{
		XmlPullParserFactory xmlFactory;
		
		try
		{
			xmlFactory = XmlPullParserFactory.newInstance();
			xmlFactory.setNamespaceAware(true);
			
			XmlPullParser xpp = xmlFactory.newPullParser();
			
			xpp.setInput(in, null);
			int eventType = xpp.getEventType();
			
			while (eventType != XmlPullParser.END_DOCUMENT)
			{
				if (eventType == XmlPullParser.START_TAG &&
						xpp.getName().equals("station"))
				{
					eventType = xpp.next();
					BikeStation newStation = new BikeStation();
					
					while (!(eventType == XmlPullParser.END_TAG &&
							xpp.getName().equals("station")))
					{
						if (eventType == XmlPullParser.START_TAG)
						{
							if (xpp.getName().equals("internal_id")) {
								newStation.setId(Integer.parseInt(xpp.nextText()));
							} else if (xpp.getName().equals("name")) {
								newStation.setName(xpp.nextText());
							} else if (xpp.getName().equals("boxes")) {
								newStation.setTotalBoxes(Integer.parseInt(xpp.nextText()));
							} else if (xpp.getName().equals("free_boxes")) {
								newStation.setFreeBoxes(Integer.parseInt(xpp.nextText()));
							} else if (xpp.getName().equals("free_bikes")) {
								newStation.setFreeBikes(Integer.parseInt(xpp.nextText()));
							} else if (xpp.getName().equals("status")) {
								newStation.setStatus(xpp.nextText());
							} else if (xpp.getName().equals("description")) {
								newStation.setDescription(xpp.nextText());
							} else if (xpp.getName().equals("latitude")) {
								newStation.setLatitude(Double.parseDouble(xpp.nextText()));
							} else if (xpp.getName().equals("longitude")) {
								newStation.setLongitude(Double.parseDouble(xpp.nextText()));
							}
							eventType = xpp.next();
						}
						eventType = xpp.next();
					}
					sendStationToQueue(newStation);
				}
				eventType = xpp.next();
			}
		}
		catch (XmlPullParserException xppe)
		{
			Log.e(CLASS_TAG, xppe.getMessage());
		}
		catch (IOException ioe)
		{
			Log.e(CLASS_TAG, String.format("%s", ioe.getMessage()));
		}
	}
	
	private void informStart()
	{
		Message msg = handler.obtainMessage();
		Bundle bundle = new Bundle();
		
		bundle.putString("status", "started querying web service.");
		msg.setData(bundle);
		handler.sendMessage(msg);
	}
	
	private void sendStationToQueue(BikeStation station)
	{
		Message msg = handler.obtainMessage();
		Bundle bundle = new Bundle();
		
		bundle.putParcelable("station", station);
		msg.setData(bundle);
		handler.sendMessage(msg);
	}
	
	private void informFinish()
	{
		Message msg = handler.obtainMessage();
		Bundle bundle = new Bundle();
		
		bundle.putString("status", "finished querying web service.");
		msg.setData(bundle);
		handler.sendMessage(msg);
	}
}
