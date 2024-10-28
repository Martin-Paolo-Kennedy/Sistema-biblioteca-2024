package com.sistema.biblioteca.Controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.sistema.biblioteca.Entity.Proveedor;
import com.sistema.biblioteca.Service.ProveedorService;
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
@RequestMapping("/url/proveedor")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class ProveedorRegistraController {
    @Autowired
    private ProveedorService proveedorService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Proveedor>> listaProveedor() {
        List<Proveedor> lista = proveedorService.listaProveedor();
        return ResponseEntity.ok(lista);

    }
    @PostMapping
    @ResponseBody
    public ResponseEntity<?> insertar(@RequestBody Proveedor obj) {
        HashMap<String, Object> salida = new HashMap<>();

        obj.setFechaActualizacion(new Date());
        obj.setFechaRegistro(new Date());
        obj.setEstado(AppSettings.ACTIVO);

        obj = proveedorService.regitrarProveedor(obj);
        if (obj == null) {
            salida.put("mensaje", "Error en el registro");
        } else {
            salida.put("mensaje", "Se registró el Proveedor con el ID ==> " + obj.getIdProveedor());
        }
        return ResponseEntity.ok(salida);
    }

}