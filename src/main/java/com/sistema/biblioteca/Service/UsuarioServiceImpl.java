package com.sistema.biblioteca.Service;

import java.util.List;

import com.sistema.biblioteca.Entity.Opcion;
import com.sistema.biblioteca.Entity.Rol;
import com.sistema.biblioteca.Entity.Usuario;
import com.sistema.biblioteca.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository repository;

    @Override
    public List<Opcion> traerEnlacesDeUsuario(int idUsuario) {
        return repository.traerEnlacesDeUsuario(idUsuario);
    }

    @Override
    public List<Rol> traerRolesDeUsuario(int idUsuario) {
        return repository.traerRolesDeUsuario(idUsuario);
    }

    @Override
    public Usuario buscaPorLogin(String login) {
        return repository.findByLogin(login);
    }

}