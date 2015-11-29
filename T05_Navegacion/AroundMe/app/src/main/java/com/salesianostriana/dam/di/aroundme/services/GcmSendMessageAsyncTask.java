package com.salesianostriana.dam.di.aroundme.services;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.salesianostriana.dam.di.aroundme.models.MensajesItem;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class GcmSendMessageAsyncTask extends AsyncTask<MensajesItem, Void, String> {

    private Context context;
    JSONArray response = new JSONArray();

    public GcmSendMessageAsyncTask(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(MensajesItem... params) {

        SharedPreferences prefs = context.getSharedPreferences("preferencias",Context.MODE_PRIVATE);
        String clave = prefs.getString("clave", null);
        MensajesItem msg = params[0];

        if (params[0] !=null)
            sendMessageToBackend(clave, msg.getRemitente(), msg.getMensaje());
            Log.i("ASYNTASK ENVIAR: ", clave + msg.getRemitente() + msg.getMensaje());

        return msg.getRemitente();
    }

    @Override
    protected void onPostExecute(String strings) {
        Toast.makeText(context, "Mensaje enviado a: " + strings, Toast.LENGTH_LONG).show();
    }

    private void sendMessageToBackend(String id, String nick, String mensaje) {
        URL url = null;
        HttpURLConnection urlConnection = null;
        Log.v("CatalogClient", "Entra en sendRegistration");

        try {
            url = new URL("http://miguelcr.hol.es/talkme/send?regId="+id+"&nickname="+nick+"&mensaje="+mensaje);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        try {
            urlConnection = (HttpURLConnection) url.openConnection();

            int responseCode = urlConnection.getResponseCode();

            // Si queremos comprobar si el código HTTP = 200 (OK)
            //if(responseCode == HttpStatusCodes.STATUS_CODE_OK){

            String responseString = readStream(urlConnection.getInputStream());
            Log.v("CatalogClient", responseString);
            try {
                response = new JSONArray(responseString);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            Log.v("CatalogClient", "Error conexión");
            e.printStackTrace();
        } finally {
            urlConnection.disconnect();
        }
    }

    private String readStream(InputStream in) {
        BufferedReader reader = null;
        StringBuffer response = new StringBuffer();
        try {
            reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return response.toString();
    }
}
