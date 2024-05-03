package hn.is501.proyecto.pinterest.services;

import hn.is501.proyecto.pinterest.entities.Perfiles;
import hn.is501.proyecto.pinterest.entities.Usuarios;

public interface UsuarioService {

    public Perfiles CrearUsuario(Usuarios Usuario);

    public Perfiles AutenticarUsuario(String nombres, String password);

    public Usuarios mostrarUsuario(int codigousuario);

    public Usuarios mostrarUsuariocorreo(String correo);
    

}
