package com.free_tanmay_salunke.loginshared;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DetalisActivity extends AppCompatActivity {
    TextView nameTextView, emailTextView, subjectTextView,passwordTextView;
    Button logout_btn;
    SharedPreferences sharedPreferences;
    private static final String Shared_Pref_Name = "MyNAME";
    private static final String Shared_Key_Name = "MyName";
    private static final String Shared_Key_Email = "MyEmail";
    private static final String Shared_Key_Password = "password"; // Correct key for password

    private static final String Shared_Key_Subject = "MySubj";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalis);
        nameTextView = findViewById(R.id.nameTextView);
        emailTextView = findViewById(R.id.emailTextView);
        subjectTextView = findViewById(R.id.subjectTextView);
        logout_btn = findViewById(R.id.logout_btn);
        passwordTextView=findViewById(R.id.passwordTextView);

        // Initialize sharedPreferences
        sharedPreferences = getSharedPreferences(Shared_Pref_Name, MODE_PRIVATE);

//        nameTextView = findViewById(R.id.nameTextView);
//        emailTextView = findViewById(R.id.emailTextView);
//        subjectTextView = findViewById(R.id.subjectTextView);
//        logout_btn = findViewById(R.id.logout_btn);
//
//        // Retrieve values from sharedPreferences
//        String email = sharedPreferences.getString(Shared_Key_Email, null);
//        String password = sharedPreferences.getString(Shared_Key_Password, null);
//        String name = sharedPreferences.getString(Shared_Key_Name, null);
//        String subject = sharedPreferences.getString(Shared_Key_Subject, null);
//
//        if (name != null && email != null && subject != null) {
//            nameTextView.setText(name);
//            subjectTextView.setText(subject); // Display the subject
//            emailTextView.setText(email);
//            passwordTextView.setText(password); // Display the password
//        }
        Intent intent = getIntent();
        if (intent != null) {
            String name = intent.getStringExtra("name");
            String email = intent.getStringExtra("email");
            String subject = intent.getStringExtra("subject");

            if (name != null && email != null && subject != null) {
                nameTextView.setText(name);
                subjectTextView.setText(subject);
                emailTextView.setText(email);
            }
        }
        logout_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear().commit();
                Intent intent = new Intent(DetalisActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                Toast.makeText(DetalisActivity.this, "LOGOUT", Toast.LENGTH_SHORT).show();
            }
        });
    }
}