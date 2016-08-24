package com.example.ricki.neroactualizado.models;

import java.io.Serializable;

/**
 * Created by Sammy on 26/07/2016.
 */
public class Dia implements Serializable {

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

    public Dia(){}
    public Dia(String nombredia) {
        this.nombredia = nombredia;

    }

    public String getNombredia() {
        return nombredia;
    }

    public void setNombredia(String nombredia) {
        this.nombredia = nombredia;
    }


    public String getAsigcod() {
        return asigcod;
    }

    public void setAsigcod(String asigcod) {
        this.asigcod = asigcod;
    }

    public String getNomasig() {
        return nomasig;
    }

    public void setNomasig(String nomasig) {
        this.nomasig = nomasig;
    }

    public String getCodigocra() {
        return codigocra;
    }

    public void setCodigocra(String codigocra) {
        this.codigocra = codigocra;
    }

    public String getGrupocod() {
        return grupocod;
    }

    public void setGrupocod(String grupocod) {
        this.grupocod = grupocod;
    }

    public String getDianombre() {
        return dianombre;
    }

    public void setDianombre(String dianombre) {
        this.dianombre = dianombre;
    }

    public String getHora() {
        return hora;
    }

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

    public String getEdinombre() {
        return edinombre;
    }

    public void setEdinombre(String edinombre) {
        this.edinombre = edinombre;
    }

    public String getSalnombre() {
        return salnombre;
    }

    public void setSalnombre(String salnombre) {
        this.salnombre = salnombre;
    }

    public String getDocente() {
        return docente;
    }

    public void setDocente(String docente) {
        this.docente = docente;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

}
