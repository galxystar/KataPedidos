package kata.es.publico.tech.kataPedidos.exception;

/**
 * Excepción personalizada para manejar errores durante la exportación a CSV.
 */
public class CsvExportException extends RuntimeException {
    
    public CsvExportException(String message) {
        super(message);
    }

    public CsvExportException(String message, Throwable cause) {
        super(message, cause);
    }
}