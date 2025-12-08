package com.AV.AngelosVip.service;

import com.AV.AngelosVip.models.Licor;
import com.AV.AngelosVip.models.Rol;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LicorService {
    Licor guardar(Licor licor);
    void eliminar(Integer id);
    List<Licor> orden();
    List<Licor> listar();
    List<Licor> buscarvarioscampos(String filtro);
    Licor buscarPorId(Integer id);
}
