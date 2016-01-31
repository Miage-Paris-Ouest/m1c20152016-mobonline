package fr.p10.miage.m1.myapplication;


import android.app.Activity;
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
        int size=0;
        emailTextView.setError(null);
        passwordTextView.setError(null);

        String email = emailTextView.getText().toString();
        String password = passwordTextView.getText().toString();

        String emailBDD=null;
        String passwordBDD=null;

        boolean log=true;

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

            try{
                ConnectionBDD db = new ConnectionBDD();
                ResultSet rs = db.selectResult("SELECT * FROM M1_USERS  where user_login='"+email+"' and user_password='"+password+"'");
                rs.next();
                String nom = rs.getString("user_login");
                String prenom = rs.getString("user_password");
                size=rs.getRow();

            } catch(Exception e) {

            }

        }

        if(size==0)
        {
            if(!email.equals(emailBDD)){
                emailTextView.setError(getString(R.string.invalid_email));
            }

            if(!password.equals(passwordBDD)){
                passwordTextView.setError(getString(R.string.incorrect_password));
            }
        }


    }

}

