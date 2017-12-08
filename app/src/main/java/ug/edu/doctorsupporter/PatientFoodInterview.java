package ug.edu.doctorsupporter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PatientFoodInterview extends Fragment {


    public PatientFoodInterview() {
    }

    private String grupyProduktow;
    private String produkty;
    private String uwagi;

    public String getGrupyProduktow() {
        return grupyProduktow;
    }

    public void setGrupyProduktow(String grupyProduktow) {
        this.grupyProduktow = grupyProduktow;
    }

    public String getProdukty() {
        return produkty;
    }

    public void setProdukty(String produkty) {
        this.produkty = produkty;
    }

    public String getUwagi() {
        return uwagi;
    }

    public void setUwagi(String uwagi) {
        this.uwagi = uwagi;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_patient_food_interview, container, false);
    }



}
