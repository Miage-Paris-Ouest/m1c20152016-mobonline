package fr.p10.miage.m1.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

        ImageButton howTo = (ImageButton) findViewById(R.id.activity_accueil_image_button_howto);
        ImageButton contact = (ImageButton) findViewById(R.id.activity_accueil_image_button_contact);
        ImageButton culture = (ImageButton) findViewById(R.id.activity_accueil_image_button_culture);
        ImageButton learnFrench = (ImageButton) findViewById(R.id.activity_accueil_image_button_learning_locale);
        ImageButton map = (ImageButton) findViewById(R.id.activity_accueil_image_button_map);
        ImageButton toDoList = (ImageButton) findViewById(R.id.activity_accueil_image_button_todolist);

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
