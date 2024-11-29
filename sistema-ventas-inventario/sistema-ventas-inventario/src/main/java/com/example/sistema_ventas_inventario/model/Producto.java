package com.example.sistema_ventas_inventario.model;

import jakarta.persistence.*;

@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private double precio;
    private int stock;

    // Getter y setter manual para 'id'
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Otros getters y setters generados automáticamente o manualmente para los otros campos
}

