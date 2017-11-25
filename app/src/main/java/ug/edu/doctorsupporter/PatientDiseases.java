package ug.edu.doctorsupporter;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PatientDiseases extends Fragment {

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








    public PatientDiseases() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_patient_diseases, container, false);
    }

}
