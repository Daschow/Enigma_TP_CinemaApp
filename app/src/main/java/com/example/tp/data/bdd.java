package com.example.tp.data;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class bdd extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "bdd.db";
    private static final int DATABASE_VERSION = 1;
    private static final String ID = "0";
    public static final String COLUMN_Film = "nom film";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_HEURE = "heure";
    public static final String COLUMN_REALISATEUR = "reali";
    public static final String COLUMN_DESC = "desc";
    public static final String COLUMN_MUSIQUE = "musique";
    public static final String COLUMN_SCENARIO = "scenario";

    public bdd(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        final String SQL_CREATE_TABLE =

                "CREATE TABLE " + InitDatabase.FormEntry.TABLE_NAME + " (" +
                        InitDatabase.FormEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        InitDatabase.FormEntry.COLUMN_Film + " TEXT, "+
                        InitDatabase.FormEntry.COLUMN_DATE + " TEXT, "+
                        InitDatabase.FormEntry.COLUMN_HEURE + " TEXT, "+
                        InitDatabase.FormEntry.COLUMN_REALISATEUR + " INTEGER, "+
                        InitDatabase.FormEntry.COLUMN_MUSIQUE + " INTEGER, "+
                        InitDatabase.FormEntry.COLUMN_SCENARIO + " INTEGER, "+
                        InitDatabase.FormEntry.COLUMN_DESCRIPTION + " TEXT" + ");";
        sqLiteDatabase.execSQL(SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + InitDatabase.FormEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);

    }







}
