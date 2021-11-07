package com.francescxavier.videotogethercliente.enums;

import com.francescxavier.videotogethercliente.utils.NetUtils;

public enum PetitionType {
    LOGIN("login"),
    CREATESALA("createSala"),
    JOINSALA("joinSala");

    private String value;


    PetitionType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
