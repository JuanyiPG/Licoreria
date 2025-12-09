package com.AV.AngelosVip.repositories;

import com.AV.AngelosVip.models.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FacturaRepositories extends JpaRepository<Factura, Integer> {
    List<Factura> findAllByOrderByFechaAsc();

    @Query("SELECT f FROM Factura f WHERE " +
            "CAST(f.idFactura AS string) LIKE CONCAT('%', :filtro, '%') OR " +
            "CAST(f.fecha AS string) LIKE CONCAT('%', :filtro, '%') OR " +
            "CAST(f.metodo_pago AS string) LIKE CONCAT('%', :filtro, '%') OR " +
            "LOWER(f.total AS string) LIKE LOWER(CONCAT('%', :filtro, '%')) OR " +
            "CAST(f.cantidad AS string) LIKE CONCAT('%', :filtro, '%') OR " +
            "LOWER(f.estado) LIKE LOWER(CONCAT('%', :filtro, '%')) OR " +
            "CAST(f.subtotal AS string) LIKE CONCAT('%', :filtro, '%')")

    List<Factura> allcampos(@Param("filtro")String filtro);
}
