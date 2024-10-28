package com.sistema.biblioteca.Service;

import com.sistema.biblioteca.Entity.Tesis;

import java.util.List;

public interface TesisService {

    public abstract Tesis registrarTesis(Tesis obj);
    public abstract List<Tesis> listarTesis();

    public abstract Tesis actualizaTesis(Tesis obj);
    public abstract void eliminaTesis(int idTesis);
    public abstract List<Tesis> listaTesisPorTituloLike(String titulo);
}