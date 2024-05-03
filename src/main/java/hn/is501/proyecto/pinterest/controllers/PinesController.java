package hn.is501.proyecto.pinterest.controllers;

import org.springframework.web.bind.annotation.RestController;

import hn.is501.proyecto.pinterest.entities.Perfiles;
import hn.is501.proyecto.pinterest.entities.Pines;
import hn.is501.proyecto.pinterest.services.implementations.PinesServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/pinterest")
public class PinesController {
    
    @Autowired
    private PinesServiceImpl pinesServiceImpl;

    @PostMapping("/pines/nuevo")
    public Perfiles crearPin(@RequestBody Pines pin, 
                             @RequestParam int codigotablero,
                             @RequestParam int codigousuario) {
        return this.pinesServiceImpl.CrearPin( codigousuario ,pin, codigotablero);  
    }
    
    @DeleteMapping("/pines/eliminar")
    public Perfiles EliminarPin(@RequestParam int codigousuario,
                                @RequestParam int codigopin){
        return this.pinesServiceImpl.EliminarPin(codigousuario, codigopin);
    }

    @GetMapping("/pines/todos")
    public List<Pines> MostrarPines() {
        return this.pinesServiceImpl.MostrarPines();
    }

    @GetMapping("/pines/usuario/{codigousuario}")
    public List<Pines> mostrarPinesPorUsuario(@PathVariable int codigousuario) {
    return this.pinesServiceImpl.pinesCreadosPorUsuario(codigousuario);
    }
    
}
