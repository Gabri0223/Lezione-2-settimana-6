package epicode.it.Lezione_2_settimana_6.exception;

import epicode.it.Lezione_2_settimana_6.model.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;

@RestControllerAdvice
public class CustomizedExceptionHandler {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ApiError notFoundExceptionHandler(NotFoundException e){
        ApiError error=new ApiError();
      error.setMessage(e.getMessage());
      error.setDataErrore(LocalDate.now());
      return error;
    }
}
