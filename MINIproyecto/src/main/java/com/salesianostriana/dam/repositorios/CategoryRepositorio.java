package com.salesianostriana.dam.repositorios;


import com.salesianostriana.dam.modelo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepositorio extends JpaRepository<Category, Long> {

}

