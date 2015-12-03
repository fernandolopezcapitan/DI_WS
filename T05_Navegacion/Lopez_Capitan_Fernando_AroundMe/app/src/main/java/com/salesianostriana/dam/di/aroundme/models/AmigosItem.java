package com.salesianostriana.dam.di.aroundme.models;

/**
 * Created by flopez on 19/11/2015.
 */
public class AmigosItem {

    private String amigos;
    private String avatar;
    private String latlong;

    public AmigosItem(String amigos, String avatar) {
        this.amigos = amigos;
        this.avatar = avatar;
    }

    public AmigosItem(String amigos, String avatar, String latlong) {
        this.amigos = amigos;
        this.avatar = avatar;
        this.latlong = latlong;
    }

    public AmigosItem(String amigos) {
        this.amigos = amigos;
    }

    public String getAmigos() {
        return amigos;
    }

    public void setAmigos(String amigos) {
        this.amigos = amigos;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getLatlong() {
        return latlong;
    }

    public void setLatlong(String latlong) {
        this.latlong = latlong;
    }
}
