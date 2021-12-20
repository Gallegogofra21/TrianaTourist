package com.salesianos.triana.dam.TrianaTourist.controller;

import com.salesianos.triana.dam.TrianaTourist.dtos.POI.CreatePoiDto;
import com.salesianos.triana.dam.TrianaTourist.dtos.POI.GetPoiDto;
import com.salesianos.triana.dam.TrianaTourist.model.POI;
import com.salesianos.triana.dam.TrianaTourist.service.PoiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/poi")
@RequiredArgsConstructor
public class PoiController {

    private final PoiService service;

    @GetMapping("/")
    public List<GetPoiDto> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public POI findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping("/")
    public POI save (@Valid @RequestBody CreatePoiDto dto) {
        return service.save(dto);
    }

    @PutMapping("/{id}")
    public POI edit (@RequestBody CreatePoiDto dto, @PathVariable Long id){
        return service.editar(dto, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
