package com.salesianostriana.dam.dto.category;

import com.salesianostriana.dam.modelo.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryDtoConverter {
    public Category createCategoryDtoToCategory(CreateCategoryDto c){
        return new Category(
                c.getId(),
                c.getName()
            );
    }
    public GetCategoryDto categoryToGetCategoryDto(Category c){
        return GetCategoryDto.builder()
                .id(c.getId())
                .name(c.getName())
                .build();
    }
}
