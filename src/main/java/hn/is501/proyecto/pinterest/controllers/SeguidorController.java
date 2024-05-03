package hn.is501.proyecto.pinterest.controllers;


import org.springframework.web.bind.annotation.RestController;

import hn.is501.proyecto.pinterest.services.implementations.SeguidorServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/pinterest")
public class SeguidorController {

    @Autowired
    private SeguidorServiceImpl seguidorServiceImpl;
    
    @PostMapping("/seguidores/nuevo")
    public String NuevoSeguidor (@RequestParam int codigousuarioseguido, 
                                @RequestParam int codigousuarioseguidor){
        return this.seguidorServiceImpl.NuevoSeguidor(codigousuarioseguido, codigousuarioseguidor);   
    }
 
    @DeleteMapping("/seguidores/eliminar")
    public String EliminarSeguidor (@RequestParam int codigoseguidor){
        return this.seguidorServiceImpl.EliminarSeguidor(codigoseguidor);
    }
}