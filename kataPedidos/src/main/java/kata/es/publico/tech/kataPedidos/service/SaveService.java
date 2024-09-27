package kata.es.publico.tech.kataPedidos.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

import org.springframework.stereotype.Service;

import kata.es.publico.tech.kataPedidos.application.ISaveService;
import kata.es.publico.tech.kataPedidos.data.ISaveData;
import kata.es.publico.tech.kataPedidos.domain.Pedido;

/**
 * Clase que implementa el servicio para guardar pedidos.
 */
@Service
public class SaveService implements ISaveService {
    private final ISaveData saveData;

    public SaveService(ISaveData saveData) {
        this.saveData = saveData;
    }

    @Override
    public void savePedidos(List<Pedido> pedidos) {
        // Delegar la tarea de guardar pedidos a SaveData
        saveData.savePedidos(pedidos);
    }
}