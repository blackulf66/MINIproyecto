package com.salesianostriana.dam.dto.POI;

import com.salesianostriana.dam.modelo.Category;
import com.salesianostriana.dam.modelo.Route;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePOIDto {
    @NotBlank(message = "{poi.name.blank}")
    private String name;
    @Pattern(regexp = "^([-+]?\\d{1,2}[.]\\d+),\\s*([-+]?\\d{1,3}[.]\\d+)$", message = "{poi.ubicacion}")
    private String location;
    private String descripcion;
    private LocalDateTime date;
    private String coverPhoto;
    private String photo2;
    private String photo3;
    private Long category;
    private List<Route> routes;
}
