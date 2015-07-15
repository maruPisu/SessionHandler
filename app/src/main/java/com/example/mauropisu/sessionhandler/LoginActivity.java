package com.example.mauropisu.sessionhandler;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends Activity{

    EditText txtUsername;
    EditText txtPassword;

    // Session Manager Class
    SessionManager session;
    Context thisContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Session Manager

        thisContext = this;
        txtPassword = (EditText)findViewById(R.id.editTextPass);
        txtUsername = (EditText)findViewById(R.id.editTextUser);

        session = new SessionManager(getApplicationContext());


        txtUsername.setText("admin");
        txtPassword.setText("admin");

        if(session.isLoggedIn()) {
            startActivity(new Intent(getApplicationContext(), Home.class));
        }

        final Button btnLogin = (Button) findViewById(R.id.button12);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                if(txtUsername.getText().toString().equals("admin")&& txtPassword.getText().toString().equals("admin"))
                {
                    session.createLoginSession("admin");
                    startActivity(new Intent(getApplicationContext(), Home.class));
                }else{
                    Toast.makeText(getApplicationContext(), "Username and/or password incorrect (Try using admin-admin)", Toast.LENGTH_LONG).show();

                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        // do nothing
    }
}

