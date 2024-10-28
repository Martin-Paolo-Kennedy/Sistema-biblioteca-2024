package com.sistema.biblioteca.Repository;

import com.sistema.biblioteca.Entity.RolHasOpcion;
import com.sistema.biblioteca.Entity.RolHasOpcionPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface RolHasOpcionRepository extends JpaRepository<RolHasOpcion, RolHasOpcionPK> {}