package kata.es.publico.tech.kataPedidos.application;

import java.util.List;

import kata.es.publico.tech.kataPedidos.domain.Pedido;

public interface IResumenService {
	public void mostrarResumen(List<Pedido> listaPedidos);
}
