package Model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Dirigente extends Dipendente {

    private LocalDate passaggioMiddle;

    private LocalDate passaggioSenior;

    private LocalDate passaggioDirigente;

    private ArrayList<Progetto> progResponsabile;

    public Dirigente(String nome, String cognome, char sesso, LocalDate bd, String luogo, String cf, LocalDate assunzione, float stipendio, LocalDate middle, LocalDate senior, LocalDate dirigente, Azienda azienda) {

        super(nome,cognome,sesso,bd,luogo,cf,assunzione, stipendio, azienda);

        passaggioMiddle = middle;

        passaggioSenior = senior;

        passaggioDirigente = dirigente;

        progResponsabile = new ArrayList<Progetto>();
    }

    public LocalDate getPassaggioMiddle() { return passaggioMiddle;}

    public LocalDate getPassaggioSenior() { return passaggioSenior; }

    public LocalDate getPassaggioDirigente() { return passaggioDirigente; }

    public void setPassaggioMiddle(LocalDate passaggioMiddle) {

        this.passaggioMiddle = passaggioMiddle;
    }

    public void setPassaggioSenior(LocalDate passaggioSenior) {

        this.passaggioSenior = passaggioSenior;
    }

    public void setPassaggioDirigente(LocalDate passaggioDirigente) {

        this.passaggioDirigente = passaggioDirigente;
    }

    public void addProgetto(Progetto progetto) {

        progResponsabile.add(progetto);
    }
}
