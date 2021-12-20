package com.salesianostriana.dam.dto.route;

import com.salesianostriana.dam.modelo.POI;
import com.salesianostriana.dam.validacion.anotaciones.UniqueName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateRouteDto {
    private Long id;
    @UniqueName(message = "{route.nombre.unico}")
    private String name;
    private List<POI> steps;
}
