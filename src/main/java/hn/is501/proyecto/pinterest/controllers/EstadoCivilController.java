package hn.is501.proyecto.pinterest.controllers;

import org.springframework.web.bind.annotation.RestController;

import hn.is501.proyecto.pinterest.entities.EstadoCivil;
import hn.is501.proyecto.pinterest.services.implementations.EstadoCivilServiceImpl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api")
public class EstadoCivilController {
    
@Autowired
private EstadoCivilServiceImpl estadoCivilServiceImpl;

    @PostMapping("/estadocivil/crear")
    public EstadoCivil CrearEstadoCivil(@RequestBody EstadoCivil estadoCivil){
        return this.estadoCivilServiceImpl.CrearEstadoCivil(estadoCivil);
    }
    
}
