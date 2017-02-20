package com.gumadev.e2indicemasacorporal.Objetos;

import com.gumadev.e2indicemasacorporal.Utilidades.Codificar;

/**
 * Created by sergu on 29/01/2017.
 */

public class Usuario {
    private int id;
    private String nombre;
    private String pass;

    public Usuario(String nombre, String pass) {
        this.nombre = nombre;
        this.pass = pass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPass() {
        String descodifocada = Codificar.decodifica(pass);
        return descodifocada;
    }

    public void setPass(String pass) {
        this.pass = Codificar.codifica(pass);
    }
}
