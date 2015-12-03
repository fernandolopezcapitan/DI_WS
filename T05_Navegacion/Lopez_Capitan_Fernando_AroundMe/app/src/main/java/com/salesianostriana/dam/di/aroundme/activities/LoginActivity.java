package com.salesianostriana.dam.di.aroundme.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.salesianostriana.dam.di.aroundme.R;

public class LoginActivity extends AppCompatActivity {

    EditText nick_name;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_login);

        SharedPreferences prefs = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = prefs.edit();


        if(prefs.getBoolean("registro", false)){
            LoginActivity.this.finish();
            Intent i = new Intent(LoginActivity.this,AvatarActivity.class);
            i.putExtra("nick_name", prefs.getString("nick_defecto", null));
            startActivity(i);

        }else {
            setContentView(R.layout.activity_login);

            nick_name = (EditText) findViewById(R.id.et_nick);
            register = (Button) findViewById(R.id.btn_registrar);

            register.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //recoger nick_name y agregar a preferences
                    editor.putString("nick_name", nick_name.getText().toString());
                    editor.putBoolean("registro", true);
                    editor.apply();
                    editor.commit();

                    //Lanzar MainActivity
                    LoginActivity.this.finish();
                    Intent i = new Intent(LoginActivity.this, AvatarActivity.class);
                    i.putExtra("nick_name", nick_name.getText().toString());
                    startActivity(i);

                }
            });
        }


    }
}
