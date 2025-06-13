package epicode.it.Lezione_2_settimana_6.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ApiError {
    private String message;
    private LocalDate dataErrore;
}
