package sr.unasat.jdbc.crud.entities;

public class Bestellingen {

    private int bestelling_id;
    private String datum;
    private int aantal;
    private String verantwoordelijke;
    private Medicijnen medicijnen;

    public Bestellingen(int bestelling_id, String datum, int aantal, String verantwoordelijke, Medicijnen medicijnen) {
        this.bestelling_id = bestelling_id;
        this.datum = datum;
        this.aantal = aantal;
        this.verantwoordelijke = verantwoordelijke;
        this.medicijnen = medicijnen;
    }

    //Gebruiken bij het inserten
    public Bestellingen(String datum, int aantal, String verantwoordelijke) {
        this.datum = datum;
        this.aantal = aantal;
        this.verantwoordelijke = verantwoordelijke;
    }

    //Gebruiken bij het deleten
    public Bestellingen(int bestelling_id) {
        this.bestelling_id = bestelling_id;
    }

    public int getBestelling_id() {
        return bestelling_id;
    }

    public void setBestelling_id(int bestelling_id) {
        this.bestelling_id = bestelling_id;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public int getAantal() {
        return aantal;
    }

    public void setAantal(int aantal) {
        this.aantal = aantal;
    }

    public String getVerantwoordelijke() {
        return verantwoordelijke;
    }

    public void setVerantwoordelijke(String verantwoordelijke) {
        this.verantwoordelijke = verantwoordelijke;
    }

    public Medicijnen getMedicijnen() {
        return medicijnen;
    }

    public void setMedicijnen(Medicijnen medicijnen) {
        this.medicijnen = medicijnen;
    }

    @Override
    public String toString() {
        return bestelling_id + "               " + datum + "        " + aantal
                + "     " + verantwoordelijke + "  " + medicijnen;
    }
}
