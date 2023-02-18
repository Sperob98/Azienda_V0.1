package Model;

import java.time.LocalDate;

public class Dipendente extends Impiegato {

    private float stipendio;

    public Dipendente(String nome, String cognome, char sesso, LocalDate bd, String luogo, String cf, LocalDate assunzione, float stipendio, Azienda azienda) {

        super(nome,cognome,sesso,bd,luogo,cf,assunzione,azienda);

        this.stipendio = stipendio;

    }
}
