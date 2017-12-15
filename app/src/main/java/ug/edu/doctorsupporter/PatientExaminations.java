package ug.edu.doctorsupporter;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PatientExaminations extends Fragment {

    private int idBadania;
    private String rodzajBadania;  // badanie zostało wygenerowane w formie tabelarycznej - tekstowej wtedy mamy załącznik/ bądz obrazowej np. badanie rentgenowskie
    private String nazwaBadania;
    private String statusBadania;

    private String dataODbadania;
    private String dataDObadania;
    private String opisBadnia;

    private String objawyZgloszonePrzezPacjenta;
    private String RozpoznanieKliniczne;
    private String Zalecenia;

    public int getIdBadania() {
        return idBadania;
    }

    public void setIdBadania(int idBadania) {
        this.idBadania = idBadania;
    }

    public String getRodzajBadania() {
        return rodzajBadania;
    }

    public void setRodzajBadania(String rodzajBadania) {
        this.rodzajBadania = rodzajBadania;
    }

    public String getNazwaBadania() {
        return nazwaBadania;
    }

    public void setNazwaBadania(String nazwaBadania) {
        this.nazwaBadania = nazwaBadania;
    }

    public String getStatusBadania() {
        return statusBadania;
    }

    public void setStatusBadania(String statusBadania) {
        this.statusBadania = statusBadania;
    }

    public String getDataODbadania() {
        return dataODbadania;
    }

    public void setDataODbadania(String dataODbadania) {
        this.dataODbadania = dataODbadania;
    }

    public String getDataDObadania() {
        return dataDObadania;
    }

    public void setDataDObadania(String dataDObadania) {
        this.dataDObadania = dataDObadania;
    }

    public String getOpisBadnia() {
        return opisBadnia;
    }

    public void setOpisBadnia(String opisBadnia) {
        this.opisBadnia = opisBadnia;
    }

    public String getObjawyZgloszonePrzezPacjenta() {
        return objawyZgloszonePrzezPacjenta;
    }

    public void setObjawyZgloszonePrzezPacjenta(String objawyZgloszonePrzezPacjenta) {
        this.objawyZgloszonePrzezPacjenta = objawyZgloszonePrzezPacjenta;
    }

    public String getRozpoznanieKliniczne() {
        return RozpoznanieKliniczne;
    }

    public void setRozpoznanieKliniczne(String rozpoznanieKliniczne) {
        RozpoznanieKliniczne = rozpoznanieKliniczne;
    }

    public String getZalecenia() {
        return Zalecenia;
    }

    public void setZalecenia(String zalecenia) {
        Zalecenia = zalecenia;
    }


    public PatientExaminations() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_patient_examinations, container, false);
    }

}
