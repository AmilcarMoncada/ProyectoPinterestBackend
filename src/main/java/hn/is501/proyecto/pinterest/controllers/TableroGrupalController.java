package hn.is501.proyecto.pinterest.controllers;

import org.springframework.web.bind.annotation.RestController;

import hn.is501.proyecto.pinterest.entities.Perfiles;
import hn.is501.proyecto.pinterest.services.implementations.TableroGrupalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;




@RestController
@RequestMapping("/pinterest")
public class TableroGrupalController {
    
    @Autowired
    private TableroGrupalServiceImpl tablerogrupalServiceImpl;

    @PostMapping("/tablerogrupal/nuevo")
    public Perfiles NuevoTableroGrupal (@RequestParam int codigousuario, @RequestParam int codigotablero) {
        return this.tablerogrupalServiceImpl.NuevoTableroGrupal(codigousuario, codigotablero);
    }
    
}
