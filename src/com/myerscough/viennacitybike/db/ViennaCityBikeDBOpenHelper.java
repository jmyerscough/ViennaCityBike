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
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Urania /Franz Josefs Kai bei Aspernbrücke U4 Station Schwedenplatz - Ausgang Urania");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 5);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Ecke Akademiestraße in der Mitte der beiden Einkaufszentren der Ringstraßengalerien");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 6);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Opernring - Kärntnerstraße U-Bahnstation Karlsplatz - Ausgang Oper");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 7);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Dr. Karl Lueger Ring gegenüber des Burgtheaters");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 8);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Franz-Josefs-Kai / Ringturm / Höhe Werdertorgasse U4 Station Schottenring beim Ausgang Salztorbrücke");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 9);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Franz-Josefs-Kai / Rotenturmstraße bei der U-Bahnstation Schwedenplatz - Ausgang Rotenturmstraße");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 10);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Parkring / Weiskirchner Str. / Stadtpark gegenüber dem Museum für Angewandte Kunst");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 11);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Ecke Schulerstraße hinter dem Stephansdom");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 12);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Burgring / Volkstheater / Bellaria U2, U3 Station Volkstheater - Ausgang Volksgarten");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 13);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "U-Bahn Aufgang Heinestraße");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 14);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 15);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Vorgartenstraße/Trabrennstraße, Unter U2 Krieau");
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
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Novaragasse/ Glockengasse, U2 Taborstraße Ausgang Novaragasse");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 19);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Obere Donaustraße Ecke Herminengasse, U2 Schottenring Ausgang Herminengasse");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 20);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Praterstern Schnellbahnunterführung");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 21);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Meiereistraße/Vorgartenstraße, Unter U2 Stadion");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 22);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Prinz Eugen Straße gegenüber 20-22");
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
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "bei der Schnellbahnunterführung");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 27);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Landstraßer Hauptstraße beim Rochusmarkt");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 28);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Rennweg / Ecke Zaunergasse vis à vis des Hochstrahlbrunnens");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 29);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Landstraßer Hauptstraße Nr. 95 bei Galeria");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 30);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Ecke Margaretenstraße 44");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 31);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Wiedner Hauptstraße vor 49");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 32);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Vor der TU-Bibliothek, U-Bahn Karlsplatz");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 33);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Margaretengürtel Ecke Arbeitergasse bei Busstation");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 34);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Kettenbrückengasse U4 Station Kettenbrückengasse - Ausgang Eggerthgasse");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 35);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "vor Wiedner Hauptstraße 92");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 36);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "St. Johann Park U4 Station Margaretengürtel");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 37);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Grünwaldgasse gegenüber 1");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 38);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Hamburgerstraße U4 Station Pilgramgasse");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 39);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Rechte Wienzeile Ecke Reinprechtsdorferstraße");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 40);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Siebenbrunnenplatz vor 5");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 41);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "unter U-Bahnbogen Höhe Ulmanstraße");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 42);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Mariahilferstraße Ecke Kollergerngasse");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 43);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Neubaugürtel / Burggasse U6 Station Burggasse - Ausgang Burggasse");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 44);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Mariahilfer Straße / Museumsquartier U2 Station Museumsquartier");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 45);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "vor der Kirche bei Lerchenfelderstraße");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 46);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Siebensterngasse vor 38 - 40");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 47);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Neubaugürtel/Märzstraße U6 Station Burggasse - Ausgang Urban Loritz Platz");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 48);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Mariahilferstraße 104 Ecke Schottenfeldgasse");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 49);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Museumstraße 7 nähe Neustiftgasse");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 50);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Alser Straße ONR 47");
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
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Währinger Straße Ecke Boltzmanngasse");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 54);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "bei Altem AKH vis à vis Otto-Wagner-Platz");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 55);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Nordbergstraße Franz Josefs Bahnhof");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 56);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Löblichgasse ggü. 16 Ecke Lustkandlgasse");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 57);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Nußdorferstraße vor 22");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 58);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "U4 Station Rossauer Lände - Ausgang Nordwest");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 59);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Sensengasse 1 nahe Spitalgasse");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 60);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Währingerstraße Ecke Universitätsstraße / Votivkirche Im Park zwischen der Votivkirche und dem Schottentor");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 11);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Nordbergbrücke bei Müllverbrennungsanlage U4 Station Spittelau - Ausgang Wirtschaftsuniversität");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 62);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "U-Bahn Ausgang Storchensteg");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 63);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Meidlinger Hauptstraße Ecke Edelsinnstraße");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 64);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "U-Bahnstation Niederhofstraße vor Reschgassse 24");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 65);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Schloß Schönbrunn gegenüber Haupteingang");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 66);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Mariahilfer Straße 212");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 67);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Johnstraße gegenüber 61");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 68);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Felberstraße 42");
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
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Mariahilfer Straße 165 - Ecke Turnergasse");
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
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Hofferplatz gegenüber 8");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 75);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Äusserer Hernalser Gürtel U6 Station Josefstädterstraße");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 76);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Paltaufgasse ggü. 16");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 77);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Richard-Wagner-Platz gegenüber 1");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 78);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 79);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Lerchenfelder Gürtel ggü. 31-33");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 80);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Äusserer Hernalser Gürtel U6 Station Alserstraße");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 81);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Rosensteingasse vor 76");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 82);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Dornerplatz gegenüber 11");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 83);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Kalvarienberggasse vor 27");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 84);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Hernalser Hauptstraße vor 102 Ecke Rosensteingasse");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 85);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Gertrudplatz vor 4");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 86);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Währinger Gürtel vor 40 Ecke Kreuzgasse");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 87);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Äusserer Währinger Gürtel U6 Station Nußdorfer Straße");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 88);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Äusserer  Währinger Gürtel - Schulgasse U6 Station Währinger Straße");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 89);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Gymasiumstraße vor 85 (Studentenheim); Ecke Billrothstraße");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 90);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "zwischen Bus und Bim-Haltestelle");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 91);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Meldemannstraße 26 Ecke Hellwagstraße");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();
		
		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 92);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Jägerstraße - Leipziger Straße U6 Station Jägerstraße");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();

		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 93);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Am Maria Restituta Platz zwischen Rivergate und Schnellbahn");
		db.insert(STATION_DESCRIPTIONS_TABLE, null, rowValues);
		rowValues.clear();

		rowValues.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 94);
		rowValues.put(ViennaCityBikeDatabase.GERMAN_DESCRTIPION, "Dresdnerstraße vor 85 Ecke Traisengasse");
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
	    
		newRow.put(ViennaCityBikeDatabase.STATION_ID, 1021);
		newRow.put(ViennaCityBikeDatabase.STATION_NAME, "Fahnengasse");
		newRow.put(ViennaCityBikeDatabase.TOTAL_BOXES, 18);
		newRow.put(ViennaCityBikeDatabase.FREE_BOXES, 0);
		newRow.put(ViennaCityBikeDatabase.FREE_BIKES, 0);
		newRow.put(ViennaCityBikeDatabase.STATION_STATUS, "aktiv");
		newRow.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 1);
		newRow.put(ViennaCityBikeDatabase.LONGITUDE, 48.209480);
		newRow.put(ViennaCityBikeDatabase.LATITUDE, 16.366085);
		db.insert(STATIONS_TABLE, null, newRow);
		newRow.clear();

		newRow.put(ViennaCityBikeDatabase.STATION_ID, 1026);
		newRow.put(ViennaCityBikeDatabase.STATION_NAME, "Friedrich Schmidtplatz");
		newRow.put(ViennaCityBikeDatabase.TOTAL_BOXES, 20);
		newRow.put(ViennaCityBikeDatabase.FREE_BOXES, 0);
		newRow.put(ViennaCityBikeDatabase.FREE_BIKES, 0);
		newRow.put(ViennaCityBikeDatabase.STATION_STATUS, "aktiv");
		newRow.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 2);
		newRow.put(ViennaCityBikeDatabase.LONGITUDE, 48.210426);
		newRow.put(ViennaCityBikeDatabase.LATITUDE, 16.356100);
		db.insert(STATIONS_TABLE, null, newRow);
		newRow.clear();

		newRow.put(ViennaCityBikeDatabase.STATION_ID, 1029);
		newRow.put(ViennaCityBikeDatabase.STATION_NAME, "Johannesgasse");
		newRow.put(ViennaCityBikeDatabase.TOTAL_BOXES, 20);
		newRow.put(ViennaCityBikeDatabase.FREE_BOXES, 0);
		newRow.put(ViennaCityBikeDatabase.FREE_BIKES, 0);
		newRow.put(ViennaCityBikeDatabase.STATION_STATUS, "aktiv");
		newRow.put(ViennaCityBikeDatabase.DESCRIPTION_ID, 3);
		newRow.put(ViennaCityBikeDatabase.LONGITUDE, 48.203365);
		newRow.put(ViennaCityBikeDatabase.LATITUDE, 16.376719);
		db.insert(STATIONS_TABLE, null, newRow);
		newRow.clear();

		
		/*
INSERT INTO Stations VALUES(1029, '', 20, 10, 9, 'aktiv', 3, , );
INSERT INTO Stations VALUES(1033, 'Julius Raab Platz', 20, 1, 19, 'aktiv', 4, 48.211533, 16.382376);
INSERT INTO Stations VALUES(1028, 'Kärntnerring', 16, 0, 16, 'aktiv', 5, 48.202156, 16.371317);
INSERT INTO Stations VALUES(1055, 'Oper', 18, 1, 17, 'aktiv', 6, 48.202675, 16.369513);
INSERT INTO Stations VALUES(1027, 'Rathausplatz', 20, 10, 10, 'aktiv', 7, 48.209923, 16.360250);
INSERT INTO Stations VALUES(1020, 'Schottenring U4', 21, 0, 20, 'aktiv', 8, 48.215965, 16.372223);
INSERT INTO Stations VALUES(1023, 'Schwedenplatz', 20, 2, 16, 'aktiv', 9, 48.211700, 16.376656);
INSERT INTO Stations VALUES(1024, 'Stadtpark Stubenring', 20, 6, 10, 'aktiv', 10, 48.206821, 16.380445);
INSERT INTO Stations VALUES(1030, 'Stephansplatz', 18, 12, 6, 'aktiv', 11, 48.208515, 16.374044);
INSERT INTO Stations VALUES(1025, 'Volksgarten', 16, 16, 0, 'aktiv', 12, 48.206509, 16.360413);
INSERT INTO Stations VALUES(1069, 'Heinestraße', 38, 0, 38, 'aktiv', 13, 48.218315, 16.390165);
INSERT INTO Stations VALUES(1066, 'Karmeliterplatz', 14, 1, 13, 'aktiv', 14, 48.215679, 16.379656);
INSERT INTO Stations VALUES(1081, 'Krieau', 24, 9, 15, 'aktiv', 15, 48.214382, 16.414371);
INSERT INTO Stations VALUES(1080, 'Messeplatz', 40, 0, 39, 'aktiv', 16, 48.217297, 16.406172);
INSERT INTO Stations VALUES(1065, 'Nepomukgasse', 15, 2, 13, 'aktiv', 17, 48.215878, 16.386209);
INSERT INTO Stations VALUES(1078, 'Novaragasse', 24, 0, 24, 'aktiv', 18, 48.219521, 16.382212);
INSERT INTO Stations VALUES(1077, 'Obere Donaustraße', 20, 1, 19, 'aktiv', 19, 48.217773, 16.373087);
INSERT INTO Stations VALUES(1086, 'Praterstern', 40, 0, 40, 'aktiv', 20, 48.217831, 16.392031);
INSERT INTO Stations VALUES(1082, 'Stadion Center', 40, 30, 10, 'aktiv', 21, 48.209984, 16.421406);
INSERT INTO Stations VALUES(1109, 'Arbeiterkammer', 24, 17, 6, 'aktiv', 22, 48.194630, 16.377123);
INSERT INTO Stations VALUES(1060, 'Fasanplatz', 10, 6, 2, 'aktiv', 23, 48.194241, 16.386581);
INSERT INTO Stations VALUES(1118, 'Juchgasse', 24, 11, 12, 'aktiv', 24, 48.196678, 16.395203);
INSERT INTO Stations VALUES(1105, 'Kundmanngasse', 27, 11, 16, 'aktiv', 25, 48.205685, 16.396009);
INSERT INTO Stations VALUES(1053, 'Radetzkyplatz', 28, 13, 15, 'aktiv', 26, 48.210682, 16.390219);
INSERT INTO Stations VALUES(1062, 'Salmgasse', 18, 8, 10, 'aktiv', 27, 48.203411, 16.389782);
INSERT INTO Stations VALUES(1031, 'Schwarzenbergplatz', 20, 0, 18, 'aktiv', 28, 48.198856, 16.376978);
INSERT INTO Stations VALUES(1059, 'Wassergasse', 20, 19, 1, 'aktiv', 29, 48.199238, 16.394331);
INSERT INTO Stations VALUES(1116, 'Heumühlgasse', 20, 1, 17, 'aktiv', 30, 48.195309, 16.363308);
INSERT INTO Stations VALUES(1104, 'Mayerhofgasse', 19, 7, 10, 'aktiv', 31, 48.192883, 16.367071);
INSERT INTO Stations VALUES(1067, 'Treitlstraße', 20, 2, 18, 'aktiv', 32, 48.199730, 16.368160);
INSERT INTO Stations VALUES(1050, 'Arbeitergasse', 20, 14, 6, 'aktiv', 33, 48.183887, 16.345833);
INSERT INTO Stations VALUES(1042, 'Falco Stiege', 17, 1, 15, 'aktiv', 34, 48.196362, 16.357409);
INSERT INTO Stations VALUES(1064, 'Hartmanngasse', 26, 25, 1, 'aktiv', 35, 48.187183, 16.363899);
INSERT INTO Stations VALUES(1052, 'Margaretengürtel U4', 30, 15, 13, 'aktiv', 36, 48.188477, 16.343868);
INSERT INTO Stations VALUES(1113, 'Matzleinsdorfer Platz', 27, 23, 4, 'aktiv', 37, 48.181549, 16.358011);
INSERT INTO Stations VALUES(1041, 'Pilgramgasse U4', 16, 0, 16, 'aktiv', 38, 48.192703, 16.354706);
INSERT INTO Stations VALUES(1056, 'Reinprechtsdorfer Brücke', 20, 4, 16, 'aktiv', 39, 48.189526, 16.351027);
INSERT INTO Stations VALUES(1107, 'Siebenbrunnenplatz', 26, 12, 13, 'aktiv', 40, 48.185276, 16.353024);
INSERT INTO Stations VALUES(1098, 'Gumpendorfer Gürtel', 27, 9, 18, 'aktiv', 41, 48.189259, 16.338308);
INSERT INTO Stations VALUES(1068, 'Kollergerngasse', 20, 17, 1, 'aktiv', 42, 48.198528, 16.350918);
INSERT INTO Stations VALUES(1044, 'Burggasse U6', 20, 17, 2, 'aktiv', 43, 48.203674, 16.337427);
INSERT INTO Stations VALUES(1032, 'Museumsplatz', 36, 13, 23, 'aktiv', 44, 48.202106, 16.360844);
INSERT INTO Stations VALUES(1045, 'Schottenfeldgasse', 10, 10, 0, 'aktiv', 45, 48.207249, 16.343241);
INSERT INTO Stations VALUES(1076, 'Siebensternplatz', 23, 22, 0, 'aktiv', 46, 48.202160, 16.352034);
INSERT INTO Stations VALUES(1043, 'Urban Loritz Platz', 17, 15, 1, 'aktiv', 47, 48.201035, 16.337727);
INSERT INTO Stations VALUES(1063, 'Webgasse', 14, 14, 0, 'aktiv', 48, 48.196728, 16.343983);
INSERT INTO Stations VALUES(1061, 'Weghuberpark', 20, 19, 1, 'aktiv', 49, 48.206005, 16.356432);
INSERT INTO Stations VALUES(1051, 'Alser Straße/Feldgasse', 12, 7, 5, 50, 48.215225, 16.346449);
INSERT INTO Stations VALUES(1119, 'Althanstraße', 22, 19, 3, 'aktiv', 51, 48.228947, 16.359613);
INSERT INTO Stations VALUES(1120, 'Bauernfeldplatz', 24, 1, 23, 'aktiv', 52, 48.221111, 16.360186);
INSERT INTO Stations VALUES(1037, 'Boltzmanngasse', 20, 16, 1, 'aktiv', 53, 48.220345, 16.356392);
INSERT INTO Stations VALUES(1036, 'Frankhplatz', 20, 18, 0, 'aktiv', 54, 48.215157, 16.355145);
INSERT INTO Stations VALUES(1034, 'Julius-Tandler-Platz', 20, 0, 20, 'aktiv', 55, 48.226086, 16.361919);
INSERT INTO Stations VALUES(1115, 'Löblichgasse', 23, 14, 7, 'aktiv', 56, 48.226433, 16.351347);
INSERT INTO Stations VALUES(1106, 'Markthalle Alsergrund', 24, 5, 19, 'aktiv', 57, 48.225151, 16.354984);
INSERT INTO Stations VALUES(1035, 'Roßauer Lände U4', 28, 7, 20, 'aktiv', 58, 48.222744, 16.367439);
INSERT INTO Stations VALUES(1094, 'Sensengasse', 20, 17, 2, 'aktiv', 59, 48.219296, 16.352484);
INSERT INTO Stations VALUES(1022, 'Sigmund Freud Park', 36, 34, 2, 'aktiv', 60, 48.214592, 16.361395);
INSERT INTO Stations VALUES(1049, 'Spittelau U4/U6', 26, 15, 11, 'aktiv', 61, 48.235207, 16.358744);
INSERT INTO Stations VALUES(1071, 'Längenfeldgasse', 25, 17, 7, 'aktiv', 62, 48.184269, 16.333931);
INSERT INTO Stations VALUES(1073, 'Philadelphiabrücke', 23, 8, 15, 'aktiv', 63, 48.174599, 16.330276);
INSERT INTO Stations VALUES(1072, 'Reschgasse', 15, 5, 10, 'aktiv', 64, 48.180248, 16.330780);
INSERT INTO Stations VALUES(1075, 'Schönbrunn Haupteingang', 40, 38, 1, 'aktiv', 65, 48.186832, 16.314241);
INSERT INTO Stations VALUES(1102, 'Technisches Museum', 31, 29, 2, 'aktiv', 66, 48.190338, 16.318560);
INSERT INTO Stations VALUES(1095, 'Meiselmarkt', 28, 9, 19, 'aktiv', 67, 48.198364, 16.318977);
INSERT INTO Stations VALUES(1092, 'Schmelzbrücke', 24, 7, 17, 'aktiv', 68, 48.196140, 16.330254);
INSERT INTO Stations VALUES(1074, 'Schönbrunner Brücke', 16, 11, 4, 'aktiv', 69, 48.185867, 16.319899);
INSERT INTO Stations VALUES(1091, 'Schwendermarkt', 35, 27, 8, 'aktiv', 70, 48.190819, 16.325500);
INSERT INTO Stations VALUES(1096, 'Turnergasse', 22, 20, 1, 'aktiv', 71, 48.193085, 16.333952);
INSERT INTO Stations VALUES(1103, 'Westbahnhof Europaplatz', 40, 38, 1, 'aktiv', 72, 48.196831, 16.338568);
INSERT INTO Stations VALUES(1058, 'Westbahnhof U6', 29, 28, 0, 'aktiv', 73, 48.197437, 16.338543);
INSERT INTO Stations VALUES(1090, 'Hofferplatz', 32, 31, 0, 'aktiv', 74, 48.209198, 16.333435);
INSERT INTO Stations VALUES(1039, 'Josefstädter Straße U6', 25, 22, 3, 'aktiv', 75, 48.211754, 16.339050);
INSERT INTO Stations VALUES(1114, 'Ottakring U3', 39, 36, 2, 'aktiv', 76, 48.211861, 16.311771);
INSERT INTO Stations VALUES(1089, 'Richard-Wagner-Platz', 25, 14, 11, 'aktiv', 77, 48.210098, 16.327990);
INSERT INTO Stations VALUES(1110, 'Schuhmeierplatz', 24, 22, 2, 'aktiv', 78, 48.210785, 16.318798);
INSERT INTO Stations VALUES(1112, 'Thaliastraße U6', 28, 25, 0, 'aktiv', 79, 48.208019, 16.337940);
INSERT INTO Stations VALUES(1038, 'Alser Straße U6', 23, 22, 1, 'aktiv', 80, 48.216587, 16.341480);
INSERT INTO Stations VALUES(1117, 'Blumengasse', 24, 24, 0, 'aktiv', 81, 48.222816, 16.328497);
INSERT INTO Stations VALUES(1101, 'Dornerplatz', 24, 4, 20, 'aktiv', 82, 48.221260, 16.334530);
INSERT INTO Stations VALUES(1079, 'Elterleinplatz', 16, 14, 1, 'aktiv', 83, 48.218040, 16.332293);
INSERT INTO Stations VALUES(1100, 'Rosensteingasse', 24, 23, 1, 'aktiv', 84, 48.219543, 16.326542);
INSERT INTO Stations VALUES(1111, 'Gertrudplatz', 24, 23, 1, 'aktiv', 85, 48.225712, 16.344202);
INSERT INTO Stations VALUES(1097, 'Michelbeuern', 31, 26, 5, 'aktiv', 86, 48.221817, 16.343716);
INSERT INTO Stations VALUES(1057, 'Nussdorfer Straße U6', 17, 17, 0, 'aktiv', 87, 48.231728, 16.352980);
INSERT INTO Stations VALUES(1048, 'Währinger Straße U6', 20, 14, 6, 'aktiv', 88, 48.224201, 16.349030);
INSERT INTO Stations VALUES(1088, 'Gymnasiumstraße', 26, 23, 2, 'aktiv', 89, 48.236599, 16.348745);
INSERT INTO Stations VALUES(1093, 'Friedrich Engels Platz', 27, 7, 19, 'aktiv', 90, 48.244026, 16.379236);
INSERT INTO Stations VALUES(1083, 'Hellwagstraße', 30, 7, 23, 'aktiv', 91, 48.237465, 16.380316);
INSERT INTO Stations VALUES(1054, 'Jägerstraße U6', 26, 3, 23, 'aktiv', 92, 48.235134, 16.369846);
INSERT INTO Stations VALUES(1087, 'Millenium Tower', 35, 4, 31, 'aktiv', 93, 48.241940, 16.384840);
INSERT INTO Stations VALUES(1085, 'Traisengasse', 24, 13, 10, 'aktiv', 94, 48.233620, 16.383446);
INSERT INTO Stations VALUES(1046, 'Wallensteinplatz', 18, 6, 11, 'aktiv', 95, 48.229912, 16.371582);
		 * 
		 */
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
