package com.salesianos.triana.dam.TrianaTourist.repo;

import com.salesianos.triana.dam.TrianaTourist.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RouteRepository extends JpaRepository<Route, Long> {

    boolean existsByName(String nombre);

}
