package com.gumadev.e2indicemasacorporal.Objetos;

import java.util.Comparator;

/**
 * Created by sergu on 19/02/2017.
 */

public class ComparaDatos implements Comparator<UsuariosDatos> {

    @Override
    public int compare(UsuariosDatos o1, UsuariosDatos o2) {

        if (o1.getResultado() < o2.getResultado()) {
            return -1;
        } else if (o1.getResultado() > o2.getResultado()) {
            return 1;
        } else {
            return 0;
        }

    }
}
