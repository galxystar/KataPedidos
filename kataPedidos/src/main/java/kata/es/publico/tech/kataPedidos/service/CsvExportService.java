package kata.es.publico.tech.kataPedidos.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import kata.es.publico.tech.kataPedidos.application.ICsvExportService;
import kata.es.publico.tech.kataPedidos.domain.Pedido;
import kata.es.publico.tech.kataPedidos.exception.CsvExportException;
/**
 * Clase que implementa la interfaz {@link ICsvExportService} para exportar una lista de pedidos
 * a un archivo CSV.
 * 
 * <p>La cabecera del archivo CSV generado incluirá las siguientes columnas:</p>
 * <ul>
 *     <li>Order ID</li>
 *     <li>Order Priority</li>
 *     <li>Order Date</li>
 *     <li>Region</li>
 *     <li>Country</li>
 *     <li>Item Type</li>
 *     <li>Sales Channel</li>
 *     <li>Ship Date</li>
 *     <li>Units Sold</li>
 *     <li>Unit Price</li>
 *     <li>Unit Cost</li>
 *     <li>Total Revenue</li>
 *     <li>Total Cost</li>
 *     <li>Total Profit</li>
 * </ul>
 * 
 * <p>La clase utiliza un {@link FileWriter} para escribir en el archivo CSV y manejar el proceso 
 * de exportación.</p>
 * 
 * <p>Las excepciones que puedan ocurrir durante la escritura del archivo son capturadas y 
 * manejadas con un bloque try-catch.</p>
 * 
 * @author Emilian Vornicu
 */
@Service
public class CsvExportService implements ICsvExportService{
    /**
     * Exporta una lista de pedidos a un archivo CSV. El archivo resultante estará 
     * ordenado por el campo "Order ID" y contendrá las siguientes columnas:
     * Order ID, Order Priority, Order Date, Region, Country, Item Type, Sales Channel,
     * Ship Date, Units Sold, Unit Price, Unit Cost, Total Revenue, Total Cost, Total Profit.
     * 
     * @param nombreArchivoCSV El nombre del archivo CSV donde se exportarán los pedidos.
     * @param listaPedidos La lista de objetos Pedido que se exportarán al archivo CSV.
     */
    @Override
    public void exportarPedidosCSV(String nombreArchivoCSV, List<Pedido> listaPedidos) {
        try (FileWriter exportCSV = new FileWriter(nombreArchivoCSV)) {

            // Escribir la cabecera del CSV
            exportCSV.append(
                    "Order ID,Order Priority,Order Date,Region,Country,Item Type,Sales Channel,Ship Date,Units Sold,Unit Price,Unit Cost,Total Revenue,Total Cost,Total Profit\n");

            // Iterar sobre la lista de pedidos y escribir cada uno en el archivo CSV
            for (Pedido pedido : listaPedidos) {

                // Escribir los detalles del pedido en el archivo CSV
                exportCSV.append(pedido.getId()).append(",");
                exportCSV.append(pedido.getPriority()).append(",");
                exportCSV.append(pedido.getDate()).append(",");
                exportCSV.append(pedido.getRegion()).append(",");
                exportCSV.append(pedido.getCountry()).append(",");
                exportCSV.append(pedido.getItem_type()).append(",");
                exportCSV.append(pedido.getSales_channel()).append(",");
                exportCSV.append(pedido.getShip_date()).append(",");
                exportCSV.append(String.valueOf(pedido.getUnits_sold())).append(",");
                exportCSV.append(String.valueOf(pedido.getUnit_price())).append(",");
                exportCSV.append(String.valueOf(pedido.getUnit_cost())).append(",");
                exportCSV.append(String.valueOf(pedido.getTotal_revenue())).append(",");
                exportCSV.append(String.valueOf(pedido.getTotal_cost())).append(",");
                exportCSV.append(String.valueOf(pedido.getTotal_profit())).append("\n");
            }
            
            // Confirmación de la ruta del archivo generado
            System.out.println("Archivo CSV generado en: " + new File(nombreArchivoCSV).getAbsolutePath());


        } catch (IOException e) {
            throw new CsvExportException("Error al exportar pedidos a CSV.", e);
        }

    }

}
