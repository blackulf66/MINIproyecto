package com.salesianostriana.dam.dto.route;

import com.salesianostriana.dam.modelo.POI;
import com.salesianostriana.dam.validacion.anotaciones.UniqueName;
import com.salesianostriana.dam.validacion.anotaciones.UniqueRoute;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateRouteDto {

    @UniqueRoute(message = "{route.nombre.unico}")
    private String name;
    private List<POI> steps;
}
