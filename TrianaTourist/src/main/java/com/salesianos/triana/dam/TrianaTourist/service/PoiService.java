package com.salesianos.triana.dam.TrianaTourist.service;

import com.salesianos.triana.dam.TrianaTourist.dtos.POI.ConverterPoiDto;
import com.salesianos.triana.dam.TrianaTourist.dtos.POI.CreatePoiDto;
import com.salesianos.triana.dam.TrianaTourist.dtos.POI.GetPoiDto;
import com.salesianos.triana.dam.TrianaTourist.errores.excepciones.ListEntityNotFoundException;
import com.salesianos.triana.dam.TrianaTourist.errores.excepciones.SingleEntityNotFoundException;
import com.salesianos.triana.dam.TrianaTourist.model.POI;
import com.salesianos.triana.dam.TrianaTourist.repo.PoiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PoiService {

    private final PoiRepository repository;
    private final ConverterPoiDto converter;
    private final CategoryService categoryService;

    public List<GetPoiDto> findAll() {
        List<POI> data = repository.findAll();

        if(data.isEmpty()){
            throw new ListEntityNotFoundException(POI.class);
        }else {
            return data
                    .stream()
                    .map(converter::getPoiToDto)
                    .collect(Collectors.toList());
        }
    }

    public POI findById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new SingleEntityNotFoundException(id.toString(), POI.class));
    }

    public POI save (CreatePoiDto c){
        POI poi = POI.builder()
                .name(c.getName())
                .location(c.getLocation())
                .description(c.getDescription())
                .date(c.getDate())
                .coverPhoto(c.getCoverPhoto())
                .category(categoryService.findById(c.getCategoryId()))
                .build();

        return repository.save(poi);

    }

    public POI editar (CreatePoiDto dto, @PathVariable Long id){
        return repository.findById(id).map(p -> {
            p.setName(dto.getName());
            p.setLocation(dto.getLocation());
            p.setDescription(dto.getDescription());
            p.setDate(dto.getDate());
            p.setCoverPhoto(dto.getCoverPhoto());
            p.setCategory(categoryService.findById(dto.getCategoryId()));
            return repository.save(p);
        }).orElseThrow(() -> new SingleEntityNotFoundException(id.toString(), POI.class));
    }

    public void delete (@PathVariable Long id) {
        POI poi = repository.findById(id).orElseThrow(() -> new SingleEntityNotFoundException(id.toString(), POI.class));
        repository.delete(poi);
    }

    /*public POI findPOIByName(String nombre){
       return repository.findPOIByName(nombre);
    }*/

}
