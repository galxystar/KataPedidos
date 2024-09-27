package kata.es.publico.tech.kataPedidos.utils;

/**
 * Clase auxiliar para mapear los enlaces (links) de la respuesta de la API.
 */
public class Links {
    private String next;
    private String prev;
    private String self;

    // Getters y Setters
    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrev() {
        return prev;
    }

    public void setPrev(String prev) {
        this.prev = prev;
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }
}
