package com.salesianos.triana.dam.TrianaTourist.repo;

import com.salesianos.triana.dam.TrianaTourist.model.POI;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PoiRepository extends JpaRepository<POI, Long> {
}
