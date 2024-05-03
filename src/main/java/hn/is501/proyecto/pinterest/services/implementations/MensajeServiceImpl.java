package hn.is501.proyecto.pinterest.services.implementations;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hn.is501.proyecto.pinterest.entities.Mensajes;
import hn.is501.proyecto.pinterest.entities.Usuarios;
import hn.is501.proyecto.pinterest.repositories.MensajesRepository;
import hn.is501.proyecto.pinterest.repositories.UsuariosRepository;
import hn.is501.proyecto.pinterest.services.MensajeService;

@Service
public class MensajeServiceImpl implements MensajeService{

@Autowired
private UsuariosRepository usuariosRepository;

@Autowired
private MensajesRepository mensajesRepository;

    @Override
    public Mensajes NuevoMensaje(int codigousuarioemisor, int codigousuarioreceptor, Mensajes mensaje) {
        Usuarios usuarioemisor = usuariosRepository.findById(codigousuarioemisor).get();
   Usuarios usuarioreceptor = usuariosRepository.findById(codigousuarioreceptor).get();
        mensaje.setUsuarioEmisorMensaje(usuarioemisor);
        mensaje.setUsuarioReceptorMensaje(usuarioreceptor);
        mensaje.setHoraMensajeEnviado(LocalDate.now());
        mensaje.setMensajeAnterior(null);
        List <Mensajes> mensajesemisor = usuarioemisor.getMensajesEnviados();
        List <Mensajes> mensajesreceptor = usuarioreceptor.getMensajesRecibidos();
        if(mensajesemisor!=null && mensajesreceptor!=null){
        for (int i=0;mensajesemisor.size()>=i;i++){
            for (int k=0;mensajesreceptor.size()>=k;k++){
            if (mensajesemisor.get(i)==mensajesreceptor.get(k)){
                mensaje.setMensajeAnterior(mensajesemisor.get(i));
            }
            }
        }
    }
    return mensajesRepository.save(mensaje);
    }
    
}
