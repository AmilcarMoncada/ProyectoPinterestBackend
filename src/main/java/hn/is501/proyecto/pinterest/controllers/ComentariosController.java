package hn.is501.proyecto.pinterest.controllers;

import org.springframework.web.bind.annotation.RestController;

import hn.is501.proyecto.pinterest.entities.Comentarios;
import hn.is501.proyecto.pinterest.services.implementations.ComentarioServiceImpl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/pinterest")
public class ComentariosController {
    
@Autowired
private ComentarioServiceImpl comentarioServiceImpl;

    @PostMapping("/comentario/nuevo")
    public Comentarios nuevoComentario(@RequestBody Comentarios comentarios,
                                       @RequestParam int codigousuarioemisor,
                                       @RequestParam int codigopincomentado ) {
        return this.comentarioServiceImpl.NuevoComentario(codigousuarioemisor, codigopincomentado, comentarios);
    }
    
}
