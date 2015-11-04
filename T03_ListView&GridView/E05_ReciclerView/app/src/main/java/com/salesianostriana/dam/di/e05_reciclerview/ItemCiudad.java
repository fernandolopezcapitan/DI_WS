package com.salesianostriana.dam.di.e05_reciclerview;

/**
 * Created by MariaJose on 04/11/2015.
 */
public class ItemCiudad {
    private String ciudad;
    private int habitantes, imagen, puntuacion, aeropuerto;

    public ItemCiudad(String ciudad, int habitantes, int imagen, int puntuacion, int aeropuerto) {
        this.ciudad = ciudad;
        this.habitantes = habitantes;
        this.imagen = imagen;
        this.puntuacion = puntuacion;
        this.aeropuerto = aeropuerto;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getHabitantes() {
        return habitantes;
    }

    public void setHabitantes(int habitantes) {
        this.habitantes = habitantes;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public int isAeropuerto() {
        return aeropuerto;
    }

    public void setAeropuerto(int aeropuerto) {
        this.aeropuerto = aeropuerto;
    }
}
