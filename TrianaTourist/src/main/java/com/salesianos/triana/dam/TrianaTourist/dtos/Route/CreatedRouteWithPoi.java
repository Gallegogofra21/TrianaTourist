package com.salesianos.triana.dam.TrianaTourist.dtos.Route;

import com.salesianos.triana.dam.TrianaTourist.validacion.anotaciones.UniquePoi;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor @AllArgsConstructor
public class CreatedRouteWithPoi {

    @UniquePoi(message = "{route.poi.unico}")
    private Long idPoi;
}
