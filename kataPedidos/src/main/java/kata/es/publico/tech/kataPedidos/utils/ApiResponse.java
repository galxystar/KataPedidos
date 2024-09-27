package kata.es.publico.tech.kataPedidos.utils;

import java.util.List;
import kata.es.publico.tech.kataPedidos.domain.Pedido;

/**
 * Clase auxiliar para mapear la respuesta de la API.
 */
public class ApiResponse {
    private int page;
    private List<Pedido> content;
    private Links links; // Agregar el campo links para mapear los enlaces.

    /**
     * Obtiene el número de página de la respuesta.
     *
     * @return El número de página de la respuesta.
     */
    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    /**
     * Obtiene la lista de pedidos en la respuesta.
     *
     * @return Una lista de objetos {@link Pedido} que representan los pedidos.
     */
    public List<Pedido> getContent() {
        return content;
    }

    public void setContent(List<Pedido> content) {
        this.content = content;
    }

    /**
     * Obtiene los enlaces para paginación.
     *
     * @return Un objeto {@link Links} que contiene los enlaces de la respuesta.
     */
    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }
}
