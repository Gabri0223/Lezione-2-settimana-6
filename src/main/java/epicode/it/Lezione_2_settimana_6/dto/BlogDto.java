package epicode.it.Lezione_2_settimana_6.dto;

import epicode.it.Lezione_2_settimana_6.model.AutorePost;
import lombok.Data;

@Data
public class BlogDto {
        private int id;
        private  String categoria;
        private String titolo;
        private String cover;
        private String contenuto;
        private int tempoLettura;
        private int autoreId;
}
