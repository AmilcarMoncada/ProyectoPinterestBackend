package hn.is501.proyecto.pinterest.services.implementations;

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
import hn.is501.proyecto.pinterest.services.PinesService;

@Service
public class PinesServiceImpl implements PinesService{

@Autowired
private UsuariosRepository usuariosRepository;

@Autowired
private PinesRepository pinesRepository;

@Autowired
private TablerosRepository tablerosRepository;


    @Override
    public Perfiles CrearPin(int codigousuario, Pines pin, int codigotablero) {
       Usuarios usuarioPin = usuariosRepository.findById(codigousuario).get();
       Tableros tableroPin = tablerosRepository.findById(codigotablero).get();
       /*List<Tableros> tableros = new ArrayList<>();
       tableros = usuarioPin.getTablerosCreados();
       Boolean condicionTablero = false;
       Vemos si el tablero mandado es del usuario
       for (Tableros tableros2 : tableros) {
        if (tableros2.getCodigoTablero()==tableroPin.getCodigoTablero()) {
            condicionTablero=true;
        }
       }
*/
       if (usuarioPin != null && tableroPin != null /*&& condicionTablero==true*/){
        pin.setUsuarioPin(usuarioPin);
        List<Tableros> tableros = new ArrayList<>();
        tableros.add(tableroPin);
        pin.setTablerosPin(tableros);
        Pines nuevoPin = pinesRepository.save(pin);
        List<Pines> pines = new ArrayList<>();
        pines.add(nuevoPin);
        //Se cumplira el if si el usuario o el tablero no a creado ningun pin
        if( usuarioPin.getPinesCreados() ==null){
            usuarioPin.setPinesCreados(pines);
        }else{
            usuarioPin.getPinesCreados().add(nuevoPin);
        }
        if(tableroPin.getPinesEnTablero()==null){
                tableroPin.setPinesEnTablero(pines);
            }else{
                tableroPin.getPinesEnTablero().add(nuevoPin);
            }
        this.usuariosRepository.save(usuarioPin);
        this.pinesRepository.save(nuevoPin);
        return usuarioPin.getPerfilUsuario();
       }
    return null;
    }

    @Override
    public Perfiles EliminarPin(int codigousuario, int codigopin) {
        Usuarios usuarioPin = usuariosRepository.findById(codigousuario).get();
        Pines pin = pinesRepository.findById(codigopin).get();
        List<Pines> pines = new ArrayList<>();
        pines = usuarioPin.getPinesCreados();
        for (int i=0;pines.size()>=i;i++) {
            if (pin.getCodigoPin()==pines.get(i).getCodigoPin()) {
                pines.remove(i);
            }
        }
        usuarioPin.setPinesCreados(pines);
        pinesRepository.delete(pin);
        usuariosRepository.save(usuarioPin);
        return usuarioPin.getPerfilUsuario();
    }

    @Override
    public List<Pines> MostrarPines() {
    return (List<Pines>) this.pinesRepository.findAll();
    }

    @Override
    public List<Pines> pinesCreadosPorUsuario(int codigousuario) {
       Usuarios usuariocreador = usuariosRepository.findById(codigousuario).get();
       List<Pines> pinesCreados = usuariocreador.getPinesCreados();
       return pinesCreados;
    }
    
}
