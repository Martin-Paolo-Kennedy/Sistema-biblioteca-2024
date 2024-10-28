package com.sistema.biblioteca.Service;

import java.util.List;

import com.sistema.biblioteca.Entity.Proveedor;
import com.sistema.biblioteca.Repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProveedorServicelmp implements ProveedorService{

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Override
    public Proveedor regitrarProveedor(Proveedor obj) {
        return proveedorRepository.save(obj);
    }

    @Override
    public List<Proveedor> listaProveedor() {
        return proveedorRepository.findAll();
    }

    @Override
    public Proveedor insertaActualizaProveedor(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    @Override
    public List<Proveedor> listaProveedorPorNombre(String nombre) {
        return proveedorRepository.listaPorNombre(nombre);
    }

    @Override
    public void eliminaProveedor(int idProveedor) {
        proveedorRepository.deleteById(idProveedor);
    }

    @Override
    public List<Proveedor> listaConsultaDinamica(String razonsocial, String celular, int estado, int idTipoProveedor) {
        return proveedorRepository.listaConsultaDinamica(razonsocial, celular, estado, idTipoProveedor);

    }




}