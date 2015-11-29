package com.salesianostriana.dam.di.aroundme.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.salesianostriana.dam.di.aroundme.R;

import java.util.ArrayList;

import com.salesianostriana.dam.di.aroundme.grid.AdapterAvatar;
import com.salesianostriana.dam.di.aroundme.grid.Avatar;

public class AvatarActivity extends AppCompatActivity {

    private GridView lista;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avatar);

        lista = (GridView)findViewById(R.id.gridView);

        final ArrayList<Avatar> listadoAvatar = new ArrayList<Avatar>();

        listadoAvatar.add(new Avatar("Agent Coulson", R.drawable.agentcoulson1));
        listadoAvatar.add(new Avatar("Black Widow", R.drawable.blackwidow2));
        listadoAvatar.add(new Avatar("Captain America", R.drawable.captainamerica3));
        listadoAvatar.add(new Avatar("Giant Man", R.drawable.giantman4));
        listadoAvatar.add(new Avatar("HawkEye", R.drawable.hawkeye5));
        listadoAvatar.add(new Avatar("Hulk", R.drawable.hulk6));
        listadoAvatar.add(new Avatar("IronMan", R.drawable.ironman7));
        listadoAvatar.add(new Avatar("Loki", R.drawable.loki8));
        listadoAvatar.add(new Avatar("Nick Fury", R.drawable.nickfury9));
        listadoAvatar.add(new Avatar("Thor", R.drawable.thor10));
        listadoAvatar.add(new Avatar("WarMachine", R.drawable.warmachine11));

        final AdapterAvatar adaptador = new AdapterAvatar(this, listadoAvatar);

        lista.setAdapter(adaptador);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Avatar avatarSeleccionado = listadoAvatar.get(position);

                preferences = getSharedPreferences("preferencias", Context.MODE_APPEND);
                final SharedPreferences.Editor editor = preferences.edit();

                editor.putInt("avatar", listadoAvatar.get(position).getUrl_avatar());
                editor.putBoolean("registro", true);
                editor.apply();
                editor.commit();

                Intent i = new Intent(AvatarActivity.this,MainActivity.class);
                i.putExtra("avatar", listadoAvatar.get(position).getUrl_avatar());//Atrapar el avatar y llevarlo al main
                startActivity(i);
                AvatarActivity.this.finish();

                //Solo si hay que actualizar el adaptador(el listado)
                //adaptador.notifyDataSetChanged();
            }
        });
    }
}
