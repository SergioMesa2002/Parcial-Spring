package com.example.sistema_ventas_inventario.controller;

import com.example.sistema_ventas_inventario.model.Venta;
import com.example.sistema_ventas_inventario.service.VentaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {

    private final VentaService ventaService;

    public VentaController(VentaService ventaService) {
        this.ventaService = ventaService;
    }

    @GetMapping
    public List<Venta> obtenerVentas() {
        return ventaService.obtenerTodas();
    }

    @PostMapping
    public Venta crearVenta(@RequestBody Venta venta) {
        return ventaService.guardar(venta);
    }
}
