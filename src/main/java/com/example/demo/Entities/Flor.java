package com.example.demo.Entities;

import lombok.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Data
@Table(name = "tbl_flor")
public class Flor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String color;
    private String variedad;
    private String tipoDeFlor;
    private Integer cantidad;
    private Integer precioDeCompra;
    private Integer precioDeVenta;
}
