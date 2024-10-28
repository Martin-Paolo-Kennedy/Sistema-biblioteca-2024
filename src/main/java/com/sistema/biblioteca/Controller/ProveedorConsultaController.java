package com.sistema.biblioteca.Controller;
import java.util.List;

import com.sistema.biblioteca.Entity.Proveedor;
import com.sistema.biblioteca.Service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/url/consultaProveedor")
@CrossOrigin(origins = "http://localhost:4200")
public class ProveedorConsultaController {
    @Autowired
    private ProveedorService service;

    @GetMapping("/consultaProveedorPorParametros")
    @ResponseBody
    public List<Proveedor> listaConsultaProveedor(
            @RequestParam(name = "razonsocial" , required = false, defaultValue = "") String razonsocial,
            @RequestParam(name = "celular" , required = false, defaultValue = "") String celular,
            @RequestParam(name = "estado" , required = true, defaultValue = "1") int estado,
            @RequestParam(name = "idTipoProveedor" , required = false, defaultValue = "-1") int idTipoProveedor){

        List<Proveedor> lstSalida = service.listaConsultaDinamica("%"+ razonsocial + "%", celular , estado, idTipoProveedor);

        return lstSalida;
    }
}