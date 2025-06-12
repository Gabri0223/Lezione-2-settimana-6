package epicode.it.Lezione_2_settimana_6.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AutorePost {
    private int id;
    private String nome;
    private String cognome;
    private String email;
    private LocalDate dataDiNascita;
    private String avatar;
}
