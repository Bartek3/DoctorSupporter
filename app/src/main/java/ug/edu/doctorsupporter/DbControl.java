package ug.edu.doctorsupporter;

import java.sql.Connection;
import java.sql.DriverManager;

import java.security.MessageDigest;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

/**
 * Created by Dominik on 31.10.2017.
 */

class DbControl {
    Connection conn = null;
    String url = "jdbc:mysql://johnny.heliohost.org:3306";
    String userName = "nadirs_doctor";
    String dbpassword = "INSERT PASSWORD HERE"; // !!!!!!!! DO NOT PUSH TO GIT REAL PASSWORD
    //todo load password from external file that is in .gitignore
    String driver = "com.mysql.jdbc.Driver";

    int id=-1;
    public int login(String login, String password) {
        try {
            Statement stmt = null;
            ResultSet rs = null;

            Class.forName (driver);
            conn = DriverManager.getConnection (url, userName, dbpassword);
            System.out.println ("Database connection established");
            String hash = md5(password);
            String query = "SELECT idLekarz FROM nadirs_doctors.Lekarz WHERE login = "+login+" AND passwordHash ="+ hash+";";

            stmt=conn.createStatement();
            rs = stmt.executeQuery(query);
            rs.next();
            id=rs.getInt("idLekarz");


        } catch (Exception e) {

        } finally {
            this.close();
            return id;
        }

    }

    public void close(){
        if (conn != null){
            try{
                    conn.close();
            }
            catch (Exception e){

            }
        }
    }

    public String md5(String s) {
        try {
            // Create MD5 Hash
            MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            for (int i=0; i<messageDigest.length; i++)
                hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
            return hexString.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
