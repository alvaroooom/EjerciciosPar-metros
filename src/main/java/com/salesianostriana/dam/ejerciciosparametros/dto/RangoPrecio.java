package com.salesianostriana.dam.ejerciciosparametros.dto;

public record RangoPrecio (
        Double max,
        Double min
) {
    public static RangoPrecio of(String rango){
        String[] partes = rango.split("-");
        return new RangoPrecio(
                Double.valueOf(partes[0].trim()),
                Double.valueOf(partes[1].trim())
        );
    }

}


