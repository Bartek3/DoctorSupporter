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
import java.text.DateFormat;
import java.text.SimpleDateFormat;

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
//
//    public Pacjent Informacje(int idPacjent) {
//        String imie = null;
//        String nazwisko = null;
//        String dataurodzenia = null;
//        String Pesel = null;
//        int AdresZamieszkania = -1;
//        int AdresKorespondencyjny = -1;
//        int OddzialNFZ = -1;
//        Pacjent pacjent = null;
//
//        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
//
//        try {
//            Statement stmt = null;
//            ResultSet rs = null;
//
//            Class.forName(driver);
//            conn = DriverManager.getConnection(url, userName, dbpassword);
//            System.out.println("Database connection established");
//            String query = "SELECT * FROM nadirs_doctors.Pacjent WHERE idPacjent = " + idPacjent + ";";
//
//            stmt = conn.createStatement();
//            rs = stmt.executeQuery(query);
//
//            while (rs.next()) {
//                imie = rs.getString("Imie");
//                nazwisko = rs.getString("Nazwisko");
//                String reportDate = df.format(rs.getDate("dataUrodzenia"));
//                Pesel = rs.getString("Pesel");
//                AdresZamieszkania = rs.getInt("AdresZamieszkania");
//                AdresKorespondencyjny = rs.getInt("AdresKorespondencyjny");
//                OddzialNFZ = rs.getInt("OddzialNFZ");
//                pacjent = new Pacjent(idPacjent, imie, nazwisko, dataurodzenia, Pesel, AdresZamieszkania,
//                        AdresKorespondencyjny, OddzialNFZ);
//            }
//
//        } catch (Exception e) {
//
//        } finally {
//            try {
//                conn.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//            return pacjent;
//        }
//
//    }

    public static class LoginAsync extends AsyncTask<String, Integer, Integer> {

        Connection conn = null;
        String url = "jdbc:mysql://johnny.heliohost.org/nadirs_doctors";
        String userName = "nadirs_doctor";
        String dbpassword = "TO DO PASSWORD FROM EXTERNAL RESOURCE, A do tego czasu INSERT PASSWORD HERE"; // !!!!!!!! DO NOT PUSH TO GIT REAL PASSWORD
        //todo load password from external file that is in .gitignore
        String driver = "com.mysql.jdbc.Driver";


        private int id = -1;
        private LoginActivity activity;

        public LoginAsync(LoginActivity activity) {
            this.activity = activity;
        }

        @Override
        protected void onPreExecute(){
            activity.printWarn("Logowanie w toku");
            activity.disableLoginButton();
        }
        @Override
        protected Integer doInBackground(String... strings) {

            String login = strings[0];
            String password = strings[1];
            // int id = -1;
            try {
                Statement stmt = null;
                ResultSet rs = null;

                Class.forName(driver).newInstance();


                conn = DriverManager.getConnection(url, userName, dbpassword);

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
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return Integer.valueOf(id);
            }
        }

        @Override
        protected void onPostExecute(Integer result) {
            activity.enableLoginButton();
            Log.d("PostLAS", ":" + id);
            if(id>0){
                activity.openMainActivity(id);
            }
            else{
                activity.printWarn("Logowanie nie powiodło się");
            }
        }
    }
}
