package com.francescxavier.videotogethercliente;

import java.util.HashSet;

public class Sala {

    public static Sala CurrentSala;

    public HashSet<String> listaUsuarios;

    private String id;


    public Sala(String id, HashSet listaUsuarios){
        this.listaUsuarios = listaUsuarios;
        this.id = id;
    }

    public HashSet<String> getListaUsuarios(){
        return listaUsuarios;
    }

    public String getId(){
        return id;
    }
}
