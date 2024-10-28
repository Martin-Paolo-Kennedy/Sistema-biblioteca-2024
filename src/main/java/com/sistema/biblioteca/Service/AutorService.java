package com.sistema.biblioteca.Service;

import java.util.List;

import com.sistema.biblioteca.Entity.Autor;
import org.springframework.stereotype.Service;

@Service
public interface AutorService {
    public abstract Autor insertaActualizaAutor(Autor obj);
    public abstract List<Autor> listaAutorPorNombreLike(String nombres);
    public abstract void eliminaAutor(int idAutor);
    public abstract List<Autor> listarTodo();
    public List<Autor> listaConsultaDinamica(String nombres, String telefono, int estado,int idPais);

}