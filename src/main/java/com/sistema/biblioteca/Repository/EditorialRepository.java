package com.sistema.biblioteca.Repository;

import java.util.List;

import com.sistema.biblioteca.Entity.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface EditorialRepository extends JpaRepository<Editorial, Integer>{
    @Query("select x from Editorial x where x.razonSocial like ?1")
    public List<Editorial> listaPorRazonSocial(String raz);

    @Query("select x from Editorial x where (x.razonSocial like ?1) and "
            + "(?2 = '' or x.direccion = ?2) and "
            + "(x.estado = ?3) and "
            + "(?4 = -1 or x.pais.idPais = ?4)")
    public List<Editorial> listaConsultaDinamica(String razonSocial, String direccion, int estado,int idPais);
}