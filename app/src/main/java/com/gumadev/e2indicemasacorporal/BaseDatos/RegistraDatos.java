package com.gumadev.e2indicemasacorporal.BaseDatos;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.gumadev.e2indicemasacorporal.Activities.MuestraResultado;
import com.gumadev.e2indicemasacorporal.Objetos.UsuariosDatos;

/**
 * Created by sergu on 14/02/2017.
 */

public class RegistraDatos {

    private Context ctx;

    public RegistraDatos(Context ctx) {
        this.ctx = ctx;
    }

    public static void registroDatos(UsuariosDatos usuariosDatos, Context ctx){
        BaseDatosUsuarios baseDatosUsuarios = new BaseDatosUsuarios(ctx, "usuariosdb", null, 1);

        baseDatosUsuarios.insertarRegistro(usuariosDatos);
        Intent intent = new Intent(ctx, MuestraResultado.class);
        ctx.startActivity(intent);

        Toast.makeText(ctx,"Los Datos han sido registrados ",Toast.LENGTH_LONG).show();

    }
}
