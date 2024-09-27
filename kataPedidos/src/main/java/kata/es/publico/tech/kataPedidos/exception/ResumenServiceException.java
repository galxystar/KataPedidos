package kata.es.publico.tech.kataPedidos.exception;

/**
 * Excepción personalizada para manejar errores en el servicio de Resumen.
 */
public class ResumenServiceException extends RuntimeException {
    
    public ResumenServiceException(String message) {
        super(message);
    }

    public ResumenServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}