package hn.is501.proyecto.pinterest.services.implementations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.is501.proyecto.pinterest.entities.Perfiles;
import hn.is501.proyecto.pinterest.entities.Pines;
import hn.is501.proyecto.pinterest.entities.Tableros;
import hn.is501.proyecto.pinterest.entities.Usuarios;
import hn.is501.proyecto.pinterest.repositories.PinesRepository;
import hn.is501.proyecto.pinterest.repositories.TablerosRepository;
import hn.is501.proyecto.pinterest.repositories.UsuariosRepository;
import hn.is501.proyecto.pinterest.services.TableroService;

@Service
public class TableroServiceImpl implements TableroService {

    @Autowired
private UsuariosRepository usuariosRepository;

@Autowired
private PinesRepository pinesRepository;

@Autowired
private TablerosRepository tablerosRepository;



    @Override
    public Perfiles CrearTablero(int codigousuario, Tableros tablero) {
        Usuarios usuario = usuariosRepository.findById(codigousuario).get();
        tablero.setUsuarioCreadorTablero(usuario);
        tablero.setPerfilTablero(usuario.getPerfilUsuario());
        tablero.setFechaCreacionTablero(LocalDate.now());
        tablerosRepository.save(tablero);
         if( usuario.getTablerosCreados() ==null){
        List<Tableros> tableros = new ArrayList<>();
            tableros.add(tablero);
            usuario.setTablerosCreados(tableros);
        }else{
        usuario.getTablerosCreados().add(tablero);
    }
        usuariosRepository.save(usuario);
        return usuario.getPerfilUsuario();
    }

    @Override
    public Perfiles EliminarTablero(int codigousuario, int codigotablero) {
        Usuarios usuario = usuariosRepository.findById(codigousuario).get();
        Tableros tablero = tablerosRepository.findById(codigotablero).get();
        List<Tableros> tableros = new ArrayList<>();
        tableros = usuario.getTablerosCreados();
        for (int i=0;tableros.size()>=i;i++) {
            if (codigotablero==tableros.get(i).getCodigoTablero()) {
                tableros.remove(i);
            }
        }
        usuario.setTablerosCreados(tableros);
        tablerosRepository.delete(tablero);
        usuariosRepository.save(usuario);
        return usuario.getPerfilUsuario();
    }

    @Override
    public Tableros MostrarTablero(int codigotablero) {
       return this.tablerosRepository.findById(codigotablero).get();
    }

    @Override
    public Tableros AgregarPinTablero(int codigopin, int codigotablero) {
        Tableros tablero = tablerosRepository.findById(codigotablero).get();
        Pines pin = pinesRepository.findById(codigopin).get();
        List<Pines> pines = new ArrayList<>();
        pines = tablero.getPinesEnTablero();
        List<Tableros> tableros = new ArrayList<>();
        tableros = pin.getTablerosPin();
        if (pines != null ){
        for (int i=0;pines.size()>=i;i++) {
            if (codigopin==pines.get(i).getCodigoPin()) {
                return null;
            }
        }
    }
        if (pines == null ){
            pines.add(pin);
         tablero.setPinesEnTablero(pines);
            tableros.add(tablero);
            pin.setTablerosPin(tableros);
        }else{
        tablero.getPinesEnTablero().add(pin);
        }
        if (tableros == null){
            tableros.add(tablero);
            pin.setTablerosPin(tableros);
        }else{
            pin.getTablerosPin().add(tablero);
        }
        pinesRepository.save(pin);
        tablerosRepository.save(tablero);
        return this.tablerosRepository.save(tablero);
    }

    @Override
    public List<Tableros> tablerosCreadosPorUsuario(int codigousuario) {
        Usuarios usuariocreador = usuariosRepository.findById(codigousuario).get();
        List<Tableros> tablerosCreados = usuariocreador.getTablerosCreados();
        return tablerosCreados;
    }

    @Override
    public List<Pines> pinesdetablero(int codigotablero) {
        Tableros tablerospin = tablerosRepository.findById(codigotablero).get();
        List<Pines> pinestablero = tablerospin.getPinesEnTablero();
        return pinestablero;
    }
    

}
