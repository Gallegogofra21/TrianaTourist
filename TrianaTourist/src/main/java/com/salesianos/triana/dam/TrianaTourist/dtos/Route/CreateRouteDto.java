package com.salesianos.triana.dam.TrianaTourist.dtos.Route;

import com.salesianos.triana.dam.TrianaTourist.validacion.anotaciones.UniqueNameCategory;
import com.salesianos.triana.dam.TrianaTourist.validacion.anotaciones.UniqueNameRoute;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor @NoArgsConstructor
public class CreateRouteDto {

    @UniqueNameRoute(message = "{route.name.unico}")
    private String name;
}
