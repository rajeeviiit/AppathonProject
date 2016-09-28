package com.example.rajeevpc.appathon;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class Main2ActivityLogin extends Activity {
    Button btnSignIn, btnSignUp;
    LoginDataBaseAdapter loginDataBaseAdapter;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginDataBaseAdapter = new LoginDataBaseAdapter(this);
        loginDataBaseAdapter = loginDataBaseAdapter.open();

// Get The Refference Of Buttons
        btnSignIn = (Button) findViewById(R.id.buttonSignIN);
        btnSignUp = (Button) findViewById(R.id.buttonSignUP);

// Set OnClick Listener on SignUp button
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
// TODO Auto-generated method stub

/// Create Intent for SignUpActivity abd Start The Activity
                Intent intentSignUP = new Intent(getApplicationContext(), SignUPActivity.class);
                startActivity(intentSignUP);
            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void signIn(View V) {
        final Dialog dialog = new Dialog(Main2ActivityLogin.this);
        dialog.setContentView(R.layout.login);
        dialog.setTitle("Login");

// get the Refferences of views
        final EditText editTextUserName = (EditText) dialog.findViewById(R.id.editTextUserNameToLogin);
        final EditText editTextPassword = (EditText) dialog.findViewById(R.id.editTextPasswordToLogin);

        Button btnSignIn = (Button) dialog.findViewById(R.id.buttonSignIn);

// Set On ClickListener
        btnSignIn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
// get The User name and Password
                String userName = editTextUserName.getText().toString();
                String password = editTextPassword.getText().toString();

// fetch the Password form database for respective user name
                String storedPassword = loginDataBaseAdapter.getSinlgeEntry(userName);

// check if the Stored password matches with Password entered by user
                if (password.equals(storedPassword)) {
                    Toast.makeText(Main2ActivityLogin.this, "Congrats: Login Successfull", Toast.LENGTH_LONG).show();
                    dialog.dismiss();
                } else {
                    Toast.makeText(Main2ActivityLogin.this, "User Name or Password does not match", Toast.LENGTH_LONG).show();
                }
            }
        });

        dialog.show();
    }

    protected void onDestroy() {
        super.onDestroy();
// Close The Database
        loginDataBaseAdapter.close();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.sandeepkumar.login_sign/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.sandeepkumar.login_sign/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}

