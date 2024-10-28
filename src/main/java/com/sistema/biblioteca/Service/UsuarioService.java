package com.sistema.biblioteca.Service;

import com.sistema.biblioteca.Entity.Opcion;
import com.sistema.biblioteca.Entity.Rol;
import com.sistema.biblioteca.Entity.Usuario;

import java.util.List;


public interface UsuarioService {

    public abstract List<Opcion> traerEnlacesDeUsuario(int idUsuario);

    public abstract List<Rol> traerRolesDeUsuario(int idUsuario);

    public abstract Usuario buscaPorLogin(String login);
}