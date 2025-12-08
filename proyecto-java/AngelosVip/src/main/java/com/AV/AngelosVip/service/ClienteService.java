package com.AV.AngelosVip.service;

import com.AV.AngelosVip.models.Cliente;
import com.AV.AngelosVip.models.Rol;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClienteService {
    Cliente guardar(Cliente cliente);
    void eliminar(Integer id);
    List<Cliente> listar();
    List<Cliente> orden();
    List<Cliente> buscarvarioscampos(String filtro);
    Cliente buscarPorId(Integer id);
}
