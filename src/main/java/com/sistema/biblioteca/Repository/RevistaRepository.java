package com.sistema.biblioteca.Repository;

import java.util.List;

import com.sistema.biblioteca.Entity.Revista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Bryan
 */
public interface RevistaRepository extends JpaRepository<Revista, Integer> {
    @Query("select x from Revista x where x.nombre like ?1")
    public List<Revista> listaPorNombreLike(String nombre);

    @Query(
            "select x from Revista x where (x.nombre like ?1) and " +
                    "(?2 = '' or x.frecuencia = ?2) and " +
                    "(x.estado = ?3) and " +
                    "(?4 = -1 or x.pais.idPais = ?4)"
    )
    public List<Revista> listaConsultaDinamica(
            String nombre,
            String frecuencia,
            int estado,
            int idPais
    );
}