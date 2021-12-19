package com.salesianos.triana.dam.TrianaTourist.dtos.Category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class GetCategoryDto {

    private Long id;
    private String name;

}
