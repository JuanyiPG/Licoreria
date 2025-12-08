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

    public Rol guardar(Rol rol){
        return rolRepositorio.save(rol);
    }

    public void eliminar(Integer id) {
        rolRepositorio.deleteById(id);
    }

    public List<Rol> listar(){
        return rolRepositorio.findAll();
    }

    public List<Rol> orden() {
        return rolRepositorio.findAllByOrderBynombrerolAsc();
    }

    public List<Rol> buscarvarioscampos(String filtro) {
        return rolRepositorio.bucarVariosCampos(filtro);
    }
}
