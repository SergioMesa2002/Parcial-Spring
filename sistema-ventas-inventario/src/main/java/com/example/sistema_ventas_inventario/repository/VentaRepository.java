package com.example.sistema_ventas_inventario.repository;

import com.example.sistema_ventas_inventario.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaRepository extends JpaRepository<Venta, Long> {
}

