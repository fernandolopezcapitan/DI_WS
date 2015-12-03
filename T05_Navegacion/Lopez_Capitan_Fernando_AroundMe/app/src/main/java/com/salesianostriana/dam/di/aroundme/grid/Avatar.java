package com.salesianostriana.dam.di.aroundme.grid;

/**
 * Created by flopez on 29/11/2015.
 */
public class Avatar {

    String nombre;
    String url_avatar;

    public Avatar(String nombre, String url_avatar) {
        this.nombre = nombre;
        this.url_avatar = url_avatar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl_avatar() {
        return url_avatar;
    }

    public void setUrl_avatar(String url_avatar) {
        this.url_avatar = url_avatar;
    }
}
