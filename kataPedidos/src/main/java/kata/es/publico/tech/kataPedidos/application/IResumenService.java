package kata.es.publico.tech.kataPedidos.application;

import java.util.List;
import kata.es.publico.tech.kataPedidos.domain.Pedido;

/**
 * Interface para la generación de un resumen de los pedidos.
 * Proporciona un método para mostrar el resumen de una lista de pedidos.
 */
public interface IResumenService {

    /**
     * Genera y muestra un resumen de la lista de pedidos proporcionada.
     *
     * @param listaPedidos La lista de objetos {@link Pedido} de la cual se generará el resumen.
     */
    public void mostrarResumen(List<Pedido> listaPedidos);
}
