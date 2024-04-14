package com.free_tanmay_salunke.loginshared;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText Name, Email, Subject, Password;
    Button Registern_btn;
    SharedPreferences sharedPreferences;
    private static final String Shared_Pref_Name = "MyPrefs";
    private static final String Shared_Key_Email = "email";
    private static final String Shared_Key_Password = "password";
    private static final String Shared_Key_Name = "name";
    private static final String Shared_Key_Subject = "subject";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Name = findViewById(R.id.Name);
        Email = findViewById(R.id.Email);
        Subject = findViewById(R.id.Subject);
        Password = findViewById(R.id.Password);
        Registern_btn = findViewById(R.id.Registern_btn);

        sharedPreferences = getSharedPreferences(Shared_Pref_Name, MODE_PRIVATE);

        Registern_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = Name.getText().toString();
                String email = Email.getText().toString();
                String subject = Subject.getText().toString();
                String password = Password.getText().toString();

                // Store data with correct keys
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(Shared_Key_Email, email);
                editor.putString(Shared_Key_Password, password);
                editor.putString(Shared_Key_Name, name);
                editor.putString(Shared_Key_Subject, subject);
                editor.apply();

                // Redirect to DetalisActivity after registration
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("email", email);
                intent.putExtra("subject", subject);
                startActivity(intent);
                finish();
            }
        });
    }
}