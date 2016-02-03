package fr.p10.miage.m1.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class Accueil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        addListenerOnButton();

    }

    public void addListenerOnButton() {

        ImageButton howTo = (ImageButton) findViewById(R.id.howTo);
        ImageButton contact = (ImageButton) findViewById(R.id.contact);
        ImageButton culture = (ImageButton) findViewById(R.id.culture);
        ImageButton learnFrench = (ImageButton) findViewById(R.id.learnFrench);
        ImageButton map = (ImageButton) findViewById(R.id.map);
        ImageButton toDoList = (ImageButton) findViewById(R.id.toDoList);

        howTo.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Accueil.this,HowTo.class);
                startActivity(intent);

            }

        });

        contact.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Accueil.this,Contact.class);
                startActivity(intent);

            }

        });

        culture.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Accueil.this,Culture.class);
                startActivity(intent);

            }

        });

        learnFrench.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Accueil.this, LearnFrench.class);
                startActivity(intent);

            }

        });

        map.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Accueil.this,Map.class);
                startActivity(intent);

            }

        });

        toDoList.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Accueil.this, ToDoList.class);
                startActivity(intent);

            }

        });

    }

}
