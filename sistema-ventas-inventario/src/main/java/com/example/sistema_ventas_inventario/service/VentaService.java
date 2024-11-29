package com.example.sistema_ventas_inventario.service;

import com.example.sistema_ventas_inventario.model.Venta;
import com.example.sistema_ventas_inventario.repository.VentaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaService {

    private final VentaRepository ventaRepository;

    public VentaService(VentaRepository ventaRepository) {
        this.ventaRepository = ventaRepository;
    }

    public List<Venta> obtenerTodas() {
        return ventaRepository.findAll();
    }

    public Venta guardar(Venta venta) {
        return ventaRepository.save(venta);
    }

    // Método para eliminar una venta por su ID
    public void eliminar(Long id) {
        ventaRepository.deleteById(id);  // Esto elimina la venta usando el ID
    }
}
