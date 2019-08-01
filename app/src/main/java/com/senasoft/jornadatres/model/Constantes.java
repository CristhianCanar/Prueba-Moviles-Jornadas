package com.senasoft.jornadatres.model;

public class Constantes {

    public static String NAME_DB = "GESTION.DB";
    public static int VERSION_DB = 1;

    public static String NAME_TABLE_1 = "PERSONA";

    public static String NAME_COLUMN_ID = "ID";
    public static String NAME_COLUMN_1 = "NOMBRE";
    public static String NAME_COLUMN_2 = "FECHANACIMIENTO";
    public static String NAME_COLUMN_3 = "CORREOELECTRONICO";
    public static String NAME_COLUMN_4 = "FECHAVENCIMIENTOLICENCIA";

    public static String CREATE_TABLE_1 = "CREATE TABLE " + NAME_TABLE_1 + "(" +NAME_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT" +
                                            NAME_COLUMN_1 + " TEXT," + NAME_COLUMN_2 + " TEXT," + NAME_COLUMN_3 + " TEXT, " +
                                            NAME_COLUMN_4 + " TEXT)";

    public static String DROP_TABLE_1 = "DROP TABLE IF EXISTS " + NAME_TABLE_1;


    public static String NAME_TABLE_2 = "AUTOS";

    public static String NAME_COLUMN_5 = "MARCA";
    public static String NAME_COLUMN_6 = "COLOR";
    public static String NAME_COLUMN_7 = "PLACA";
    public static String NAME_COLUMN_8 = "CIUDAD";
    public static String NAME_COLUMN_9 = "MODELO";
    public static String NAME_COLUMN_10 = "FECHASOAT";

    public static String CREATE_TABLE_2 = "CREATE TABLE " + NAME_TABLE_2 + "(" + NAME_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                                            NAME_COLUMN_5 + " TEXT, " + NAME_COLUMN_6 + " TEXT, " + NAME_COLUMN_7 + " TEXT, "+ NAME_COLUMN_8 + " TEXT, "
                                            + NAME_COLUMN_9 + " TEXT, "+ NAME_COLUMN_10 + " TEXT)";

    public static String DROP_TABLE_2 = "DROP TABLE IF EXISTS " + NAME_TABLE_2;

    public static String NAME_TABLE_3 = "SEVICIOS";

    public static String NAME_COLUMN_11 = "SERV1";
    public static String NAME_COLUMN_12 = "SERV2";
    public static String NAME_COLUMN_13 = "SERV3";
    public static String NAME_COLUMN_14 = "SERV4";

    public static String CREATE_TABLE_3 = "CREATE TABLE " + NAME_TABLE_3 + "(" + NAME_COLUMN_11 + " NUMERIC," + NAME_COLUMN_12 + " NUMERIC,"
                                            + NAME_COLUMN_13 + " NUMERIC, " + NAME_COLUMN_14 + " NUMERIC)";


    public static String DROP_TABLE_3 = "DROP TABLE IF EXISTS " + NAME_TABLE_3;

}
