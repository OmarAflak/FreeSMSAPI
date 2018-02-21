package me.aflak.freesmsapiandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import me.aflak.libraries.FreeAPI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String user = "user";
        final String pass = "pass";
        FreeAPI api = new FreeAPI(user, pass);

        api.sms("Hello World !");
    }
}
