package com.senasoft.jornadatres.model;

import java.util.Date;

public class Person {

    private int idPerson;
    private String nombrePerson;
    private Date fechaNacPerson;
    private String correoPerson;
    private Date fechaVencLicencia;

    public Person() {
    }

    public Person(int idPerson, String nombrePerson, Date fechaNacPerson, String correoPerson, Date fechaVencLicencia) {
        this.idPerson = idPerson;
        this.nombrePerson = nombrePerson;
        this.fechaNacPerson = fechaNacPerson;
        this.correoPerson = correoPerson;
        this.fechaVencLicencia = fechaVencLicencia;
    }


    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public String getNombrePerson() {
        return nombrePerson;
    }

    public void setNombrePerson(String nombrePerson) {
        this.nombrePerson = nombrePerson;
    }

    public Date getFechaNacPerson() {
        return fechaNacPerson;
    }

    public void setFechaNacPerson(Date fechaNacPerson) {
        this.fechaNacPerson = fechaNacPerson;
    }

    public String getCorreoPerson() {
        return correoPerson;
    }

    public void setCorreoPerson(String correoPerson) {
        this.correoPerson = correoPerson;
    }

    public Date getFechaVencLicencia() {
        return fechaVencLicencia;
    }

    public void setFechaVencLicencia(Date fechaVencLicencia) {
        this.fechaVencLicencia = fechaVencLicencia;
    }
}
