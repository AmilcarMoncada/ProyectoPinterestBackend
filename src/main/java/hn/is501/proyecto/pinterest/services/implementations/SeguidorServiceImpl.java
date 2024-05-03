package hn.is501.proyecto.pinterest.services.implementations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.is501.proyecto.pinterest.entities.Pines;
import hn.is501.proyecto.pinterest.entities.Seguidores;
import hn.is501.proyecto.pinterest.entities.TablerosGrupales;
import hn.is501.proyecto.pinterest.entities.Usuarios;
import hn.is501.proyecto.pinterest.repositories.PinesRepository;
import hn.is501.proyecto.pinterest.repositories.SeguidoresRepository;
import hn.is501.proyecto.pinterest.repositories.TablerosRepository;
import hn.is501.proyecto.pinterest.repositories.UsuariosRepository;
import hn.is501.proyecto.pinterest.services.SeguidorService;

@Service
public class SeguidorServiceImpl implements SeguidorService{

    @Autowired
private UsuariosRepository usuariosRepository;

@Autowired
private SeguidoresRepository seguidoresRepository;

    @Override
    public String NuevoSeguidor(int codigousuarioseguido, int codigousuarioseguidor) {
   Usuarios usuarioseguido = usuariosRepository.findById(codigousuarioseguido).get();
   Usuarios usuarioseguidor = usuariosRepository.findById(codigousuarioseguidor).get();
   Seguidores seguidor = new Seguidores();
   seguidor.setUsuarioSeguido(usuarioseguido);
   seguidor.setUsuarioSeguidor(usuarioseguidor);
   seguidor.setFechaComienzoSeguir(LocalDate.now());
   seguidoresRepository.save(seguidor);
    List<Seguidores> seguidores = new ArrayList<>();
    seguidores= usuarioseguido.getUsuariosSeguidores();
    if (seguidores==null){
        seguidores.add(seguidor);
        usuarioseguido.setUsuariosSeguidores(seguidores);
    }else{
        usuarioseguido.getUsuariosSeguidores().add(seguidor);
    }

    List<Seguidores> seguidos = new ArrayList<>();
    seguidos= usuarioseguidor.getUsuariosSeguidos();
    if (seguidos==null){
        seguidos.add(seguidor);
        usuarioseguidor.setUsuariosSeguidos(seguidos);
    }else{
        usuarioseguidor.getUsuariosSeguidos().add(seguidor);
    }
    usuariosRepository.save(usuarioseguido);
    usuariosRepository.save(usuarioseguidor);
    return "Comenzaste a seguir a "+usuarioseguido.getNombres();
    }


    @Override
    public String EliminarSeguidor(int codigoseguidor) {
        Seguidores seguidor = seguidoresRepository.findById(codigoseguidor).get();
        seguidoresRepository.delete(seguidor);
        return "Ya no tienes este seguidor";
    }
    
}
