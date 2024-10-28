package com.sistema.biblioteca.Controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.sistema.biblioteca.Entity.Alumno;
import com.sistema.biblioteca.Service.AlumnoService;
import com.sistema.biblioteca.Util.AppSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/url/alumno")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class AlumnoRegistraController {

    @Autowired
    private AlumnoService AlumnoService;


	/*@GetMapping
	@ResponseBody
	public ResponseEntity<List<Alumno>> listaAlumno(){
		List<Alumno> lista = AlumnoService.listaTodos();
		return ResponseEntity.ok(lista);
	}*/

    @PostMapping
    @ResponseBody
    public ResponseEntity<?> inserta(@RequestBody Alumno obj){
        HashMap<String, Object> salida=new HashMap<>();

        obj.setFechaActualizacion(new Date());
        obj.setFechaRegistro(new Date());
        obj.setEstado(AppSettings.ACTIVO);

        Alumno objSalida=AlumnoService.InsertaAlumno(obj);
        if(objSalida == null) {
            salida.put("mensaje","Error en el registro");
        }else {
            salida.put("mensaje","Se registró el Alumno con el ID ==> " + objSalida.getIdAlumno());
        }

        return ResponseEntity.ok(salida);


    }

    //NECESARIO PARA RESERVA SALA
    @ResponseBody
    @GetMapping("/listaAlumno")
    public List<Alumno> listaAlumno(
            @RequestParam(name = "page", defaultValue = "0", required = false) int page,
            @RequestParam(name = "size", defaultValue = "5", required = false) int size) {
        Pageable paginacion = PageRequest.of(page, size);
        List<Alumno> lista = AlumnoService.listaAlumnos("%", paginacion);
        return lista;
    }

    @ResponseBody
    @GetMapping("/listaAlumno/{filtro}")
    public List<Alumno> listaAlumno(@PathVariable("filtro") String filtro,
                                    @RequestParam(name = "page", defaultValue = "0", required = false) int page,
                                    @RequestParam(name = "size", defaultValue = "5", required = false) int size) {
        Pageable paginacion = PageRequest.of(page, size);
        List<Alumno> lista = AlumnoService.listaAlumnos(filtro + "%", paginacion);
        return lista;
    }

}