package com.AV.AngelosVip.repositories;

import com.AV.AngelosVip.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClienteRepositories extends JpaRepository<Cliente, Integer> {
    List<Cliente> findAllByOrderBynombreUsuarioAsc();
    @Query("SELECT fd FROM Cliente fd HWERE " +
            "CAST(fd.fechaNacimiento AS string) LIKE CONCAT('%', :filtro, '%') OR " +
            "CAST(fd.direccion AS string) LIKE CONCAT('%', :filtro, '%') OR " +
            "CAST(fd.tel AS string) LIKE CONCAT('%', :filtro, '%') OR" +
            "CAST(fd.tipoId AS string) LIKE CONCAT('%', :filtro, '%') OR " +
            "CAST(fd.numId AS string) LIKE CONCAT('%', :filtro, '%') OR " +
            "CAST(fd.nombreUsuario AS string) LIKE CONCAT('%', :filtro, '%') OR " +
            "CAST(fd.correo AS string) LIKE CONCAT('%', :filtro, '%') OR")
    List<Cliente> allcampos(@Param("filtro")String filtro);

}
