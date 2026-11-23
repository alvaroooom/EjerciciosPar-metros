package com.salesianostriana.dam.ejerciciosparametros.dto;

import java.util.List;

public record FiltroProductoDto(
        String nombre,
        List<RangoPrecio> rangos
) {

    public static FiltroProductoDto of(String nombre, List<String> rangos) {
        return new FiltroProductoDto(
                nombre,
                rangos != null
                        ? rangos.stream().map(RangoPrecio::of).toList()
                        : List.of()
        );
    }

}
