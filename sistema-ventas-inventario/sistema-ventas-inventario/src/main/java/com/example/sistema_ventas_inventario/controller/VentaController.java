package com.example.sistema_ventas_inventario.controller;

import com.example.sistema_ventas_inventario.model.Venta;
import com.example.sistema_ventas_inventario.service.VentaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {

    private final VentaService ventaService;

    public VentaController(VentaService ventaService) {
        this.ventaService = ventaService;
    }

    @Operation(summary = "Obtener lista de ventas", description = "Devuelve todas las ventas registradas en el sistema")
    @ApiResponse(responseCode = "200", description = "Ventas obtenidas con éxito")
    @GetMapping
    public List<Venta> obtenerVentas() {
        return ventaService.obtenerTodas();
    }

    @Operation(summary = "Crear una nueva venta", description = "Crea una venta en el sistema",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Venta.class,
                                    example = "{\"fecha\": \"2024-11-28\", \"producto\": {\"id\": 1}, \"cantidad\": 2, \"total\": 200.0}")
                    )
            )
    )
    @ApiResponse(responseCode = "201", description = "Venta creada con éxito")
    @PostMapping
    public Venta crearVenta(@RequestBody Venta venta) {
        return ventaService.guardar(venta);
    }

    @Operation(summary = "Actualizar una venta existente", description = "Actualiza los detalles de una venta en el sistema")
    @ApiResponse(responseCode = "200", description = "Venta actualizada con éxito")
    @PutMapping("/{id}")
    public Venta actualizarVenta(@PathVariable Long id, @RequestBody Venta venta) {
        venta.setId(id);
        return ventaService.guardar(venta);
    }

    @Operation(summary = "Eliminar una venta", description = "Elimina una venta del sistema")
    @ApiResponse(responseCode = "200", description = "Venta eliminada con éxito")
    @DeleteMapping("/{id}")
    public void eliminarVenta(@PathVariable Long id) {
        ventaService.eliminar(id);
    }
}
