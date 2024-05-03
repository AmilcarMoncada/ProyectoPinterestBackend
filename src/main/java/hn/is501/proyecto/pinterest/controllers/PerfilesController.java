package hn.is501.proyecto.pinterest.controllers;

import org.springframework.web.bind.annotation.RestController;

import hn.is501.proyecto.pinterest.entities.Perfiles;
import hn.is501.proyecto.pinterest.services.implementations.PerfilesServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/pinterest")
public class PerfilesController {
    
    @Autowired
    private PerfilesServiceImpl perfilesServiceImpl;

      @GetMapping("/todosperfiles")
    public List<Perfiles> MostrarPines() {
        return this.perfilesServiceImpl.mostrarPerfiles();
    }
    
}
