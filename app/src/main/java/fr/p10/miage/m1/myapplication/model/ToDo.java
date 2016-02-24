package fr.p10.miage.m1.myapplication.model;


/**
 * Created by adrie_000 on 13/02/2016.
 */
public class ToDo {
    String name;
    int value;
    String date;

    public ToDo(String name, int value,String date){
        this.name = name;
        this.value = value;
        this.date=date;
    }
    public String getName(){return this.name;}
    public int getValue(){return this.value;}
    public String getDate(){return this.date;}
}
