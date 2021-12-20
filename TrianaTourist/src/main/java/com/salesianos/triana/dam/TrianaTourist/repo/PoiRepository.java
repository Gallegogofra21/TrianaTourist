package com.salesianos.triana.dam.TrianaTourist.repo;

import com.salesianos.triana.dam.TrianaTourist.model.POI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PoiRepository extends JpaRepository<POI, Long> {


}
