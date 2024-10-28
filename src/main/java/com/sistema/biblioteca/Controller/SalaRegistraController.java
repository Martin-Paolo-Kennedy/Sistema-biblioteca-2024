package com.sistema.biblioteca.Controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sistema.biblioteca.Entity.ReservaSala;
import com.sistema.biblioteca.Entity.Sala;
import com.sistema.biblioteca.Service.ReservaSalaService;
import com.sistema.biblioteca.Service.SalaService;
import com.sistema.biblioteca.Util.AppSettings;
import com.sistema.biblioteca.Util.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/url/sala")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class SalaRegistraController {

    @Autowired
    private SalaService salaService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Sala>> listaSala() {
        List<Sala> lista = salaService.listaSala();
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<?> insertar(@RequestBody Sala obj) {
        HashMap<String, Object> salida = new HashMap<>();

        obj.setFechaActualizacion(new Date());
        obj.setFechaRegistro(new Date());
        obj.setEstado(AppSettings.ACTIVO);

        obj = salaService.regitrarSala(obj);
        if (obj == null) {
            salida.put("mensaje", "Error en el registro");
        } else {
            salida.put("mensaje", "Se registró la Sala con el ID ==> " + obj.getIdSala());
        }
        return ResponseEntity.ok(salida);
    }

    @GetMapping("/listaSalaPorNombreLike/{nom}")
    @ResponseBody
    public ResponseEntity<List<Sala>> listaSalaPorNombreLike(@PathVariable("nom") String nom) {
        List<Sala> lista = null;
        try {
            if (nom.equals("todos")) {
                lista = salaService.listaSalaPorNombreLike("%");
            } else {
                lista = salaService.listaSalaPorNombreLike("%" + nom + "%");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(lista);
    }

    @PostMapping("/registraSala")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> insertaSala(@RequestBody Sala obj) {
        Map<String, Object> salida = new HashMap<>();
        try {
            obj.setIdSala(0);
            obj.setFechaActualizacion(new Date());
            obj.setFechaRegistro(new Date());
            obj.setEstado(AppSettings.ACTIVO);
            Sala objSalida = salaService.insertaActualizaSala(obj);
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

    @PutMapping("/actualizaSala")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> actualizaSala(@RequestBody Sala obj) {
        Map<String, Object> salida = new HashMap<>();
        try {
            obj.setFechaActualizacion(new Date());
            Sala objSalida = salaService.insertaActualizaSala(obj);
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

    @DeleteMapping("/eliminaSala/{id}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> eliminaSala(@PathVariable("id") int idSala) {
        Map<String, Object> salida = new HashMap<>();
        try {
            salaService.eliminaSala(idSala);
            salida.put("mensaje", Constantes.MENSAJE_ELI_EXITOSO);
        } catch (Exception e) {
            e.printStackTrace();
            salida.put("mensaje", Constantes.MENSAJE_ELI_ERROR);
        }
        return ResponseEntity.ok(salida);
    }

    //NECESARIO PARA RESERVA SALA
    @Autowired
    private ReservaSalaService reservaSalaService;


    @ResponseBody
    @GetMapping("/listaSala")
    public List<Sala> listaSala(
            @RequestParam(name = "page", defaultValue = "0", required = false) int page,
            @RequestParam(name = "size", defaultValue = "5", required = false) int size) {
        Pageable paginacion = PageRequest.of(page, size);
        List<Sala> lista = salaService.listaSalas("%", paginacion);
        return lista;
    }

    @ResponseBody
    @GetMapping("/listaSala/{filtro}")
    public List<Sala> listaSala(@PathVariable("filtro") String filtro,
                                @RequestParam(name = "page", defaultValue = "0", required = false) int page,
                                @RequestParam(name = "size", defaultValue = "5", required = false) int size) {
        Pageable paginacion = PageRequest.of(page, size);
        List<Sala> lista = salaService.listaSalas(filtro + "%", paginacion);
        return lista;
    }

    @PostMapping("/registraReservaSala")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> registraReservaSala(@RequestBody ReservaSala obj) {
        Map<String, Object> salida = new HashMap<>();
        System.out.println(obj.getAlumno().getIdAlumno());
        try {
            obj.setFechaRegistro(new Date());
            obj.setEstado(AppSettings.ACTIVO);
            ReservaSala objSalida = reservaSalaService.registraReservaSala(obj);
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
}