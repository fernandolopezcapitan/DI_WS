package salesianostriana.com.di.talkme;

/**
 * Created by flopez on 19/11/2015.
 */
public class Mensajes_item {

    String remitente, mensaje;
    int icon;

    public Mensajes_item(String remitente, String mensaje, int icon) {
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
