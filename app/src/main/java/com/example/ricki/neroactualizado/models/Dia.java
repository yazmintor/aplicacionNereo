package com.example.ricki.neroactualizado.models;

import java.io.Serializable;

/**
 * Created by Sammy on 26/07/2016.
 */
public class Dia implements Serializable {

// se declaran las variables a utilizar
    private String nombredia;

    private String asigcod;
    private String nomasig;
    private String codigocra;
    private String grupocod;
    private String dianombre;
    private String hora;
    private String horas;
    private String sedenombre;
    private String edinombre;
    private String salnombre;
    private String docente;
    private String apellido;

// se declaran los get y set de cada una de las variables
    public Dia(){}
    public Dia(String nombredia) {
        this.nombredia = nombredia;

    }

    public String getNombredia() {
        return nombredia;
    }
// se hace la adaptacion que envie la  informacion 
    public void setNombredia(String nombredia) {
        this.nombredia = nombredia;
    }
// se hace la adaptacion que envie la  informacion

    public String getAsigcod() {
        return asigcod;
    }
// se hace la adaptacion que envie la  informacion
    public void setAsigcod(String asigcod) {
        this.asigcod = asigcod;
    }

    public String getNomasig() {
        return nomasig;
    }
// se hace la adaptacion que envie la  informacion
    public void setNomasig(String nomasig) {
        this.nomasig = nomasig;
    }

    public String getCodigocra() {
        return codigocra;
    }
// se hace la adaptacion que envie la  informacion
    public void setCodigocra(String codigocra) {
        this.codigocra = codigocra;
    }

    public String getGrupocod() {
        return grupocod;
    }
// se hace la adaptacion que envie la  informacion
    public void setGrupocod(String grupocod) {
        this.grupocod = grupocod;
    }

    public String getDianombre() {
        return dianombre;
    }
// se hace la adaptacion que envie la  informacion
    public void setDianombre(String dianombre) {
        this.dianombre = dianombre;
    }

    public String getHora() {
        return hora;
    }
// se hace la adaptacion que envie la  informacion
    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getHoras() {
        return horas;
    }

    public void setHoras(String horas) {
        this.horas = horas;
    }

    public String getSedenombre() {
        return sedenombre;
    }

    public void setSedenombre(String sedenombre) {
        this.sedenombre = sedenombre;
    }
// se hace la adaptacion que envie la  informacion
    public String getEdinombre() {
        return edinombre;
    }
// se hace la adaptacion que envie la  informacion
    public void setEdinombre(String edinombre) {
        this.edinombre = edinombre;
    }

    public String getSalnombre() {
        return salnombre;
    }
// se hace la adaptacion que envie la  informacion
    public void setSalnombre(String salnombre) {
        this.salnombre = salnombre;
    }

    public String getDocente() {
        return docente;
    }
// se hace la adaptacion que envie la  informacion
    public void setDocente(String docente) {
        this.docente = docente;
    }

    public String getApellido() {
        return apellido;
    }
// se hace la adaptacion que envie la  informacion
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

}
