package com.salesianos.triana.dam.TrianaTourist.controller;

import com.salesianos.triana.dam.TrianaTourist.dtos.POI.CreatePoiDto;
import com.salesianos.triana.dam.TrianaTourist.model.Category;
import com.salesianos.triana.dam.TrianaTourist.model.POI;
import com.salesianos.triana.dam.TrianaTourist.service.PoiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final PoiService service;

    @PostMapping("/")
    public POI save(@RequestBody CreatePoiDto dto){
        return service.save(dto);
    }
}
