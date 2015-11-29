package com.salesianostriana.dam.di.aroundme.services;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by flopez on 20/11/2015.
 */
public class AmigosAsyncTask extends AsyncTask<Void, Void, ArrayList<String>> {
    Context context;
    JSONArray response;
    ArrayList<String> lista;
    ArrayList<String> nueva;
    URL url = null;
    String msg = "";
    HttpURLConnection urlConnection = null;
    SharedPreferences preferences = context.getSharedPreferences("preferencias", Context.MODE_APPEND);
    String regId;

    @Override
    protected ArrayList<String> doInBackground(Void... params) {
        lista = new ArrayList();

        regId = preferences.getString("regId", null);
        try {
            // Coje la URL
            url=new URL("http://miguelcr.hol.es/talkme/users?regId="+regId);

            // Abre la conexión
            urlConnection=(HttpURLConnection) url.openConnection();

            String responseString = readStream(urlConnection.getInputStream());
            response = new JSONArray(responseString);
            lista = new ArrayList();

            for (int i = 0; i < response.length(); i++){
                String amigos = response.getJSONObject(i).getString("nickname");
                lista.add(amigos);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return lista;
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

    @Override
    protected void onPostExecute(ArrayList<String> strings) {
        if (lista != null){
            nueva = new ArrayList();
            for(int i = 0; i < lista.size(); i++){
                String users = lista.get(i);
                nueva.add(users);
            }

        }

    }
}

