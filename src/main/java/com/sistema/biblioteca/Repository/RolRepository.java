package com.sistema.biblioteca.Repository;

import com.sistema.biblioteca.Entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {}