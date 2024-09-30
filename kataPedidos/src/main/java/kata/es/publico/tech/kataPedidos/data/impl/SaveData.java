package kata.es.publico.tech.kataPedidos.data.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

import org.springframework.stereotype.Service;

import kata.es.publico.tech.kataPedidos.data.ISaveData;
import kata.es.publico.tech.kataPedidos.domain.Pedido;
import kata.es.publico.tech.kataPedidos.exception.PedidoException;
import kata.es.publico.tech.kataPedidos.exception.SaveServiceException;

/**
 * Clase que implementa la interfaz {@link ISaveData}.
 * Esta clase se encarga de establecer la conexión a la base de datos
 * y guardar la información de los pedidos en ella.
 */
@Service
public class SaveData implements ISaveData {
    
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mi_base_de_datos"; // Ajusta la URL a tu BD
    private static final String DB_USER = "admin";
    private static final String DB_PASSWORD = "admin";

    @Override
    public void savePedidos(List<Pedido> pedidos) {
        // Creamos la query con el orden establecido
        String query = "INSERT INTO pedidos (uuid, id, region, country, item_type, sales_channel, priority, date, ship_date, units_sold, unit_price, unit_cost, total_revenue, total_cost, total_profit)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        // Iniciamos conexión con la base de datos
        try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             // Creamos PreparedStatement que son SQL precompilados
             PreparedStatement pst = con.prepareStatement(query)) {

            // Set de cada pedido hasta completarlos
            for (Pedido pedido : pedidos) {
                pst.setString(1, pedido.getUuid());
                pst.setString(2, pedido.getId());
                pst.setString(3, pedido.getRegion());
                pst.setString(4, pedido.getCountry());
                pst.setString(5, pedido.getItem_type());
                pst.setString(6, pedido.getSales_channel());
                pst.setString(7, pedido.getPriority());
                pst.setString(8, pedido.getDate());
                pst.setString(9, pedido.getShip_date());
                pst.setInt(10, pedido.getUnits_sold());
                pst.setDouble(11, pedido.getUnit_price());
                pst.setDouble(12, pedido.getUnit_cost());
                pst.setDouble(13, pedido.getTotal_revenue());
                pst.setDouble(14, pedido.getTotal_cost());
                pst.setDouble(15, pedido.getTotal_profit());
                // Se añaden las querys hasta acabar los pedidos
                pst.addBatch();
            }
            // Se ejecutan todas las querys precompiladas
            pst.executeBatch();

        } catch (Exception e) {
        	  throw new SaveServiceException("Se ha producido un error al guardar los pedidos en BBDD.", e);
        }
    }
}