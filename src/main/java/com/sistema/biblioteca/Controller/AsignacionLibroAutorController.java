package com.sistema.biblioteca.Controller;

import java.util.List;

import com.sistema.biblioteca.Entity.Autor;
import com.sistema.biblioteca.Entity.Libro;
import com.sistema.biblioteca.Entity.LibroHasAutor;
import com.sistema.biblioteca.Service.AsignacionLibroAutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/url/asignacionLibAut")
@CrossOrigin(origins = "http://localhost:4200")
public class AsignacionLibroAutorController {

    @Autowired
    private AsignacionLibroAutorService libAuService;

    @GetMapping("/libros")
    @ResponseBody
    public List<Libro> obtenerLibros() {
        return libAuService.obtenerLibro();
    }

    @GetMapping("/autores")
    @ResponseBody
    public List<Autor> obtenerAutor() {
        return libAuService.obtenerAutor();
    }

    @GetMapping("/asignacion")
    @ResponseBody
    public List<LibroHasAutor> obtenerAsignaciones() {
        return libAuService.obtenerAsignacion();
    }

    @PostMapping("/agregarAsignacion")
    @ResponseBody
    public void agregarAsignacion(@RequestParam int idLibro, @RequestParam int idAutor) {
        libAuService.agregarAsignacion(idLibro, idAutor);
    }

    @DeleteMapping("/asignacione/{idLibro}/{idAutor}")
    @ResponseBody
    public void eliminarAsignacion(@PathVariable int idLibro, @PathVariable int idAutor) {
        libAuService.eliminarAsignacion(idLibro, idAutor);
    }
}