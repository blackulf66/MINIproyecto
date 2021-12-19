package com.salesianostriana.dam.servicios;

import com.salesianostriana.dam.errores.excepciones.ListEntityNotFoundException;
import com.salesianostriana.dam.modelo.Category;
import com.salesianostriana.dam.modelo.POI;
import com.salesianostriana.dam.repositorios.POIRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class POIService extends BaseService<POI,Long, POIRepositorio> {

    @Autowired
    private POIRepositorio poiRepositorio;

    public List<POI> findAll() {
        if (poiRepositorio.findAll().isEmpty()) {
            throw new ListEntityNotFoundException(Category.class);
        } else {
            return poiRepositorio.findAll();
        }
    }

    public Optional<POI> findById(Long id){
        if (poiRepositorio.findById(id).isEmpty()){
            throw new ListEntityNotFoundException(Category.class);
        }else{
            return poiRepositorio.findById(id);
        }
    }


}
