package kata.es.publico.tech.kataPedidos.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import kata.es.publico.tech.kataPedidos.application.IResumenService;
import kata.es.publico.tech.kataPedidos.domain.Pedido;
import kata.es.publico.tech.kataPedidos.exception.ResumenServiceException;
@Service
public class ResumenService implements IResumenService{

	@Override
	public String mostrarResumen(List<Pedido> listaPedidos) {
        StringBuilder resumenBuilder = new StringBuilder(); // Crear un StringBuilder para construir el resumen

		try {
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
                resumenBuilder.append("\n- Resumen por ").append(campo).append(":\n");
                Map<String, Integer> conteoCampo = resumen.get(campo);
                for (Map.Entry<String, Integer> entry : conteoCampo.entrySet()) {
                    resumenBuilder.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
                }
            }
            
            // Imprimir el resumen por pantalla
            System.out.println(resumenBuilder.toString());
            
		} catch (Exception e) {
			
			throw new ResumenServiceException("Se ha producido un error al generar el resumen de los pedidos.", e);
		}

        return resumenBuilder.toString(); // Devolver el resumen como String
	  
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
