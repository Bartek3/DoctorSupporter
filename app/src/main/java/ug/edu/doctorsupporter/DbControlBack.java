package ug.edu.doctorsupporter;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;

import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dominik on 31.10.2017.
 */

class DbControlBack {


    public static String md5(String s) {
        try {
            // Create MD5 Hash
            MessageDigest digest = MessageDigest.getInstance("MD5");
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

    public static class dbFunctions extends AsyncTask<String, Integer, String> {

        String typ = "";
        String res = "[{}]";
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
                case "wypelnijBelke":
                    wypelnijBelkeOnPreExecute();
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

        ;

        protected void wypelnijBelkeOnPreExecute() {
        }

        @Override
        protected String doInBackground(String... strings) {
            String toRet = "";


            switch (typ) {
                case "login":
                    toRet = loginDoInBackground(strings);

                    break;
                case "wypelnijBelke":
                    toRet = wypelnijBelkeDoInBackground(strings);
            }

            res = toRet;
            Log.d("DIB ret",res);
            return toRet;
        }


        // doInBackground for login
        protected String loginDoInBackground(String... strings) {

            final String login = strings[0];
            final String password = strings[1];
            res = "";

            RequestQueue requsetqueue = Volley.newRequestQueue(this.activity.getApplicationContext());

            final String api = "https://nadirdoc.herokuapp.com/api/login";

            StringRequest postRequest = new StringRequest(Method.POST, api,
                    new Response.Listener<String>() {


                        @Override
                        public void onResponse(String response) {
                            Log.d("Response", response);

                            res = response;

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.d("Error.Response", error.getMessage());
                        }
                    }) {
                @Override
                protected Map<String, String> getParams() {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("login", login);
                    params.put("hashPass", md5(password));

                    return params;

                }
            };
            //add to the request queue
            requsetqueue.add(postRequest);


           return res;

        }

        // doInBackground for Belka
        protected String wypelnijBelkeDoInBackground(String... strings) {
            res = "";
            final String idPacjent = strings[0];

            RequestQueue requsetqueue = Volley.newRequestQueue(this.activity.getApplicationContext());

            final String api = "https://nadirdoc.herokuapp.com/api/pacjentInfo";

            StringRequest postRequest = new StringRequest(Method.POST, api,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.d("Response", response);
                            res = response;

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.d("Error.Response", error.getMessage());
                        }
                    }) {
                @Override
                protected Map<String, String> getParams() {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("idPacjent", idPacjent);


                    return params;

                }
            };
            //add to the request queue
            requsetqueue.add(postRequest);


            return res;

        }


        @Override
        protected void onPostExecute(String result) {
            Log.d("onPostResult", result);
            switch (typ) {

                case "login":
                    loginOnPostExecute(result);
                    break;
                case "wypelnijBelke":
                    wypelnijBelkeOnPostExecute(result);
            }

        }

        private void loginOnPostExecute(String result) {
            // int id = result.intValue();
            String res = result;
            LoginActivity loginActivity = (LoginActivity) this.activity;
            loginActivity.enableLoginButton();
            Log.d("PostLAS", ":" + res);

            if (new JsonParser().parse(result).isJsonObject()) {
                JsonObject jsonObject = new JsonParser().parse(result).getAsJsonObject();


                int id = jsonObject.get("idLekarz").getAsInt();
                Log.d("logPost id", id + "");
                if (id > 0) {
                    loginActivity.openMainActivity(id);
                } else {
                    loginActivity.printWarn("Logowanie nie powiodło się [1]");
                }

            } else {
                loginActivity.printWarn("Logowanie nie powiodło się [2]");
            }
        }

        private void wypelnijBelkeOnPostExecute(String result) {
            // int id = result.intValue();
            String res = result;
            MainActivity mainActivity = (MainActivity) this.activity;

            if (new JsonParser().parse(result).isJsonObject()) {
                JsonObject jsonObject = new JsonParser().parse(result).getAsJsonObject();


                String imie = jsonObject.get("Imie").getAsString();
                String nazwisko = jsonObject.get("Nazwisko").getAsString();
                String dataurodzenia = jsonObject.get("dataUrodzenia").getAsString();
                String Pesel = jsonObject.get("Pesel").getAsString();


                mainActivity.PacjentInfo(imie, nazwisko, dataurodzenia, Pesel);

            }
        }
    }
}
