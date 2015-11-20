package com.salesianostriana.dam.di.talkmev1.models;

/**
 * Created by flopez on 19/11/2015.
 */
public class MensajesItem {

    String remitente, mensaje;
    int icon;

    public MensajesItem(String remitente, String mensaje, int icon) {
        this.remitente = remitente;
        this.mensaje = mensaje;
        this.icon = icon;
    }

    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
