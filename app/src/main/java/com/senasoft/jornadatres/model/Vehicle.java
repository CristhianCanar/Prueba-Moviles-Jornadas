package com.senasoft.jornadatres.model;

public class Vehicle {

    private int idVehicle;
    private String marcaVehicle;
    private String colorVehicle;
    private String placaVehicle;
    private String ciudadVehicle;
    private String modeloVehicle;
    private String fechaSoatVehicle;

    public Vehicle() {
    }

    public Vehicle(int idVehicle, String marcaVehicle, String colorVehicle, String placaVehicle, String ciudadVehicle, String modeloVehicle, String fechaSoatVehicle) {
        this.idVehicle = idVehicle;
        this.marcaVehicle = marcaVehicle;
        this.colorVehicle = colorVehicle;
        this.placaVehicle = placaVehicle;
        this.ciudadVehicle = ciudadVehicle;
        this.modeloVehicle = modeloVehicle;
        this.fechaSoatVehicle = fechaSoatVehicle;
    }

    public int getIdVehicle() {
        return idVehicle;
    }

    public void setIdVehicle(int idVehicle) {
        this.idVehicle = idVehicle;
    }

    public String getMarcaVehicle() {
        return marcaVehicle;
    }

    public void setMarcaVehicle(String marcaVehicle) {
        this.marcaVehicle = marcaVehicle;
    }

    public String getColorVehicle() {
        return colorVehicle;
    }

    public void setColorVehicle(String colorVehicle) {
        this.colorVehicle = colorVehicle;
    }

    public String getPlacaVehicle() {
        return placaVehicle;
    }

    public void setPlacaVehicle(String placaVehicle) {
        this.placaVehicle = placaVehicle;
    }

    public String getCiudadVehicle() {
        return ciudadVehicle;
    }

    public void setCiudadVehicle(String ciudadVehicle) {
        this.ciudadVehicle = ciudadVehicle;
    }

    public String getModeloVehicle() {
        return modeloVehicle;
    }

    public void setModeloVehicle(String modeloVehicle) {
        this.modeloVehicle = modeloVehicle;
    }

    public String getFechaSoatVehicle() {
        return fechaSoatVehicle;
    }

    public void setFechaSoatVehicle(String fechaSoatVehicle) {
        this.fechaSoatVehicle = fechaSoatVehicle;
    }
}
