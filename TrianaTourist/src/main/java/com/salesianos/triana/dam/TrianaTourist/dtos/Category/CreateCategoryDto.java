package com.salesianos.triana.dam.TrianaTourist.dtos.Category;

import com.salesianos.triana.dam.TrianaTourist.validacion.anotaciones.UniqueNameCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Builder
@Data
@AllArgsConstructor @NoArgsConstructor

public class CreateCategoryDto {

    @NotBlank(message = "{category.nombre.blank}")
    @UniqueNameCategory(message = "{category.nombre.unico}")
    private String name;
}
