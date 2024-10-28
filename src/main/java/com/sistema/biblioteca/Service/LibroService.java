package com.sistema.biblioteca.Service;

import com.sistema.biblioteca.Entity.Libro;

import java.util.List;


public interface LibroService {
    public abstract Libro insertaActualizaLibro(Libro obj);

    public abstract List<Libro> listaLibro();

    // Agrega un método para consultar libros por título y serie
    public abstract List<Libro> listaConsultaDinamica(String titulo, String serie);
}