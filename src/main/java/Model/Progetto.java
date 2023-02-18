package Model;

import java.awt.dnd.DragGestureEvent;
import java.time.LocalDate;
import java.util.ArrayList;

public class Progetto {

    private String cup;

    private String nome;

    private LocalDate dataInizio;

    private LocalDate dataFine;

    private double budget;

    private double spesaAttrezzatura;

    private double spesaDipendenti;

    private ArrayList<Laboratorio> laboratori;

    private Senior referenteScientifico;

    private Dirigente responsabile;

    private ArrayList<Collaboratore> collaboratori;

    private Azienda azienda;

    public Progetto(String cup, String nome, LocalDate dataInizio, double budget, Laboratorio laboratorio, Senior referente, Dirigente responsabile, Azienda azienda) {

        this.cup = cup;

        this.nome = nome;

        this.dataInizio = dataInizio;

        this.budget = budget;

        laboratori = new ArrayList<Laboratorio>();

        laboratori.add(laboratorio);

        this.referenteScientifico = referente;

        this.responsabile = responsabile;

        this.azienda = azienda;
    }

    public void addLaboratorio(Laboratorio laboratorio) {

        laboratori.add(laboratorio);
    }
}
