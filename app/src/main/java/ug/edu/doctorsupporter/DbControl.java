package ug.edu.doctorsupporter;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

import static java.nio.charset.StandardCharsets.*;

/**
 * Created by Dominik on 31.10.2017.
 */

class DbControl {


    public static String md5(String s) {
        try {
            // Create MD5 Hash
            MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < messageDigest.length; i++)
                hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
            return hexString.toString().toLowerCase();  //  zapisywanie małymi literami

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static class dbFunctions extends AsyncTask<String, Integer, Integer> {

        String typ = "";
        private Activity activity;


        public dbFunctions(Activity activity, String typ) {
            this.activity = activity;
            this.typ = typ;
        }




        @Override
        protected void onPreExecute() {

            switch (typ) {
                case "login":
                    loginOnPreExecute();
                    break;
                default:
                    Log.d("TYP", "Nierozpoznany typ " + typ);
                    break;
            }
        }

        //onPreExecute for login
        protected void loginOnPreExecute() {
            LoginActivity loginActivity = (LoginActivity) this.activity;
            loginActivity.printWarn("Logowanie w toku");
            loginActivity.disableLoginButton();
        }

        @Override
        protected Integer doInBackground(String... strings) {
            Integer toRet = -1;

            switch (typ) {
                case "login":
                    toRet = loginDoInBackground(strings);

                    break;
            }


            return toRet;
        }

        // doInBackground for login
        protected Integer loginDoInBackground(String... strings) {

            final String login = strings[0];
            final String password = strings[1];

            RequestQueue requsetqueue = Volley.newRequestQueue(this.activity.getApplicationContext());

            final String api = "https://nadirdoc.herokuapp.com/api/login";

            StringRequest postReqest = new StringRequest(Method.POST, api,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.d("Response",response);
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.d("Error.Response", error.getMessage());
                        }
                    }            ){
                @Override
                protected Map<String,String> getParams(){
                    Map<String, String>  params = new HashMap<String, String>();
                    params.put("login", login);
                    params.put("hashPass", md5(password));

                    return params;

                }
            };
            //add to the request queue
            requsetqueue.add(postReqest);



            return 0;

        }

        @Override
        protected void onPostExecute(Integer result) {

            switch (typ) {

                case "login":
                    loginOnPostExecute(result);
                    break;
            }

        }

        private void loginOnPostExecute(Integer result) {
            int id = result.intValue();
            LoginActivity loginActivity = (LoginActivity) this.activity;
            loginActivity.enableLoginButton();
            Log.d("PostLAS", ":" + id);
            if (id > 0) {
                loginActivity.openMainActivity(id);
            } else {
                loginActivity.printWarn("Logowanie nie powiodło się");
            }
        }
    }
}
