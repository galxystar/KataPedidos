package kata.es.publico.tech.kataPedidos.application;

import java.util.List;
import kata.es.publico.tech.kataPedidos.domain.Pedido;

/**
 * Interface para la operación de guardar pedidos.
 * Proporciona un método para almacenar una lista de pedidos en la base de datos o en otro sistema de almacenamiento.
 */
public interface ISaveService {

    /**
     * Guarda una lista de pedidos en el sistema de almacenamiento.
     *
     * @param pedidos La lista de objetos {@link Pedido} que se guardarán.
     */
    public void savePedidos(List<Pedido> pedidos);
}
