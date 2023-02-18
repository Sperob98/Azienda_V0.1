package Model;

import java.time.LocalDate;

public class Middle extends Dipendente{

    private LocalDate passaggioMiddle;

    public Middle(String nome, String cognome, char sesso, LocalDate bd, String luogo, String cf, LocalDate assunzione, float stipendio, LocalDate middle, Azienda azienda) {

        super(nome,cognome,sesso,bd,luogo,cf,assunzione, stipendio, azienda);

        passaggioMiddle = middle;

    }

    public LocalDate getPassaggioMiddle() { return passaggioMiddle;}

    public void setPassaggioMiddle(LocalDate passaggioMiddle) {

        this.passaggioMiddle = passaggioMiddle;
    }
}
