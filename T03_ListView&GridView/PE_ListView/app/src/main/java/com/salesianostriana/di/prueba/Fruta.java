package com.salesianostriana.di.prueba;

/**
 * Created by flopez on 28/10/2015.
 */
public class Fruta {
    private int marcado;
    private String nombre;
    private String comentarios;
    private int estrella;

    public Fruta(int marcado, String nombre, String comentarios, int estrella) {
        this.marcado = marcado;
        this.nombre = nombre;
        this.comentarios = comentarios;
        this.estrella = estrella;
    }

    public int getMarcado() {
        return marcado;
    }

    public void setMarcado(int marcado) {
        this.marcado = marcado;
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

    public int getEstrella() {
        return estrella;
    }

    public void setEstrella(int estrella) {
        this.estrella = estrella;
    }
}
