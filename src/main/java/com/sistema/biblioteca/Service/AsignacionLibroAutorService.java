package com.sistema.biblioteca.Service;

import com.sistema.biblioteca.Entity.Autor;
import com.sistema.biblioteca.Entity.Libro;
import com.sistema.biblioteca.Entity.LibroHasAutor;

import java.util.List;



public interface AsignacionLibroAutorService {
    List<Libro> obtenerLibro();
    List<Autor> obtenerAutor();
    List<LibroHasAutor> obtenerAsignacion();
    void agregarAsignacion(int idLibro,int idAutor);
    void eliminarAsignacion(int idLibro,int idAutor);
}