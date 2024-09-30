package kata.es.publico.tech.kataPedidos.application;

import java.util.List;
import kata.es.publico.tech.kataPedidos.domain.Pedido;

/**
 * Interface para la obtención de pedidos desde el servicio web.
 * Proporciona un método para obtener todos los pedidos disponibles.
 */
public interface IPedidoService {

    /**
     * Obtiene todos los pedidos disponibles en el servicio web.
     * Este método incluye la lógica de paginación para obtener grandes cantidades de datos.
     *
     * @return Una lista de objetos {@link Pedido} obtenidos desde el servicio web.
     * @throws Exception Si ocurre un error durante la solicitud o el procesamiento de los pedidos.
     */
    public List<Pedido> getAllPedidos() throws Exception;
}
