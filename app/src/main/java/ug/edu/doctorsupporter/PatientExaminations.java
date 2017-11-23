package ug.edu.doctorsupporter;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PatientExaminations extends Fragment {

    private String wzorst;
    private String waga;
    private String procentWodyWorganizmie;
    private String masaMiesni;
    private String procentTkankiTluszczowej;
    private String brzuch;
    private String obieNogi;
    private String biodra;
    private String udo;
    private String masaOczekiwna;

    private int idBadania;
    private String dataBadania;

    public int getIdBadania() {
        return idBadania;
    }

    public void setIdBadania(int idBadania) {
        this.idBadania = idBadania;
    }

    public String getDataBadania() {
        return dataBadania;
    }

    public void setDataBadania(String dataBadania) {
        this.dataBadania = dataBadania;
    }

    public String getWzorst() {
        return wzorst;
    }

    public void setWzorst(String wzorst) {
        this.wzorst = wzorst;
    }

    public String getWaga() {
        return waga;
    }

    public void setWaga(String waga) {
        this.waga = waga;
    }

    public String getProcentWodyWorganizmie() {
        return procentWodyWorganizmie;
    }

    public void setProcentWodyWorganizmie(String procentWodyWorganizmie) {
        this.procentWodyWorganizmie = procentWodyWorganizmie;
    }

    public String getMasaMiesni() {
        return masaMiesni;
    }

    public void setMasaMiesni(String masaMiesni) {
        this.masaMiesni = masaMiesni;
    }

    public String getProcentTkankiTluszczowej() {
        return procentTkankiTluszczowej;
    }

    public void setProcentTkankiTluszczowej(String procentTkankiTluszczowej) {
        this.procentTkankiTluszczowej = procentTkankiTluszczowej;
    }

    public String getBrzuch() {
        return brzuch;
    }

    public void setBrzuch(String brzuch) {
        this.brzuch = brzuch;
    }

    public String getObieNogi() {
        return obieNogi;
    }

    public void setObieNogi(String obieNogi) {
        this.obieNogi = obieNogi;
    }

    public String getBiodra() {
        return biodra;
    }

    public void setBiodra(String biodra) {
        this.biodra = biodra;
    }

    public String getUdo() {
        return udo;
    }

    public void setUdo(String udo) {
        this.udo = udo;
    }

    public String getMasaOczekiwna() {
        return masaOczekiwna;
    }

    public void setMasaOczekiwna(String masaOczekiwna) {
        this.masaOczekiwna = masaOczekiwna;
    }



    public PatientExaminations() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_patient_examinations, container, false);
    }

}
