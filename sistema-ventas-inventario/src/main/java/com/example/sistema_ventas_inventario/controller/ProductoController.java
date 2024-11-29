package com.example.sistema_ventas_inventario.controller;

import com.example.sistema_ventas_inventario.model.Producto;
import com.example.sistema_ventas_inventario.service.ProductoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @Operation(summary = "Obtener lista de productos", description = "Devuelve todos los productos disponibles en el sistema")
    @ApiResponse(responseCode = "200", description = "Productos obtenidos con éxito")
    @GetMapping
    public List<Producto> obtenerProductos() {
        return productoService.obtenerTodos();
    }

    @Operation(summary = "Crear un nuevo producto", description = "Crea un producto en el sistema")
    @ApiResponse(responseCode = "201", description = "Producto creado con éxito")
    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto) {
        return productoService.guardar(producto);
    }

    @Operation(summary = "Actualizar un producto existente", description = "Actualiza los datos de un producto en el sistema")
    @ApiResponse(responseCode = "200", description = "Producto actualizado con éxito")
    @PutMapping("/{id}")
    public Producto actualizarProducto(@PathVariable Long id, @RequestBody Producto producto) {
        producto.setId(id);
        return productoService.guardar(producto);
    }

    @Operation(summary = "Eliminar un producto", description = "Elimina un producto del sistema")
    @ApiResponse(responseCode = "200", description = "Producto eliminado con éxito")
    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable Long id) {
        productoService.eliminar(id);
    }
}
