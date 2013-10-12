package com.myerscough.viennacitybike.tasks;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import android.R;
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
		ArrayList<BikeStation> stations = new ArrayList<BikeStation>();

		informStart();		
		try
		{
			URL url = new URL(bikeFeed);
			
			URLConnection connection = url.openConnection();
			HttpURLConnection httpConnection = (HttpURLConnection)connection;
			int responseCode = httpConnection.getResponseCode();
			
			if (responseCode == HttpURLConnection.HTTP_OK)
			{
				stations = parseXML(httpConnection.getInputStream());
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
		
		informFinish(stations);
	}
	
	private ArrayList<BikeStation> parseXML(InputStream in)
	{
		XmlPullParserFactory xmlFactory;
		ArrayList<BikeStation> stations = null;
		
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
					
					if (stations == null)
						stations = new ArrayList<BikeStation>();
					
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
					stations.add(newStation);
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
		
		return stations;
	}
	
	private void informStart()
	{
	}
	
	private void informFinish(ArrayList<BikeStation> stations)
	{
		
	}
}
