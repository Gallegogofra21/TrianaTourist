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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany
    @Builder.Default
    @JoinTable(joinColumns = @JoinColumn(name = "poi_id",
                                foreignKey = @ForeignKey(name = "FK_RUTA_POI")),
            inverseJoinColumns = @JoinColumn(name = "route_id",
                    foreignKey = @ForeignKey(name = "FK_POI_RUTA")),
            name = "POIRUTAS")
    private List<POI> steps = new ArrayList<>();
}
