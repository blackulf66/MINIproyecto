package com.salesianostriana.dam.dto.POI;

import com.salesianostriana.dam.modelo.Category;
import com.salesianostriana.dam.modelo.Route;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePOIDto {

    private Long id;
    private String name;
    private String location;
    private String descripcion;
    private LocalDateTime date;
    private String coverPhoto;
    private String photo2;
    private String photo3;
    private Category category;
    private List<Route> routes;
}
