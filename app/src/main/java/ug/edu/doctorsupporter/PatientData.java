package ug.edu.doctorsupporter;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class PatientData extends Fragment {

    DbControl dbc;

    private int idPacjenta;
    private String imie;
    private String nazwisko;
    private String ulica;
    private String nrBudynku;
    private String kodPocztowy;
    private String miejscowosc;
    private String wojewodztwo;
    private String kraj;
    private String nrTelefonuPacjenta;
    private String oddzialNFZ;
    private String lekarzProwadzacy;
    private String email;
    private String pesel;
    private String nrDowoduOsobistego;
    private String plec;
    private String wzrost;
    private String waga;
    private String grupaKrwi;
    private String osobaDoPowiadomienia; // imie nazwisko
    private String nrTelOsDoPowiadomienia;
    private String emailOsDoPowiadomienia;
    private String powinowactwo;
    private String alergieUczulenia;
    private String zalaczniki;  // załaczniki badań, obrazów rentgenowskich, itp itd etc.

    public int getIdPacjenta() {
        return idPacjenta;
    }

    public void setIdPacjenta(int idPacjenta) {
        this.idPacjenta = idPacjenta;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getNrBudynku() {
        return nrBudynku;
    }

    public void setNrBudynku(String nrBudynku) {
        this.nrBudynku = nrBudynku;
    }

    public String getKodPocztowy() {
        return kodPocztowy;
    }

    public void setKodPocztowy(String kodPocztowy) {
        this.kodPocztowy = kodPocztowy;
    }

    public String getMiejscowosc() {
        return miejscowosc;
    }

    public void setMiejscowosc(String miejscowosc) {
        this.miejscowosc = miejscowosc;
    }

    public String getWojewodztwo() {
        return wojewodztwo;
    }

    public void setWojewodztwo(String wojewodztwo) {
        this.wojewodztwo = wojewodztwo;
    }

    public String getKraj() {
        return kraj;
    }

    public void setKraj(String kraj) {
        this.kraj = kraj;
    }

    public String getNrTelefonuPacjenta() {
        return nrTelefonuPacjenta;
    }

    public void setNrTelefonuPacjenta(String nrTelefonuPacjenta) {
        this.nrTelefonuPacjenta = nrTelefonuPacjenta;
    }

    public String getOddzialNFZ() {
        return oddzialNFZ;
    }

    public void setOddzialNFZ(String oddzialNFZ) {
        this.oddzialNFZ = oddzialNFZ;
    }

    public String getLekarzProwadzacy() {
        return lekarzProwadzacy;
    }

    public void setLekarzProwadzacy(String lekarzProwadzacy) {
        this.lekarzProwadzacy = lekarzProwadzacy;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getNrDowoduOsobistego() {
        return nrDowoduOsobistego;
    }

    public void setNrDowoduOsobistego(String nrDowoduOsobistego) {
        this.nrDowoduOsobistego = nrDowoduOsobistego;
    }

    public String getPlec() {
        return plec;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    public String getWzrost() {
        return wzrost;
    }

    public void setWzrost(String wzrost) {
        this.wzrost = wzrost;
    }

    public String getWaga() {
        return waga;
    }

    public void setWaga(String waga) {
        this.waga = waga;
    }

    public String getGrupaKrwi() {
        return grupaKrwi;
    }

    public void setGrupaKrwi(String grupaKrwi) {
        this.grupaKrwi = grupaKrwi;
    }

    public String getOsobaDoPowiadomienia() {
        return osobaDoPowiadomienia;
    }

    public void setOsobaDoPowiadomienia(String osobaDoPowiadomienia) {
        this.osobaDoPowiadomienia = osobaDoPowiadomienia;
    }

    public String getNrTelOsDoPowiadomienia() {
        return nrTelOsDoPowiadomienia;
    }

    public void setNrTelOsDoPowiadomienia(String nrTelOsDoPowiadomienia) {
        this.nrTelOsDoPowiadomienia = nrTelOsDoPowiadomienia;
    }

    public String getEmailOsDoPowiadomienia() {
        return emailOsDoPowiadomienia;
    }

    public void setEmailOsDoPowiadomienia(String emailOsDoPowiadomienia) {
        this.emailOsDoPowiadomienia = emailOsDoPowiadomienia;
    }

    public String getPowinowactwo() {
        return powinowactwo;
    }

    public void setPowinowactwo(String powinowactwo) {
        this.powinowactwo = powinowactwo;
    }

    public String getAlergieUczulenia() {
        return alergieUczulenia;
    }

    public void setAlergieUczulenia(String alergieUczulenia) {
        this.alergieUczulenia = alergieUczulenia;
    }

    public String getZalaczniki() {
        return zalaczniki;
    }

    public void setZalaczniki(String zalaczniki) {
        this.zalaczniki = zalaczniki;
    }



    public void PacjentInfo(String imie, String nazwisko, String dataurodzenia, String Pesel) {



        TextView wyswietl1 = (TextView) getView().findViewById(R.id.imiePDTV);

        wyswietl1.setText(imie);

        TextView wyswietl2 = (TextView) getView().findViewById((R.id.nazwiskoPDTV));
        wyswietl2.setText(nazwisko);

        TextView wyswietl3 = (TextView) getView().findViewById((R.id.dataUroPDTV));
        wyswietl3.setText(dataurodzenia);

        TextView wyswietl4 = (TextView) getView().findViewById((R.id.peselPDTV));
        wyswietl4.setText(Pesel);

    }


    public void pacjentAdres(String... Adres) {
        String adres = Adres[1] + " " +Adres[2]+" "+Adres[3]+"/n"+Adres[4]+Adres[0];

        TextView wyswietl1 = (TextView) getView().findViewById(R.id.adresPDTV);

        wyswietl1.setText(adres);


    }

    public void pacjentAdresKorespondencyjny(String... Adres) {
        String adres = Adres[1] + " " +Adres[2]+" "+Adres[3]+"/n"+Adres[4]+Adres[0];

        TextView wyswietl1 = (TextView) getView().findViewById(R.id.adresKorPDTV);

        wyswietl1.setText(adres);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        final Handler handler = new Handler();

        dbc = new DbControl();

        final String [] params = {"1"};


                dbc.task(this, "belka5", "pacjentInfo", params);

        final Object tmp = this;
        handler.postDelayed(new Runnable() {
            @Override
            public void run(){
                dbc.task(tmp, "belka6", "pacjentAdres", params);
            }
        }, 500 );


        handler.postDelayed(new Runnable() {
            @Override
            public void run(){
                dbc.task(tmp, "belka7", "pacjentAdresKorespondencyjny", params);
            }
        }, 1000 );


        return inflater.inflate(R.layout.fragment_patient_data, container, false);

    }

}
