package com.salesianostriana.dam.di.aroundme.fragments;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.salesianostriana.dam.di.aroundme.R;
import com.salesianostriana.dam.di.aroundme.adapters.AmigosAdapter;
import com.salesianostriana.dam.di.aroundme.models.AmigosItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by flopez on 29/11/2015.
 */
public class AmigosFragment extends Fragment {

    JSONArray response = new JSONArray();
    Context context;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ArrayList<String> lista;
    ArrayList<String> nueva;

    public AmigosFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_amigos, container, false);
        context=container.getContext();
        mRecyclerView = (RecyclerView) v.findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        new AmigosParseAsyncTask().execute();

        return v;

    }


    private class AmigosParseAsyncTask extends AsyncTask<Void, Void, ArrayList<AmigosItem>> {

        URL url = null;
        String msg = "";
        HttpURLConnection urlConnection = null;
        SharedPreferences prefs = context.getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        String regId;

        @Override
        protected ArrayList<AmigosItem> doInBackground(Void... params) {
            ArrayList<AmigosItem> lista = new ArrayList<>();
            regId = prefs.getString("clave", null);
            try {
                // Coje la URL
                url = new URL("http://rest.miguelcr.com/aroundme/users?regId=" + regId);
                InputStream is = url.openStream();
                Reader reader = new BufferedReader(new InputStreamReader(is));

                StringBuilder sb = new StringBuilder();
                int c;
                while((c = reader.read())!= -1){
                    sb.append((char)c);
                }

                String json_obtenido = sb.toString();

                Log.i("JSON OBTENIDO",json_obtenido);
                JSONArray array = new JSONArray(json_obtenido);
                for (int i = 0; i < array.length(); i++) {
                    JSONObject obj = array.getJSONObject(i);
                    String nombre  = obj.getString("nickname");
                    String avatar = obj.getString("avatar");
                    lista.add(new AmigosItem(nombre,avatar));
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

        @Override
        protected void onPostExecute(ArrayList<AmigosItem> amigosItems) {
            super.onPostExecute(amigosItems);
            mAdapter = new AmigosAdapter(amigosItems);
            mRecyclerView.setAdapter(mAdapter);
        }
    }
}
