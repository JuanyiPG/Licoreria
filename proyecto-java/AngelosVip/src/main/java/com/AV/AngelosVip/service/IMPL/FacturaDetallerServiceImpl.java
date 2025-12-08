package com.AV.AngelosVip.service.IMPL;


import com.AV.AngelosVip.models.FacturaDetalle;
import com.AV.AngelosVip.repositories.FacturaDetalleRepositories;
import com.AV.AngelosVip.service.FacturaDetalleService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service
public class FacturaDetallerServiceImpl implements FacturaDetalleService {
    private final FacturaDetalleRepositories facturaDetalleRepositories;

    public FacturaDetallerServiceImpl(FacturaDetalleRepositories facturaDetalleRepositories){
        this.facturaDetalleRepositories =facturaDetalleRepositories;
    }

    @Override
    public List<FacturaDetalle> listar(){
        return facturaDetalleRepositories.findAll();
    }
    @Override
    public FacturaDetalle guardar(FacturaDetalle facturaDetalle){
        return facturaDetalleRepositories.save(facturaDetalle);
    }
    @Override
    public void Eliminar(Integer id){
        facturaDetalleRepositories.deleteById(id);
    }

    @Override
    public List<FacturaDetalle> allcampos(String filtro){
        return facturaDetalleRepositories.allcampos(filtro);
    }
}
