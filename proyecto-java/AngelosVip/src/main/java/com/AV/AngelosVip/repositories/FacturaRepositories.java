package com.AV.AngelosVip.repositories;

import com.AV.AngelosVip.models.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FacturaRepositories extends JpaRepository<Factura, Integer> {
    List<Factura> findAllByOrderByFechaAsc();

    @Query("""
    SELECT f FROM Factura f
    WHERE STR(f.idFactura) LIKE CONCAT('%', :filtro, '%')
        OR STR(f.fecha) LIKE CONCAT('%', :filtro, '%')
        OR LOWER(f.metodo_pago) LIKE LOWER(CONCAT('%', :filtro, '%'))
        OR STR(f.total) LIKE CONCAT('%', :filtro, '%')
        OR STR(f.cantidad) LIKE CONCAT('%', :filtro, '%')
        OR LOWER(f.estado) LIKE LOWER(CONCAT('%', :filtro, '%'))
        OR STR(f.subtotal) LIKE CONCAT('%', :filtro, '%')
    """)
    List<Factura> allcampos(@Param("filtro") String filtro);


}
