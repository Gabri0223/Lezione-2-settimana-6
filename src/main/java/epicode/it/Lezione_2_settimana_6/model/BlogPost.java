package epicode.it.Lezione_2_settimana_6.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class BlogPost {
    @Id
    @GeneratedValue
    private int id;
    private  String categoria;
    private String titolo;
    private String cover;
    private String contenuto;
    private int tempoLettura;

    @ManyToOne
    @JoinColumn(name = "autore_id")
    private AutorePost autore;
}
