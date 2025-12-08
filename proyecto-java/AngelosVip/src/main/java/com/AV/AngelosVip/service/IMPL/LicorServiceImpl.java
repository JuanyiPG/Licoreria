package com.AV.AngelosVip.service.IMPL;

import com.AV.AngelosVip.models.Licor;
import com.AV.AngelosVip.repositories.LicorRepositories;
import com.AV.AngelosVip.service.LicorService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service
public class LicorServiceImpl  implements LicorService {

    private final LicorRepositories licorRepositorio;

    public LicorServiceImpl(LicorRepositories licorRepositorio) {
        this.licorRepositorio = licorRepositorio;
    }


    public Licor guardar(Licor licor){
        return licorRepositorio.save(licor);
    }

    public void eliminar(Integer id){
        licorRepositorio.deleteById(id);
    }

    public List<Licor> orden(){
        return licorRepositorio.findAllByOrderByFechanombreLicorAsc();
    }

    public List<Licor> listar(){
        return licorRepositorio.findAll();
    }

    public List<Licor> buscarvarioscampos(String filtro){
        return licorRepositorio.bucarVariosCampos(filtro);
    }
}
