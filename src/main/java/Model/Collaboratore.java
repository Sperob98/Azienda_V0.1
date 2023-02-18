package Model;

import java.time.LocalDate;

public class Collaboratore extends Impiegato {

    private LocalDate scadenzaContratto;

    private float compenso;

    private Progetto progetto;


    public Collaboratore(String nome, String cognome, char sesso, LocalDate bd, String luogo, String cf, LocalDate assunzione, LocalDate scadenza, float compenso, Progetto progetto, Azienda azienda) {

        super(nome, cognome, sesso, bd, luogo, cf, assunzione, azienda);

        scadenzaContratto = scadenza;

        this.compenso = compenso;

        this.progetto = progetto;
    }

    public LocalDate getScadenzaContratto() { return scadenzaContratto; }

    public float getCompenso() { return compenso;};

    public Progetto getProgetto() { return progetto;};

    public void setScadenzaContratto(LocalDate scadenza) {

        scadenzaContratto = scadenza;

    }

    public void setCompenso(float compenso) {

        this.compenso = compenso;

    }

    public void setProgetto(Progetto progetto) {

        this.progetto = progetto;

    }

}
