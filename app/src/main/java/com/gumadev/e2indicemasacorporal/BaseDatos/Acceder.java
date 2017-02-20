package com.gumadev.e2indicemasacorporal.BaseDatos;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import com.gumadev.e2indicemasacorporal.Activities.MainActivity;
import com.gumadev.e2indicemasacorporal.Objetos.Usuario;

/**
 * Created by sergu on 01/02/2017.
 */

public class Acceder {
    private Context ctx;

    public Acceder(Context ctx) {
        this.ctx = ctx;
    }

    public static void accederapp(Usuario usuario, Context ctx){


        BaseDatosUsuarios baseDatosUsuarios = new BaseDatosUsuarios(ctx, "usuariosdb", null, 1);
        Activity activity = (Activity) ctx;

        SharedPreferences sharedPreferences = activity.getSharedPreferences("preferen", ctx.MODE_PRIVATE);

        if(baseDatosUsuarios.existeUsuario(usuario)){
            //si el usuario existe paso a la actividad que calcula el imc y cambio el valor de la preferen a true
            int idUsuario = baseDatosUsuarios.idDeUsuario(usuario);

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("idusuario", idUsuario);
            editor.putBoolean("logueo", true);
            editor.commit();


            Intent intent = new Intent(ctx, MainActivity.class);
            ctx.startActivity(intent);
            activity.finishAffinity();
        }else{

            //compruebo lo intentos de acceso y si pasa de 3 cierro la app

            int intentos = sharedPreferences.getInt("intentos", 0);

            if( intentos < 3){
                intentos += 1;
            }else{
                intentos = 0;
                activity.finishAffinity();
            }

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("intentos", intentos);
            editor.commit();

            Toast.makeText(ctx,"El acceso no es válido",Toast.LENGTH_LONG).show();
        }

    }
}
