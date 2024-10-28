package com.sistema.biblioteca.Repository;

import java.util.List;

import com.sistema.biblioteca.Entity.Tesis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface TesisRepository extends JpaRepository<Tesis, Integer>{

    @Query("select t from Tesis t where t.titulo like?1")
    public List<Tesis> listaPorTituloLike(String titulo);
}