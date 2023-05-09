package com.arslan.politicsbookjava;

public class Singleton {
    private Politics sentPolitics;
    private static Singleton singleton;
    private Singleton(){

    }
    public Politics getSentPolitics(){
        return sentPolitics;
    }
    public void setSentPolitics(Politics sentPolitics){
        this.sentPolitics = sentPolitics;
    }
    public static Singleton getInstance(){
        if (singleton == null){
            singleton = new Singleton();
        }
        return singleton;
    }
}
