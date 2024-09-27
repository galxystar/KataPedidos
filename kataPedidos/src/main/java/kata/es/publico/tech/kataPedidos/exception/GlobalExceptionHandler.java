package kata.es.publico.tech.kataPedidos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * Manejador global de excepciones para capturar y gestionar excepciones de la aplicación.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PedidoNotFoundException.class)
    public ResponseEntity<String> handlePedidoNotFound(PedidoNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CsvExportException.class)
    public ResponseEntity<String> handleCsvExportException(CsvExportException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResumenServiceException.class)
    public ResponseEntity<String> handleResumenServiceException(ResumenServiceException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(SaveServiceException.class)
    public ResponseEntity<String> handleSaveServiceException(SaveServiceException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Manejador de excepciones general para casos no contemplados
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(Exception ex) {
        return new ResponseEntity<>("Ocurrió un error inesperado: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}