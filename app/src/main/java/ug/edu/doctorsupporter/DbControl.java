package ug.edu.doctorsupporter;

import android.app.Activity;
import android.app.Fragment;
import android.os.AsyncTask;
import android.util.Log;

import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONObject;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dominik on 31.10.2017.
 */

class DbControl {
    private static final Gson gson = new Gson();

    public static boolean isJSONValid(String jsonInString) {
        try {
            gson.fromJson(jsonInString, Object.class);
            return true;
        } catch (com.google.gson.JsonSyntaxException ex) {
            return false;
        }
    }

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

    public void task(final Object a, final String whattodo, final String api, final String... par) {
        RequestQueue queue;

        Log.d("dbc task", api + ": " + par.toString());

        //if( a.getClass().isAssignableFrom(Fragment.class)){


        if (a instanceof PatientDiseases)  {
            Log.d("tskISAFrag", "TRUE"+whattodo);
            queue = Volley.newRequestQueue((((PatientDiseases) a).getActivity()));

        } else if (a instanceof PatientData) {
            Log.d("tskISAFrag", "TRUE"+whattodo);
            queue = Volley.newRequestQueue((((PatientData) a).getActivity()));

        } else {
            Log.d("tskISAFrag", "False"+whattodo);
            queue = Volley.newRequestQueue((Activity) a);
        }
        final String url = "https://nadirdoc.herokuapp.com/api/" + api;


        StringRequest postRequest = new StringRequest(Method.POST, url,
                new Response.Listener<String>() {
                    //    Log.d("PR1","TEST1");

                    @Override
                    public void onResponse(String response) {
                        Log.d("ResponseAAA", response + " " + api);

                        if (isJSONValid(response)) {
                            Log.d("CheckJSON", "VALID");
                            //   try {
                            JsonArray jsonArray = new JsonParser().parse(response).getAsJsonArray();
                            if (jsonArray.size() > 0) {

                                switch (whattodo) {
                                    case "login":
                                        loginOnResponse(jsonArray, (Activity) a);
                                        break;
                                    case "belka":
                                        pacjentInfoOnResponse(jsonArray, (Activity) a);
                                        break;
                                    case "belka1":
                                        getLekarzInfoOnResponse(jsonArray, (Activity) a);
                                        break;
                                    case "belka2":
                                        getPacjentWiekOnResponse(jsonArray, (Activity) a);
                                        break;
//                                    case"belka3":
//                                        getPacjentPeselOnResponse(jsonArray,(Activity)a);
//                                        break;
//                                    case "belka4":
//                                        getChorobyOnResponse(jsonArray, a, Integer.valueOf(par[par.length - 1]));
//                                        break;
                                    case "belka5":
                                        getPatientDataOnResponse(jsonArray, a);
                                        break;
                                    case "belka6":
                                        getpacjentAdresOnResponse(jsonArray, a);
                                        break;
                                    case "belka7":
                                        getpacjentAdresKorespondencyjnyDataOnResponse(jsonArray, a);
                                        break;

                                }
                            }

                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Error.ResponseAAA", error.getMessage() + "???");
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = null;
                switch (api) {
                    case "login":
                        params = loginParams(par);
                        break;
                    case "pacjentInfo":
                        params = pacjentInfoParams(par);
                        break;
                    case "getLekarzInfo":
                        params = getLekarzInfoParams(par);
                        break;
                    case "getPacjentWiek":
                        params = getPacjentWiekParams(par);
                        break;
//                    case "getPacjentPesel":
//                        params = getPacjentPeselParams(par);
//                        break;
//                    case "getChoroby":
//                        params = getChorobyParams(par);
//                        break;
                    case "pacjentAdres":
                        params = getPacjentWiekParams(par);
                        break;
                    case "pacjentAdresKorespondencyjny":
                        params = getPacjentWiekParams(par);
                        break;
                }
                Log.d("getParams", params.toString());
                return params;

            }
        };

        queue.add(postRequest);

    }


    private Map<String, String> pacjentInfoParams(String[] par) {
        String idPacjent = par[0];
        Map<String, String> params = new HashMap<String, String>();
        params.put("idPacjent", idPacjent);
        return params;
    }


    private Map<String, String> loginParams(String... par) {
        String login = par[0];
        String password = par[1];
        Map<String, String> params = new HashMap<String, String>();
        params.put("login", login);
        params.put("hashPass", md5(password));

        return params;
    }

    private Map<String, String> getLekarzInfoParams(String[] par) {
        String idLekarz = par[0];
        Map<String, String> params = new HashMap<String, String>();
        params.put("idLekarz", idLekarz);
        return params;
    }

    private Map<String, String> getPacjentWiekParams(String[] par) {
        String idPacjent = par[0];
        Map<String, String> params = new HashMap<String, String>();
        params.put("idPacjent", idPacjent);
        return params;
    }

//    private Map<String,String> getPacjentPeselParams(String[] par) {
//        String idPacjent= par[0];
//        Map<String, String> params = new HashMap<String, String>();
//        params.put("idPacjent", idPacjent);
//        return params;
//    }

//    private Map<String, String> getChorobyParams(String[] par) {
//        String idPacjent = par[0];
//        Map<String, String> params = new HashMap<String, String>();
//        params.put("idPacjent", idPacjent);
//        return params;
//    }


    private void loginOnResponse(JsonArray jsonArray, Activity a) {
        LoginActivity loginActivity = (LoginActivity) a;
        Log.d("LOR", jsonArray.toString());

        String temp = jsonArray.get(0).toString();
        Log.d("jo", jsonArray.get(0).toString());
        JsonObject jsonObject = new JsonParser().parse(temp).getAsJsonObject();

        int id = jsonObject.get("idLekarz").getAsInt();

        if (id > 0) {
            Log.d("LoR id>0", id + "");
            loginActivity.openMainActivity(id);
        } else {
            Log.d("LoR id<=0", id + "");
            loginActivity.printWarn("Logowanie nie powiodło się [1]");
        }

    }


    private void pacjentInfoOnResponse(JsonArray jsonArray, Activity a) {

        MainActivity mainActivity = (MainActivity) a;

        String temp = jsonArray.get(0).toString();

        JsonObject jsonObject = new JsonParser().parse(temp).getAsJsonObject();

        String imie = jsonObject.get("Imie").getAsString();
        String nazwisko = jsonObject.get("Nazwisko").getAsString();
        String dataurodzenia = jsonObject.get("dataUrodzenia").getAsString();
        String Pesel = jsonObject.get("Pesel").getAsString();


        mainActivity.PacjentInfo(imie, nazwisko, dataurodzenia, Pesel);

    }

    private void getLekarzInfoOnResponse(JsonArray jsonArray, Activity a) {

        MainActivity mainActivity = (MainActivity) a;

        String temp = jsonArray.get(0).toString();

        JsonObject jsonObject = new JsonParser().parse(temp).getAsJsonObject();

        String imie = jsonObject.get("imie").getAsString();
        String nazwisko = jsonObject.get("nazwisko").getAsString();
        String tytuł = jsonObject.get("tytuł").getAsString();
        String Specjalnosc_idSpecjalnosc = jsonObject.get("Specjalnosc_idSpecjalnosc").getAsString();


        mainActivity.getLekarzInfo(imie, nazwisko, tytuł, Specjalnosc_idSpecjalnosc);

        Log.d("ERROR", jsonArray.toString());

    }

    private void getPacjentWiekOnResponse(JsonArray jsonArray, Activity a) {
        Log.d("gpwor", jsonArray.toString());
        MainActivity mainActivity = (MainActivity) a;

        String temp = jsonArray.get(0).toString();

        JsonObject jsonObject = new JsonParser().parse(temp).getAsJsonObject();
        Log.d("gpwor", jsonObject.toString());
        int sliwka = jsonObject.get("wiek").getAsInt();

        String wiek = sliwka + "";

        mainActivity.getPacjentWiek(wiek);
    }


//    private void getChorobyOnResponse(JsonArray jsonArray, Object a, int index) {
//
//        ArrayList<String> nazwyChorobyPacjenta = new ArrayList<>();
//        ArrayList<String> uwagiChorobyPacjenta = new ArrayList<>();
//
//
//        PatientDiseases patientDiseases = (PatientDiseases) a;
//        for (JsonElement b : jsonArray) {
//            if (b.isJsonObject()) {
//
//                String nazwaDolegliwosci = b.getAsJsonObject().get("nazwaDolegliwosci").getAsString();
//                String uwagiDolegliwosc = b.getAsJsonObject().get("uwagiDolegliwosc").getAsString();
//                nazwyChorobyPacjenta.add(nazwaDolegliwosci);
//                uwagiChorobyPacjenta.add(uwagiDolegliwosc);
//            }
//        }

//
//        String temp = jsonArray.get(index).toString();
//
//        JsonObject jsonObject = new JsonParser().parse(temp).getAsJsonObject();
//        String nazwaDolegliwosci = jsonObject.get("nazwaDolegliwosci").getAsString();
//        String uwagiDolegliwosc = jsonObject.get("uwagiDolegliwosc").getAsString();
        //  mainActivity.showChoroby(uwagiChorobyPacjenta.toString());

//        patientDiseases.showNazwaChoroby(nazwyChorobyPacjenta.toString());
//        patientDiseases.listChorobyUwagi(uwagiChorobyPacjenta);
//   }

    private void getPatientDataOnResponse(JsonArray jsonArray, Object a) {


        PatientData patientData = (PatientData) a;
        String temp = jsonArray.get(0).toString();
        JsonObject jsonObject = new JsonParser().parse(temp).getAsJsonObject();
        String imie = jsonObject.get("Imie").getAsString();
        String nazwisko = jsonObject.get("Nazwisko").getAsString();
        String dataurodzenia = jsonObject.get("dataUrodzenia").getAsString();
        String Pesel = jsonObject.get("Pesel").getAsString();


        patientData.PacjentInfo(imie, nazwisko, dataurodzenia, Pesel);

    }

    private void getpacjentAdresOnResponse(JsonArray jsonArray, Object a) {


        PatientData patientData = (PatientData) a;
        String temp = jsonArray.get(0).toString();
        JsonObject jsonObject = new JsonParser().parse(temp).getAsJsonObject();
        String miasto =  jsonObject.get("Miasto").getAsString();
        String ulica= jsonObject.get("Ulica").getAsString();
        String numerDomu = jsonObject.get("NumerDomu").getAsString();
        String numerMieszkania = jsonObject.get("NumerMieszkania").getAsString();
        String KodPocztowy = jsonObject.get("KodPocztowy").getAsString();


        patientData.pacjentAdres(miasto,ulica,numerDomu,numerMieszkania,KodPocztowy);

    }

    private void getpacjentAdresKorespondencyjnyDataOnResponse(JsonArray jsonArray, Object a) {


        PatientData patientData = (PatientData) a;
        String temp = jsonArray.get(0).toString();
        JsonObject jsonObject = new JsonParser().parse(temp).getAsJsonObject();
        String miasto =  jsonObject.get("Miasto").getAsString();
        String ulica= jsonObject.get("Ulica").getAsString();
        String numerDomu = jsonObject.get("NumerDomu").getAsString();
        String numerMieszkania = jsonObject.get("NumerMieszkania").getAsString();
        String KodPocztowy = jsonObject.get("KodPocztowy").getAsString();

        patientData.pacjentAdresKorespondencyjny(miasto,ulica,numerDomu,numerMieszkania,KodPocztowy);

    }

}


//    private void getPacjentWiekOnResponse(JsonArray jsonArray, Activity a) {
//
//        MainActivity mainActivity = (MainActivity) a;
//
//        String temp = jsonArray.get(0).toString();
//
//        JsonObject jsonObject = new JsonParser().parse(temp).getAsJsonObject();
//
//        String wiek = jsonObject.get("wiek").getAsString();
//
//        mainActivity.getPacjentWiek(wiek);
//
//
//    }


//
//    public static class dbFunctions extends AsyncTask<String, Integer, String> {
//
//        String typ = "";
//        String res = "[{}]";
//        private Activity activity;
//
//
//        public dbFunctions(Activity activity, String typ) {
//            this.activity = activity;
//            this.typ = typ;
//        }
//
//        @Override
//        protected void onPreExecute() {
//
//            switch (typ) {
//                case "login":
//                    loginOnPreExecute();
//                    break;
//                case "wypelnijBelke":
//                    wypelnijBelkeOnPreExecute();
//                default:
//                    Log.d("TYP", "Nierozpoznany typ " + typ);
//                    break;
//            }
//        }
//
//        //onPreExecute for login
//        protected void loginOnPreExecute() {
//            LoginActivity loginActivity = (LoginActivity) this.activity;
//            loginActivity.printWarn("Logowanie w toku");
//            loginActivity.disableLoginButton();
//        }
//
//        ;
//
//        protected void wypelnijBelkeOnPreExecute() {
//        }
//
//        @Override
//        protected String doInBackground(String... strings) {
//            String toRet = "";
//
//
//            switch (typ) {
//                case "login":
//                    toRet = loginDoInBackground(strings);
//
//                    break;
//                case "wypelnijBelke":
//                    toRet = wypelnijBelkeDoInBackground(strings);
//            }
//
//            res = toRet;
//            Log.d("DIB ret", res);
//            return toRet;
//        }
//
//
//        // doInBackground for login
//        protected String loginDoInBackground(String... strings) {
//
//            final String login = strings[0];
//            final String password = strings[1];
//            res = "";
//
//            RequestQueue requsetqueue = Volley.newRequestQueue(this.activity.getApplicationContext());
//
//            final String api = "https://nadirdoc.herokuapp.com/api/login";
//
//            StringRequest postRequest = new StringRequest(Method.POST, api,
//                    new Response.Listener<String>() {
//
//
//                        @Override
//                        public void onResponse(String response) {
//                            Log.d("Response", response);
//
//                            res = response;
//
//                        }
//                    },
//                    new Response.ErrorListener() {
//                        @Override
//                        public void onErrorResponse(VolleyError error) {
//                            Log.d("Error.Response", error.getMessage());
//                        }
//                    }) {
//                @Override
//                protected Map<String, String> getParams() {
//                    Map<String, String> params = new HashMap<String, String>();
//                    params.put("login", login);
//                    params.put("hashPass", md5(password));
//
//                    return params;
//
//                }
//            };
//            //add to the request queue
//            requsetqueue.add(postRequest);
//
//
//            return res;
//
//        }
//
//        // doInBackground for Belka
//        protected String wypelnijBelkeDoInBackground(String... strings) {
//            res = "";
//            final String idPacjent = strings[0];
//
//            RequestQueue requsetqueue = Volley.newRequestQueue(this.activity.getApplicationContext());
//
//            final String api = "https://nadirdoc.herokuapp.com/api/pacjentInfo";
//
//            StringRequest postRequest = new StringRequest(Method.POST, api,
//                    new Response.Listener<String>() {
//                        @Override
//                        public void onResponse(String response) {
//                            Log.d("Response", response);
//                            res = response;
//
//                        }
//                    },
//                    new Response.ErrorListener() {
//                        @Override
//                        public void onErrorResponse(VolleyError error) {
//                            Log.d("Error.Response", error.getMessage());
//                        }
//                    }) {
//                @Override
//                protected Map<String, String> getParams() {
//                    Map<String, String> params = new HashMap<String, String>();
//                    params.put("idPacjent", idPacjent);
//
//
//                    return params;
//
//                }
//            };
//            //add to the request queue
//            requsetqueue.add(postRequest);
//
//
//            return res;
//
//        }
//
//
//        @Override
//        protected void onPostExecute(String result) {
//            Log.d("onPostResult", result);
//            switch (typ) {
//
//                case "login":
//                    loginOnPostExecute(result);
//                    break;
//                case "wypelnijBelke":
//                    wypelnijBelkeOnPostExecute(result);
//            }
//
//        }
//
//        private void loginOnPostExecute(String result) {
//            // int id = result.intValue();
//            String res = result;
//            LoginActivity loginActivity = (LoginActivity) this.activity;
//            loginActivity.enableLoginButton();
//            Log.d("PostLAS", ":" + res);
//
//            if (new JsonParser().parse(result).isJsonObject()) {
//                JsonObject jsonObject = new JsonParser().parse(result).getAsJsonObject();
//
//
//                int id = jsonObject.get("idLekarz").getAsInt();
//                Log.d("logPost id", id + "");
//                if (id > 0) {
//                    loginActivity.openMainActivity(id);
//                } else {
//                    loginActivity.printWarn("Logowanie nie powiodło się [1]");
//                }
//
//            } else {
//                loginActivity.printWarn("Logowanie nie powiodło się [2]");
//            }
//        }
//
//        private void wypelnijBelkeOnPostExecute(String result) {
//            // int id = result.intValue();
//            String res = result;
//            MainActivity mainActivity = (MainActivity) this.activity;
//
//            if (new JsonParser().parse(result).isJsonObject()) {
//                JsonObject jsonObject = new JsonParser().parse(result).getAsJsonObject();
//
//
//                String imie = jsonObject.get("Imie").getAsString();
//                String nazwisko = jsonObject.get("Nazwisko").getAsString();
//                String dataurodzenia = jsonObject.get("dataUrodzenia").getAsString();
//                String Pesel = jsonObject.get("Pesel").getAsString();
//
//
//                mainActivity.PacjentInfo(imie, nazwisko, dataurodzenia, Pesel);
//
//            }
//        }
//    }
//


