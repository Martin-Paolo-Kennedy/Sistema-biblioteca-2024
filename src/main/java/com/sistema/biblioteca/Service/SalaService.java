package com.sistema.biblioteca.Service;

import java.util.List;

import com.sistema.biblioteca.Entity.Sala;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface SalaService {
    public abstract Sala regitrarSala(Sala obj);

    public abstract List<Sala> listaSala();

    public abstract Sala insertaActualizaSala(Sala sala);


    public abstract List<Sala> listaSalaPorNombreLike(String numero);

    public abstract void eliminaSala(int idSala);
//NECESARIO PARA RESERVA SALA

    public abstract List<Sala> listaSalas(String filtro, Pageable ageable);
  /*
	public abstract Sala regitrarSala(Sala obj);
    public abstract List<Sala> listaSala();
    public abstract Sala insertaActualizaSala(Sala sala);
	public abstract List<Sala> listaSalaPorNombreLike(String numero);
	public abstract void eliminaSala(int idSala);
	*/

    public List<Sala> listaConsultaDinamica(String numero, String recursos, int estado,int idSede);
    /*
     */
}