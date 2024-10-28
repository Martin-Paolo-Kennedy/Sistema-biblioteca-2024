package com.sistema.biblioteca.Controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sistema.biblioteca.Entity.Proveedor;
import com.sistema.biblioteca.Service.ProveedorService;
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
@RequestMapping("/url/crudproveedor")
@CrossOrigin(origins =  AppSettings.URL_CROSS_ORIGIN)
public class ProveedorCrudController {
    @Autowired
    private ProveedorService service;


    @GetMapping("/listaProveedorPorNombre/{nom}")
    @ResponseBody
    public ResponseEntity<List<Proveedor>> listaProveedorPorNombre(@PathVariable("nom") String nom) {
        List<Proveedor> lista  = null;
        try {
            if (nom.equals("todos")) {
                lista = service.listaProveedorPorNombre("%");
            }else {
                lista = service.listaProveedorPorNombre("%" + nom + "%");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(lista);
    }

    @PostMapping("/registraProveedor")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> insertaProveedor(@RequestBody Proveedor obj) {
        Map<String, Object> salida = new HashMap<>();
        try {
            obj.setIdProveedor(0);
            obj.setFechaActualizacion(new Date());
            obj.setFechaRegistro(new Date());
            obj.setEstado(1);
            Proveedor objSalida =  service.insertaActualizaProveedor(obj);
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

    @PutMapping("/actualizaProveedor")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> actualizaProveedor(@RequestBody Proveedor obj) {
        Map<String, Object> salida = new HashMap<>();
        try {
            obj.setFechaActualizacion(new Date());
            Proveedor objSalida =  service.insertaActualizaProveedor(obj);
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


    @DeleteMapping("/eliminaProveedor/{id}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> eliminaProveedor(@PathVariable("id") int idProveedor) {
        Map<String, Object> salida = new HashMap<>();
        try {
            service.eliminaProveedor(idProveedor);
            salida.put("mensaje", Constantes.MENSAJE_ELI_EXITOSO);
        } catch (Exception e) {
            e.printStackTrace();
            salida.put("mensaje", Constantes.MENSAJE_ELI_ERROR);
        }
        return ResponseEntity.ok(salida);
    }
}