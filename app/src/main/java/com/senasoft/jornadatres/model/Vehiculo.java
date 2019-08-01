package com.senasoft.jornadatres.model;

import java.util.Date;

public class Vehiculo {

    private int id;
    private String marca;
    private String color;
    private String placa;
    private String ciudad;
    private String modelo;
    private Date fechaSoat;

    public Vehiculo() {
    }

    public Vehiculo(int id, String marca, String color, String placa, String ciudad, String modelo, Date fechaSoat) {
        this.id = id;
        this.marca = marca;
        this.color = color;
        this.placa = placa;
        this.ciudad = ciudad;
        this.modelo = modelo;
        this.fechaSoat = fechaSoat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Date getFechaSoat() {
        return fechaSoat;
    }

    public void setFechaSoat(Date fechaSoat) {
        this.fechaSoat = fechaSoat;
    }
}
