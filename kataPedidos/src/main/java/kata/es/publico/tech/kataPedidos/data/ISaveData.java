package kata.es.publico.tech.kataPedidos.data;

import java.util.List;

import kata.es.publico.tech.kataPedidos.domain.Pedido;

/**
 * Interfaz que define los métodos para guardar datos en la base de datos.
 */
public interface ISaveData {
    /**
     * Guarda una lista de pedidos en la base de datos.
     *
     * @param listaPedidos La lista de objetos {@link Pedido} a guardar.
     */
    void savePedidos(List<Pedido> listaPedidos);
}