package com.sistema.biblioteca.Repository;

import java.util.List;

import com.sistema.biblioteca.Entity.Sala;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface SalaRepository extends JpaRepository<Sala, Integer>{

    @Query("select x from Sala x where x.numero like ?1")
    public List<Sala> listaPorNombreLike(String numero);


    //paginacion para Reserva Sala
    @Query("Select x from Sala x where numero like :var_filtro")
    public abstract List<Sala> listaSalas(@Param("var_filtro") String filtro, Pageable ageable);


    @Query("select x from Sala x where (x.numero like ?1) and "
            + "(?2 = '' or x.recursos = ?2) and "
            + "(x.estado = ?3) and "
            + "(?4 = -1 or x.sede.idDataCatalogo = ?4)")
    public List<Sala> listaConsultaDinamica(String numero, String recursos, int estado,int idSede);


}