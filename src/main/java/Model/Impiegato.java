package Model;

import java.time.LocalDate;

public class Impiegato {

    private String nome;

    private String cognome;

    private char sesso;

    private LocalDate dataDiNascita;

    private String luogoDiNascita;

    private String cf;

    private LocalDate dataAssunzione;

    private Laboratorio laboratorio;

    private Azienda azienda;

    public Impiegato(String nome, String cognome, char sesso, LocalDate bd, String luogo, String cf, LocalDate assunzione, Azienda azienda) {

        this.nome = nome;

        this.cognome = cognome;

        this.sesso = sesso;

        dataDiNascita = bd;

        luogoDiNascita = luogo;

        this.cf = cf;

        dataAssunzione = assunzione;

        this.azienda = azienda;

        laboratorio = null;
    }

    public String getNome() { return nome; }

    public String getCognome() { return cognome; }

    public char getSesso() {return sesso;}

    public LocalDate getDataDiNascita() { return dataDiNascita; }

    public String getLuogoDiNascita() { return luogoDiNascita; }

    public String getCF() { return cf; }

    public LocalDate getDataAssunzione() { return dataAssunzione; }

    public Laboratorio getLaboratorio() { return laboratorio; }

    public void setNome(String nome) {

        this.nome = nome;
    }

    public void setCognome(String cognome) {

        this.cognome = cognome;
    }

    public void setSesso(char sesso) {

        this.sesso = sesso;
    }

    public void setDataDiNascita(LocalDate dataNascita) {

        dataDiNascita = dataNascita;
    }

    public void setLuogoDiNascita(String luogo) {

        luogoDiNascita = luogo;
    }

    public void setCF(String cf) {

        this.cf = cf;
    }

    public void setDataAssunzione(LocalDate dataAssunzione) {

        this.dataAssunzione = dataAssunzione;
    }

    public void setLaboratorio(Laboratorio laboratorio) {

        this.laboratorio = laboratorio;
    }


}
