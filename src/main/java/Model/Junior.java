package Model;

import java.time.LocalDate;

public class Junior extends Dipendente{

    public Junior(String nome, String cognome, char sesso, LocalDate bd, String luogo, String cf, LocalDate assunzione, float stipendio, Azienda azienda) {

        super(nome,cognome,sesso,bd,luogo,cf,assunzione, stipendio, azienda);
    }

}
