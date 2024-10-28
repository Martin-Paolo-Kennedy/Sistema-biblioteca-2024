package com.sistema.biblioteca.Service;

import com.sistema.biblioteca.Entity.Proveedor;

import java.util.List;

public interface ProveedorService {
    public abstract Proveedor regitrarProveedor(Proveedor obj);

    public abstract List<Proveedor> listaProveedor();

    public abstract Proveedor insertaActualizaProveedor(Proveedor proveedor);

    public abstract List<Proveedor> listaProveedorPorNombre(String nombre);

    public abstract void eliminaProveedor(int idProveedor);

    public List<Proveedor> listaConsultaDinamica(String razonsocial, String celular, int estado,int idTipoProveedor);
}