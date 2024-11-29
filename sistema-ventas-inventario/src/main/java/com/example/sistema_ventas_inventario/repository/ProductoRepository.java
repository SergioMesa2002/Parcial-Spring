package com.example.sistema_ventas_inventario.repository;

import com.example.sistema_ventas_inventario.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
