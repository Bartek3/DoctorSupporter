package ug.edu.doctorsupporter;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class PatientDiseases extends Fragment {


    DbControl dbc;

    private int idDolegliwosci;
    private String nazwaDolegliwosci;
    private String uwagiDolegliwosc;

    public int getIdDolegliwosci() {
        return idDolegliwosci;
    }

    public void setIdDolegliwosci(int idDolegliwosci) {
        this.idDolegliwosci = idDolegliwosci;
    }

    public String getNazwaDolegliwosci() {
        return nazwaDolegliwosci;
    }

    public void setNazwaDolegliwosci(String nazwaDolegliwosci) {
        this.nazwaDolegliwosci = nazwaDolegliwosci;
    }

    public String getUwagiDolegliwosc() {
        return uwagiDolegliwosc;
    }

    public void setUwagiDolegliwosc(String uwagiDolegliwosc) {
        this.uwagiDolegliwosc = uwagiDolegliwosc;
    }


   @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       
       /*dbc = new DbControl();
       String[] params = {"1", "0"};
       dbc.task(this, "belka4", "getChoroby", params);*/

        return inflater.inflate(R.layout.fragment_patient_diseases, container, false);
    }

//    public void listChorobyUwagi(ArrayList<String> uwagi) {
//        TextView names = (TextView) getView().findViewById(R.id.uwagiChorobyTV);
//        names.setText("");
//        String temp = "";
//        for (String t : uwagi) {
//            temp += t + "\n";
//        }
//        names.setText(temp);
//    }
//
//     public void showChoroby(String uwagiDolegliwosc) {
//         Log.d("PD:sC",uwagiDolegliwosc);
//        TextView wyswietl = (TextView) getView().findViewById(R.id.uwagiChorobyTV);
//
//
//        wyswietl.setText(uwagiDolegliwosc);
//
//
//
//    }

//    public void showNazwaChoroby(String nazwaDolegliwosci) {
//        Log.d("PD:sC", nazwaDolegliwosci);
//        TextView wyswietl = (TextView) getView().findViewById(R.id.nazwaChorobyTV);
//
//        wyswietl.setText(nazwaDolegliwosci);
//    }


}
