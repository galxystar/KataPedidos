package kata.es.publico.tech.kataPedidos.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import kata.es.publico.tech.kataPedidos.application.IResumenService;
import kata.es.publico.tech.kataPedidos.domain.Pedido;
@Service
public class ResumenService implements IResumenService{
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mi_base_de_datos"; 
    private static final String DB_USER = "admin";
    private static final String DB_PASSWORD = "admin";

	@Override
	public void mostrarResumen(List<Pedido> listaPedidos) {
	    // Definir los campos para agrupar el resumen
	    String[] campos = { "region", "country", "item_type", "sales_channel", "priority" };

	    // Map para almacenar el conteo de cada campo
	    Map<String, Map<String, Integer>> resumen = new HashMap<>();

	    // Inicializar los mapas de resumen para cada campo
	    for (String campo : campos) {
	        resumen.put(campo, new HashMap<>());
	    }

	    // Recorrer la lista de pedidos y actualizar los conteos en los mapas correspondientes
	    for (Pedido pedido : listaPedidos) {
	        incrementarConteo(resumen.get("region"), pedido.getRegion());
	        incrementarConteo(resumen.get("country"), pedido.getCountry());
	        incrementarConteo(resumen.get("item_type"), pedido.getItem_type());
	        incrementarConteo(resumen.get("sales_channel"), pedido.getSales_channel());
	        incrementarConteo(resumen.get("priority"), pedido.getPriority());
	    }

	    // Mostrar el resumen por cada campo
	    for (String campo : campos) {
	        System.out.println("Resumen por " + campo + ":");
	        Map<String, Integer> conteoCampo = resumen.get(campo);
	        for (Map.Entry<String, Integer> entry : conteoCampo.entrySet()) {
	            System.out.println(entry.getKey() + ": " + entry.getValue());
	        }
	    }
	}

	/**
	 * Incrementa el conteo de ocurrencias de un valor en un mapa.
	 * Si el valor ya existe en el mapa, incrementa su conteo en 1.
	 * Si no existe, lo añade al mapa con un conteo inicial de 1.
	 * 
	 * @param mapa El mapa que almacena los conteos de cada valor.
	 * @param valor El valor cuyo conteo se debe incrementar.
	 */
	private void incrementarConteo(Map<String, Integer> mapa, String valor) {
	    mapa.put(valor, mapa.getOrDefault(valor, 0) + 1);
	}

}
