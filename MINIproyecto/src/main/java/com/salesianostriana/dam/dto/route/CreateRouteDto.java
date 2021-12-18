package com.salesianostriana.dam.dto.route;

import com.salesianostriana.dam.modelo.POI;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateRouteDto {
    private Long id;
    private String steps;
}
