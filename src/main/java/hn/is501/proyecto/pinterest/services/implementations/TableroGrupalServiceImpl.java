package hn.is501.proyecto.pinterest.services.implementations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.is501.proyecto.pinterest.entities.Perfiles;
import hn.is501.proyecto.pinterest.entities.Tableros;
import hn.is501.proyecto.pinterest.entities.TablerosGrupales;
import hn.is501.proyecto.pinterest.entities.Usuarios;
import hn.is501.proyecto.pinterest.repositories.TablerosGrupalesRepository;
import hn.is501.proyecto.pinterest.repositories.TablerosRepository;
import hn.is501.proyecto.pinterest.repositories.UsuariosRepository;
import hn.is501.proyecto.pinterest.services.TableroGrupalService;

@Service
public class TableroGrupalServiceImpl implements TableroGrupalService{

@Autowired
private UsuariosRepository usuariosRepository;

@Autowired
private TablerosRepository tablerosRepository;

@Autowired
private TablerosGrupalesRepository tablerosGrupalesRepository;


    @Override
    public Perfiles NuevoTableroGrupal(int codigousuario, int codigotablero) {
    Tableros tablero = tablerosRepository.findById(codigotablero).get();
    Usuarios usuario = usuariosRepository.findById(codigousuario).get();

    TablerosGrupales nuevotablerogrupal = new TablerosGrupales();
    nuevotablerogrupal.setTableroAnidado(tablero);
    nuevotablerogrupal.setUsuarioTableroGrupal(usuario);
    nuevotablerogrupal.setNombreTableroGrupal(tablero.getNombreTablero());
    tablerosGrupalesRepository.save(nuevotablerogrupal);
    return usuario.getPerfilUsuario();
}
    
}
