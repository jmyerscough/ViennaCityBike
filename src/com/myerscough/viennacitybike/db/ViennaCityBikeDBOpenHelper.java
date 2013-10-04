package com.myerscough.viennacitybike.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @author Jason Myerscough
 * @since 03.10.2013
 */
public class ViennaCityBikeDBOpenHelper extends SQLiteOpenHelper
{
	private static final String DATABASE_NAME = "vcb.db";
	private static final String STATIONS_TABLE = "Stations";
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
				    ViennaCityBikeDatabase.LATITUDE +       " REAL, " +
				    ViennaCityBikeDatabase.DISTRICT_ID +    " INTEGER REFERENCES " + DISTRICTS_TABLE + " (" + ViennaCityBikeDatabase.DISTRICT_ID + ") " +
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

	public ViennaCityBikeDBOpenHelper(Context context, String name,
			CursorFactory factory, int version,
			DatabaseErrorHandler errorHandler) 
	{
		super(context, name, factory, version, errorHandler);
	}

	@Override
	public void onCreate(SQLiteDatabase db) 
	{
		// create the tables
		db.execSQL(CREATE_STATIONS_TABLE);
		db.execSQL(CREATE_STATION_DESCRIPTION_TABLE);
		db.execSQL(CREATE_DISTRICT_TABLE);
		
		// initialise the tables
		populateStationDescriptionTable(db);
		
	}

