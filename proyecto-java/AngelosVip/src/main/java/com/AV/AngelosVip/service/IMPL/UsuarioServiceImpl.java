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
    @Override
    public Usuario guardar(Usuario usuario){
        return usuarioRepositorio.save(usuario);
    }

    @Override
    public void eliminar(Integer id){
        usuarioRepositorio.deleteById(id);
    }

    @Override
    public List<Usuario> orden(){
        return usuarioRepositorio.findAllByOrderByNombreUsuariosAsc();
    }

    @Override
    public List<Usuario> listar(){
        return usuarioRepositorio.findAll();
    }

    @Override
    public List<Usuario> buscarvarioscampos(String filtro){
        return usuarioRepositorio.bucarVariosCampos(filtro);
    }

    @Override
    public Usuario buscarPorId(Integer id){
        return usuarioRepositorio.findById(id).orElse(null);
    }
}
