package com.AV.AngelosVip.service;

import com.AV.AngelosVip.models.Factura;
import com.AV.AngelosVip.models.Rol;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FacturaService {
    List<Factura> ordenAsc();
    List<Factura> listar();
    List<Factura> allcampos(String filtro);
    Factura guardar(Factura factura);
    void Eliminar(Integer Id);
    Factura buscarPorId(Integer id);
}
