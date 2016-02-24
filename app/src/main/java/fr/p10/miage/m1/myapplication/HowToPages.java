package fr.p10.miage.m1.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * Created by CrazyTulips on 18/02/2016.
 */
public class HowToPages extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String title ="";
        String content_description = "";

        Bundle extras = getIntent().getExtras();

        // On récupères les valeurs envoyés en paramètres à notre activité
        if (extras != null) {

            //---------Récupère informations------------
             title = extras.getString("title_how_to");

        }
        // On récupère notre layout
        setContentView(R.layout.activity_how_to_pages);

        // On set notre titre
        TextView textView_title = (TextView) findViewById(R.id.textView_how_to_pages_title);
        textView_title.setText(title);


        // On récupère les information de la base de données

        content_description = " Test contenu de la description";

        // On set les information de la description de notre How To
        TextView textView_description = (TextView) findViewById(R.id.textView_how_to_pages_contentDescription);
        textView_description.setText("Bla bla bla");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_profile) {
            Intent intent = new Intent(this, Settings.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

}
