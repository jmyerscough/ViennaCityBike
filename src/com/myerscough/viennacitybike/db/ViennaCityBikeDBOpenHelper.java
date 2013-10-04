package com.myerscough.viennacitybike.db;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.myerscough.viennacitybike.R;

/**
 * @author Jason Myerscough
 * @since 03.10.2013
 */
public class ViennaCityBikeDBOpenHelper extends SQLiteOpenHelper
{
	private static final String LOG = "ViennaCityBikeDBOpenHelper";
	private static final String DATABASE_NAME = "vcb.db";
	public static final String STATIONS_TABLE = "Stations";
	private static final String STATION_DESCRIPTIONS_TABLE = "StationDescriptions";
	private static final String DISTRICTS_TABLE = "Districts";
	
	private static final String CREATE_STATIONS_TABLE = "CREATE TABLE " + STATIONS_TABLE + 
			"(" +
				    ViennaCityBikeDatabase.STATION_ID +     "INTEGER PRIMARY KEY ASC," +
				    ViennaCityBikeDatabase.STATION_NAME +   " TEXT, " +
				    ViennaCityBikeDatabase.TOTAL_BOXES +    " INTEGER, " +
				    ViennaCityBikeDatabase.FREE_BOXES +     " INTEGER, " +
				    ViennaCityBikeDatabase.FREE_BIKES +     " INTEGER, " +
				    ViennaCityBikeDatabase.STATION_STATUS + " TEXT, " +
				    ViennaCityBikeDatabase.DESCRIPTION_ID + " INTEGER REFERENCES " + STATION_DESCRIPTIONS_TABLE + " ( " + ViennaCityBikeDatabase.DESCRIPTION_ID + "), " +
				    ViennaCityBikeDatabase.LONGITUDE +      " REAL, " +
				    ViennaCityBikeDatabase.LATITUDE +       " REAL " +
				    /*ViennaCityBikeDatabase.DISTRICT_ID +    " INTEGER REFERENCES " + DISTRICTS_TABLE + " (" + ViennaCityBikeDatabase.DISTRICT_ID + ") " + */
				");";
	
	private static final String CREATE_STATION_DESCRIPTION_TABLE = "CREATE TABLE " + STATION_DESCRIPTIONS_TABLE +
			"(" +
			        ViennaCityBikeDatabase.DESCRIPTION_ID +       " INTEGER PRIMARY KEY, " +
			        ViennaCityBikeDatabase.ENGLISH_DESCRIPTION +  " TEXT, " +
			        ViennaCityBikeDatabase.GERMAN_DESCRTIPION +   " TEXT " +
				");";
	
	private static final String CREATE_DISTRICT_TABLE = "CREATE TABLE " + DISTRICTS_TABLE +
			"(" +
 			        ViennaCityBikeDatabase.DISTRICT_ID +       " INTEGER PRIMARY KEY NOT NULL, " +
 			       ViennaCityBikeDatabase.DISTRICT_NAME +      " TEXT " +
				");";
	
	private static final int DATABASE_VERSION = 1;
	private Context context;
	
	public ViennaCityBikeDBOpenHelper(Context context)
	{
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		this.context = context;
	}

	public ViennaCityBikeDBOpenHelper(Context context, String name,
			CursorFactory factory, int version,
			DatabaseErrorHandler errorHandler) 
	{
		super(context, name, factory, version, errorHandler);
		this.context = context;
	}

	@Override
	public void onCreate(SQLiteDatabase db) 
	{
		// create the tables
		db.execSQL(CREATE_STATIONS_TABLE);
		db.execSQL(CREATE_STATION_DESCRIPTION_TABLE);
		db.execSQL(CREATE_DISTRICT_TABLE);
		
		// initialise the tables
		db.beginTransaction();
		try
		{
			populateStationDescriptionTable(db);
			populateStationsTable(db);
			db.setTransactionSuccessful();
		}
		finally
		{
			db.endTransaction();
		}
	}

	/**
	 * 
	 * @param db The DB the method writes to.
	 */
	private void populateStationDescriptionTable(SQLiteDatabase db)
	{
		try
		{
			insertFromFile(db, R.raw.station_descriptions);
		}
		catch (IOException e)
		{
			Log.v(LOG, e.getMessage());
		}
	}

	/**
	 * 
	 * @param db The DB to write to.
	 */
	private void populateStationsTable(SQLiteDatabase db)
	{
		try
		{
			insertFromFile(db, R.raw.stations);
		}
		catch (IOException e)
		{
			Log.v(LOG, e.getMessage());
		}
	}
	
	/**
	 * Reads the insert statements from file and executes the statements on the DB.
	 * @param db
	 * @param resourceId
	 * @throws IOException
	 */
	private void insertFromFile(SQLiteDatabase db, int resourceId) throws IOException
	{
		InputStream insertStream = context.getResources().openRawResource(resourceId);
		BufferedReader insertReader = new BufferedReader(new InputStreamReader(insertStream));
		
		while (insertReader.ready())
		{
			String insertStmt = insertReader.readLine();
			if (insertStmt.startsWith("INSERT INTO "))
				db.execSQL(insertStmt);
		}
		insertReader.close();
		insertStream.close();
	}
	
	/**
	 * 
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) 
	{
		db.execSQL("DROP TABLE IF IT EXISTS " + STATIONS_TABLE);
		db.execSQL("DROP TABLE IF IT EXISTS " + STATION_DESCRIPTIONS_TABLE);
		db.execSQL("DROP TABLE IF IT EXISTS " + CREATE_DISTRICT_TABLE);
		
		onCreate(db);
	}

}
