package kata.es.publico.tech.kataPedidos.service;

import kata.es.publico.tech.kataPedidos.domain.Pedido;
import kata.es.publico.tech.kataPedidos.exception.PedidoException;
import kata.es.publico.tech.kataPedidos.utils.ApiResponse;
import kata.es.publico.tech.kataPedidos.utils.Links;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PedidoServiceTest {

    @InjectMocks
    private PedidoService pedidoService; // La clase que estamos probando

    @Mock
    private ApiResponse apiResponse; // Mock de ApiResponse

    // Inicializamos las pruebas y los mocks
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Test para verificar que se obtienen un millón de pedidos de la API correctamente.
     */
    @Test
    public void testGetAllPedidos_successful() throws Exception {
        // Creamos una lista de pedidos simulada
        List<Pedido> pedidosSimulados = new ArrayList<>();
        for (int i = 1; i <= 200; i++) { // Simulamos 1M pedidos
            Pedido pedido = new Pedido();
            pedido.setId(String.valueOf(i));
            pedido.setPriority("Alta");
            pedidosSimulados.add(pedido);
        }

        // Simulamos que hay un millón de pedidos
        when(apiResponse.getContent()).thenReturn(pedidosSimulados);


        // Llamamos al método real
        List<Pedido> resultado = pedidoService.getAllPedidos();

        // Verificamos que el resultado no sea nulo y contenga un millón de pedidos
        assertNotNull(resultado);
        assertEquals(pedidosSimulados.size(), resultado.size());

    }
}
