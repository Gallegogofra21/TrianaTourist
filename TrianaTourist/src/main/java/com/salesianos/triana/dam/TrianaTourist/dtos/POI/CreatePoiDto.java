package com.salesianos.triana.dam.TrianaTourist.dtos.POI;

import com.salesianos.triana.dam.TrianaTourist.model.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Builder
@Data
@AllArgsConstructor @NoArgsConstructor
public class CreatePoiDto {

    private Long id;

    @NotBlank(message = "{poi.name.blank}")
    private String name;

    @Pattern(regexp = "^([-+]?\\d{1,2}[.]\\d+),\\s*([-+]?\\d{1,3}[.]\\d+)$", message = "{poi.location.formato}")
    private String location;
    private String description;
    private Date date;
    private String coverPhoto;
    private Long categoryId;
}
