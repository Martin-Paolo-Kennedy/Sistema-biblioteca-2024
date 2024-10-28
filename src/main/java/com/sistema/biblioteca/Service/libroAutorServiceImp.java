package com.sistema.biblioteca.Service;

import java.util.List;

import com.sistema.biblioteca.Entity.LibroHasAutor;
import com.sistema.biblioteca.Repository.libroAutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class libroAutorServiceImp implements libroAutorService{

    @Autowired
    private libroAutorRepository repository;

    @Override
    public LibroHasAutor inserta(LibroHasAutor obj) {
        // TODO Auto-generated method stub
        return repository.save(obj);
    }

    @Override
    public List<LibroHasAutor> lista() {
        // TODO Auto-generated method stub
        return repository.findAll();
    }

}