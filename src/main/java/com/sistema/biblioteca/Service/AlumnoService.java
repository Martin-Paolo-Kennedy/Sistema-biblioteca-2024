package com.sistema.biblioteca.Service;

import java.util.List;

import com.sistema.biblioteca.Entity.Alumno;
import org.springframework.data.domain.Pageable;


public interface AlumnoService {

    public abstract List<Alumno> listaTodos();

    public abstract Alumno InsertaAlumno(Alumno obj);

    public abstract List<Alumno> listaAlumnoPorNombreLike(String nombres);

    public abstract Alumno insertaActualizaAlumno(Alumno alumno);

    public abstract void eliminaAlumno(int idAlumno);

    //consulta
    public List<Alumno> listaConsultaDinamica(String nombres, String apellidos, String dni,int idPais);

    public abstract List<Alumno> listaAlumnos(String filtro, Pageable ageable) ;
}