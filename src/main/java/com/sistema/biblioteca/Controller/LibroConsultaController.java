package com.sistema.biblioteca.Controller;

import java.util.List;

import com.sistema.biblioteca.Entity.Libro;
import com.sistema.biblioteca.Service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/url/consultaLibro")
@CrossOrigin(origins = "http://localhost:4200")
public class LibroConsultaController {
    @Autowired
    private LibroService service;

    @GetMapping("/consultaLibroPorParametros")
    @ResponseBody
    public List<Libro> listaConsultaLibro(
            @RequestParam(name = "titulo" , required = false, defaultValue = "") String titulo,
            @RequestParam(name = "serie" , required = false, defaultValue = "") String serie) {

        List<Libro> lstSalida = service.listaConsultaDinamica("%" + titulo + "%", serie);

        return lstSalida;
    }
}