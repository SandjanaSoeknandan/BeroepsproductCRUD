package sr.unasat.jdbc.crud.entities;

public class TT_Medicijnen_Klanten {

    private Medicijnen medicijnen;
    private Klanten klanten;
    private int aantal_verkocht;

    //Gebruiken voor invoeren
    public TT_Medicijnen_Klanten(Medicijnen medicijnen, Klanten klanten, int aantal_verkocht) {
        this.medicijnen = medicijnen;
        this.klanten = klanten;
        this.aantal_verkocht = aantal_verkocht;
    }

    //delete methode
    public TT_Medicijnen_Klanten(Medicijnen medicijnen, Klanten klanten) {
        this.medicijnen = medicijnen;
        this.klanten = klanten;
    }

    //update methode
    public TT_Medicijnen_Klanten(Medicijnen medicijnen) {
        this.medicijnen = medicijnen;
    }

    public Medicijnen getMedicijnen() {
        return medicijnen;
    }

    public void setMedicijnen(Medicijnen medicijnen) {
        this.medicijnen = medicijnen;
    }

    public Klanten getKlanten() {
        return klanten;
    }

    public void setKlanten(Klanten klanten) {
        this.klanten = klanten;
    }

    public int getAantal_verkocht() {
        return aantal_verkocht;
    }

    public void setAantal_verkocht(int aantal_verkocht) {
        this.aantal_verkocht = aantal_verkocht;
    }

    @Override
    public String toString() {
        return medicijnen + "  " + "Aantal_verkocht: " + aantal_verkocht + " " + klanten ;
    }
}
