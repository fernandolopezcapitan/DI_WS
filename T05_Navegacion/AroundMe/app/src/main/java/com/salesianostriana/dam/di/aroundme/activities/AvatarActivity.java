package com.salesianostriana.dam.di.aroundme.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.salesianostriana.dam.di.aroundme.R;
import com.salesianostriana.dam.di.aroundme.grid.AdapterAvatar;
import com.salesianostriana.dam.di.aroundme.grid.Avatar;

import java.util.ArrayList;

public class AvatarActivity extends AppCompatActivity {

    private GridView lista;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avatar);

        lista = (GridView)findViewById(R.id.gridView);

        final ArrayList<Avatar> listadoAvatar = new ArrayList<Avatar>();

        listadoAvatar.add(new Avatar("Agent Coulson", "http://rest.miguelcr.com/images/aroundme/1.png"));
        listadoAvatar.add(new Avatar("Black Widow", "http://rest.miguelcr.com/images/aroundme/2.png"));
        listadoAvatar.add(new Avatar("Captain America", "http://rest.miguelcr.com/images/aroundme/3.png"));
        listadoAvatar.add(new Avatar("Giant Man", "http://rest.miguelcr.com/images/aroundme/4.png"));
        listadoAvatar.add(new Avatar("HawkEye", "http://rest.miguelcr.com/images/aroundme/5.png"));
        listadoAvatar.add(new Avatar("Hulk", "http://rest.miguelcr.com/images/aroundme/6.png"));
        listadoAvatar.add(new Avatar("IronMan", "http://rest.miguelcr.com/images/aroundme/7.png"));
        listadoAvatar.add(new Avatar("Loki", "http://rest.miguelcr.com/images/aroundme/8.png"));
        listadoAvatar.add(new Avatar("Nick Fury", "http://rest.miguelcr.com/images/aroundme/9.png"));
        listadoAvatar.add(new Avatar("Thor", "http://rest.miguelcr.com/images/aroundme/10.png"));
        listadoAvatar.add(new Avatar("WarMachine", "http://rest.miguelcr.com/images/aroundme/11.png"));

        final AdapterAvatar adaptador = new AdapterAvatar(this, listadoAvatar);

        lista.setAdapter(adaptador);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Avatar avatarSeleccionado = listadoAvatar.get(position);

                preferences = getSharedPreferences("preferencias", Context.MODE_APPEND);
                final SharedPreferences.Editor editor = preferences.edit();

                editor.putString("avatar", listadoAvatar.get(position).getUrl_avatar());
                editor.putBoolean("registro", true);
                editor.apply();
                editor.commit();

                Intent i = new Intent(AvatarActivity.this, MainActivity.class);
                i.putExtra("avatar", listadoAvatar.get(position).getUrl_avatar());//Atrapar el avatar y llevarlo al main
                startActivity(i);
                AvatarActivity.this.finish();

                //Solo si hay que actualizar el adaptador(el listado)
                //adaptador.notifyDataSetChanged();
            }
        });
    }
}
