package com.salesianostriana.dam.di.aroundme.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.salesianostriana.dam.di.aroundme.R;

import org.json.JSONArray;

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
        mRecyclerView = (RecyclerView) v.findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);


        //new AmigosParseAsyncTask().execute();
        //new GcmRegistrationAsyncTask(LoginActivity.this).execute(nick_name.getText().toString());

        // specify an adapter (see also next example)

        return v;

    }

/*
    private class AmigosParseAsyncTask extends AsyncTask<Void, Void, ArrayList<String>> {


        URL url = null;
        String msg = "";
        HttpURLConnection urlConnection = null;
        SharedPreferences prefs = context.getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        String regId;

        @Override
        protected ArrayList<String> doInBackground(Void... params) {
            lista = new ArrayList();


            regId = prefs.getString("regId", null);
            try {
                // Coje la URL
                url = new URL("http://miguelcr.hol.es/talkme/users?regId=" + regId);

                // Abre la conexión
                urlConnection = (HttpURLConnection) url.openConnection();
                String responseString = readStream(urlConnection.getInputStream());
                response = new JSONArray(responseString);
                lista = new ArrayList();

                for (int i = 0; i < response.length(); i++) {
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
            if (lista != null) {
                nueva = new ArrayList();
                for (int i = 0; i < lista.size(); i++) {
                    String users = lista.get(i);
                    nueva.add(users);
                }

            }

        }

    }*/
}
