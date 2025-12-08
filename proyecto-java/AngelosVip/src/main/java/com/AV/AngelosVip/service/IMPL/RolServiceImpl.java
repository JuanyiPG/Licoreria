package com.AV.AngelosVip.service.IMPL;

import com.AV.AngelosVip.models.Rol;
import com.AV.AngelosVip.repositories.RolRepositories;
import com.AV.AngelosVip.service.RolService;

import java.util.List;

public class RolServiceImpl implements RolService {
    private final RolRepositories rolRepositorio;

    public RolServiceImpl(RolRepositories rolRepositorio) {
        this.rolRepositorio = rolRepositorio;
    }

    public Rol guardar(Rol rol){
        return rolRepositorio.save(rol);
    }

    public void eliminar(Integer id){
        rolRepositorio.deleteById(id);
    }

    public List<Rol> listar(){
        return rolRepositorio.findAllByOrderBynombrerolAsc();
    }

    public List<Rol> buscarvarioscampos(String filtro){
        return rolRepositorio.bucarVariosCampos(filtro);
    }
}
