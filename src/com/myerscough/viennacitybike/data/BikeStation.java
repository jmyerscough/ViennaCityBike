package com.myerscough.viennacitybike.data;

import com.google.android.gms.maps.model.LatLng;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 
 * @author Jason Myerscough
 * @since 12.10.2013
 *
 */
public class BikeStation implements Parcelable
{
	private int id;
	private String name;
	private int totalBoxes;
	private int freeBoxes;
	private int freeBikes;
	private String status;
	private String description;
	private double latitude;
	private double longitude;
	
	public BikeStation()
	{
		
	}
	
	public BikeStation(int id, String name, int totalBoxes, int freeBoxes, 
			int freeBikes, String status, String description, double latitude, double longitude)
	{
		this.id = id;
		this.name = name;
		this.totalBoxes= totalBoxes;
		this.freeBoxes = freeBoxes;
		this.freeBikes = freeBikes;
		this.status = status;
		this.description = description;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public int getId()
	{
		return id;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getTotalBoxes()
	{
		return totalBoxes;
	}
	
	public int getFreeBoxes()
	{
		return freeBoxes;
	}
	
	public int getFreeBikes()
	{
		return freeBikes;
	}
	
	public String getStatus()
	{
		return status;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public LatLng getLocation()
	{
		LatLng loc = new LatLng(longitude, latitude);
		return loc;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setTotalBoxes(int totalBoxes)
	{
		this.totalBoxes = totalBoxes;
	}
	
	public void setFreeBoxes(int freeBoxes)
	{
		this.freeBoxes = freeBoxes;
	}
	
	public void setFreeBikes(int freeBikes)
	{
		this.freeBikes = freeBikes;
	}
	
	public void setStatus(String status)
	{
		this.status = status;
	}
	
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	public void setLongitude(double longitude)
	{
		this.longitude = longitude;
	}
	
	public void setLatitude(double latitude)
	{
		this.latitude = latitude;
	}
	
	public static final Parcelable.Creator<BikeStation> CREATOR
		= new Parcelable.Creator<BikeStation>()
		{
			public BikeStation createFromParcel(Parcel in)
			{
				return new BikeStation(in);
			}

			@Override
			public BikeStation[] newArray(int size)
			{
				return new BikeStation[size];
			}
		};

	@Override
	public int describeContents() 
	{
		return 0;
	}

	@Override
	public void writeToParcel(Parcel out, int flags)
	{
		out.writeInt(getId());
		out.writeString(getName());
		out.writeInt(getTotalBoxes());
		out.writeInt(getFreeBoxes());
		out.writeInt(getFreeBikes());
		out.writeString(getStatus());
		out.writeString(getDescription());
		out.writeDouble(latitude);
		out.writeDouble(longitude);
	}
	
	private BikeStation(Parcel in)
	{
		setId(in.readInt());
		setName(in.readString());
		setTotalBoxes(in.readInt());
		setFreeBoxes(in.readInt());
		setFreeBikes(in.readInt());
		setStatus(in.readString());
		setDescription(in.readString());
		setLatitude(in.readDouble());
		setLongitude(in.readDouble());
	}

}
