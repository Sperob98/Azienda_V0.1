package Model;

import java.util.ArrayList;

public class Azienda {

    private ArrayList<Impiegato> impiegati;

    private ArrayList<Laboratorio> laboratori;

    private ArrayList<Progetto> progetti;

    public Azienda() {

        impiegati = new ArrayList<Impiegato>();

        laboratori = new ArrayList<Laboratorio>();

        progetti = new ArrayList<Progetto>();

    }

    public void addEmployee(Impiegato impiegato) {

        impiegati.add(impiegato);
    }

    public void addLaboratory(Laboratorio laboratorio) {

        laboratori.add(laboratorio);
    }

    public void addProject(Progetto progetto) {

        progetti.add(progetto);
    }

}
