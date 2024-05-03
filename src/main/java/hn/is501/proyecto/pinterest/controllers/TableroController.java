package hn.is501.proyecto.pinterest.controllers;

import org.springframework.web.bind.annotation.RestController;

import hn.is501.proyecto.pinterest.entities.Perfiles;
import hn.is501.proyecto.pinterest.entities.Pines;
import hn.is501.proyecto.pinterest.entities.Tableros;
import hn.is501.proyecto.pinterest.services.implementations.TableroServiceImpl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;





@RestController
@RequestMapping("/pinterest")
public class TableroController {
    
    @Autowired
    private TableroServiceImpl tableroServiceImpl;

    @PostMapping("/tablero/nuevo")
    public Perfiles CrearTablero (@RequestParam int codigousuario,@RequestBody Tableros tablero){
        return this.tableroServiceImpl.CrearTablero(codigousuario, tablero);
    }
    
    @DeleteMapping("/tablero/eliminar")
    public Perfiles EliminarTablero (@RequestParam int codigousuario,
                                     @RequestParam int codigotablero){
        return this.tableroServiceImpl.EliminarTablero(codigousuario, codigotablero);
    }

    @GetMapping("/tablero/mostrar")
    public  Tableros MostrarTablero (@RequestParam int codigotablero) {
        return this.tableroServiceImpl.MostrarTablero(codigotablero);
    }

    @PutMapping("/tablero/agregarpin")
    public Tableros AgregarPinTablero (@RequestParam int codigopin,@RequestParam int codigotablero) {        
        return this.tableroServiceImpl.AgregarPinTablero(codigopin, codigotablero);
    }
    
      @GetMapping("/tablero/usuario/{codigousuario}")
    public List<Tableros> mostrarTablerosPorUsuario(@PathVariable int codigousuario) {
    return this.tableroServiceImpl.tablerosCreadosPorUsuario(codigousuario);
    }

    @GetMapping("/tablero/pines/{codigotablero}")
    public List<Pines> mostrarpinTableros(@PathVariable int codigotablero) {
    return this.tableroServiceImpl.pinesdetablero(codigotablero);
    }
    
}
