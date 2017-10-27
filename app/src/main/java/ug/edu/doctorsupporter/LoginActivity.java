package ug.edu.doctorsupporter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class LoginActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void login(View v) {
        // Tutaj dodać sprawdzanie, czy ID i hasło się zgadzają
        openMainActivity();
    }

    public void openMainActivity() {
        Intent mainIntent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(mainIntent);
    }

/* Metoda wywoływana przy błędnej próbie zalogowania, jeszcze nieaktywna
    public void error(){
        TextView errorText = findViewById(R.id.wrongLoginText);
        errorText.setVisibility(View.VISIBLE);
    } */

}

