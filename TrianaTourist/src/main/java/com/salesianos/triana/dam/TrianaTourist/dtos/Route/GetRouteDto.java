package com.salesianos.triana.dam.TrianaTourist.dtos.Route;

import com.salesianos.triana.dam.TrianaTourist.model.POI;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
public class GetRouteDto {

    private Long id;
    private String name;
    private int numSteps;
}
