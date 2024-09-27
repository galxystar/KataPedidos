package kata.es.publico.tech.kataPedidos.application;

import java.util.List;

import kata.es.publico.tech.kataPedidos.domain.Pedido;

public interface ICsvExportService {
	 public void exportarPedidosCSV(String nombreArchivoCSV,List<Pedido> listaPedidos);
}
