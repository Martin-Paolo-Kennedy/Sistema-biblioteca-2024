package com.sistema.biblioteca.Controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sistema.biblioteca.Entity.Alumno;
import com.sistema.biblioteca.Service.AlumnoService;
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
@RequestMapping("/url/crudAlumno")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class AlumnoCrudController {

    @Autowired
    private AlumnoService service;

    @GetMapping("/listaAlumnoPorNombreLike/{nom}")
    @ResponseBody
    public ResponseEntity<List<Alumno>> listaAlumnoPorNombreLike(@PathVariable("nom") String nom) {
        List<Alumno> lista  = null;
        try {
            if (nom.equals("todos")) {
                lista = service.listaAlumnoPorNombreLike("%");
            }else {
                lista = service.listaAlumnoPorNombreLike("%" + nom + "%");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(lista);
    }

    @PostMapping("/registraAlumno")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> insertaAlumno(@RequestBody Alumno obj) {
        Map<String, Object> salida = new HashMap<>();
        try {
            obj.setIdAlumno(0);
            obj.setFechaActualizacion(new Date());
            obj.setFechaRegistro(new Date());
            obj.setEstado(AppSettings.ACTIVO);
            Alumno objSalida =  service.insertaActualizaAlumno(obj);
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

    @PutMapping("/actualizaAlumno")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> actualizaAlumno(@RequestBody Alumno obj) {
        Map<String, Object> salida = new HashMap<>();
        try {
            Alumno objSalida =  service.insertaActualizaAlumno(obj);
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

    @DeleteMapping("/eliminaAlumno/{id}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> eliminaAlumno(@PathVariable("id") int idAlumno) {
        Map<String, Object> salida = new HashMap<>();
        try {
            service.eliminaAlumno(idAlumno);
            salida.put("mensaje", Constantes.MENSAJE_ELI_EXITOSO);
        } catch (Exception e) {
            e.printStackTrace();
            salida.put("mensaje", Constantes.MENSAJE_ELI_ERROR);
        }
        return ResponseEntity.ok(salida);
    }
}