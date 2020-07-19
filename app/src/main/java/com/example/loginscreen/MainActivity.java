package com.example.loginscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView username;
    TextView password;
    Button button;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    CheckBox savelogincheckbox;
    boolean savelogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View v;
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.usernm);
        password = findViewById(R.id.passwrd);
        button = findViewById(R.id.login);
        sharedPreferences = getSharedPreferences("loginref", MODE_PRIVATE);
        savelogincheckbox = findViewById(R.id.checkBox);
        editor = sharedPreferences.edit();
        Intent intent = new Intent(MainActivity.this, screen.class);
        boolean status = sharedPreferences.getBoolean("savelogin", false);
        if (status) {
            startActivity(intent);
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abc();
            }
        });
    }

    public void abc() {
        String usrname = username.getText().toString();
        String psswrd = password.getText().toString();
        Intent intent = new Intent(MainActivity.this, screen.class);

        if (usrname.equals("username") && psswrd.equals("password")) {
            startActivity(intent);

            Toast.makeText(this, "successful", Toast.LENGTH_SHORT).show();
            if (savelogincheckbox.isChecked()) {
                editor.putBoolean("savelogin", true);
                editor.putString("username", usrname);
                editor.putString("password", psswrd);
                editor.apply();
            }
        } else {
            Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
        }
    }
}
