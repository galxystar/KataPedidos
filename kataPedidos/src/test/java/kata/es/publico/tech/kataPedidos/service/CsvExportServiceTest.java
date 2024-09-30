package kata.es.publico.tech.kataPedidos.service;

import kata.es.publico.tech.kataPedidos.domain.Pedido;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CsvExportServiceTest {

    @InjectMocks
    private CsvExportService csvExportService;

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

    // Test que verifica si se genera correctamente el archivo CSV
    @Test
    public void testExportarPedidosCSV() {
        String fileName = "test_pedidos.csv";

        // Llamada al método para exportar el CSV
        csvExportService.exportarPedidosCSV(fileName, pedidos);

        // Verificar si el archivo fue creado exitosamente
        File file = new File(fileName);
        assertTrue(file.exists(), "El archivo CSV debería haberse creado correctamente");

        // Eliminar el archivo creado tras la prueba
        file.delete();
    }
}
