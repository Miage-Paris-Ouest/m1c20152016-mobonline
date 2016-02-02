package fr.p10.miage.m1.myapplication;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.sql.ResultSet;
import java.util.ArrayList;


public class Login extends Activity {

    private View loginFormView;
    private EditText emailTextView;
    private EditText passwordTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailTextView = (EditText) findViewById(R.id.email);

        passwordTextView = (EditText) findViewById(R.id.password);

        Button loginButton = (Button) findViewById(R.id.connexion_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initLogin();
            }
        });

        loginFormView = findViewById(R.id.login_form);
    }


    public void initLogin() {

        emailTextView.setError(null);
        passwordTextView.setError(null);

        String email = emailTextView.getText().toString();
        String password = passwordTextView.getText().toString();


        boolean log=true;

        //email et mdp vide
        if (TextUtils.isEmpty(password)) {
            passwordTextView.setError(getString(R.string.field_required));
            log=false;
        }

        if (TextUtils.isEmpty(email)) {
            emailTextView.setError(getString(R.string.field_required));
            log=false;

        }

        //test des log avec fichier property temporaire
        if(!email.equals(getString(R.string.adrien_user))){
            emailTextView.setError(getString(R.string.invalid_email));
            log=false;
        }

        if(!password.equals(getString(R.string.adrien_mdp))){
            passwordTextView.setError(getString(R.string.incorrect_password));
            log=false;
        }


        if(log)
        {
            Intent intent = new Intent(this,Accueil.class);
            startActivity(intent);
        }

    }

}

