package com.francescxavier.videotogethercliente;

import java.util.UUID;

public class User {
    private static User usuario;

    String nombre;
    String id;

    public User(String nombre, String id){
        this.nombre = nombre;
        this.id = id;
    }

    public static User getUsuario(){
        return usuario;
    }

    public static void setUsuario(User nUsuario){
        usuario = nUsuario;
    }

    public String getId(){
        return id;
    }

    public String getNombre(){
        return nombre;
    }
}
