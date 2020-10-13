package com.company;

public class Guest {
    private String name;
    private int passportnumber;

    Guest(String name, int passportnumber){
        this.name = name;
        this.passportnumber = passportnumber;
    }

    public String getName() {
        return name;
    }

    public int getPassportnumber() {
        return passportnumber;
    }
}
