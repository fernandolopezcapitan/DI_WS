package com.salesianostriana.di.lopez_capitan_fernando_examendi;

/**
 * Created by flopez on 30/10/2015.
 */
public class EmailItem {
    String icono, nombre, comentarios;

    public EmailItem(String icono, String nombre, String comentarios) {
        this.icono = icono;
        this.nombre = nombre;
        this.comentarios = comentarios;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
}
