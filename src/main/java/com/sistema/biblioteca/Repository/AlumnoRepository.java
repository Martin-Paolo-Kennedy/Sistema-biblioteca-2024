package com.sistema.biblioteca.Repository;

import java.util.List;

import com.sistema.biblioteca.Entity.Alumno;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface AlumnoRepository extends JpaRepository<Alumno, Integer>{

    @Query("select a from Alumno a where a.nombres like %?1%")
    public List<Alumno> listaAlumnoPorNombreLike(String nombres);


    @Query("select x from Alumno x where (x.nombres like ?1) and "
            + "(x.apellidos like ?2) and "
            + "(?3 = '' or x.dni = ?3) and "
            + "(?4 = -1 or x.pais.idPais = ?4)")
    public List<Alumno> listaConsultaDinamica(String nombres, String apellidos, String dni, int idPais);



    //paginacion para Reserva Sala
    @Query("Select x from Alumno x where nombres like :var_filtro or apellidos like :var_filtro")
    public abstract List<Alumno> listaAlumnos(@Param("var_filtro") String filtro, Pageable ageable);

}