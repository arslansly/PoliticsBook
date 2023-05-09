package com.arslan.politicsbookjava;

import java.io.Serializable;

public class Politics implements Serializable {
    String name;
    String gecmis;
    int image;

    //Constructor
    public  Politics(String name, String gecmis, int image){
        this.name = name;
        this.gecmis = gecmis;
        this.image = image;
    }
}
