package com.sistema.biblioteca.Controller;
import java.util.List;

import com.sistema.biblioteca.Entity.Autor;
import com.sistema.biblioteca.Service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/url/consultaAutor")
@CrossOrigin(origins = "http://localhost:4200")
public class AutorConsultaController {
    @Autowired
    private AutorService service;

    @GetMapping("/consultaAutorPorParametros")
    @ResponseBody
    public List<Autor> listaConsultaAutor(
            @RequestParam(name = "nombres" , required = false, defaultValue = "") String nombres,
            @RequestParam(name = "telefono" , required = false, defaultValue = "") String telefono,
            @RequestParam(name = "estado" , required = true, defaultValue = "1") int estado,
            @RequestParam(name = "idPais" , required = false, defaultValue = "-1") int idPais){

        List<Autor> lstSalida = service.listaConsultaDinamica("%"+ nombres + "%", telefono, estado, idPais);

        return lstSalida;
    }
}