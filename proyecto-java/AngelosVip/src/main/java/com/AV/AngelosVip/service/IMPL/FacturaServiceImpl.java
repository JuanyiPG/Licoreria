package com.AV.AngelosVip.service.IMPL;

import com.AV.AngelosVip.models.Factura;
import com.AV.AngelosVip.models.Usuario;
import com.AV.AngelosVip.repositories.FacturaRepositories;
import com.AV.AngelosVip.service.FacturaService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service
public class FacturaServiceImpl implements FacturaService{
    private final FacturaRepositories facturaRepositorio;

    public FacturaServiceImpl(FacturaRepositories facturaRepositorio){
        this.facturaRepositorio = facturaRepositorio;
    }

    @Override
    public List<Factura> ordenAsc(){
        return facturaRepositorio.findAllByOrderByFechaAsc();
    }
    @Override
    public   List<Factura> listar(){
        return facturaRepositorio.findAll();
    }
    @Override
    public Factura guardar(Factura factura){
        return facturaRepositorio.save(factura);
    }
    @Override
    public List<Factura> allcampos(String filtro){
        return facturaRepositorio.allcampos(filtro);
    }
    @Override
    public void Eliminar(Integer id){
        facturaRepositorio.deleteById(id);
    }
    @Override
    public Factura buscarPorId(Integer id){
        return facturaRepositorio.findById(id).orElse(null);
    }
}
