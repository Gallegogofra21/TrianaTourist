package com.salesianos.triana.dam.TrianaTourist.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class Route {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "route_id",
                                foreignKey = @ForeignKey(name = "FK_RUTA_POI")),
            inverseJoinColumns = @JoinColumn(name = "poi_id",
                    foreignKey = @ForeignKey(name = "FK_POI_RUTA")),
            name = "puntos de ruta")
    private List<POI> steps = new ArrayList<>();
}
