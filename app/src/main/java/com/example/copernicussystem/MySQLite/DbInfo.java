package com.example.copernicussystem.MySQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class DbInfo extends DbMyPaginaWeb{

    Context context;

    public DbInfo(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public boolean comprobarInfo(int id){
        DbMyPaginaWeb dbPagina = new DbMyPaginaWeb(context);
        SQLiteDatabase db = dbPagina.getWritableDatabase();

        boolean Info;
        Cursor cursorInfo;

        cursorInfo = db.rawQuery("SELECT * FROM " + TABLE_INFO + " WHERE id = " + id + " LIMIT 1", null);

        if (cursorInfo.moveToFirst()) {
            Info = true;
        }else{
            Info = false;
        }

        cursorInfo.close();

        return Info;
    }

    public String verInfo(int id) {

        DbMyPaginaWeb dbPagina = new DbMyPaginaWeb(context);
        SQLiteDatabase db = dbPagina.getWritableDatabase();

        String Info = null;
        Cursor cursorInfo;

        cursorInfo = db.rawQuery("SELECT * FROM " + TABLE_INFO + " WHERE id = " + id + " LIMIT 1", null);

        if (cursorInfo.moveToFirst()) {
            Info = cursorInfo.getString(1);
        }

        cursorInfo.close();

        return Info;
    }

    public long insertarInfo(int id, String textoC) {

        long status = 0;

        try {
            DbMyPaginaWeb dbPagina = new DbMyPaginaWeb(context);
            SQLiteDatabase db = dbPagina.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("id", id);
            values.put("textoC", textoC);

            status = db.insert(TABLE_INFO, null, values);
        } catch (Exception ex) {
            ex.toString();
        }

        return status;
    }

    public boolean editarInfo(int id, String textoC) {

        boolean correcto = false;

        DbMyPaginaWeb dbPagina = new DbMyPaginaWeb(context);
        SQLiteDatabase db = dbPagina.getWritableDatabase();

        try {
            db.execSQL("UPDATE " + TABLE_INFO + " SET textoC = '" + textoC + "' WHERE id = " + id + "");
            correcto = true;
        } catch (Exception ex) {
            ex.toString();
            correcto = false;
        } finally {
            db.close();
        }

        return correcto;
    }

}
