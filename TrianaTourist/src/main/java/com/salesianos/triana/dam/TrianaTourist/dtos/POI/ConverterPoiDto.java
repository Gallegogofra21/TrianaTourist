package com.salesianos.triana.dam.TrianaTourist.dtos.POI;

import com.salesianos.triana.dam.TrianaTourist.model.POI;
import com.salesianos.triana.dam.TrianaTourist.service.CategoryService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ConverterPoiDto {

    public GetPoiDto getPoiToDto (POI p) {
        return GetPoiDto.builder()
                .id(p.getId())
                .name(p.getName())
                .coverPhoto(p.getCoverPhoto())
                .category(p.getCategory().getName())
                .build();
    }
}
