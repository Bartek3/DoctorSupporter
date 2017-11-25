package ug.edu.doctorsupporter;

/**
 * Created by Andrzej on 02.11.2017.
 */



public class PacjentBelka {

        private int id;
        private  String imie;
        private  String nazwisko;
        private String dataurodzenia;
        private String Pesel;
        private int AdresZamieszkania;
        private int AdresKorespondencyjny;
        private int  OddzialNFZ;

    public PacjentBelka (int id, String imie, String nazwisko, String dataurodzenia, String Pesel, int AdresZamieszkania,
                    int AdresKorespondencyjny, int OddzialNFZ) {

        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko  ;
        this.dataurodzenia = dataurodzenia;
        this.Pesel = Pesel;
        this.AdresZamieszkania = AdresZamieszkania;
        this.AdresKorespondencyjny = AdresKorespondencyjny;
        this.OddzialNFZ = OddzialNFZ;

    }

    public int getId() {
        return id;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getDataurodzenia() {
        return dataurodzenia;
    }

    public String getPesel() {
        return Pesel;
    }

    public int getAdresZamieszkania() {
        return AdresZamieszkania;
    }

    public int getAdresKorespondencyjny() {
        return AdresKorespondencyjny;
    }

    public int getOddzialNFZ() {
        return OddzialNFZ;
    }


}
