package ug.edu.doctorsupporter;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


    }

    public void login(View v) {
        Log.d("Login","ClickedLogin");
       DbControl dbc= new DbControl();
        EditText loginET = (EditText) findViewById(R.id.idEditText);
        String login = loginET.getText().toString();
        EditText passET = (EditText) findViewById(R.id.passwordEditText);
        String password = passET.getText().toString();
        int userId = -3;

        String err= "--";

       // new DbControl.dbFunctions(this,"login").execute(login,password);
       String[] params = {login,password};
        dbc.task(this,"login","login",params);
       Log.d("Alt","AAA");
       //openMainActivity(1);  // wejscie tutaj
         //  userId = dbc.login(login, password);
        //openMainActivity(userId); // wejscie
        if(userId>0){
           openMainActivity(userId);
        }
        else {

       TextView wrongLogin = (TextView) findViewById(R.id.wrongLoginText);
           wrongLogin.setVisibility(View.VISIBLE);  // jakie to jest zjebane
         wrongLogin.setText("Nieprawidłowe logowanie!");  // "+err+": "+userId");
        }

    }
    public void printWarn(String text){
        TextView warn = (TextView) findViewById(R.id.wrongLoginText);
        warn.setVisibility(View.VISIBLE);
        warn.setText(text);
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
        public void disableLoginButton(){
            Button loginBtn = findViewById(R.id.loginButton);
            loginBtn.setEnabled(false);
            loginBtn.setBackgroundColor(Color.GRAY);
        }
        public void enableLoginButton(){
            Button loginBtn = findViewById(R.id.loginButton);
            loginBtn.setEnabled(true);
            int a = (int) R.color.colorAccent;
            loginBtn.setBackgroundColor(a);
        }

}

