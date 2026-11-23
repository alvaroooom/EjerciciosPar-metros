package com.salesianostriana.dam.ejerciciosparametros.repo;

import com.salesianostriana.dam.ejerciciosparametros.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
