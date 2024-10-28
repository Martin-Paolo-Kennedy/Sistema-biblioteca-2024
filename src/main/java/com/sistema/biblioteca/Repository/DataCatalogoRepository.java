package com.sistema.biblioteca.Repository;

import java.util.List;

import com.sistema.biblioteca.Entity.DataCatalogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface DataCatalogoRepository extends JpaRepository<DataCatalogo, Integer>{


    @Query("Select r from DataCatalogo r where r.catalogo.idCatalogo =  ?1 order by descripcion asc")
    public abstract List<DataCatalogo> listaDataCatalogo(int idTipo);
}