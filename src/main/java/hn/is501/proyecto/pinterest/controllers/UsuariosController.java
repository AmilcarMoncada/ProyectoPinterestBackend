package hn.is501.proyecto.pinterest.controllers;

import org.springframework.web.bind.annotation.RestController;

import hn.is501.proyecto.pinterest.entities.Perfiles;
import hn.is501.proyecto.pinterest.entities.Usuarios;
import hn.is501.proyecto.pinterest.services.implementations.UsuarioServiceImpl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/pinterest")
public class UsuariosController {
    
@Autowired
private UsuarioServiceImpl usuarioServiceImpl;

    @PostMapping("/usuario/crear")
    public Perfiles CrearUsuario(@RequestBody Usuarios Usuario) {
        return this.usuarioServiceImpl.CrearUsuario(Usuario);
    }

    @GetMapping("/usuario/autenticar/{nombres}")
    public Perfiles AutenticarUsuario(@PathVariable String nombres,@RequestParam String password) {
        return this.usuarioServiceImpl.AutenticarUsuario(nombres, password);
        }
    
        @GetMapping("/usuario/mostrar")
        public Usuarios mostrarUsuario(@RequestParam int codigousuario) {
            return this.usuarioServiceImpl.mostrarUsuario(codigousuario);
            }

            @GetMapping("/usuario/mostrarusuario")
            public Usuarios mostrarUsuariocorreo(@RequestParam String correo) {
                return this.usuarioServiceImpl.mostrarUsuariocorreo(correo);
                }
    
}
