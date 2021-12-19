package com.salesianostriana.dam.dto.route;

import com.salesianostriana.dam.modelo.POI;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetRouteDto {
    private Long id;
    private List<POI> steps;
}
