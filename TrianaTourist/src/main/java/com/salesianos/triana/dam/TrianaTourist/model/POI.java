package com.salesianos.triana.dam.TrianaTourist.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@Builder
public class POI implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String location;
    private String description;
    private Date date;
    private String coverPhoto;
    private String photo2;
    private String photo1;

    @ManyToOne
    @JoinColumn(name = "category_id", foreignKey = @ForeignKey(name = "FK_POI_CATEGORY"))
    private Category category;


}
