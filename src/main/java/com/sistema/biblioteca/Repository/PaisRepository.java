package com.sistema.biblioteca.Repository;

import java.util.List;

import com.sistema.biblioteca.Entity.Pais;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PaisRepository extends JpaRepository<Pais, Integer>{


    public abstract List<Pais> findByOrderByNombreAsc();


}