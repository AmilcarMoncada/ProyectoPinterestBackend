package hn.is501.proyecto.pinterest.controllers;

import org.springframework.web.bind.annotation.RestController;

import hn.is501.proyecto.pinterest.entities.Mensajes;
import hn.is501.proyecto.pinterest.services.implementations.MensajeServiceImpl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/pinterest")
public class MensajeController {
    @Autowired
    private MensajeServiceImpl mensajeServiceImpl;

    @PostMapping("/mensaje/nuevo")
    public Mensajes nuevoMensaje(@RequestBody Mensajes mensaje,
                                 @RequestParam int codigousuarioemisor,
                                 @RequestParam int codigousuarioreceptor) {
        return this.mensajeServiceImpl.NuevoMensaje(codigousuarioemisor, codigousuarioreceptor, mensaje);
    }
    
}
