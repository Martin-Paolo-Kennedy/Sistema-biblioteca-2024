package com.sistema.biblioteca.Service;

import java.util.List;

import com.sistema.biblioteca.Entity.Alumno;
import com.sistema.biblioteca.Repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class AlumnoServiceImp implements AlumnoService {

    @Autowired
    private AlumnoRepository repository;

    @Override
    public List<Alumno> listaTodos() {
        return repository.findAll();
    }

    @Override
    public List<Alumno> listaAlumnoPorNombreLike(String nombres) {
        return repository.listaAlumnoPorNombreLike(nombres);
    }

    @Override
    public Alumno InsertaAlumno(Alumno obj) {

        return repository.save(obj);
    }

    @Override
    public Alumno insertaActualizaAlumno(Alumno alumno) {
        return repository.save(alumno);
    }

    @Override
    public void eliminaAlumno(int idAlumno) {
        repository.deleteById(idAlumno);
    }

    //consulta

    @Override
    public List<Alumno> listaConsultaDinamica(String nombres, String apellidos, String dni, int idPais) {
        return repository.listaConsultaDinamica(nombres, apellidos, dni, idPais);
    }

    //PARA RESERVA SALA
    @Override
    public List<Alumno> listaAlumnos(String filtro, Pageable ageable) {
        return repository.listaAlumnos(filtro, ageable);
    }


}