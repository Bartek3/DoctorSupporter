package ug.edu.doctorsupporter;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
        //private int id = -1;
        Connection conn = null;

        private Activity activity;


        public dbFunctions(Activity activity, String typ) {
            this.activity = activity;
            this.typ = typ;
        }

        private Connection connect() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {

            Connection conn = null;
            String url = "jdbc:mysql://johnny.heliohost.org/nadirs_doctors";
            String userName = "nadirs_doctor";
            String dbpassword = "PASSWORD"; // !!!!!!!! DO NOT PUSH TO GIT REAL PASSWORD
            //todo load password from external file that is in .gitignore
            String driver = "com.mysql.jdbc.Driver";


            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url, userName, dbpassword);

            return conn;
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

            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return toRet;
        }

        // doInBackground for login
        protected Integer loginDoInBackground(String... strings) {

            String login = strings[0];
            String password = strings[1];
            int id = -1;
            try {
                Statement stmt = null;
                ResultSet rs = null;


                conn = this.connect();
                System.out.println("Database connection established");
                String hash = DbControl.md5(password);
                String query = "SELECT idLekarz FROM Lekarz WHERE login = \"" + login + "\" AND passwordHash =\"" + hash + "\";";

                stmt = conn.createStatement();
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    id = rs.getInt("idLekarz");
                }

            } catch (Exception e) {

                Log.d("LoginException: ", e.toString());

            } finally {
                Log.d("finallyLAS", "!!!!!");

                return Integer.valueOf(id);
            }

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
