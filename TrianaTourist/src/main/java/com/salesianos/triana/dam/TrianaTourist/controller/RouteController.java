package com.salesianos.triana.dam.TrianaTourist.controller;

import com.salesianos.triana.dam.TrianaTourist.dtos.POI.CreatePoiDto;
import com.salesianos.triana.dam.TrianaTourist.dtos.Route.CreateRouteDto;
import com.salesianos.triana.dam.TrianaTourist.dtos.Route.CreatedRouteWithPoi;
import com.salesianos.triana.dam.TrianaTourist.dtos.Route.GetRouteDto;
import com.salesianos.triana.dam.TrianaTourist.model.Route;
import com.salesianos.triana.dam.TrianaTourist.service.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/route")
@RequiredArgsConstructor
public class RouteController {

    private final RouteService service;

    @GetMapping("/")
    public List<GetRouteDto> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Route findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping("/")
    public Route save (@Valid @RequestBody CreateRouteDto dto) {
        return service.save(dto);
    }

    @PutMapping("/{id}")
    public Route edit (@RequestBody CreateRouteDto dto, @PathVariable Long id){
        return service.editar(dto, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/poi")
    public GetRouteDto addPoi (@RequestBody CreatedRouteWithPoi dto, @PathVariable Long id){
        return service.addPoiToRoute(dto, id);
    }

    @DeleteMapping("/{id1}/poi/{id2}")
    public ResponseEntity<?> deletePoi (@PathVariable Long id1, @PathVariable Long id2){
        service.deletePoiByRoute(id1, id2);
        return ResponseEntity.noContent().build();
    }



}
