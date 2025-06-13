package epicode.it.Lezione_2_settimana_6.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class AutorePost {
    @Id
    @GeneratedValue
    private int id;
    private String nome;
    private String cognome;
    private String email;
    private LocalDate dataDiNascita;
    private String avatar;

    @OneToMany(mappedBy="autore")
    @JsonIgnore
    private  BlogPost blogPost;

}
