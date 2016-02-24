package fr.p10.miage.m1.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SendMail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_mail);

        Button buttonSend = (Button) findViewById(R.id.mail_btn_send);
        final EditText textTo = (EditText) findViewById(R.id.mail_c_mailto);
        final EditText textSubject = (EditText) findViewById(R.id.mail_c_subject);
        final EditText textMessage = (EditText) findViewById(R.id.mail_c_message);

        Bundle extras = getIntent().getExtras();
        String mail_to;

        // On récupères les valeurs envoyés en paramètres à notre activité
        if (extras != null) {
            //---------Récupère informations------------
            mail_to = extras.getString("mail_to");
            textTo.setText(mail_to);
        }


        buttonSend.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String to = textTo.getText().toString();
                String subject = textSubject.getText().toString();
                String message = textMessage.getText().toString();

                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
                // email.putExtra(Intent.EXTRA_CC, new String[]{ to});
                // email.putExtra(Intent.EXTRA_BCC, new String[]{to});
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.putExtra(Intent.EXTRA_TEXT, message);

                // need this to prompts email client only
                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email, "Choose an Email client :"));

            }
        });
    }
}