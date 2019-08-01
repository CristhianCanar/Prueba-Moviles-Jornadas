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
}
