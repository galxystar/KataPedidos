package kata.es.publico.tech.kataPedidos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kata.es.publico.tech.kataPedidos.domain.Pedido;
import kata.es.publico.tech.kataPedidos.application.IPedidoService;
import kata.es.publico.tech.kataPedidos.application.ICsvExportService;
import kata.es.publico.tech.kataPedidos.application.IResumenService;
import kata.es.publico.tech.kataPedidos.application.ISaveService;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private IPedidoService iPedidoService;  // Inyectamos el servicio de pedidos

    @Autowired
    private ISaveService iSaveService;       // Servicio para guardar pedidos

    @Autowired
    private IResumenService iResumenService; // Servicio para mostrar el resumen

    @Autowired
    private ICsvExportService iCsvExportService; // Servicio para exportar pedidos a CSV

    /**
     * Endpoint para obtener todos los pedidos y realizar las acciones necesarias.
     * 
     * @return Un mensaje con el número total de pedidos procesados.
     */
    @GetMapping("/all")
    public String getAllPedidos() {
        try {
            // Obtener todos los pedidos desde el servicio
            List<Pedido> pedidos = iPedidoService.getAllPedidos();

            // Guardar los pedidos en la base de datos (descomentar si es necesario)
     //       iSaveService.savePedidos(pedidos);

            // Mostrar el resumen de pedidos (descomentar si es necesario)
            iResumenService.mostrarResumen(pedidos);

            // Exportar pedidos a un archivo CSV (descomentar si es necesario)
            iCsvExportService.exportarPedidosCSV("FicheroPedidos.csv", pedidos);

            // Devolver un mensaje con el número total de pedidos procesados
            return "Pedidos obtenidos y procesados: " + pedidos.size();
            
        } catch (Exception e) {
            e.printStackTrace();
            return "Ocurrió un error al procesar los pedidos: " + e.getMessage();
        }
    }
}
