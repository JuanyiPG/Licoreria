package com.AV.AngelosVip.repositories;

import com.AV.AngelosVip.models.Licor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LicorRepositories extends JpaRepository <Licor, Integer>{
List<Licor> findAllByOrderByFechanombreLicorAsc();
List<Licor> listar();
@Query( "SELECT r FROM Licor r WHERE" +
        "LOWER(r.nombreLicor) LIKE LOWER (CONCAT('%', :filtro, '%')) OR " +
        "LOWER(r.marca) LIKE LOWER (CONCAT('%', :filtro, '%')) OR " +
        "LOWER(r.precio) LIKE LOWER (CONCAT('%', :filtro, '%')) OR " +
        "LOWER(r.stockmin) LIKE LOWER (CONCAT('%', filtro, '%')) OR " +
        "LOWER(r.stockmax) LIKE LOWER (CONCAT('%', filtro, '%')) OR ")
List<Licor> bucarVariosCampos(@Param("filtro") String filtro);
}
