package com.sistema.biblioteca.Service;

import java.util.List;

import com.sistema.biblioteca.Entity.Libro;
import com.sistema.biblioteca.Repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LibroServicelmp implements LibroService {

    @Autowired
    private LibroRepository libroRepository;

    @Override
    public Libro insertaActualizaLibro(Libro obj) {
        return libroRepository.save(obj);
    }

    @Override
    public List<Libro> listaLibro() {
        return libroRepository.findAll();
    }

    // Agrega la implementación del nuevo método
    @Override
    public List<Libro> listaConsultaDinamica(String titulo, String serie) {

        return LibroRepository.listaConsultaDinamica(titulo, serie);
    }
}