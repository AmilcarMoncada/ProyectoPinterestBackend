package hn.is501.proyecto.pinterest.services.implementations;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.is501.proyecto.pinterest.entities.Perfiles;
import hn.is501.proyecto.pinterest.entities.Usuarios;
import hn.is501.proyecto.pinterest.repositories.PerfilesRepository;
import hn.is501.proyecto.pinterest.repositories.UsuariosRepository;
import hn.is501.proyecto.pinterest.services.UsuarioService;


@Service
public class UsuarioServiceImpl implements UsuarioService{

@Autowired
private UsuariosRepository usuariosRepository;

@Autowired
private PerfilesRepository perfilesRepository;

    @Override
    public Perfiles CrearUsuario(Usuarios Usuario) {
        Usuarios UsuarioExistente = usuariosRepository.findByCorreo(Usuario.getCorreo());
        if (UsuarioExistente != null) {
            // Si ya existe un Usuario con el mismo correo electrónico, lanza una
            // excepción.
            throw new IllegalArgumentException("El correo electrónico ya está registrado");
        }

        // Si el correo electrónico no está registrado, guardar el nuevo usuario y devuelve su respectivo perfil
        Usuario.setFechaCreacionCuenta(LocalDate.now());
        Usuarios usuarioGuardado= usuariosRepository.save(Usuario); 
        Perfiles perfilUsuario= new Perfiles();
        perfilUsuario.setUltimaConexion(LocalDate.now());
        perfilUsuario.setUsuarioPerfil(usuarioGuardado);
        return this.perfilesRepository.save(perfilUsuario);
    }

    @Override
    public Perfiles AutenticarUsuario(String nombres, String password) {
        // Buscar el Usuario por su correo electrónico
        Usuarios usuario = usuariosRepository.findByNombres(nombres);
        // Verificar si el Usuarios existe y si la contraseña es correcta
        if (usuario != null && password.equals(usuario.getPassword())) {
            // El Usuarios y la contraseña son válidos
            // Devolveremos su respectivo perfil
            int codigoPerfil= usuario.getCodigousuario();
            Perfiles perfilUsuario= perfilesRepository.findById(codigoPerfil).get();
            perfilUsuario.setUltimaConexion(LocalDate.now());
            return this.perfilesRepository.save(perfilUsuario);
        }
        return null; // El Usuarios no existe o la contraseña es incorrecta
    }
    
    @Override
    public Usuarios mostrarUsuario(int codigousuario) {
        return this.usuariosRepository.findById(codigousuario).get();
    }

    @Override
    public Usuarios mostrarUsuariocorreo(String nombres) {
        return this.usuariosRepository.findByNombres(nombres);
    }
}
