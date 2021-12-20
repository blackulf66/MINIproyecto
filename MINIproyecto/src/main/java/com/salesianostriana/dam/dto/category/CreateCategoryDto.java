package com.salesianostriana.dam.dto.category;


import com.salesianostriana.dam.validacion.anotaciones.UniqueName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCategoryDto {

    private Long id;
    @NotBlank(message = "{categoria.name.blank}")
    @UniqueName(message = "{categoria.nombre.unico}")
    private String name;
}
