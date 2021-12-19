package com.salesianos.triana.dam.TrianaTourist.dtos.POI;

import com.salesianos.triana.dam.TrianaTourist.model.POI;
import org.springframework.stereotype.Component;

@Component
public class ConverterPoiDto {

    public POI createdPoiToDto(CreatePoiDto c){
        return POI.builder()
                .name(c.getName())
                .location(c.getLocation())
                .description(c.getDescription())
                .date(c.getDate())
                .coverPhoto(c.getCoverPhoto())
                .category(c.getCategory())
                .build();
    }

    public GetPoiDto getPoiToDto (POI p) {
        return GetPoiDto.builder()
                .id(p.getId())
                .name(p.getName())
                .coverPhoto(p.getCoverPhoto())
                .categoryId(p.getCategory().getId())
                .build();
    }
}
