package com.salesianostriana.di.gestionllamadasapp;


public class Llamadas {
    private String nombre;
    private int numero;
    private String fecha;
    private String restante;
    private int flecha;

    public Llamadas(String nombre, int numero, String fecha, String restante, int flecha) {
        this.nombre = nombre;
        this.numero = numero;
        this.fecha = fecha;
        this.restante = restante;
        this.flecha = flecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getRestante() {
        return restante;
    }

    public void setRestante(String restante) {
        this.restante = restante;
    }

    public int getFlecha() {
        return flecha;
    }

    public void setFlecha(int flecha) {
        this.flecha = flecha;
    }
}
