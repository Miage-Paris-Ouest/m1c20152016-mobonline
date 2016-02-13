package fr.p10.miage.m1.myapplication.model;

/**
 * Created by adrie_000 on 13/02/2016.
 */
public class ToDo {
    String name;
    int value;

    public ToDo(String name, int value){
        this.name = name;
        this.value = value;
    }
    public String getName(){
        return this.name;
    }
    public int getValue(){
        return this.value;
    }
}
