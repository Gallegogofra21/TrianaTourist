package com.salesianos.triana.dam.TrianaTourist.dtos.Category;

import com.salesianos.triana.dam.TrianaTourist.model.Category;
import org.springframework.stereotype.Component;

@Component
public class ConverterCategoryDto {

    public Category createdCategoryToDto(CreateCategoryDto c) {
        return Category.builder()
                .name(c.getName())
                .build();
    }

    public GetCategoryDto getCategoryToDto(Category c) {
        return GetCategoryDto.builder()
                .id(c.getId())
                .name(c.getName())
                .build();
    }
}
