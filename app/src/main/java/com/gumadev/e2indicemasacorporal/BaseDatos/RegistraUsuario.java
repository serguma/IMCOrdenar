package com.gumadev.e2indicemasacorporal.BaseDatos;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.gumadev.e2indicemasacorporal.Activities.MainActivity;
import com.gumadev.e2indicemasacorporal.Objetos.Usuario;

/**
 * Created by sergu on 29/01/2017.
 */

public class RegistraUsuario {

    private Context ctx;

    public RegistraUsuario(Context ctx) {
        this.ctx = ctx;
    }

    public static void registro(Usuario usuario, Context ctx){

        BaseDatosUsuarios baseDatosUsuarios = new BaseDatosUsuarios(ctx, "usuariosdb", null, 1);

        if(!baseDatosUsuarios.existeUsuario(usuario)){
            baseDatosUsuarios.insertarUusario(usuario);

            Activity activity = (Activity) ctx;
            SharedPreferences sharedPreferences = activity.getSharedPreferences("preferen", ctx.MODE_PRIVATE);
            int idUsuario = sharedPreferences.getInt("idusuario", 0);

            idUsuario = baseDatosUsuarios.idDeUsuario(usuario);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("idusuario", idUsuario);
            editor.commit();

            Intent intent = new Intent(ctx, MainActivity.class);
            ctx.startActivity(intent);

            activity.finishAffinity();

            Toast.makeText(ctx,"Lo registro "+ baseDatosUsuarios.existeUsuario(usuario),Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(ctx,"Este usuario ya existe",Toast.LENGTH_LONG).show();
        }

    }
}
