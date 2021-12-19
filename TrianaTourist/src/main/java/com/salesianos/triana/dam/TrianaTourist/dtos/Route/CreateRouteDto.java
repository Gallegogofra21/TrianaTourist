package com.salesianos.triana.dam.TrianaTourist.dtos.Route;

import com.salesianos.triana.dam.TrianaTourist.model.POI;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
public class CreateRouteDto {

    private String name;
    private List<POI> steps;
}
