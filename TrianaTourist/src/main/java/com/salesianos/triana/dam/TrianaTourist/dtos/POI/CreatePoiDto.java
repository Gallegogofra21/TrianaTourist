package com.salesianos.triana.dam.TrianaTourist.dtos.POI;

import com.salesianos.triana.dam.TrianaTourist.validacion.anotaciones.ExistsCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
    @Lob
    private String description;
    private Date date;

    @NotNull(message = "{poi.photo.null}")
    @URL(message = "{poi.photo.url}")
    private String coverPhoto;

    @ExistsCategory(message = "{poi.category.unica}")
    private Long categoryId;
}
