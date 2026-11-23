package com.salesianostriana.dam.ejerciciosparametros.spec;

import com.salesianostriana.dam.ejerciciosparametros.dto.FiltroProductoDto;
import com.salesianostriana.dam.ejerciciosparametros.dto.RangoPrecio;
import com.salesianostriana.dam.ejerciciosparametros.model.Producto;
import org.springframework.data.jpa.domain.PredicateSpecification;

import java.util.List;

public class ProductoSpecifications {

    // WHERE LOWER(nombre) LIKE '%texto%'
    public static PredicateSpecification<Producto> nombreContiene(String nombre) {
        return (root, cb) -> cb.like(
                cb.lower(root.get("nombre")),
                "%" + nombre.toLowerCase() + "%"
        );
    }

    // WHERE precio BETWEEN min AND max
    public static PredicateSpecification<Producto> precioEntre(Double min, Double max) {
        return (root, cb) -> cb.between(root.get("precio"), min, max);
    }

    // Combina todo: (rango1 OR rango2 OR ...) AND nombre
    public static PredicateSpecification<Producto> filtrar(FiltroProductoDto filtro) {

        PredicateSpecification<Producto> spec = PredicateSpecification.unrestricted();

        // Los rangos se unen con OR: el producto vale si cae en cualquiera de ellos
        if (filtro.rangos() != null && !filtro.rangos().isEmpty()) {
            List<PredicateSpecification<Producto>> rangos = filtro.rangos().stream()
                    .map(r -> precioEntre(r.min(), r.max()))
                    .toList();
            spec = spec.and(PredicateSpecification.anyOf(rangos));
        }

        // El nombre se une con AND al resto
        if (filtro.nombre() != null && !filtro.nombre().isBlank()) {
            spec = spec.and(nombreContiene(filtro.nombre()));
        }

        return spec;
    }

}
