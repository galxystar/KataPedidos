package kata.es.publico.tech.kataPedidos.exception;

/**
 * Excepción personalizada para manejar errores en el servicio de guardar pedidos.
 */
public class SaveServiceException extends RuntimeException {
    
    public SaveServiceException(String message) {
        super(message);
    }

    public SaveServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}