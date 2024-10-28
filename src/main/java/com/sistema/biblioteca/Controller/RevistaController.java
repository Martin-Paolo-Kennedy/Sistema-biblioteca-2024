package com.sistema.biblioteca.Controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sistema.biblioteca.Entity.Revista;
import com.sistema.biblioteca.Service.RevistaService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Bryan
 */
@RestController
@RequestMapping("/url/revista")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class RevistaController {

    @Autowired
    private RevistaService revistaService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Revista>> listaRevista() {
        List<Revista> lista = revistaService.listaRevista();
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<?> insertar(@RequestBody Revista obj) {
        HashMap<String, Object> salida = new HashMap<>();

        obj.setFechaActualizacion(new Date());
        obj.setFechaRegistro(new Date());
        obj.setEstado(AppSettings.ACTIVO);

        obj = revistaService.regitrarRevista(obj);
        if (obj == null) {
            salida.put("mensaje", "Error en el registro");
        } else {
            salida.put(
                    "mensaje",
                    "Se registró la Revista con el ID ==> " + obj.getIdRevista()
            );
        }
        return ResponseEntity.ok(salida);
    }

    @GetMapping("/listaRevistaPorNombreLike/{nom}")
    @ResponseBody
    public ResponseEntity<List<Revista>> listaRevistaPorNombreLike(
            @PathVariable("nom") String nom
    ) {
        List<Revista> lista = null;
        try {
            if (nom.equals("todos")) {
                lista = revistaService.listaRevistaPorNombreLike("%");
            } else {
                lista = revistaService.listaRevistaPorNombreLike("%" + nom + "%");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(lista);
    }

    @PostMapping("/registraRevista")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> insertaRevista(
            @RequestBody Revista obj
    ) {
        Map<String, Object> salida = new HashMap<>();
        try {
            obj.setIdRevista(0);
            obj.setFechaRegistro(new Date());
            obj.setEstado(1);
            Revista objSalida = revistaService.insertaActualizaRevista(obj);
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

    @PutMapping("/actualizaRevista")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> actualizaRevista(
            @RequestBody Revista obj
    ) {
        Map<String, Object> salida = new HashMap<>();
        try {
            obj.setFechaActualizacion(new Date());
            Revista objSalida = revistaService.insertaActualizaRevista(obj);
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

    @DeleteMapping("/eliminaRevista/{id}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> eliminaRevista(
            @PathVariable("id") int idRevista
    ) {
        Map<String, Object> salida = new HashMap<>();
        try {
            revistaService.eliminaRevista(idRevista);
            salida.put("mensaje", Constantes.MENSAJE_ELI_EXITOSO);
        } catch (Exception e) {
            e.printStackTrace();
            salida.put("mensaje", Constantes.MENSAJE_ELI_ERROR);
        }
        return ResponseEntity.ok(salida);
    }

    @GetMapping("/consultarevistaporparametros")
    @ResponseBody
    public List<Revista> listaConsultaDocente(
            @RequestParam(
                    name = "nombre",
                    required = false,
                    defaultValue = ""
            ) String nombre,
            @RequestParam(
                    name = "frecuencia",
                    required = false,
                    defaultValue = ""
            ) String frecuencia,
            @RequestParam(
                    name = "estado",
                    required = true,
                    defaultValue = "1"
            ) int estado,
            @RequestParam(
                    name = "idPais",
                    required = false,
                    defaultValue = "-1"
            ) int idPais
    ) {
        List<Revista> lstSalida = revistaService.listaConsultaDinamica(
                "%" + nombre + "%",
                frecuencia,
                estado,
                idPais
        );

        return lstSalida;
    }
}