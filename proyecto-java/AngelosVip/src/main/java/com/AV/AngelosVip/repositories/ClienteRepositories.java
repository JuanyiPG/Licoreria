package com.AV.AngelosVip.repositories;

import com.AV.AngelosVip.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClienteRepositories extends JpaRepository<Cliente, Integer> {

    List<Cliente> findAllByOrderByNombreUsuarioAsc();
    @Query(value = "SELECT * FROM cliente fd " +
            "WHERE DATE_FORMAT(fd.fecha_nacimiento, '%Y-%m-%d') LIKE %:filtro% " +
            "OR LOWER(fd.direccion) LIKE LOWER(CONCAT('%', :filtro, '%')) " +
            "OR LOWER(fd.tel) LIKE LOWER(CONCAT('%', :filtro, '%')) " +
            "OR LOWER(fd.tipo_id) LIKE LOWER(CONCAT('%', :filtro, '%')) " +
            "OR LOWER(fd.num_id) LIKE LOWER(CONCAT('%', :filtro, '%')) " +
            "OR LOWER(fd.nombre_usuario) LIKE LOWER(CONCAT('%', :filtro, '%')) " +
            "OR LOWER(fd.correo) LIKE LOWER(CONCAT('%', :filtro, '%'))",
            nativeQuery = true)
    List<Cliente> allcampos(@Param("filtro") String filtro);


}
