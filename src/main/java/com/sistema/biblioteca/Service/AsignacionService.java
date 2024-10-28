package com.sistema.biblioteca.Service;

import com.sistema.biblioteca.Entity.Opcion;
import com.sistema.biblioteca.Entity.Rol;
import com.sistema.biblioteca.Entity.RolHasOpcion;

import java.util.List;



public interface AsignacionService {

    List<Rol> obtenerRoles();
    List<Opcion> obtenerOpciones();
    List<RolHasOpcion> obtenerAsignaciones();
    void agregarAsignacion(int idRol, int idOpcion);
    void eliminarAsignacion(int idRol, int idOpcion);

}