package com.sistema.biblioteca.Service;

import java.util.List;

import com.sistema.biblioteca.Entity.Ejemplo;
import com.sistema.biblioteca.Repository.EjemploRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EjemploServiceImp implements EjemploService {

    @Autowired
    private EjemploRepository repository;

    @Override
    public Ejemplo insertaActualizaEjemplo(Ejemplo obj) {
        return repository.save(obj);
    }

    @Override
    public List<Ejemplo> listaEjemplo() {
        return repository.findAll();
    }

}