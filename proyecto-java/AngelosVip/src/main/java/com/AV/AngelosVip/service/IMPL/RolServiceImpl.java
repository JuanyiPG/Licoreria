package com.AV.AngelosVip.service.IMPL;

import com.AV.AngelosVip.models.Licor;
import com.AV.AngelosVip.models.Rol;
import com.AV.AngelosVip.repositories.RolRepositories;
import com.AV.AngelosVip.service.RolService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
public class RolServiceImpl implements RolService {
    private final RolRepositories rolRepositorio;

    public RolServiceImpl(RolRepositories rolRepositorio) {
        this.rolRepositorio = rolRepositorio;
    }

    @Override
    public Rol guardar(Rol rol){
        return rolRepositorio.save(rol);
    }

    @Override
    public void eliminar(Integer id) {
        rolRepositorio.deleteById(id);
    }

    @Override
    public List<Rol> listar(){
        return rolRepositorio.findAll();
    }

    @Override
    public List<Rol> orden() {
        return rolRepositorio.findAllByOrderByNombrerolAsc();
    }

    @Override
    public List<Rol> buscarvarioscampos(String filtro) {
        return rolRepositorio.buscarVariosCampos(filtro);
    }

    @Override
    public Rol buscarPorId(Integer id){
        return rolRepositorio.findById(id).orElse(null);
    }
}
