package com.AV.AngelosVip.service;

import com.AV.AngelosVip.models.Rol;
import com.AV.AngelosVip.repositories.RolRepositories;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RolService {
    Rol guardar(Rol rol);
    void eliminar(Integer id);
    List<Rol> listar();
    List<Rol> orden();
    List<Rol> buscarvarioscampos(String filtro);
    Rol buscarPorId(Integer id);
}
