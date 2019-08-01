package com.senasoft.jornadatres.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class ManagerHelper {

    ControlHelper controlHelper;
    SQLiteDatabase db;

    public ManagerHelper(Context context) {

        this.controlHelper = new ControlHelper(context);

    }


    public void openRd(){

        db = controlHelper.getReadableDatabase();

    }

    public void openWr(){

        db = controlHelper.getWritableDatabase();

    }

    public void close(){

        if (db != null){
            db.close();
        }

    }


    public long insertPerson(Person person){

        openWr();

        ContentValues values = new ContentValues();

        values.put(Constantes.NAME_COLUMN_1, person.getNombrePerson());
        values.put(Constantes.NAME_COLUMN_2, person.getFechaNacPerson());
        values.put(Constantes.NAME_COLUMN_3, person.getCorreoPerson());
        values.put(Constantes.NAME_COLUMN_4, person.getFechaVencLicencia());

        long insert = db.insert(Constantes.NAME_TABLE_1, null, values);

        close();

        return insert;

    }

    public List<Person> listPrson(){

        openRd();

        ArrayList<Person> list = new ArrayList<>();




        close();


        return list;

    }

}
