package com.salesianostriana.dam.servicios;

import com.salesianostriana.dam.dto.category.GetCategoryDto;
import com.salesianostriana.dam.errores.excepciones.EntityNotFoundException;
import com.salesianostriana.dam.errores.excepciones.ListEntityNotFoundException;
import com.salesianostriana.dam.modelo.Category;
import com.salesianostriana.dam.repositorios.CategoryRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService extends BaseService<Category, Long, CategoryRepositorio>{
    @Autowired
    private CategoryRepositorio categoryRepositorio;

    public List<Category> findAll() {
        if (categoryRepositorio.findAll().isEmpty()) {
            throw new ListEntityNotFoundException(Category.class);
        } else {
            return categoryRepositorio.findAll();
        }
    }

    public Optional<Category> findById(Long id){
        if (categoryRepositorio.findById(id).isEmpty()){
            throw new ListEntityNotFoundException(Category.class);
        }else{
            return categoryRepositorio.findById(id);
        }
    }

}
