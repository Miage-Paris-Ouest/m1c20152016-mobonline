package fr.p10.miage.m1.myapplication;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import fr.p10.miage.m1.myapplication.ExpandableList.ExpandableListAdapter;

import fr.p10.miage.m1.myapplication.model.ResourceHelper;


public class HowTo extends AppCompatActivity implements AsyncResponse {
    private RecyclerView recyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_list);

        TextView title = (TextView) findViewById(R.id.TextView_list_header);
        title.setText("How To ?");

        recyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        // On récupère le nom de notre classe
        String className = getLocalClassName();

        // On crée notre liste avec les paramètres de notre classe et les informations requises
        List<ExpandableListAdapter.Item> data = new ArrayList<>();
        
        for (TypedArray item : ResourceHelper.getMultiTypedArray(this, "howTo"))
        {

            for(int i=0;i<item.length();i++)
            {
                if (i == 0)
                {
                    data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.HEADER, item.getString(i)));
                }
                else
                {
                    data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, item.getString(i)));
                }
            }

        }


        // on set notre recyclerview avec les informations des listes qui renvoient sur la page de la classname passée en paramètre
        recyclerview.setAdapter(new ExpandableListAdapter(data,className));
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
