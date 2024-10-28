package com.sistema.biblioteca.Repository;

import com.sistema.biblioteca.Entity.LibroHasAutor;
import com.sistema.biblioteca.Entity.LibroHasAutorPK;
import org.springframework.data.jpa.repository.JpaRepository;


public interface libroAutorRepository extends JpaRepository<LibroHasAutor, LibroHasAutorPK>{
    //LibroHasAutorPK
}