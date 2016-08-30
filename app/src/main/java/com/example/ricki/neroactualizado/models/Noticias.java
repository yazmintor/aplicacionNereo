package com.example.ricki.neroactualizado.models;

import android.content.Context;
import android.graphics.Bitmap;

import com.example.ricki.neroactualizado.adapters.ItemAdapterNoticia;
import com.google.gson.JsonElement;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Sammy on 27/08/2016.
 */
public class Noticias implements Serializable {

    private String nombrenoti;
    private String descripcion;
    private String enlace;
    private String fecha_radica;
    private String imagen;



    public String getNombrenoti() {
        return nombrenoti;
    }

    public void setNombrenoti(String nombrenoti) {
        this.nombrenoti = nombrenoti;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEnlace() {
        return enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }

    public String getFecha_radica() {
        return fecha_radica;
    }

    public void setFecha_radica(String fecha_radica) {
        this.fecha_radica = fecha_radica;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
