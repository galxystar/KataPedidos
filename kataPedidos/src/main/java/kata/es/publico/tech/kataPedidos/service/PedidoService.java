package kata.es.publico.tech.kataPedidos.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import kata.es.publico.tech.kataPedidos.application.IPedidoService;
import kata.es.publico.tech.kataPedidos.domain.Pedido;
import kata.es.publico.tech.kataPedidos.exception.PedidoException;
import kata.es.publico.tech.kataPedidos.utils.ApiResponse;

/**
 * Clase que proporciona servicios relacionados con la obtención de pedidos
 * desde un servicio web externo con soporte de paginación.
 */
@Service
public class PedidoService implements IPedidoService{

    // URL base de la API para obtener los pedidos
    private final static String BASE_URL_PEDIDOS = "https://kata-espublicotech.g3stiona.com/v1/orders";

    /**
     * Obtiene todos los pedidos disponibles en la API, recorriendo todas las páginas.
     *
     * @param pagina Número de la página a obtener. Si es {@code null}, comenzará desde la página 1.
     * @param maxPorPagina Máximo número de pedidos por página. Este valor debe ser positivo.
     * @return Una lista de objetos {@link Pedido} obtenidos desde el servicio web.
     * @throws PedidoException Si ocurre un error durante la solicitud o el procesamiento de la respuesta.
     */
    public List<Pedido> getAllPedidos(Integer pagina, Integer maxPorPagina) throws Exception {
        // Lista que almacenará todos los pedidos
        List<Pedido> allPedidos = new ArrayList<>();
        
        // Inicializamos la página en 1 si 'pagina' es nula, de lo contrario usamos el valor proporcionado
        int currentPage = (pagina != null) ? pagina : 1;
        
        // Inicializamos el numero maxi de paginas en 100 si 'maxPorPagina' es nulo, de lo contrario usamos el valor proporcionado
        int currentMax= (maxPorPagina != null) ? maxPorPagina : 100;
        
        boolean morePages = true;
        
		try {
			
	        while (morePages) {
	            // Construimos la URL para la página actual con los parámetros dinámicos
	            String paginatedUrl = BASE_URL_PEDIDOS + "?page=" + currentPage + "&max-per-page=" + currentMax;

	            // Realizamos la solicitud HTTP para obtener la página actual
	            ApiResponse apiResponse = fetchPedidosFromUrl(paginatedUrl);

	            if (apiResponse == null || apiResponse.getContent().isEmpty()) {
	                // Si no hay más pedidos en la página actual, detenemos el ciclo
	                morePages = false;
	            } else {
	                // Añadimos los pedidos de la página actual a la lista completa
	                allPedidos.addAll(apiResponse.getContent());

	                // Verificamos si hay un enlace "next" para continuar paginando
	                morePages = apiResponse.getLinks().getNext() != null;
	            }
	            // Avanzamos a la siguiente página
	            currentPage++;
	        }
	        return allPedidos; // Retornamos todos los pedidos obtenidos
	        
	    } catch (Exception e) {
            throw new PedidoException("Se ha producido un error al obtener los pedidos.", e);
        }
        // Mientras haya más páginas con pedidos, seguiremos solicitando

    }

    /**
     * Realiza una solicitud HTTP GET a una URL específica y devuelve la respuesta deserializada.
     *
     * @param urlString La URL a la que se realizará la solicitud.
     * @return Un objeto {@link ApiResponse} con la respuesta de la API.
     * @throws Exception Si ocurre un error durante la solicitud o el procesamiento de la respuesta.
     */
    protected ApiResponse fetchPedidosFromUrl(String urlString) throws Exception {
        // Configuración de la conexión HTTP
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");

        // Verificar el código de respuesta
        int responseCode = connection.getResponseCode();
        if (responseCode == 204) {
            // Si obtenemos un 204 (No Content), retornamos null para indicar que no hay más contenido
            return null;
        } else if (responseCode != 200) {
            throw new RuntimeException("Fallo en la solicitud: Código HTTP " + responseCode);
        }

        // Leer la respuesta desde el servidor
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close(); // Cerrar el lector de la respuesta
        connection.disconnect(); // Desconectar la conexión

        // Deserializar el JSON en un objeto ApiResponse
        Gson gson = new Gson();
        Type apiResponseType = new TypeToken<ApiResponse>() {}.getType();
        return gson.fromJson(content.toString(), apiResponseType); // Retornar la respuesta deserializada
    }
}
