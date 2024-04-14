package com.free_tanmay_salunke.loginshared;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView register_txt, login_txtview;
    EditText email_txt, pass_txt;
    Button Login_btn;
    SharedPreferences sharedPreferences;
    // Constants for SharedPreferences keys
    private static final String Shared_Pref_Name = "MyPrefs";
    private static final String Shared_Key_Email = "email";
    private static final String Shared_Key_Password = "password";
    private static final String Shared_Key_Name = "name";
    private static final String Shared_Key_Subject = "subject";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        register_txt = findViewById(R.id.register_txt);
        login_txtview = findViewById(R.id.login_txtview);
        email_txt = findViewById(R.id.email_txt);
        pass_txt = findViewById(R.id.pass_txt);
        Login_btn = findViewById(R.id.Login_btn);
        sharedPreferences = getSharedPreferences(Shared_Pref_Name, MODE_PRIVATE);

        Login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enteredEmail = email_txt.getText().toString().trim();
                String enteredPassword = pass_txt.getText().toString().trim();

                // Retrieve registered email and password from SharedPreferences using the correct keys
                String registeredEmail = sharedPreferences.getString(Shared_Key_Email, "");
                String registeredPassword = sharedPreferences.getString(Shared_Key_Password, "");
                String registeredName = sharedPreferences.getString(Shared_Key_Name, "");
                String registeredSubject = sharedPreferences.getString(Shared_Key_Subject, "");

                if (enteredEmail.equals(registeredEmail) && enteredPassword.equals(registeredPassword)) {
                    // Login successful
                    Intent intent = new Intent(MainActivity.this, DetalisActivity.class);
                    intent.putExtra("name", registeredName);
                    intent.putExtra("email", enteredEmail);
                    intent.putExtra("subject", registeredSubject);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(MainActivity.this, "Please register first or check your credentials.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        register_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
