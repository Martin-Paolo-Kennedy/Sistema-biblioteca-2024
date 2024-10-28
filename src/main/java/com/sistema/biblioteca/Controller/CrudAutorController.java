package com.sistema.biblioteca.Controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sistema.biblioteca.Entity.Autor;
import com.sistema.biblioteca.Service.AutorService;
import com.sistema.biblioteca.Util.AppSettings;
import com.sistema.biblioteca.Util.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/url/crudAutor")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class CrudAutorController {

    @Autowired
    private AutorService service;


    @GetMapping("/listaAutorPorNombreLike/{nom}")
    @ResponseBody
    public ResponseEntity<List<Autor>> listaAutorPorNombreLike(@PathVariable("nom") String nom) {
        List<Autor> lista  = null;
        try {
            if (nom.equals("todos")) {
                lista = service.listaAutorPorNombreLike("%");
            }else {
                lista = service.listaAutorPorNombreLike("%" + nom + "%");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(lista);
    }

    @PostMapping("/registraAutor")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> insertaAutor(@RequestBody Autor obj) {
        Map<String, Object> salida = new HashMap<>();
        try {
            obj.setIdAutor(0);
            obj.setFechaActualizacion(new Date());
            obj.setFechaRegistro(new Date());
            obj.setEstado(AppSettings.ACTIVO);
            Autor objSalida =  service.insertaActualizaAutor(obj);
            if (objSalida == null) {
                salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
            } else {
                salida.put("mensaje", Constantes.MENSAJE_REG_EXITOSO);
            }
        } catch (Exception e) {
            e.printStackTrace();
            salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
        }
        return ResponseEntity.ok(salida);
    }

    @PutMapping("/actualizaAutor")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> actualizaAutor(@RequestBody Autor obj) {
        Map<String, Object> salida = new HashMap<>();
        try {
            Autor objSalida =  service.insertaActualizaAutor(obj);
            if (objSalida == null) {
                salida.put("mensaje", Constantes.MENSAJE_ACT_ERROR);
            } else {
                salida.put("mensaje", Constantes.MENSAJE_ACT_EXITOSO);
            }
        } catch (Exception e) {
            e.printStackTrace();
            salida.put("mensaje", Constantes.MENSAJE_ACT_ERROR);
        }
        return ResponseEntity.ok(salida);
    }


    @DeleteMapping("/eliminaAutor/{id}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> eliminaAutor(@PathVariable("id") int idAutor) {
        Map<String, Object> salida = new HashMap<>();
        try {
            service.eliminaAutor(idAutor);
            salida.put("mensaje", Constantes.MENSAJE_ELI_EXITOSO);
        } catch (Exception e) {
            e.printStackTrace();
            salida.put("mensaje", Constantes.MENSAJE_ELI_ERROR);
        }
        return ResponseEntity.ok(salida);
    }

    @GetMapping("/listaAutor")
    @ResponseBody
    public List<Autor> listaAutor() {
        return service.listarTodo();
    }
}