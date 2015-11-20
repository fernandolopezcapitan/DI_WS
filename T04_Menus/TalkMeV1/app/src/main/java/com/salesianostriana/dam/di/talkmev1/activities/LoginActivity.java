package com.salesianostriana.dam.di.talkmev1.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.salesianostriana.dam.di.talkmev1.R;
import com.salesianostriana.dam.di.talkmev1.services.GcmRegistrationAsyncTask;

public class LoginActivity extends AppCompatActivity {

    EditText nick_name;
    Button register;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Modo append = editable. Modo private = no editable
        preferences = getSharedPreferences("preferencias", Context.MODE_APPEND);
        final SharedPreferences.Editor editor = preferences.edit();

        if(preferences.getBoolean("registro", false)){
            LoginActivity.this.finish();
            Intent i = new Intent(LoginActivity.this,MainActivity.class);
            i.putExtra("nick_name", preferences.getString("nick_defecto",null));
            startActivity(i);

        }else {
            setContentView(R.layout.activity_login);

            nick_name = (EditText) findViewById(R.id.et_nick);
            register = (Button) findViewById(R.id.btn_registrar);

            register.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //Lanzar registro en Gcm
                    new GcmRegistrationAsyncTask(LoginActivity.this).execute(nick_name.getText().toString());

                    //recoger nick_name y agregar a preferences
                    editor.putString("nick_name", nick_name.getText().toString());
                    editor.putBoolean("registro", true);
                    editor.apply();
                    editor.commit();

                    //Lanzar MainActivity
                    Intent i = new Intent(LoginActivity.this,MainActivity.class);
                    i.putExtra("nick_name", nick_name.getText().toString());
                    startActivity(i);
                    LoginActivity.this.finish();
                }
            });
        }
    }
}
