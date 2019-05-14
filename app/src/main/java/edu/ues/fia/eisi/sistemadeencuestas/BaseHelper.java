package edu.ues.fia.eisi.sistemadeencuestas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BaseHelper extends SQLiteOpenHelper {
    String tabla="CREATE TABLE ALUMNO(IDALUMNO INTEGER PRIMARY KEY, NOMALUMNO TEXT, APELALUMNO TEXT)";

    public BaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tabla);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table Alumno");
        db.execSQL(tabla);
    }
}
