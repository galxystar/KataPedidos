package kata.es.publico.tech.kataPedidos.application;

import java.util.List;
import kata.es.publico.tech.kataPedidos.domain.Pedido;

/**
 * Interfaz para la obtención de pedidos desde el servicio web.
 * Proporciona un método para obtener todos los pedidos disponibles.
 */
public interface IPedidoService {

    /**
     * Obtiene todos los pedidos disponibles en el servicio web.
     * Este método incluye la lógica de paginación para obtener grandes cantidades de datos.
     *
     * @param pagina Número de la página a obtener. Si es {@code null}, comenzará desde la página 1.
     * @param maxPorPagina Máximo número de pedidos a recuperar por página. Si es {@code null}, se establece a 100.
     * @return Una lista de objetos {@link Pedido} obtenidos desde el servicio web.
     * @throws Exception Si ocurre un error durante la solicitud o el procesamiento de los pedidos.
     */
    public List<Pedido> getAllPedidos(Integer pagina, Integer maxPorPagina) throws Exception;
}
