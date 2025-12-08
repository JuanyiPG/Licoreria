package com.AV.AngelosVip.repositories;

import com.AV.AngelosVip.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsuarioRepositories extends JpaRepository<Usuario, Integer> {
    List<Usuario> findAllByOrderByAsc();
    @Query( "SELECT r FROM Usuario r WHERE" +
            "LOWER(r.nombreUsuario) LIKE LOWER (CONCAT('%', :filtro, '%')) OR " +
            "LOWER(r.email) LIKE LOWER (CONCAT('%', :filtro, '%')) OR " +
            "LOWER(r.telefono) LIKE LOWER (CONCAT('%', :filtro, '%')) OR " +
            "LOWER(r.direccion) LIKE LOWER (CONCAT('%', filtro, '%')) OR " +
            "LOWER(r.estadoUsuario) LIKE LOWER (CONCAT('%', filtro, '%')) OR ")
    List<Usuario> bucarVariosCampos(@Param("filtro") String filtro);

}
