package com.salesianostriana.dam.servicios;

import com.salesianostriana.dam.errores.excepciones.ListEntityNotFoundException;
import com.salesianostriana.dam.modelo.Category;
import com.salesianostriana.dam.modelo.Route;
import com.salesianostriana.dam.repositorios.RouteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RouteService extends BaseService<Route,Long, RouteRepositorio> {

    @Autowired
    private RouteRepositorio routeRepositorio;

    public List<Route> findAll() {
        if (routeRepositorio.findAll().isEmpty()) {
            throw new ListEntityNotFoundException(Category.class);
        } else {
            return routeRepositorio.findAll();
        }
    }

    public Optional<Route> findById(Long id){
        if (routeRepositorio.findById(id).isEmpty()){
            throw new ListEntityNotFoundException(Category.class);
        }else{
            return routeRepositorio.findById(id);
        }
    }

}
