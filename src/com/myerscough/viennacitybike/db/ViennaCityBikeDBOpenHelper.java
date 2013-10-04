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
