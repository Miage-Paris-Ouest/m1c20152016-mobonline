package fr.p10.miage.m1.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import fr.p10.miage.m1.myapplication.model.AsyncResponse;
import fr.p10.miage.m1.myapplication.model.Communicator;
import fr.p10.miage.m1.myapplication.model.JsonData;

public class MainActivity extends AppCompatActivity implements AsyncResponse {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       Communicator c = new Communicator();
        c.delegate=this;
        c.execute("http://10.0.2.2:8080/NanterasmusWEB/REST/user/connect.json?username=flo&password=flo123");

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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void processFinish(String output) {

        try {
            JSONObject parentObject = new JSONObject(output);

            //And then read attributes like
            String last_name = parentObject.getString("last_name");
            String first_name = parentObject.getString("first_name");
            String email = parentObject.getString("email");
            String status = parentObject.getString("status");

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}