package com.francescxavier.videotogethercliente.utils;

import com.francescxavier.videotogethercliente.User;
import com.francescxavier.videotogethercliente.enums.PetitionType;
import com.francescxavier.videotogethercliente.enums.ResponseType;

public class Petition {
    private PetitionType petitionType;
    private String contenido;
    private User usuario;

    public Petition(PetitionType petitionType, String contenido) {
        this.petitionType = petitionType;
        this.contenido = contenido;

        if (User.getUsuario() != null){
            this.usuario = User.getUsuario();
        }
    }

    public void setPetitionType(PetitionType petitionType) {
        this.petitionType = petitionType;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public PetitionType getPetitionType(){
        return petitionType;
    }

    public String getContenido(){
        return contenido;
    }

    @Override
    public String toString() {
        if (usuario != null){
            return petitionType.getValue()+NetUtils.Separator+usuario.getNombre()+NetUtils.Separator+usuario.getId()+NetUtils.Separator+contenido;
        } else {
            return petitionType.getValue()+NetUtils.Separator+contenido;
        }

    }
}
