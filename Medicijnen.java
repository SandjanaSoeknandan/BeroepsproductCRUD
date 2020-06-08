package sr.unasat.jdbc.crud.entities;

import java.security.MessageDigest;

public class Medicijnen {
    private int medicijn_id;
    private String medicijn_naam;
    private int medicijn_aantal;

    public Medicijnen(int medicijn_id, String medicijn_naam, int medicijn_aantal) {
        this.medicijn_id = medicijn_id;
        this.medicijn_naam = medicijn_naam;
        this.medicijn_aantal = medicijn_aantal;
    }

    //Gebruiken voor het inserten
    public Medicijnen(String medicijn_naam, int medicijn_aantal) {
        this.medicijn_naam = medicijn_naam;
        this.medicijn_aantal = medicijn_aantal;
    }

    //Gebruiken voor het deleten en updaten
    public Medicijnen(int medicijn_id) {
        this.medicijn_id = medicijn_id;
    }

    public int getMedicijn_id() {
        return medicijn_id;
    }

    public void setMedicijn_id(int medicijn_id) {
        this.medicijn_id = medicijn_id;
    }

    public String getMedicijn_naam() {
        return medicijn_naam;
    }

    public void setMedicijn_naam(String medicijn_naam) {
        this.medicijn_naam = medicijn_naam;
    }

    public int getMedicijn_aantal() {
        return medicijn_aantal;
    }

    public void setMedicijn_aantal(int medicijn_aantal) {
        this.medicijn_aantal = medicijn_aantal;
    }

    /*
    @Override
    public String toString() {
        return Medicijn_id + "               " +
                Medicijn_naam + "      " + Medicijn_aantal;
    }

    */

    @Override
    public String toString() {
        return "Medicijnen{" +
                "Medicijn_id=" + medicijn_id +
                ", Medicijn_naam='" + medicijn_naam + '\'' +
                ", Medicijn_aantal=" + medicijn_aantal +
                '}';
    }

}
