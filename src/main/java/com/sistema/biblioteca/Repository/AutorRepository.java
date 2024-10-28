package com.sistema.biblioteca.Repository;

import java.util.List;

import com.sistema.biblioteca.Entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface AutorRepository extends JpaRepository<Autor, Integer>{

    @Query("select a from Autor a where a.nombres like ?1")
    public List<Autor> listaPorNombreLike(String nombres);

    @Query("select x from Autor x where (x.nombres like ?1) and "
            + "(?2 = '' or x.telefono = ?2) and "
            + "(x.estado = ?3) and "
            + "(?4 = -1 or x.pais.idPais = ?4)")
    public List<Autor> listaConsultaDinamica(String nombres, String telefono, int estado,int idPais);
}