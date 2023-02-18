package Model;

public class Lavorare {

    private int ore;

    private Dipendente dip;

    private Progetto progetto;

    public Lavorare(Dipendente emp, Progetto progetto, int ore) {

        dip = emp;

        this.progetto = progetto;

        this.ore = ore;
    }
}
