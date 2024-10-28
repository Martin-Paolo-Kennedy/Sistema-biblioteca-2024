package com.sistema.biblioteca.Service;

import com.sistema.biblioteca.Entity.DataCatalogo;

import java.util.List;


public interface DataCatalogoService {

    public abstract List<DataCatalogo> listaDataCatalogo(int idTipo);


}