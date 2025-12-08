package com.AV.AngelosVip.service;

import com.AV.AngelosVip.models.Factura;

import java.util.List;

public interface FacturaService {
    List<Factura> findAllByOrderByFechaAsc();
    List<Factura> listar();
    List<Factura> allcampos(String filtro);
    List<Factura> guardar(Factura factura);
    void Eliminar(Integer Id);
}
