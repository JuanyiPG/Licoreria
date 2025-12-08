package com.AV.AngelosVip.service.IMPL;

import com.AV.AngelosVip.models.Cliente;
import com.AV.AngelosVip.models.Rol;
import com.AV.AngelosVip.repositories.ClienteRepositories;
import com.AV.AngelosVip.service.ClienteService;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service
public class ClienteServiceImpl implements ClienteService {
    private final ClienteRepositories clienteRepositories;

    public ClienteServiceImpl (ClienteRepositories clienteRepositories){
        this.clienteRepositories = clienteRepositories;
    }

    @Override
    public Cliente guardar(Cliente cliente){
        return clienteRepositories.save(cliente);
    }

    @Override
    public void eliminar(Integer id) {clienteRepositories.deleteById(id);
    }

    @Override
    public List<Cliente> listar(){
        return clienteRepositories.findAll();
    }

    @Override
    public List<Cliente> orden() {
        return clienteRepositories.findAllByOrderBynombreUsuarioAsc();
    }

    @Override
    public List<Cliente> buscarvarioscampos(String filtro) {
        return clienteRepositories.allcampos(filtro);
    }
}
