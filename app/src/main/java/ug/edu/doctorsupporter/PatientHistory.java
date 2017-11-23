package ug.edu.doctorsupporter;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PatientHistory extends Fragment {

    private int idChoroby;

    public int getIdChoroby() {
        return idChoroby;
    }

    public void setIdChoroby(int idChoroby) {
        this.idChoroby = idChoroby;
    }

    public String getOpisChoroby() {
        return opisChoroby;
    }

    public void setOpisChoroby(String opisChoroby) {
        this.opisChoroby = opisChoroby;
    }

    public String getDataChoroby() {
        return dataChoroby;
    }

    public void setDataChoroby(String dataChoroby) {
        this.dataChoroby = dataChoroby;
    }

    public String getLeczenie() {
        return leczenie;
    }

    public void setLeczenie(String leczenie) {
        this.leczenie = leczenie;
    }

    public String getZalaczniki() {
        return zalaczniki;
    }

    public void setZalaczniki(String zalaczniki) {
        this.zalaczniki = zalaczniki;
    }

    private String opisChoroby;
    private String dataChoroby;
    private String leczenie;
    private String zalaczniki;




    public PatientHistory() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_patient_history, container, false);
    }

}
