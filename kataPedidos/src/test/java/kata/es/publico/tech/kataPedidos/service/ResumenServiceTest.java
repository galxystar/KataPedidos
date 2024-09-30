package kata.es.publico.tech.kataPedidos.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import kata.es.publico.tech.kataPedidos.domain.Pedido;

import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.jupiter.api.Assertions.assertNotNull; 

public class ResumenServiceTest {

    @InjectMocks
    private ResumenService resumenService;

    private List<Pedido> pedidos;

    // Inicializa los datos de prueba antes de cada test
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        // Inicializamos datos de ejemplo para los pedidos
        pedidos = new ArrayList<>();
        Pedido pedido = new Pedido();
        pedido.setId("1");
        pedido.setCountry("España");
        pedidos.add(pedido);
    }

    // Test para verificar el resumen de los pedidos
    @Test
    public void testMostrarResumen() {
        // Llamar al método para mostrar el resumen
      String resumen =  resumenService.mostrarResumen(pedidos);

      // Comprobar que el el contador de Resumen por country sea 1
      assertNotNull(resumen); // Verificar que el resumen no sea nulo
      assertThat(resumen, containsString("España: 1"));
    }
}
