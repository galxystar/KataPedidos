package kata.es.publico.tech.kataPedidos.exception;

/**
 * Excepción personalizada para indicar que no se ha encontrado un pedido.
 */
public class PedidoNotFoundException extends RuntimeException {
    
    public PedidoNotFoundException(String message) {
        super(message);
    }
    
    public PedidoNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

