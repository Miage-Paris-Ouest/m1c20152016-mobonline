package fr.p10.miage.m1.myapplication;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import fr.p10.miage.m1.myapplication.model.AsyncResponse;
import fr.p10.miage.m1.myapplication.model.Communicator;


public class Login extends Activity implements AsyncResponse {

    private View loginFormView;
    private EditText emailTextView;
    private EditText passwordTextView;
    private String status;
    private String email;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailTextView = (EditText) findViewById(R.id.activity_login_edit_text_email);

        passwordTextView = (EditText) findViewById(R.id.activity_login_edit_text_password);

        Button loginButton = (Button) findViewById(R.id.activity_login_button_connection);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initLogin();
            }
        });


    }


    public void initLogin() {

        emailTextView.setError(null);
        passwordTextView.setError(null);

        email = emailTextView.getText().toString();
        password = passwordTextView.getText().toString();

        Communicator c = new Communicator();
        c.delegate=this;
        c.execute("http://10.0.2.2:8080/NanterasmusWEB/REST/user/connect.json?username="+email+"&password="+password);
    }

    @Override
    public void processFinish(String output) {

        try {
            JSONObject parentObject = new JSONObject(output);

            status = parentObject.getString("status");

            boolean log=true;


            //test des log avec fichier property temporaire
            if(status.equals("false")){
                emailTextView.setError(getString(R.string.invalid_email));
                passwordTextView.setError(getString(R.string.incorrect_password));
                log=false;
            }

            //email et mdp vide
            if (TextUtils.isEmpty(password)) {
                passwordTextView.setError(getString(R.string.field_required));
                log=false;
            }

            if (TextUtils.isEmpty(email)) {
                emailTextView.setError(getString(R.string.field_required));
                log=false;

            }


            if(log)
            {
                Intent intent = new Intent(this,Accueil.class);
                ((ShareDatas) getApplicationContext()).univId=parentObject.getInt("university");
                //intent.putExtra(parentObject.getString("status"));
                startActivity(intent);
            }




        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}

