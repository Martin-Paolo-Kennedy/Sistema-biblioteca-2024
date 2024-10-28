package com.sistema.biblioteca.Service;

import java.util.List;

import com.sistema.biblioteca.Entity.Pais;
import com.sistema.biblioteca.Repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PaisServiceImp implements PaisService {

    @Autowired
    private PaisRepository repository;

    @Override
    public List<Pais> listaTodos() {
        return repository.findByOrderByNombreAsc();

    }

}