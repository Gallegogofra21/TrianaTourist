package com.salesianos.triana.dam.TrianaTourist.dtos.Category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class CreateCategoryDto {
    private String name;
}
