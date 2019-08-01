package com.senasoft.jornadatres.model;

public class Person {

    private int idPerson;
    private String nombrePerson;
    private String fechaNacPerson;
    private String correoPerson;
    private String fechaVencLicencia;

    public Person() {
    }

    public Person(int idPerson, String nombrePerson, String fechaNacPerson, String correoPerson, String fechaVencLicencia) {
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

    public String getFechaNacPerson() {
        return fechaNacPerson;
    }

    public void setFechaNacPerson(String fechaNacPerson) {
        this.fechaNacPerson = fechaNacPerson;
    }

    public String getCorreoPerson() {
        return correoPerson;
    }

    public void setCorreoPerson(String correoPerson) {
        this.correoPerson = correoPerson;
    }

    public String getFechaVencLicencia() {
        return fechaVencLicencia;
    }

    public void setFechaVencLicencia(String fechaVencLicencia) {
        this.fechaVencLicencia = fechaVencLicencia;
    }
}
