package com.sistema.biblioteca.Controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.sistema.biblioteca.Entity.Ejemplo;
import com.sistema.biblioteca.Service.EjemploService;
import com.sistema.biblioteca.Util.AppSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/url/ejemplo")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class EjemploController {

    @Autowired
    private EjemploService EjemploService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Ejemplo>> listaeEjemplo() {
        List<Ejemplo> lista = EjemploService.listaEjemplo();
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<?> inserta(@RequestBody Ejemplo obj) {
        HashMap<String, Object> salida = new HashMap<>();

        obj.setFechaActualizacion(new Date());
        obj.setFechaRegistro(new Date());
        obj.setEstado(AppSettings.ACTIVO);

        Ejemplo objSalida = EjemploService.insertaActualizaEjemplo(obj);
        if (objSalida == null) {
            salida.put("mensaje", "Error en el registro");
        } else {
            salida.put("mensaje", "Se registró la Ejemplo con el ID ==> " + objSalida.getIdEjemplo());
        }
        return ResponseEntity.ok(salida);
    }

}