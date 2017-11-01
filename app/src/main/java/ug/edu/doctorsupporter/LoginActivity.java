package ug.edu.doctorsupporter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void login(View v) {
        DbControl dbc= new DbControl();
        EditText loginET = (EditText) findViewById(R.id.idEditText);
        String login = loginET.getText().toString();
        EditText passET = (EditText) findViewById(R.id.passwordEditText);
        String password = passET.getText().toString();
        int userId = dbc.login(login,password);

        if(userId>0){
            openMainActivity(userId);
        }

    }

    public void openMainActivity(int doctorId) {
        Intent mainIntent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(mainIntent);
    }

/* Metoda wywoływana przy błędnej próbie zalogowania, jeszcze nieaktywna
    public void error(){
        TextView errorText = findViewById(R.id.wrongLoginText);
        errorText.setVisibility(View.VISIBLE);
    } */

}

