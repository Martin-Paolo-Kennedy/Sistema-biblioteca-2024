package com.sistema.biblioteca.Repository;

import java.util.List;

import com.sistema.biblioteca.Entity.Opcion;
import com.sistema.biblioteca.Entity.Rol;
import com.sistema.biblioteca.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

    @Query("Select x from Usuario x where x.login = :#{#usu.login} and x.password = :#{#usu.password}")
    public abstract Usuario login(@Param(value = "usu") Usuario bean);

    @Query("Select p from Opcion p, RolHasOpcion pr, Rol r, UsuarioHasRol u where  p.idOpcion = pr.opcion.idOpcion and pr.rol.idRol = r.idRol and r.idRol = u.rol.idRol and u.usuario.idUsuario = :var_idUsuario")
    public abstract List<Opcion> traerEnlacesDeUsuario(@Param("var_idUsuario") int idUsuario);

    @Query("Select r from Rol r, UsuarioHasRol u where r.idRol = u.rol.idRol and u.usuario.idUsuario = :var_idUsuario")
    public abstract List<Rol> traerRolesDeUsuario(@Param("var_idUsuario")int idUsuario);

    public abstract Usuario findByLogin(String login);

}