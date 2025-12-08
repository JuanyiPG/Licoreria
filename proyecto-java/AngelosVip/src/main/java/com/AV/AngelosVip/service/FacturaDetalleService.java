package com.AV.AngelosVip.service;

import com.AV.AngelosVip.models.FacturaDetalle;
import com.AV.AngelosVip.models.Rol;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FacturaDetalleService {
    List<FacturaDetalle> listar();
    void Eliminar (Integer Id);
    List<FacturaDetalle> allcampos(String filtro);
    FacturaDetalle guardar(FacturaDetalle facturaDetalle);
    FacturaDetalle buscarPorId(Integer id);
}
