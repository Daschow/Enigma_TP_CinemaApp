package com.example.tp.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class InitDatabase {


    public static final class FormEntry implements BaseColumns {

        public static final String TABLE_NAME = "FormID";
        public static final String COLUMN_Film = "Film";
        public static final String COLUMN_DATE = "date";
        public static final String COLUMN_HEURE = "Heure";
        public static final String COLUMN_REALISATEUR = "Realisateur";
        public static final String COLUMN_MUSIQUE = "Musique";
        public static final String COLUMN_SCENARIO = "Scenario";
        public static final String COLUMN_DESCRIPTION = "Description";


    }




}


