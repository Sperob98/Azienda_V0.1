package Model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Senior extends Dipendente {

    private LocalDate passaggioMiddle;

    private LocalDate passaggioSenior;

    private ArrayList<Laboratorio> labResponsabile;

    private ArrayList<Progetto> progReferente;

    public Senior(String nome, String cognome, char sesso, LocalDate bd, String luogo, String cf, LocalDate assunzione, float stipendio, LocalDate middle, LocalDate senior, Azienda azienda) {

        super(nome,cognome,sesso,bd,luogo,cf,assunzione, stipendio, azienda);

        passaggioMiddle = middle;

        passaggioSenior = senior;

        labResponsabile = new ArrayList<Laboratorio>();

        progReferente = new ArrayList<Progetto>();
    }

    public LocalDate getPassaggioMiddle() { return passaggioMiddle;}

    public LocalDate getPassaggioSenior() { return passaggioSenior; }

    public void setPassaggioMiddle(LocalDate passaggioMiddle) {

        this.passaggioMiddle = passaggioMiddle;
    }

    public void setPassaggioSenior(LocalDate passaggioSenior) {

        this.passaggioSenior = passaggioSenior;
    }

    public void addLaboratorio(Laboratorio laboratorio) {

        labResponsabile.add(laboratorio);

    }

    public void addReferente(Progetto progetto) {

        progReferente.add(progetto);
    }
}
