package com.sistema.biblioteca.Repository;

import java.util.List;

import com.sistema.biblioteca.Entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LibroRepository extends JpaRepository<Libro, Integer>{

    static List<Libro> listaConsultaDinamica(String titulo, String serie) {

        return null;
    }

}