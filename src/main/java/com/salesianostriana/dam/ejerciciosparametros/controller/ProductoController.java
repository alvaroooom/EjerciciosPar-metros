package com.salesianostriana.dam.ejerciciosparametros.controller;

import com.salesianostriana.dam.ejerciciosparametros.dto.FiltroProductoDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {

    @GetMapping
    public ResponseEntity<FiltroProductoDto> filtrarProductos(
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) List<String> rangos) {

        FiltroProductoDto filtro = FiltroProductoDto.of(nombre, rangos);

        System.out.println("Filtrado por nombre: " + filtro.nombre());
        filtro.rangos().forEach(r ->
                System.out.println("Filtrado por rango de precio: " + r.min() + " - " + r.max()));

        return ResponseEntity.ok(filtro);
    }

}
