package com.sistema.biblioteca.Controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sistema.biblioteca.Entity.Editorial;
import com.sistema.biblioteca.Service.EditorialService;
import com.sistema.biblioteca.Util.AppSettings;
import com.sistema.biblioteca.Util.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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


@Controller
@RequestMapping("/url/editorialcrud")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class EditorialCrudController {
    @Autowired
    private EditorialService editorialService;

    @GetMapping("/listaEditorialPorRazLike/{raz}")
    @ResponseBody
    public ResponseEntity<List<Editorial>> listaEditorialPorRazLike(@PathVariable("raz") String raz) {
        List<Editorial> lista  = null;
        try {
            if (raz.equals("todos")) {
                lista = editorialService.listaEditorialPorRazLike("%");
            }else {
                lista = editorialService.listaEditorialPorRazLike("%" + raz + "%");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/consultaEditorial")
    @ResponseBody
    public List<Editorial> listaConsultaEditorial(
            @RequestParam(name = "razonSocial" , required = false, defaultValue = "") String razonSocial,
            @RequestParam(name = "direccion" , required = false, defaultValue = "") String direccion,
            @RequestParam(name = "estado" , required = true, defaultValue = "1") int estado,
            @RequestParam(name = "idPais" , required = false, defaultValue = "-1") int idPais){

        List<Editorial> lstSalida = editorialService.listaConsultaDinamica("%"+ razonSocial + "%", direccion, estado, idPais);

        return lstSalida;
    }







    @PostMapping("/registraEditorial")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> insertaEditorial(@RequestBody Editorial obj) {
        Map<String, Object> salida = new HashMap<>();
        try {
            obj.setIdEditorial(0);
            obj.setFechaActualizacion(new Date());
            obj.setFechaRegistro(new Date());
            obj.setEstado(AppSettings.ACTIVO);
            Editorial objSalida =  editorialService.insertaActualizaEditorial(obj);
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



    @PutMapping("/actualizaEditorial")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> actualizaEditorial(@RequestBody Editorial obj) {
        Map<String, Object> salida = new HashMap<>();
        try {
            Editorial objSalida =  editorialService.insertaActualizaEditorial(obj);
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




    @DeleteMapping("/eliminaEditorial/{id}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> eliminaEditorial(@PathVariable("id") int idEditorial) {
        Map<String, Object> salida = new HashMap<>();
        try {
            editorialService.eliminarEditorial(idEditorial);
            salida.put("mensaje", Constantes.MENSAJE_ELI_EXITOSO);
        } catch (Exception e) {
            e.printStackTrace();
            salida.put("mensaje", Constantes.MENSAJE_ELI_ERROR);
        }
        return ResponseEntity.ok(salida);
    }

}