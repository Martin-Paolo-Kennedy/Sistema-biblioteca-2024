package com.sistema.biblioteca.Controller;
import java.util.List;

import com.sistema.biblioteca.Entity.Sala;
import com.sistema.biblioteca.Service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/url/consultaSala")
@CrossOrigin(origins = "http://localhost:4200")
public class SalaConsultaController {
    @Autowired
    private SalaService service;

    @GetMapping("/consultaSalaPorParametros")
    @ResponseBody
    public List<Sala> listaConsultaSala(
            @RequestParam(name = "numero" , required = false, defaultValue = "") String numero,
            @RequestParam(name = "recursos" , required = false, defaultValue = "") String recursos,
            @RequestParam(name = "estado" , required = true, defaultValue = "1") int estado,
            @RequestParam(name = "idSede" , required = false, defaultValue = "-1") int idSede){

        List<Sala> lstSalida = service.listaConsultaDinamica("%"+ numero + "%", recursos , estado, idSede);

        return lstSalida;
    }
}