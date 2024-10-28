package com.sistema.biblioteca.Service;

import com.sistema.biblioteca.Entity.LibroHasAutor;

import java.util.List;


public interface libroAutorService {
    public LibroHasAutor inserta(LibroHasAutor obj);
    public List<LibroHasAutor> lista();
}