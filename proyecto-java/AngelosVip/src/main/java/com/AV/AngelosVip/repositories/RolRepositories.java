package com.AV.AngelosVip.repositories;

import com.AV.AngelosVip.models.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RolRepositories extends JpaRepository<Rol, Integer> {
    List<Rol> findAllByOrderByNombrerolAsc();
    @Query( "SELECT r FROM Rol r WHERE " +
            "LOWER(r.nombrerol) LIKE LOWER (CONCAT('%', :filtro, '%'))")
    List<Rol> bucarVariosCampos(@Param("filtro") String filtro);
}
