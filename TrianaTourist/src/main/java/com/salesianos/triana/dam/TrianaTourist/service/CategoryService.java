package com.salesianos.triana.dam.TrianaTourist.service;

import com.salesianos.triana.dam.TrianaTourist.errores.excepciones.EntityNotFoundException;
import com.salesianos.triana.dam.TrianaTourist.errores.excepciones.ListEntityNotFoundException;
import com.salesianos.triana.dam.TrianaTourist.errores.excepciones.SingleEntityNotFoundException;
import com.salesianos.triana.dam.TrianaTourist.errores.modelo.ApiError;
import com.salesianos.triana.dam.TrianaTourist.model.Category;
import com.salesianos.triana.dam.TrianaTourist.repo.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private CategoryRepository repository;

    public List<Category> findAll() {
        List<Category> result = repository.findAll();

        if(result.isEmpty()) {
            throw new ListEntityNotFoundException(Category.class);
        }else {
            return result;
        }
    }

    public Category findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new SingleEntityNotFoundException(id.toString(), Category.class));
    }

    public Category save (Category category) {
        return repository.save(category);
    }
}
