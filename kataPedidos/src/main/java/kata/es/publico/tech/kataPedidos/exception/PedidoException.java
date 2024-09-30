package kata.es.publico.tech.kataPedidos.exception;

/**
 * Excepción personalizada para Pedido Serviceindicar que no se ha encontrado un pedido.
 */
public class PedidoException extends RuntimeException {
    
    public PedidoException(String message) {
        super(message);
    }
    
    public PedidoException(String message, Throwable cause) {
        super(message, cause);
    }
}

