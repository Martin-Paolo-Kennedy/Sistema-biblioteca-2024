package com.sistema.biblioteca.Repository;

import com.sistema.biblioteca.Entity.Opcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OpcionRepository extends JpaRepository<Opcion, Integer> {}