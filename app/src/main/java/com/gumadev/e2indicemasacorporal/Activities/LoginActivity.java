package com.gumadev.e2indicemasacorporal.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.gumadev.e2indicemasacorporal.Listener.EscuchaBotonLogin;
import com.gumadev.e2indicemasacorporal.R;


public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        SharedPreferences logueado = getSharedPreferences("preferen", Context.MODE_PRIVATE);
        boolean estaRegistrado = logueado.getBoolean("logueo", false);

        if( estaRegistrado ){
            //se ha logueado anteriormente
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finishAffinity();
        }

        Button accederBT = (Button) findViewById(R.id.acceder);
        Button registrarseBT = (Button) findViewById(R.id.registrarse);

        EscuchaBotonLogin escuchaBotonLogin = new EscuchaBotonLogin(this);

        accederBT.setOnClickListener(escuchaBotonLogin);
        registrarseBT.setOnClickListener(escuchaBotonLogin);

    }
}
