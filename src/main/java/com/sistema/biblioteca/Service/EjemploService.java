package com.sistema.biblioteca.Service;

import com.sistema.biblioteca.Entity.Ejemplo;

import java.util.List;


public interface EjemploService {

    public abstract Ejemplo insertaActualizaEjemplo(Ejemplo obj);
    public abstract List<Ejemplo> listaEjemplo();
}