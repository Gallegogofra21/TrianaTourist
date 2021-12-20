package com.salesianos.triana.dam.TrianaTourist.controller;

import com.salesianos.triana.dam.TrianaTourist.dtos.Category.CreateCategoryDto;
import com.salesianos.triana.dam.TrianaTourist.dtos.Category.GetCategoryDto;
import com.salesianos.triana.dam.TrianaTourist.dtos.POI.CreatePoiDto;
import com.salesianos.triana.dam.TrianaTourist.model.Category;
import com.salesianos.triana.dam.TrianaTourist.model.POI;
import com.salesianos.triana.dam.TrianaTourist.service.CategoryService;
import com.salesianos.triana.dam.TrianaTourist.service.PoiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService service;

    @GetMapping("/")
    public List<GetCategoryDto> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Category findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping("/")
    public Category save(@Valid @RequestBody CreateCategoryDto dto){
        return service.save(dto);
    }

    @PutMapping("/{id}")
    public Category edit(@RequestBody CreateCategoryDto dto, @PathVariable Long id) {
        return service.edit(dto, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
