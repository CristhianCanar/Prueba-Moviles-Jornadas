package com.senasoft.jornadatres.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

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
        values.put(Constantes.NAME_COLUMN_2, String.valueOf(person.getFechaNacPerson()));
        values.put(Constantes.NAME_COLUMN_3, person.getCorreoPerson());
        values.put(Constantes.NAME_COLUMN_4, String.valueOf(person.getFechaVencLicencia()));

        long insert = db.insert(Constantes.NAME_TABLE_1, null, values);

        close();

        return insert;

    }

    public long insertService1(){

        openWr();

        Services services = new Services();

        services.setServ1(0);
        services.setServ2(0);
        services.setServ3(0);
        services.setServ4(0);

        ContentValues values = new ContentValues();

        values.put(Constantes.NAME_COLUMN_11, services.getServ1());
        values.put(Constantes.NAME_COLUMN_12, services.getServ2());
        values.put(Constantes.NAME_COLUMN_13, services.getServ3());
        values.put(Constantes.NAME_COLUMN_14, services.getServ4());

        long insert = db.insert(Constantes.NAME_TABLE_3, null, values);

        close();

        return insert;
    }

    public List<Services> listServices(){

        openRd();

        ArrayList<Services> list = new ArrayList<>();

        Cursor cursor = db.rawQuery("SELECT * FROM " + Constantes.NAME_TABLE_3, null);

        if (cursor.moveToFirst()){
            do {

                Services services = new Services();

                services.setServ1(cursor.getInt(0));
                services.setServ2(cursor.getInt(1));
                services.setServ3(cursor.getInt(2));
                services.setServ4(cursor.getInt(3));

            }while (cursor.moveToNext());
        }

        close();

        return list;
    }

    public long insertVehiculo(Vehicle vehicle){

        openWr();

        ContentValues values = new ContentValues();

        values.put(Constantes.NAME_COLUMN_5, vehicle.getMarcaVehicle());
        values.put(Constantes.NAME_COLUMN_6, vehicle.getColorVehicle());
        values.put(Constantes.NAME_COLUMN_7, vehicle.getPlacaVehicle());
        values.put(Constantes.NAME_COLUMN_8, vehicle.getCiudadVehicle());
        values.put(Constantes.NAME_COLUMN_9, vehicle.getModeloVehicle());
        values.put(Constantes.NAME_COLUMN_10, vehicle.getFechaSoatVehicle());

        long insert = db.insert(Constantes.NAME_TABLE_2, null, values);

        close();

        return insert;

    }


    public List<Person> listPerson() throws ParseException {

        openRd();

        Date date;

        ArrayList<Person> list = new ArrayList<>();

        Cursor cursor = db.rawQuery("SELECT * FROM " + Constantes.NAME_TABLE_1, null);


        if (cursor.moveToFirst()){
            do {

                Person person = new Person();

                person.setNombrePerson(cursor.getString(1));
                person.setFechaNacPerson(date = new SimpleDateFormat("dd/mm/yy").parse(cursor.getString(2)));
                person.setCorreoPerson(cursor.getString(3));
                person.setFechaVencLicencia(date = new SimpleDateFormat("dd/mm/yy").parse(cursor.getString(4)));

                list.add(person);

            }while(cursor.moveToNext());
        }

        close();


        return list;

    }

    public List<Vehicle> listVehiculo(){

        openRd();

        Date date;

        ArrayList<Vehicle> list = new ArrayList<>();

        Cursor cursor = db.rawQuery("SELECT * FROM " + Constantes.NAME_TABLE_2, null);


        if (cursor.moveToFirst()){
            do {

                Vehicle vehicle = new Vehicle();

                try {
                    vehicle.setMarcaVehicle(cursor.getString(1));
                    vehicle.setColorVehicle(cursor.getString(2));
                    vehicle.setPlacaVehicle(cursor.getString(3));
                    vehicle.setCiudadVehicle(cursor.getString(4));
                    vehicle.setModeloVehicle(cursor.getString(5));
                    vehicle.setFechaSoatVehicle(cursor.getString(6));
                }catch (Exception e){
                    e.printStackTrace();
                }


                list.add(vehicle);

            }while(cursor.moveToNext());
        }

        close();

        return list;

    }

    public long updateService(int id, String column, int value){

        openWr();

        String[] data = {String.valueOf(id)};

        ContentValues values = new ContentValues();

        values.put(column, value);

        long update = db.update(Constantes.NAME_TABLE_2, values, Constantes.NAME_COLUMN_ID+ "=?", data);

        close();

        return update;
    }

}
