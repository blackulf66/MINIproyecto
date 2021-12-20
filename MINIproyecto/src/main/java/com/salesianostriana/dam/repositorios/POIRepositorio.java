package com.salesianostriana.dam.repositorios;

import com.salesianostriana.dam.modelo.POI;
import org.springframework.data.jpa.repository.JpaRepository;

public interface POIRepositorio extends JpaRepository<POI, Long> {

    boolean existsByName(String name);

}
