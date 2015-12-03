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
import com.salesianostriana.dam.di.aroundme.services.GcmRegistrationAsyncTask;

import java.util.ArrayList;

public class AvatarActivity extends AppCompatActivity {

    private GridView lista;
    SharedPreferences preferences;

    public static String URL_AVATAR(String num_avatar){
        return "http://rest.miguelcr.com/images/aroundme/"+num_avatar;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avatar);

        lista = (GridView)findViewById(R.id.gridView);
        final ArrayList<Avatar> listadoAvatar = new ArrayList<Avatar>();

        listadoAvatar.add(new Avatar("Agent Coulson", "1.png"));
        listadoAvatar.add(new Avatar("Black Widow", "2.png"));
        listadoAvatar.add(new Avatar("Captain America", "3.png"));
        listadoAvatar.add(new Avatar("Giant Man", "4.png"));
        listadoAvatar.add(new Avatar("HawkEye", "5.png"));
        listadoAvatar.add(new Avatar("Hulk", "6.png"));
        listadoAvatar.add(new Avatar("IronMan", "7.png"));
        listadoAvatar.add(new Avatar("Loki", "8.png"));
        listadoAvatar.add(new Avatar("Nick Fury", "9.png"));
        listadoAvatar.add(new Avatar("Thor", "10.png"));
        listadoAvatar.add(new Avatar("WarMachine", "11.png"));


        preferences = getSharedPreferences("preferencias", Context.MODE_APPEND);
        final SharedPreferences.Editor editor = preferences.edit();

        if(preferences.getString("clave",null)!=null){
            this.finish();
            Intent i = new Intent(AvatarActivity.this, MainActivity.class);
            startActivity(i);
        }else{

            final AdapterAvatar adaptador = new AdapterAvatar(this, listadoAvatar);
            lista.setAdapter(adaptador);
            Bundle extras = getIntent().getExtras();
            final String nickname = extras.getString("nick_name");
            lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Avatar avatarSeleccionado = listadoAvatar.get(position);

                    editor.putString("avatar", listadoAvatar.get(position).getUrl_avatar());
                    editor.putBoolean("registro", true);
                    editor.apply();
                    editor.commit();

                    new GcmRegistrationAsyncTask(AvatarActivity.this).execute(nickname, listadoAvatar.get(position).getUrl_avatar());

                    Intent i = new Intent(AvatarActivity.this, MainActivity.class);
                    i.putExtra("avatar", listadoAvatar.get(position).getUrl_avatar());//Atrapar el avatar y llevarlo al main
                    startActivity(i);
                    AvatarActivity.this.finish();


                }
            });

        }


    }
}
