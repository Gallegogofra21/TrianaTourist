package com.salesianos.triana.dam.TrianaTourist.dtos.POI;

import com.salesianos.triana.dam.TrianaTourist.model.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
public class CreatePoiDto {

    private String name;
    private String location;
    private String description;
    private Date date;
    private String coverPhoto;
    private Category category;
}
