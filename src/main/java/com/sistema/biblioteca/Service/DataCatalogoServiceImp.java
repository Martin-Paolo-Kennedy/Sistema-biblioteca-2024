package com.sistema.biblioteca.Service;

import java.util.List;

import com.sistema.biblioteca.Entity.DataCatalogo;
import com.sistema.biblioteca.Repository.DataCatalogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DataCatalogoServiceImp implements DataCatalogoService {

    @Autowired
    private DataCatalogoRepository repository;

    @Override
    public List<DataCatalogo> listaDataCatalogo(int idTipo) {
        return repository.listaDataCatalogo(idTipo);
    }

}