package com.salesianostriana.dam.ejerciciosparametros.controller;

import com.salesianostriana.dam.ejerciciosparametros.dto.FiltroProductoDto;
import com.salesianostriana.dam.ejerciciosparametros.model.Producto;
import com.salesianostriana.dam.ejerciciosparametros.services.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/producto")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService productoService;

    @GetMapping
    public ResponseEntity<List<Producto>> filtrarProductos(
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) List<String> rangos) {

        FiltroProductoDto filtro = FiltroProductoDto.of(nombre, rangos);
        return ResponseEntity.ok(productoService.filtrar(filtro));
    }

}
