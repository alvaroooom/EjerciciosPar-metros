package com.salesianostriana.dam.ejerciciosparametros.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Producto {
    private long id;
    private String nombre;
    private Double precio;
}
