package kg.megacom.Final.Project.exceptions;

import kg.megacom.Final.Project.models.response.exception.ResponseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandling{
    @ExceptionHandler({EntityNotFoundEx.class})
    public ResponseEntity<?> handleCreateEntityException(EntityNotFoundEx ex){
        return new ResponseEntity(ResponseException.getErrorResponse(ex.getMessage()), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler({SaveTroubleException.class})
    public ResponseEntity<?> handleCreateSaveException(SaveTroubleException ex){
        return new ResponseEntity(ResponseException.getErrorResponse(ex.getMessage()), HttpStatus.CONFLICT);
    }

}
