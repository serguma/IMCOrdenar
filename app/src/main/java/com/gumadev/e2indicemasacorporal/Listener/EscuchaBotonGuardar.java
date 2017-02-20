package com.gumadev.e2indicemasacorporal.Listener;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.gumadev.e2indicemasacorporal.Activities.MuestraRegistros;
import com.gumadev.e2indicemasacorporal.BaseDatos.RegistraDatos;
import com.gumadev.e2indicemasacorporal.Objetos.UsuariosDatos;

/**
 * Created by sergu on 14/02/2017.
 */

public class EscuchaBotonGuardar implements View.OnClickListener {

    private Context ctx;
    private UsuariosDatos usuariosDatos;

    public EscuchaBotonGuardar(Context ctx, UsuariosDatos usuariosDatos) {
        this.ctx = ctx;
        this.usuariosDatos = usuariosDatos;
    }

    @Override
    public void onClick(View v) {

        Activity activity = (Activity) ctx;

        RegistraDatos.registroDatos(usuariosDatos,ctx);
        Intent intent = new Intent(ctx, MuestraRegistros.class);
        activity.startActivity(intent);

        Log.d(getClass().getCanonicalName(),"He pulsado el botón guardar");
    }
}
