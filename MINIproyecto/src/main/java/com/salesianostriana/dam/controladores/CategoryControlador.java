package com.salesianostriana.dam.controladores;

import com.salesianostriana.dam.dto.category.CategoryDtoConverter;
import com.salesianostriana.dam.dto.category.CreateCategoryDto;
import com.salesianostriana.dam.dto.category.GetCategoryDto;
import com.salesianostriana.dam.modelo.Category;
import com.salesianostriana.dam.servicios.CategoryService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categoria")
public class CategoryControlador {

    private final CategoryService categoryService;
    private final CategoryDtoConverter categoryDtoConverter;

    @GetMapping("/")
    public ResponseEntity<List<Category>> findAll(){ return ResponseEntity.ok().body(categoryService.findAll());}

    @GetMapping("/{id}")
    public ResponseEntity<GetCategoryDto> findOne(@PathVariable Long id){
        return ResponseEntity.ok().body(categoryDtoConverter.categoryToGetCategoryDto(categoryService.findById(id).get()));
    }
    @PostMapping("/")
    public ResponseEntity<GetCategoryDto> create(@Valid @RequestBody CreateCategoryDto c){
        Category category = categoryDtoConverter.createCategoryDtoToCategory(c);
        categoryService.save(category);
        GetCategoryDto categoryDto = categoryDtoConverter.categoryToGetCategoryDto(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryDto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        categoryService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
