package ug.edu.doctorsupporter;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PatientHistory extends Fragment {

    private int idDolegliwosci;
    private String dataDolegliwosci;
    private String statusDolegliwosci; // wyleczone, niewyleczone itp

    public int getIdDolegliwosci() {
        return idDolegliwosci;
    }

    public void setIdDolegliwosci(int idDolegliwosci) {
        this.idDolegliwosci = idDolegliwosci;
    }

    public String getDataDolegliwosci() {
        return dataDolegliwosci;
    }

    public void setDataDolegliwosci(String dataDolegliwosci) {
        this.dataDolegliwosci = dataDolegliwosci;
    }

    public String getStatusDolegliwosci() {
        return statusDolegliwosci;
    }

    public void setStatusDolegliwosci(String statusDolegliwosci) {
        this.statusDolegliwosci = statusDolegliwosci;
    }

    public String getZrealizowaneBadnaia() {
        return zrealizowaneBadnaia;
    }

    public void setZrealizowaneBadnaia(String zrealizowaneBadnaia) {
        this.zrealizowaneBadnaia = zrealizowaneBadnaia;
    }

    public String getRozpoznanieKliniczne() {
        return rozpoznanieKliniczne;
    }

    public void setRozpoznanieKliniczne(String rozpoznanieKliniczne) {
        this.rozpoznanieKliniczne = rozpoznanieKliniczne;
    }

    public String getOpisDolegliwosci() {
        return opisDolegliwosci;
    }

    public void setOpisDolegliwosci(String opisDolegliwosci) {
        this.opisDolegliwosci = opisDolegliwosci;
    }

    public String getDataDolegliwosciOD() {
        return dataDolegliwosciOD;
    }

    public void setDataDolegliwosciOD(String dataDolegliwosciOD) {
        this.dataDolegliwosciOD = dataDolegliwosciOD;
    }

    public String getDataDolegliwosciDO() {
        return dataDolegliwosciDO;
    }

    public void setDataDolegliwosciDO(String dataDolegliwosciDO) {
        this.dataDolegliwosciDO = dataDolegliwosciDO;
    }

    public String getZalecenia() {
        return zalecenia;
    }

    public void setZalecenia(String zalecenia) {
        this.zalecenia = zalecenia;
    }

    public String getLekarzProwadzacy() {
        return lekarzProwadzacy;
    }

    public void setLekarzProwadzacy(String lekarzProwadzacy) {
        this.lekarzProwadzacy = lekarzProwadzacy;
    }

    private String zrealizowaneBadnaia;
    private String rozpoznanieKliniczne;
    private String opisDolegliwosci;
    private String dataDolegliwosciOD;
    private String dataDolegliwosciDO;
    private String zalecenia;
    private String lekarzProwadzacy;










    public PatientHistory() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_patient_history, container, false);
    }

}
