package com.gumadev.e2indicemasacorporal.Dialogos;

import android.content.Context;
import android.support.v7.app.AlertDialog;

import com.gumadev.e2indicemasacorporal.Listener.EscuchaDialogos;

/**
 * Created by sergu on 07/02/2017.
 * Clase para mostrar Dialogos en este caso Alert
 */

public class AlertDialogos {

    private Context ctx;

    public AlertDialogos(Context ctx) {
        this.ctx = ctx;
    }

    public void dialogoSalir(){

        AlertDialog dialogoSalir = new AlertDialog.Builder(ctx).create();
        dialogoSalir.setTitle("Salir de la palicación");
        dialogoSalir.setMessage("¿Quieres Salir de la Aplicación?");

        EscuchaDialogos escuchaDialogos = new EscuchaDialogos(ctx);

        dialogoSalir.setButton(AlertDialog.BUTTON_NEGATIVE, "NO", escuchaDialogos);
        dialogoSalir.setButton(AlertDialog.BUTTON_POSITIVE, "SI", escuchaDialogos);

        dialogoSalir.show();
    }


}
