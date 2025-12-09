package com.AV.AngelosVip.repositories;

import com.AV.AngelosVip.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClienteRepositories extends JpaRepository<Cliente, Integer> {
<<<<<<< Updated upstream
    List<Cliente> findAllByOrderByNombreUsuarioAsc();
    @Query("SELECT fd FROM Cliente fd WHERE " +
            "CAST(FUNCTION('DATE_FORMAT', fd.fechaNacimiento, '%Y-%m-%d') AS string) LIKE CONCAT('%', :filtro, '%') OR " +
            "LOWER(fd.direccion) LIKE LOWER(CONCAT('%', :filtro, '%')) OR " +
            "LOWER(fd.tel) LIKE LOWER(CONCAT('%', :filtro, '%')) OR " +
            "LOWER(fd.tipoId) LIKE LOWER(CONCAT('%', :filtro, '%')) OR " +
            "LOWER(fd.numId) LIKE LOWER(CONCAT('%', :filtro, '%')) OR " +
            "LOWER(fd.nombreUsuario) LIKE LOWER(CONCAT('%', :filtro, '%')) OR " +
            "LOWER(fd.correo) LIKE LOWER(CONCAT('%', :filtro, '%'))")
    List<Cliente> allcampos(@Param("filtro") String filtro);

=======
    List<Cliente> findAllByOrderBynombreUsuarioAsc();
    @Query("SELECT fd FROM Cliente fd WHERE " +
            "CAST(fd.fechaNacimiento AS string) LIKE CONCAT('%', :filtro, '%') OR " +
            "CAST(fd.direccion AS string) LIKE CONCAT('%', :filtro, '%') OR " +
            "CAST(fd.tel AS string) LIKE CONCAT('%', :filtro, '%') OR" +
            "CAST(fd.tipoId AS string) LIKE CONCAT('%', :filtro, '%') OR " +
            "CAST(fd.numId AS string) LIKE CONCAT('%', :filtro, '%') OR " +
            "CAST(fd.nombreUsuario AS string) LIKE CONCAT('%', :filtro, '%') OR " +
            "CAST(fd.correo AS string) LIKE CONCAT('%', :filtro, '%') OR")
    List<Cliente> allcampos(@Param("filtro")String filtro);
>>>>>>> Stashed changes

}
