package com.sistema.biblioteca.Service;

import com.sistema.biblioteca.Entity.Editorial;

import java.util.List;


public interface EditorialService {
    public abstract Editorial insertaActualizaEditorial(Editorial editorial);
    public abstract List<Editorial> listaEditorial();

    public abstract List<Editorial> listaEditorialPorRazLike(String razon);
    public abstract void eliminarEditorial(int idEditorial);

    public abstract List<Editorial> listaConsultaDinamica(String razonSocial, String direccion, int estado, int idPais);
}