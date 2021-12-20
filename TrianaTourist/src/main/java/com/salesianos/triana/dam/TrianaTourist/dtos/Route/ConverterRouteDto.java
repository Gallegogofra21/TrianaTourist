package com.salesianos.triana.dam.TrianaTourist.dtos.Route;

import com.salesianos.triana.dam.TrianaTourist.model.Route;
import org.springframework.stereotype.Component;

@Component
public class ConverterRouteDto {

    public Route createRouteToDto(CreateRouteDto c) {
        return Route.builder()
                .name(c.getName())
                .build();
    }

    public GetRouteDto getRouteToDto (Route r) {
        return GetRouteDto.builder()
                .id(r.getId())
                .name(r.getName())
                .numSteps(r.getSteps().size())
                .build();
    }
}
