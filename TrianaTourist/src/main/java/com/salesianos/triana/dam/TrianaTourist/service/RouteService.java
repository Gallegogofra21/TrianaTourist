package com.salesianos.triana.dam.TrianaTourist.service;

import com.salesianos.triana.dam.TrianaTourist.dtos.Route.ConverterRouteDto;
import com.salesianos.triana.dam.TrianaTourist.dtos.Route.CreateRouteDto;
import com.salesianos.triana.dam.TrianaTourist.dtos.Route.CreatedRouteWithPoi;
import com.salesianos.triana.dam.TrianaTourist.dtos.Route.GetRouteDto;
import com.salesianos.triana.dam.TrianaTourist.errores.excepciones.ListEntityNotFoundException;
import com.salesianos.triana.dam.TrianaTourist.errores.excepciones.SingleEntityNotFoundException;
import com.salesianos.triana.dam.TrianaTourist.model.POI;
import com.salesianos.triana.dam.TrianaTourist.model.Route;
import com.salesianos.triana.dam.TrianaTourist.repo.PoiRepository;
import com.salesianos.triana.dam.TrianaTourist.repo.RouteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RouteService {

    private final RouteRepository repository;
    private final ConverterRouteDto converter;
    private final PoiService poiService;

    public List<GetRouteDto> findAll() {
        List<Route> data = repository.findAll();

        if(data.isEmpty()) {
            throw new ListEntityNotFoundException(Route.class);
        }else {
            return data
                    .stream()
                    .map(converter::getRouteToDto)
                    .collect(Collectors.toList());
        }
    }

    public Route findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new SingleEntityNotFoundException(id.toString(), Route.class));
    }

    public Route save (CreateRouteDto dto) {
        return repository.save(converter.createRouteToDto(dto));
    }

    public Route editar (CreateRouteDto dto, Long id){
        return repository.findById(id).map(p -> {
            p.setName(dto.getName());
            return repository.save(p);
        }).orElseThrow(() -> new SingleEntityNotFoundException(id.toString(), Route.class));
    }

    public void delete(Long id) {
        Route route = repository.findById(id)
                .orElseThrow(() -> new SingleEntityNotFoundException(id.toString(), Route.class));
        repository.delete(route);
    }

    public GetRouteDto addPoiToRoute(CreatedRouteWithPoi dto, @PathVariable Long id){
        Route ruta = repository.findById(id)
                .orElseThrow(() -> new SingleEntityNotFoundException(id.toString(), Route.class));

        //POI poi = poiService.findPOIByName(dto.getPoiName());
        POI poi = poiService.findById(dto.getIdPoi());

        if(poi == null)
            throw new SingleEntityNotFoundException("Nulo", POI.class);

        ruta.getSteps().add(poi);

        repository.save(ruta);

        return converter.getRouteToDto(ruta);
    }

    public void deletePoiByRoute (@PathVariable Long id1, @PathVariable Long id2){
        Route route = repository.findById(id1)
                .orElseThrow(() -> new SingleEntityNotFoundException(id1.toString(), Route.class));

        POI poi = poiService.findById(id2);

        route.getSteps().forEach(p -> {
            poiService.findById(id2);
        });

        route.getSteps().remove(poi);
        repository.save(route);
    }

    public boolean comprobarName(String name){
        return repository.existsByName(name);
    }
}
