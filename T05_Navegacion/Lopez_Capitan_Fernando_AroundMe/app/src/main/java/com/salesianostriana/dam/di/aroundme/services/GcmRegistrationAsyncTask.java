package com.salesianostriana.dam.di.aroundme.services;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;

import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.salesianostriana.dam.di.aroundme.activities.AvatarActivity;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by flopez on 19/11/15.
 */
public class GcmRegistrationAsyncTask extends AsyncTask<String, Void, String> {
    private GoogleCloudMessaging gcm;
    private Context context;
    private String regId;
    JSONArray response = new JSONArray();
    String nick_name;
    String avatar;

    // TODO: change to your own sender ID to Google Developers Console project number, as per instructions above
    private static final String SENDER_ID = "93663396119";

    public GcmRegistrationAsyncTask(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(String... params) {

        String msg = "";
        nick_name = params[0];
        avatar = params[1];
        try {
            if (gcm == null) {
                gcm = GoogleCloudMessaging.getInstance(context);
            }
            regId = gcm.register(SENDER_ID);
            msg = "Device registered, registration ID=" + regId;

            // You should send the registration ID to your server over HTTP,
            // so it can use GCM/HTTP or CCS to send messages to your app.
            // The request to your server should be authenticated if your app
            // is using accounts.
            sendRegistrationIdToBackend();


        } catch (IOException ex) {
            ex.printStackTrace();
            msg = "Error: " + ex.getMessage();
        }
        return msg;
    }

    @Override
    protected void onPostExecute(String msg) {
        Logger.getLogger("REGISTRATION").log(Level.INFO, msg);
        SharedPreferences preferences = context.getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = preferences.edit();
        editor.putString("clave", regId);
        editor.apply();
        editor.commit();

        Intent i = new Intent(context, AvatarActivity.class);
        i.putExtra("clave", regId);
        context.startActivity(i);

    }

    private void sendRegistrationIdToBackend() {
        URL url = null;
        HttpURLConnection urlConnection = null;
        Log.v("CatalogClient", "Entra en sendRegistration");

        try {
            //http://miguelcr.hol.es/talkme/register?regId=REGISTRATION_ID&nickname=NICK_NAME
            url = new URL("http://rest.miguelcr.com/aroundme/register?regId=" + regId+ "&avatar="+avatar+"&nickname="+nick_name);
            //url = new URL("http://weather.miguelcr.com/register.php?regId=" + regId+"&city="+ nick_name);
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
