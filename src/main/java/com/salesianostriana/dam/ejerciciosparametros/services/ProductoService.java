package com.salesianostriana.dam.ejerciciosparametros.services;

import com.salesianostriana.dam.ejerciciosparametros.dto.FiltroProductoDto;
import com.salesianostriana.dam.ejerciciosparametros.model.Producto;
import com.salesianostriana.dam.ejerciciosparametros.repo.ProductoRepository;
import com.salesianostriana.dam.ejerciciosparametros.spec.ProductoSpecifications;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoService {

    private final ProductoRepository productoRepository;

    public List<Producto> filtrar(FiltroProductoDto filtro) {
        return productoRepository.findAll(ProductoSpecifications.filtrar(filtro));
    }
}
