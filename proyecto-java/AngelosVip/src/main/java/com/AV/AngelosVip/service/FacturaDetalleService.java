package com.AV.AngelosVip.service;

import com.AV.AngelosVip.models.FacturaDetalle;

import java.util.List;

public interface FacturaDetalleService {
    List<FacturaDetalle> listar();
    void Eliminar (Integer Id);
    List<FacturaDetalle> allcampos(String filtro);
    List<FacturaDetalle> guardar(FacturaDetalle facturaDetalle);
}
