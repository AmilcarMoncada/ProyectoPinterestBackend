package hn.is501.proyecto.pinterest.services.implementations;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.is501.proyecto.pinterest.entities.Comentarios;
import hn.is501.proyecto.pinterest.entities.Pines;
import hn.is501.proyecto.pinterest.entities.Usuarios;
import hn.is501.proyecto.pinterest.repositories.ComentariosRepository;
import hn.is501.proyecto.pinterest.repositories.PinesRepository;
import hn.is501.proyecto.pinterest.repositories.TablerosRepository;
import hn.is501.proyecto.pinterest.repositories.UsuariosRepository;
import hn.is501.proyecto.pinterest.services.ComentarioService;

@Service
public class ComentarioServiceImpl implements ComentarioService{

    @Autowired
private UsuariosRepository usuariosRepository;

@Autowired
private PinesRepository pinesRepository;

@Autowired
private TablerosRepository tablerosRepository;

@Autowired
private ComentariosRepository comentariosRepository;


    @Override
    public Comentarios NuevoComentario(int codigousuarioemisor, int codigopincomentado, Comentarios comentario) {
       Usuarios usuariocomentario = usuariosRepository.findById(codigousuarioemisor).get();
       Pines pincomentado = pinesRepository.findById(codigopincomentado).get();
       comentario.setPinComentado(pincomentado);
       comentario.setUsuarioEmisorComentario(usuariocomentario);
       comentario.setFechayHoraComentario(LocalDate.now());
       List <Comentarios> comentariospin = pincomentado.getComentariosPin();
       if (comentariospin==null){
        comentario.setComentarioAnterior(null);
       }else{
        comentario.setComentarioAnterior(comentariospin.get(comentariospin.size() - 1));
       }
    Comentarios comentarioguardado = comentariosRepository.save(comentario);
    comentariospin.add(comentario);
    pincomentado.setComentariosPin(comentariospin);
    pinesRepository.save(pincomentado);
    List <Comentarios> comentariosusuario = usuariocomentario.getComentariosUsuario();
    if (comentariosusuario==null){
        comentariosusuario.add(comentario);
    usuariocomentario.setComentariosUsuario(comentariosusuario);
       }else{
        usuariocomentario.getComentariosUsuario().add(comentario);
       }
       usuariosRepository.save(usuariocomentario);
       return comentarioguardado;
    }
    
}
