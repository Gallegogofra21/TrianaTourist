package com.salesianos.triana.dam.TrianaTourist.service;

import com.salesianos.triana.dam.TrianaTourist.dtos.Category.ConverterCategoryDto;
import com.salesianos.triana.dam.TrianaTourist.dtos.Category.CreateCategoryDto;
import com.salesianos.triana.dam.TrianaTourist.dtos.Category.GetCategoryDto;
import com.salesianos.triana.dam.TrianaTourist.errores.excepciones.EntityNotFoundException;
import com.salesianos.triana.dam.TrianaTourist.errores.excepciones.ListEntityNotFoundException;
import com.salesianos.triana.dam.TrianaTourist.errores.excepciones.SingleEntityNotFoundException;
import com.salesianos.triana.dam.TrianaTourist.errores.modelo.ApiError;
import com.salesianos.triana.dam.TrianaTourist.model.Category;
import com.salesianos.triana.dam.TrianaTourist.repo.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository repository;
    private final ConverterCategoryDto converter;

    public List<GetCategoryDto> findAll() {
        List<Category> data = repository.findAll();

        if(data.isEmpty()) {
            throw new ListEntityNotFoundException(Category.class);
        }else {
            return data
                    .stream()
                    .map(converter::getCategoryToDto)
                    .collect(Collectors.toList());
        }
    }

    public Category findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new SingleEntityNotFoundException(id.toString(), Category.class));
    }

    public Category save (CreateCategoryDto dto) {
        return repository.save(converter.createdCategoryToDto(dto));
    }

    public Category edit (CreateCategoryDto dto, @PathVariable Long id) {
        return repository.findById(id).map(c -> {
            c.setName(dto.getName());
            return repository.save(c);
        }).orElseThrow(() -> new SingleEntityNotFoundException(id.toString(), Category.class));
    }

    public void delete (@PathVariable Long id){
        Category category = repository.findById(id).orElseThrow(() -> new SingleEntityNotFoundException(id.toString(), Category.class));
        repository.delete(category);
    }

    public boolean comprobarName(String name) {
        return repository.existsByName(name);
    }

    public boolean comprobarId(Long id){
        return repository.existsById(id);
    }
}
