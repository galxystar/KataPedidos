package kata.es.publico.tech.kataPedidos.service;

import kata.es.publico.tech.kataPedidos.data.impl.SaveData;
import kata.es.publico.tech.kataPedidos.domain.Pedido;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class SaveServiceTest {

    @InjectMocks
    private SaveService saveService;
    
    @Mock
    private SaveData saveData;

    private List<Pedido> pedidos;

    // Inicializa los datos de prueba antes de cada test
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        // Inicializamos datos de ejemplo para los pedidos
        pedidos = new ArrayList<>();
        Pedido pedido = new Pedido();
        pedido.setId("1");
        pedido.setPriority("Alta");
        pedido.setDate("2024-09-23");
        pedido.setRegion("Europa");
        pedido.setCountry("España");
        pedido.setItem_type("Electrónica");
        pedido.setSales_channel("Online");
        pedido.setShip_date("2024-09-25");
        pedido.setUnits_sold(100);
        pedido.setUnit_price(250.0);
        pedido.setUnit_cost(150.0);
        pedido.setTotal_revenue(25000.0);
        pedido.setTotal_cost(15000.0);
        pedido.setTotal_profit(10000.0);

        pedidos.add(pedido);
    }

    // Test para verificar que se llama correctamente al método savePedidos
    @Test
    public void testSavePedidos() {
        // Crear un espía para la instancia del servicio
        SaveService spySaveService = spy(saveService);

        // Llamar al método savePedidos
        spySaveService.savePedidos(pedidos);

        // Verificar que el método savePedidos se llamó exactamente una vez
        verify(spySaveService, times(1)).savePedidos(pedidos);
    }
}
