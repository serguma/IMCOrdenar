package com.gumadev.e2indicemasacorporal.Objetos;

/**
 * Created by sergu on 12/02/2017.
 */

public class UsuariosDatos implements Comparable<UsuariosDatos>{

    private int id;
    private float resultado;
    private int idusuario;
    private String fecha;

    public UsuariosDatos(float resultado, int idusuario, String fecha) {
        this.resultado = resultado;
        this.idusuario = idusuario;
        this.fecha = fecha;
    }

    public UsuariosDatos(float resultado, int idusuario) {
        this.resultado = resultado;
        this.idusuario = idusuario;
    }

    public float getResultado() {
        return resultado;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public String getFecha() {
        return fecha;
    }

    @Override
    public int compareTo(UsuariosDatos o) {
        return this.getFecha().compareTo(o.getFecha());
    }
}
