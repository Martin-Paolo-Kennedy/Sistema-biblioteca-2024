package com.sistema.biblioteca.Controller;

import java.util.List;

import com.sistema.biblioteca.Entity.Alumno;
import com.sistema.biblioteca.Entity.DataCatalogo;
import com.sistema.biblioteca.Entity.Pais;
import com.sistema.biblioteca.Service.AlumnoService;
import com.sistema.biblioteca.Service.DataCatalogoService;
import com.sistema.biblioteca.Service.PaisService;
import com.sistema.biblioteca.Util.AppSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/url/util")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class UtilController {

    @Autowired
    private PaisService paisService;

    @Autowired
    private DataCatalogoService dataCatalogoService;

    @Autowired
    private AlumnoService alumnoService;


    @GetMapping("/listaPais")
    @ResponseBody
    public List<Pais> listaPais() {
        return paisService.listaTodos();
    }

    @GetMapping("/listaAlumno")
    @ResponseBody
    public List<Alumno> listaAlumno() {
        return alumnoService.listaTodos();
    }


    @GetMapping("/listaCategoriaDeLibro")
    @ResponseBody
    public List<DataCatalogo> listaCategoriaDeLibro() {
        return dataCatalogoService.listaDataCatalogo(AppSettings.CATALOGO_01_CATEGORIA_DE_LIBRO);
    }

    @GetMapping("/listaTipoProveedor")
    @ResponseBody
    public List<DataCatalogo> listaTipoProveedor() {
        return dataCatalogoService.listaDataCatalogo(AppSettings.CATALOGO_02_TIPO_DE_PROVEEDOR);
    }

    @GetMapping("/listaModalidadAlumno")
    @ResponseBody
    public List<DataCatalogo> listaModalidadAlumno() {
        return dataCatalogoService.listaDataCatalogo(AppSettings.CATALOGO_03_MODALIDAD_DE_ALUMNO);
    }

    @GetMapping("/listaGradoAutor")
    @ResponseBody
    public List<DataCatalogo> listaGradoAutor() {
        return dataCatalogoService.listaDataCatalogo(AppSettings.CATALOGO_04_GRADO_DE_AUTOR);
    }

    @GetMapping("/listaTipoLibroRevista")
    @ResponseBody
    public List<DataCatalogo> listaTipoLibroRevista() {
        return dataCatalogoService.listaDataCatalogo(AppSettings.CATALOGO_05_TIPO_DE_LIBRO_Y_REVISTA);
    }

    @GetMapping("/listaTipoSala")
    @ResponseBody
    public List<DataCatalogo> listaTipoSala() {
        return dataCatalogoService.listaDataCatalogo(AppSettings.CATALOGO_06_TIPO_DE_SALA);
    }

    @GetMapping("/listaSede")
    @ResponseBody
    public List<DataCatalogo> listaSede() {
        return dataCatalogoService.listaDataCatalogo(AppSettings.CATALOGO_07_SEDE);
    }

    @GetMapping("/listaEstadoLibro")
    @ResponseBody
    public List<DataCatalogo> listaEstadoLibro() {
        return dataCatalogoService.listaDataCatalogo(AppSettings.CATALOGO_08_ESTADO_DE_LIBRO);
    }
}