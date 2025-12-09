package com.AV.AngelosVip.service;

import com.AV.AngelosVip.models.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UsuarioService {
    Usuario guardar(Usuario usuario);
    void eliminar(Integer id);
    List<Usuario> orden();
    List<Usuario> listar();
    List<Usuario> buscarvarioscampos(String filtro);
    Usuario buscarPorId(Integer id);
    public Usuario buscarPorEmail(String email);
    }


