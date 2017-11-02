package ug.edu.doctorsupporter;

/**
 * Created by Andrzej on 02.11.2017.
 */

public class Pacjent {

    private int id;
      private  String imie = null;
        private  String nazwisko = null;
        private String dataurodzenia = null;
        private String Pesel = null;
        private int AdresZamieszkania = -1;
        private int AdresKorespondencyjny = -1;
        private int  OddzialNFZ = -1;


    public Pacjent (int id, String imie, String nazwisko, String dataurodzenia, String Pesel, int AdresZamieszkania,
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
