package com.salesianostriana.dam.dto.POI;

import com.salesianostriana.dam.validacion.anotaciones.UniqueName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

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
    @UniqueName(message = "{url.unico}")
    @Pattern(regexp = "(http)?s?:?(\\/\\/[^\"']*\\.(?:png|jpg|jpeg|gif|png|svg))", message="{url.ruta.valido}")
    private String coverPhoto;
    @Pattern(regexp = "(http)?s?:?(\\/\\/[^\"']*\\.(?:png|jpg|jpeg|gif|png|svg))", message="{url.ruta.valido}")
    private String photo2;
    @Pattern(regexp = "(http)?s?:?(\\/\\/[^\"']*\\.(?:png|jpg|jpeg|gif|png|svg))", message="{url.ruta.valido}")
    private String photo3;
    private Long category;

}
