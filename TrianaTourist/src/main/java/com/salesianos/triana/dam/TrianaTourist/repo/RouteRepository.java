package com.salesianos.triana.dam.TrianaTourist.repo;

import com.salesianos.triana.dam.TrianaTourist.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RouteRepository extends JpaRepository<Route, Long> {

    boolean existsByName(String nombre);

    @Query(value = """
            SELECT p.id
            FROM POI p LEFT JOIN ROUTE r
            where p.name IN(
            SELECT p.name
            FROM POIRUTAS r
            WHERE (p.id = r.POI_ID) AND (p.id = :id)
            )
            """, nativeQuery = true)
    Long comprobarPOI(@Param("id") Long id);

}
