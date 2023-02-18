package Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;

public class Fornitura {

    private LocalDate dataAcquisto;

    private float prezzo;

    private Laboratorio laboratorio;

    private Progetto progetto;

    private ArrayList<Attrezzatura> attrezzature;

    public Fornitura(Laboratorio lab, Progetto prog, ArrayList<Attrezzatura> attr, LocalDate date, float prezzo ) {

        dataAcquisto = date;

        this.prezzo = prezzo;

        laboratorio =lab;

        progetto = prog;

        attrezzature = attr;
    }
}
