package kata.es.publico.tech.kataPedidos.application;

import java.util.List;
import kata.es.publico.tech.kataPedidos.domain.Pedido;

/**
 * Interface para la exportación de pedidos a un archivo CSV.
 * Proporciona un método para generar un archivo CSV a partir de una lista de pedidos.
 */
public interface ICsvExportService {

    /**
     * Exporta una lista de pedidos a un archivo CSV.
     *
     * @param nombreArchivoCSV El nombre del archivo CSV donde se exportarán los pedidos.
     * @param listaPedidos      La lista de objetos {@link Pedido} que serán exportados al archivo CSV.
     */
    public void exportarPedidosCSV(String nombreArchivoCSV, List<Pedido> listaPedidos);
}
