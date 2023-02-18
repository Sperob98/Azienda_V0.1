package Model;

import java.util.ArrayList;

public class Laboratorio {

    private String nome;

    private String topic;

    private ArrayList<Dipendente> impiegati;

    private Senior responsabileScientifico;

    private ArrayList<Progetto> progetti;

    private Azienda azienda;

    public Laboratorio(String nome,String topic,Senior responsabile, Azienda azienda) {

        this.nome = nome;

        this.topic = topic;

        responsabileScientifico = responsabile;

        this.azienda = azienda;

        impiegati = new ArrayList<Dipendente>();

        progetti = new ArrayList<Progetto>();
    }

    public void addImpiegato(Dipendente impiegato) {

        impiegati.add(impiegato);
    }

    public void addProgetto(Progetto progetto) {

        progetti.add(progetto);
    }
}
