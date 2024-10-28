package com.sistema.biblioteca.Service;

import java.util.List;

import com.sistema.biblioteca.Entity.Revista;
import com.sistema.biblioteca.Repository.RevistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Bryan
 */
@Service
public class RevistaServiceImp implements RevistaService {

    @Autowired
    private RevistaRepository revistaRepository;

    @Override
    public Revista regitrarRevista(Revista obj) {
        return revistaRepository.save(obj);
    }

    @Override
    public List<Revista> listaRevista() {
        return revistaRepository.findAll();
    }

    @Override
    public Revista insertaActualizaRevista(Revista revista) {
        return revistaRepository.save(revista);
    }

    @Override
    public List<Revista> listaRevistaPorNombreLike(String nombre) {
        return revistaRepository.listaPorNombreLike(nombre);
    }

    @Override
    public void eliminaRevista(int idRevista) {
        revistaRepository.deleteById(idRevista);
    }

    @Override
    public List<Revista> listaConsultaDinamica(String nombre, String frecuencia, int estado, int idPais) {
        return revistaRepository.listaConsultaDinamica(nombre, frecuencia, estado, idPais);
    }

}