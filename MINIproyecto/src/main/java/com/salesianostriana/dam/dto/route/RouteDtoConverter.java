package com.salesianostriana.dam.dto.route;


import com.salesianostriana.dam.dto.category.CreateCategoryDto;
import com.salesianostriana.dam.dto.category.GetCategoryDto;

import com.salesianostriana.dam.modelo.Route;
import org.springframework.stereotype.Component;

@Component
public class RouteDtoConverter {
    public Route createRouteDtoToRoute(CreateRouteDto c){
        return  Route.builder()
                .name(c.getName())
                .steps(c.getSteps())
                .build();
    }
    public GetRouteDto routeToGetrouteDto(Route c){
        return GetRouteDto.builder()
                .id(c.getId())
                .name(c.getName())
                .steps(c.getSteps())
                .build();
    }
}