	/**
	 * 
	 * @param db The DB the method writes to.
	 */
	private void populateStationDescriptionTable(SQLiteDatabase db)
	{
		ContentValues rowValues = new ContentValues();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 1);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Ecke Herrengasse U3 Station Herrengasse links beim Ausgang Fahnengasse");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 2);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Ecke Lichtenfelsgasse U2 Station Rathaus");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 3);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Parkring / Stadtpark beim Haupteingang des Kursalons");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 4);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Urania /Franz Josefs Kai bei Aspernbr�cke U4 Station Schwedenplatz - Ausgang Urania");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 5);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Ecke Akademiestra�e in der Mitte der beiden Einkaufszentren der Ringstra�engalerien");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 6);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Opernring - K�rntnerstra�e U-Bahnstation Karlsplatz - Ausgang Oper");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 7);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Dr. Karl Lueger Ring gegen�ber des Burgtheaters");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 8);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Franz-Josefs-Kai / Ringturm / H�he Werdertorgasse U4 Station Schottenring beim Ausgang Salztorbr�cke");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 9);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Franz-Josefs-Kai / Rotenturmstra�e bei der U-Bahnstation Schwedenplatz - Ausgang Rotenturmstra�e");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 10);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Parkring / Weiskirchner Str. / Stadtpark gegen�ber dem Museum f�r Angewandte Kunst");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 11);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Ecke Schulerstra�e hinter dem Stephansdom");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 12);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Burgring / Volkstheater / Bellaria U2, U3 Station Volkstheater - Ausgang Volksgarten");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 13);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "U-Bahn Aufgang Heinestra�e");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 14);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 15);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Vorgartenstra�e/Trabrennstra�e, Unter U2 Krieau");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 16);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Messeplatz");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 17);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "ENestroyplatz U1");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 18);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Novaragasse/ Glockengasse, U2 Taborstra�e Ausgang Novaragasse");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 19);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Obere Donaustra�e Ecke Herminengasse, U2 Schottenring Ausgang Herminengasse");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 20);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Praterstern Schnellbahnunterf�hrung");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 21);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Meiereistra�e/Vorgartenstra�e, Unter U2 Stadion");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 22);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Prinz Eugen Stra�e gegen�ber 20-22");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 23);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Schnellbahnstation Rennweg");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 24);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 25);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Kundmanngasse vor 2");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 26);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "bei der Schnellbahnunterf�hrung");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 27);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Landstra�er Hauptstra�e beim Rochusmarkt");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 28);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Rennweg / Ecke Zaunergasse vis � vis des Hochstrahlbrunnens");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 29);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Landstra�er Hauptstra�e Nr. 95 bei Galeria");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 30);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Ecke Margaretenstra�e 44");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 31);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Wiedner Hauptstra�e vor 49");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 32);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Vor der TU-Bibliothek, U-Bahn Karlsplatz");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 33);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Margareteng�rtel Ecke Arbeitergasse bei Busstation");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 34);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Kettenbr�ckengasse U4 Station Kettenbr�ckengasse - Ausgang Eggerthgasse");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 35);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "vor Wiedner Hauptstra�e 92");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 36);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "St. Johann Park U4 Station Margareteng�rtel");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 37);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Gr�nwaldgasse gegen�ber 1");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 38);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Hamburgerstra�e U4 Station Pilgramgasse");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 39);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Rechte Wienzeile Ecke Reinprechtsdorferstra�e");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 40);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Siebenbrunnenplatz vor 5");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 41);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "unter U-Bahnbogen H�he Ulmanstra�e");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 42);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Mariahilferstra�e Ecke Kollergerngasse");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 43);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Neubaug�rtel / Burggasse U6 Station Burggasse - Ausgang Burggasse");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 44);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Mariahilfer Stra�e / Museumsquartier U2 Station Museumsquartier");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 45);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "vor der Kirche bei Lerchenfelderstra�e");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 46);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Siebensterngasse vor 38 - 40");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 47);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Neubaug�rtel/M�rzstra�e U6 Station Burggasse - Ausgang Urban Loritz Platz");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 48);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Mariahilferstra�e 104 Ecke Schottenfeldgasse");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 49);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Museumstra�e 7 n�he Neustiftgasse");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 50);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Alser Stra�e ONR 47");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 51);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 52);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 53);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "W�hringer Stra�e Ecke Boltzmanngasse");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 54);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "bei Altem AKH vis � vis Otto-Wagner-Platz");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 55);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Nordbergstra�e Franz Josefs Bahnhof");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 56);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "L�blichgasse gg�. 16 Ecke Lustkandlgasse");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 57);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Nu�dorferstra�e vor 22");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 58);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "U4 Station Rossauer L�nde - Ausgang Nordwest");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 59);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Sensengasse 1 nahe Spitalgasse");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 60);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "W�hringerstra�e Ecke Universit�tsstra�e / Votivkirche Im Park zwischen der Votivkirche und dem Schottentor");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 11);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Nordbergbr�cke bei M�llverbrennungsanlage U4 Station Spittelau - Ausgang Wirtschaftsuniversit�t");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 62);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "U-Bahn Ausgang Storchensteg");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 63);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Meidlinger Hauptstra�e Ecke Edelsinnstra�e");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 64);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "U-Bahnstation Niederhofstra�e vor Reschgassse 24");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 65);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Schlo� Sch�nbrunn gegen�ber Haupteingang");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 66);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Mariahilfer Stra�e 212");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 67);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Johnstra�e gegen�ber 61");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 68);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Felberstra�e 42");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 69);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 70);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 71);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Mariahilfer Stra�e 165 - Ecke Turnergasse");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 72);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 73);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Europaplatz beim Westbahnhof");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 74);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Hofferplatz gegen�ber 8");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 75);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "�usserer Hernalser G�rtel U6 Station Josefst�dterstra�e");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 76);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Paltaufgasse gg�. 16");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 77);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Richard-Wagner-Platz gegen�ber 1");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 78);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 79);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Lerchenfelder G�rtel gg�. 31-33");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 80);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "�usserer Hernalser G�rtel U6 Station Alserstra�e");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 81);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Rosensteingasse vor 76");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 82);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Dornerplatz gegen�ber 11");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 83);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Kalvarienberggasse vor 27");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 84);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Hernalser Hauptstra�e vor 102 Ecke Rosensteingasse");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 85);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Gertrudplatz vor 4");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 86);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "W�hringer G�rtel vor 40 Ecke Kreuzgasse");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 87);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "�usserer W�hringer G�rtel U6 Station Nu�dorfer Stra�e");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 88);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "�usserer  W�hringer G�rtel - Schulgasse U6 Station W�hringer Stra�e");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 89);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Gymasiumstra�e vor 85 (Studentenheim); Ecke Billrothstra�e");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 90);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "zwischen Bus und Bim-Haltestelle");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 91);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Meldemannstra�e 26 Ecke Hellwagstra�e");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 92);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "J�gerstra�e - Leipziger Stra�e U6 Station J�gerstra�e");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();

		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 93);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Am Maria Restituta Platz zwischen Rivergate und Schnellbahn");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();

		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 94);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Dresdnerstra�e vor 85 Ecke Traisengasse");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();		

		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 95);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
	}

	/**
	 * 
	 * @param db The DB to write to.
	 */
	private void populateStationsTable(SQLiteDatabase db)
	{
		ContentValues newRow = new ContentValues();
		
/*	    ViennaCityBikeDatabase.STATION_ID
	    ViennaCityBikeDatabase.STATION_NAME
	    ViennaCityBikeDatabase.TOTAL_BOXE
	    ViennaCityBikeDatabase.FREE_BOXES
	    ViennaCityBikeDatabase.FREE_BIKES
	    ViennaCityBikeDatabase.STATION_STATUS
	    ViennaCityBikeDatabase.DESCRIPTION_ID
	    ViennaCityBikeDatabase.LONGITUDE
	    ViennaCityBikeDatabase.LATITUDE
	    ViennaCityBikeDatabase.DISTRICT_ID */
		
		
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
