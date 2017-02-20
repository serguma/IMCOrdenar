package com.gumadev.e2indicemasacorporal.Listener;


import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.gumadev.e2indicemasacorporal.BaseDatos.Acceder;
import com.gumadev.e2indicemasacorporal.R;
import com.gumadev.e2indicemasacorporal.BaseDatos.RegistraUsuario;
import com.gumadev.e2indicemasacorporal.Objetos.Usuario;

/**
 * Created by sergu on 29/01/2017.
 */

public class EscuchaBotonLogin implements View.OnClickListener {

    private Context ctx;

    public EscuchaBotonLogin(Context ctx){
        this.ctx = ctx;
    }

    @Override
    public void onClick(View v) {

        Activity activity = (Activity) ctx;

        //obtengo los valores introducidos
        EditText nombreTV = (EditText) activity.findViewById(R.id.usuario);
        String nombre = nombreTV.getText().toString();

        EditText passTV = (EditText) activity.findViewById(R.id.pass);
        String pass = passTV.getText().toString();

        if(nombre.length() > 0 && pass.length() > 0){
            Usuario usuario = new Usuario(nombre, pass);

            switch (v.getId()) {
                case R.id.registrarse:
                    Log.d(getClass().getCanonicalName(), "He pulsado el botón registrarse " + usuario.getNombre());
                    RegistraUsuario.registro(usuario,ctx);
                    break;
                case R.id.acceder:
                    Log.d(getClass().getCanonicalName(), "He pulsado el botón acceder " + usuario.getNombre());
                    Acceder.accederapp(usuario, ctx);
                    break;

            }


        }else{
            Toast.makeText(ctx,"Debes rellenar los campos",Toast.LENGTH_LONG).show();
        }



    }
}
