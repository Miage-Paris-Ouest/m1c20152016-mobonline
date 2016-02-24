package fr.p10.miage.m1.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import fr.p10.miage.m1.myapplication.model.AsyncResponse;
import fr.p10.miage.m1.myapplication.model.Communicator;

public class Accueil extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener,AsyncResponse {

        private Map<String,Integer> categories;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            Log.i("Univ id= :", "" + ((ShareDatas) getApplicationContext()).univId);
            initParentPages();
            setContentView(R.layout.activity_accueil);

            addListenerOnButton();


            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);


            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.setDrawerListener(toggle);
            toggle.syncState();

            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            navigationView.setNavigationItemSelectedListener(this);

    }

    public void initParentPages() {
        Communicator c = new Communicator();
        c.delegate=this;
        c.execute("http://10.0.2.2:8080/NanterasmusWEB/REST/university/pages/parents.json?university="+((ShareDatas) getApplicationContext()).univId);
    }


    public void addListenerOnButton() {

        ImageButton howTo = (ImageButton) findViewById(R.id.activity_accueil_image_button_howto);
        ImageButton contact = (ImageButton) findViewById(R.id.activity_accueil_image_button_contact);
        ImageButton culture = (ImageButton) findViewById(R.id.activity_accueil_image_button_culture);
        ImageButton learnFrench = (ImageButton) findViewById(R.id.activity_accueil_image_button_learning_locale);
        ImageButton map = (ImageButton) findViewById(R.id.activity_accueil_image_button_map);
        ImageButton toDoList = (ImageButton) findViewById(R.id.activity_accueil_image_button_todolist);

        howTo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Accueil.this,HowTo.class);
                intent.putExtra("cat_id",categories.get("How To"));
                startActivity(intent);

            }

        });

        contact.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Accueil.this,Contact.class);
                intent.putExtra("cat_id",categories.get("Contact"));
                startActivity(intent);

            }

        });

        culture.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Accueil.this,Culture.class);
                intent.putExtra("cat_id",categories.get("Culture"));
                startActivity(intent);

            }

        });

        learnFrench.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Accueil.this, LearnFrench.class);
                intent.putExtra("cat_id",categories.get("Learning"));
                startActivity(intent);

            }

        });

        map.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Accueil.this,MapPlan.class);
                intent.putExtra("cat_id",categories.get("Map"));
                startActivity(intent);
            }

        });

        toDoList.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Accueil.this, ToDoList.class);
                intent.putExtra("cat_id",categories.get("To Do List"));
                startActivity(intent);

            }

        });

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

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void processFinish(String output) {

        try {
            JSONObject parentObject = new JSONObject(output);

            String status = parentObject.getString("status");
            categories=new HashMap<>();

            JSONArray categoriesArray=parentObject.getJSONArray("categories");

            for (int i = 0; i < categoriesArray.length(); i++) {
                JSONObject jsonobject = categoriesArray.getJSONObject(i);

                categories.put(jsonobject.getString("cat_name"),jsonobject.getInt("cat_id"));

                Log.i("CategoriesParentes !!!","CatName :"+jsonobject.getString("cat_name")+"Cat Id"+jsonobject.getInt("cat_id"));
            }

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_accueil) {

            Intent intent = new Intent(this, Accueil.class);
            startActivity(intent);

        }else if (id == R.id.nav_to_contact) {

            Intent intent = new Intent(this, Contact.class);
            startActivity(intent);

        }else if (id == R.id.nav_to_culture) {

            Intent intent = new Intent(this, Culture.class);
            startActivity(intent);

        }else if (id == R.id.nav_to_how_to) {

            Intent intent = new Intent(this, HowTo.class);
            startActivity(intent);

        }else if (id == R.id.nav_to_learn_french) {

            Intent intent = new Intent(this, LearnFrench.class);
            startActivity(intent);

        }else if (id == R.id.nav_to_map) {

            Intent intent = new Intent(this, MapPlan.class);
            startActivity(intent);

        }else if (id == R.id.nav_to_dolist) {

            Intent intent = new Intent(this, ToDoList.class);
            startActivity(intent);

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
