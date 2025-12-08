package com.AV.AngelosVip.repositories;

import com.AV.AngelosVip.models.Factura;
import com.AV.AngelosVip.models.FacturaDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FacturaDetalleRepositories extends JpaRepository<Factura, Integer> {

    @Query("SELECT fd FROM FacturaDetalle fd HWERE " +
     "CAST(fd.idFactDet AS string) LIKE CONCAT('%', :filtro, '%')")
    List<FacturaDetalle> allcampos(@Param("filtro")String filtro);
}
