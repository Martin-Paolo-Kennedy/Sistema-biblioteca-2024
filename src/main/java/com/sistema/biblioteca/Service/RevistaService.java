package com.sistema.biblioteca.Service;

import com.sistema.biblioteca.Entity.Revista;

import java.util.List;

/**
 *
 * @author Bryan
 */
public interface RevistaService {

    public abstract Revista regitrarRevista(Revista obj);

    public abstract List<Revista> listaRevista();

    public abstract Revista insertaActualizaRevista(Revista revista);

    public abstract List<Revista> listaRevistaPorNombreLike(String nombre);

    public abstract void eliminaRevista(int idRevista);

    public abstract List<Revista> listaConsultaDinamica(String nombre, String frecuencia, int estado,int idPais);

}