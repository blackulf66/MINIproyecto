package com.salesianostriana.dam.servicios;

import com.salesianostriana.dam.modelo.Category;
import com.salesianostriana.dam.repositorios.CategoryRepositorio;
import org.springframework.stereotype.Service;

@Service
public class CategoryService  extends BaseService<Category, Long, CategoryRepositorio>{
}
