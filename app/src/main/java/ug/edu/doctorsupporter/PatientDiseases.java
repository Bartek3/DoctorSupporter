package ug.edu.doctorsupporter;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PatientDiseases extends Fragment {

    private int idChoroby;

    public int getIdChoroby() {
        return idChoroby;
    }

    public void setIdChoroby(int idChoroby) {
        this.idChoroby = idChoroby;
    }

    public String getNazwaChoroby() {
        return nazwaChoroby;
    }

    public void setNazwaChoroby(String nazwaChoroby) {
        this.nazwaChoroby = nazwaChoroby;
    }

    public String getOpischorobty() {
        return opischorobty;
    }

    public void setOpischorobty(String opischorobty) {
        this.opischorobty = opischorobty;
    }

    public String getOpisLeczenia() {
        return opisLeczenia;
    }

    public void setOpisLeczenia(String opisLeczenia) {
        this.opisLeczenia = opisLeczenia;
    }

    private String nazwaChoroby;
    private String opischorobty;
    private String opisLeczenia;


    public PatientDiseases() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_patient_diseases, container, false);
    }

}
