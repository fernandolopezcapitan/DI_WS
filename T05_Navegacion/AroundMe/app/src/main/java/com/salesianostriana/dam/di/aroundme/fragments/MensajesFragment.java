package com.salesianostriana.dam.di.aroundme.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.salesianostriana.dam.di.aroundme.R;
import com.salesianostriana.dam.di.aroundme.adapters.MensajesAdapter;
import com.salesianostriana.dam.di.aroundme.models.MensajesItem;

import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by flopez on 29/11/2015.
 */
public class MensajesFragment extends Fragment {

    JSONArray response = new JSONArray();
    Context context;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<MensajesItem> mensajes;


    public MensajesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_mensajes, container, false);
        mRecyclerView = (RecyclerView) v.findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        new GetnParseMensajesTask().execute();

        /*
        mensajes = new ArrayList();
        mensajes.add(new MensajesItem("Luís", "Mensaje 1",R.drawable.ic_recibido));
        mensajes.add(new MensajesItem("Pepe", "Mensaje 2",R.drawable.ic_recibido));
        mensajes.add(new MensajesItem("Manolo", "Mensaje 3",R.drawable.ic_enviado));
        */

        // specify an adapter (see also next example)
        //mAdapter = new MensajesAdapter(mensajes);
        //mRecyclerView.setAdapter(mAdapter);

        return v;
    }

    private class GetnParseMensajesTask extends AsyncTask<Void, Void, List<MensajesItem>> {


        URL url = null;
        HttpURLConnection urlConnection = null;
        SharedPreferences prefs = context.getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        String id;

        @Override
        protected List<MensajesItem> doInBackground(Void... params) {
            id = prefs.getString("REGISTRATION_ID", null);

            List<MensajesItem> result = new ArrayList<MensajesItem>();

            try {
                url = new URL("http://miguelcr.hol.es/talkme/mensajes?regId=" + id.replace(" ", ""));
                BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));

                Gson gson = new Gson();
                MensajesItem[] mensajes = gson.fromJson(br, MensajesItem[].class);
                if (mensajes.length > 0) {
                    result = Arrays.asList(mensajes);
                } else {
                    result.add(new MensajesItem("No has recibido ningún mensaje", ""));
                }
               /* String responseString = readStream(urlConnection.getInputStream());
                response = new JSONArray(responseString);
                listaMensajes = new ArrayList();


                for (int i = 0; i < response.length(); i++) {

                    String user = response.getJSONObject(i).getString("from");
                    String mensaje = response.getJSONObject(i).getString("mensaje");

                    ItemMensaje m = new ItemMensaje(user,mensaje);

                    listaMensajes.add(m);

                }
*/

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return result;
        }
        @Override
        protected void onPostExecute(List<MensajesItem> lista) {
            super.onPostExecute(lista);

            mRecyclerView.setAdapter(new MensajesAdapter(context, lista));


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
