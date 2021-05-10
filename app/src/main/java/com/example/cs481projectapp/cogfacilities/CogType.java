package com.example.cs481projectapp.cogfacilities;

public enum CogType {

    BOSSBOT("bossbot"), LAWBOT("lawbot"),
    CASHBOT("cashbot"), SELLBOT("sellbot");

    private String type;

    CogType(String type){
        this.type = type;
    }
}
