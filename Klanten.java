package sr.unasat.jdbc.crud.entities;

public class Klanten {

    private int klant_id;
    private String voornaam;
    private String achternaam;
    private int contactnummer;
    private String adress;

    public Klanten(int klant_id, String voornaam, String achternaam, int contactnummer, String adress) {
        this.klant_id = klant_id;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.contactnummer = contactnummer;
        this.adress = adress;
    }

    //Gebruiken voor insert
    public Klanten(String voornaam, String achternaam, int contactnummer, String adress) {
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.contactnummer = contactnummer;
        this.adress = adress;
    }

    //Gebruiken voor delete
    public Klanten(int klant_id) {
        this.klant_id = klant_id;
    }

    public int getKlant_id() {
        return klant_id;
    }

    public void setKlant_id(int klant_id) {
        this.klant_id = klant_id;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public int getContactnummer() {
        return contactnummer;
    }

    public void setContactnummer(int contactnummer) {
        this.contactnummer = contactnummer;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        return "Klanten{" +
                "klant_id=" + klant_id +
                ", voornaam='" + voornaam + '\'' +
                ", achternaam='" + achternaam + '\'' +
                ", contactnummer=" + contactnummer +
                ", adress='" + adress + '\'' +
                '}';
    }
}
