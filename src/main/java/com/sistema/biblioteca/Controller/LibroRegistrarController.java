package com.sistema.biblioteca.Controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.sistema.biblioteca.Entity.DataCatalogo;
import com.sistema.biblioteca.Entity.Libro;
import com.sistema.biblioteca.Service.LibroService;
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
@RequestMapping("/url/libro")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class LibroRegistrarController {

    @Autowired
    private LibroService LibroService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Libro>> listaLibro(){
        List<Libro> lista = LibroService.listaLibro();
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<?> inserta(@RequestBody Libro obj){
        HashMap<String, Object> salida = new HashMap<>();

        obj.setFechaActualizacion(new Date());
        obj.setFechaRegistro(new Date());
        obj.setEstado(AppSettings.ACTIVO);

        DataCatalogo objDataCatalogo  = new DataCatalogo();
        objDataCatalogo.setIdDataCatalogo(27);
        obj.setEstadoPrestamo(objDataCatalogo);


        Libro objSalida = LibroService.insertaActualizaLibro(obj);
        if (objSalida == null) {
            salida.put("mensaje","Error en el registro");
        }else {
            salida.put("mensaje","Se registró la Ejemplo con el ID ==> " + objSalida.getIdLibro());
        }
        return ResponseEntity.ok(salida);
    }
    @GetMapping("/listaLibro")
    @ResponseBody
    public List<Libro> listaLibroT() {
        return LibroService.listaLibro();
    }
}