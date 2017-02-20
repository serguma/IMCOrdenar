package com.gumadev.e2indicemasacorporal.Listener;

import android.content.Context;
import android.content.DialogInterface;

import com.gumadev.e2indicemasacorporal.Utilidades.Utils;

/**
 * Created by sergu on 07/02/2017.
 */

public class EscuchaDialogos implements DialogInterface.OnClickListener {

    private Context ctx;

    public EscuchaDialogos(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {

        if(which == dialog.BUTTON_POSITIVE){
            //salgo de la aplicación
            Utils.salir(ctx);
        }else if(which == dialog.BUTTON_NEGATIVE){
            //cierro el dialogo
            dialog.cancel();
        }

    }
}
