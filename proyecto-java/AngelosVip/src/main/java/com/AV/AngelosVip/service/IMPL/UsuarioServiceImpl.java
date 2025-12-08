package com.AV.AngelosVip.service.IMPL;

import com.AV.AngelosVip.models.Licor;
import com.AV.AngelosVip.models.Rol;
import com.AV.AngelosVip.models.Usuario;
import com.AV.AngelosVip.repositories.UsuarioRepositories;
import com.AV.AngelosVip.service.UsuarioService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
public class UsuarioServiceImpl  implements UsuarioService {
    private final UsuarioRepositories usuarioRepositorio;

    public UsuarioServiceImpl(UsuarioRepositories usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    public Usuario guardar(Usuario usuario){
        return usuarioRepositorio.save(usuario);
    }

    public void eliminar(Integer id){
        usuarioRepositorio.deleteById(id);
    }

    public List<Usuario> orden(){
        return usuarioRepositorio.findAllByOrderByAsc();
    }

    public List<Usuario> listar(){
        return usuarioRepositorio.findAll();
    }

    public List<Usuario> buscarvarioscampos(String filtro){
        return usuarioRepositorio.bucarVariosCampos(filtro);
    }
}
