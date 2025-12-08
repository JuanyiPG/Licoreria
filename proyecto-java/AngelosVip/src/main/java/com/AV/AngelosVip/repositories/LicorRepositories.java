package com.AV.AngelosVip.repositories;

import com.AV.AngelosVip.models.Licor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LicorRepositories extends JpaRepository <Licor, Integer>{
List<Licor> findAllByOrderByNombreLicorAsc();
    @Query("SELECT r FROM Licor r WHERE " +
            "LOWER(r.nombreLicor) LIKE LOWER(CONCAT('%', :filtro, '%')) OR " +
            "LOWER(r.marca) LIKE LOWER(CONCAT('%', :filtro, '%')) OR " +
            "CAST(r.precio AS string) LIKE CONCAT('%', :filtro, '%') OR " +
            "CAST(r.stockmin AS string) LIKE CONCAT('%', :filtro, '%') OR " +
            "CAST(r.stockmax AS string) LIKE CONCAT('%', :filtro, '%')")
    List<Licor> bucarVariosCampos(@Param("filtro") String filtro);


}
