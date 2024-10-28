package com.sistema.biblioteca.Service;

import java.util.Date;

import com.sistema.biblioteca.Entity.ReservaSala;
import com.sistema.biblioteca.Entity.Sala;
import com.sistema.biblioteca.Entity.Usuario;
import com.sistema.biblioteca.Repository.ReservaSalaRepository;
import com.sistema.biblioteca.Repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReservaSalaServiceImpl implements ReservaSalaService {

    @Autowired
    private ReservaSalaRepository repository;

    @Autowired
    private SalaRepository salaRepository;

    @Override
    @Transactional
    public ReservaSala registraReservaSala(ReservaSala obj) {
        Sala sala = new Sala();
        sala = salaRepository.findById(obj.getSala().getIdSala()).orElse(null);
        sala.setEstado(obj.getSala().getEstado());

        Usuario usu = new Usuario();
        usu.setIdUsuario(obj.getUsuarioRegistro().getIdUsuario());
        sala.setUsuarioRegistro(usu);

        sala.setFechaActualizacion(new Date());
        salaRepository.save(sala);
        return repository.save(obj);
    }
}