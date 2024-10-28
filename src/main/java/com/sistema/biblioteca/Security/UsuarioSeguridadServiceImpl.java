package com.sistema.biblioteca.Security;

import java.util.List;

import com.sistema.biblioteca.Entity.Opcion;
import com.sistema.biblioteca.Entity.Rol;
import com.sistema.biblioteca.Entity.Usuario;
import com.sistema.biblioteca.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



import lombok.extern.apachecommons.CommonsLog;

@Service
@CommonsLog
public class UsuarioSeguridadServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        log.info(">>>loadUserByUsername >>> " + login);
        UserDetails userDetails = null;
        try {
            Usuario objUsuario = usuarioRepository.findByLogin(login);
            if (objUsuario != null) {
                log.info("==> Login =========== " + objUsuario);

                List<Rol> lstRol = usuarioRepository.traerRolesDeUsuario(objUsuario.getIdUsuario());
                log.info("==> Roles =========== " + lstRol);

                List<Opcion> lstOpciones = usuarioRepository.traerEnlacesDeUsuario(objUsuario.getIdUsuario());
                log.info("==> Opciones =========== " + lstOpciones);

                userDetails = UsuarioPrincipal.build(objUsuario, lstRol, lstOpciones);
            }
        } catch (IndexOutOfBoundsException e) {
            throw new UsernameNotFoundException("Wrong username");
        } catch (DataAccessException e) {
            e.printStackTrace();
            throw new UsernameNotFoundException("Database Error");
        } catch (Exception e) {
            e.printStackTrace();
            throw new UsernameNotFoundException("Unknown Error");
        }
        return userDetails;
    }

}