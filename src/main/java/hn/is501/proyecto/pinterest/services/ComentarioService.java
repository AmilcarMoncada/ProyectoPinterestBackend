package hn.is501.proyecto.pinterest.services;

import hn.is501.proyecto.pinterest.entities.Comentarios;

public interface ComentarioService {
    
    public Comentarios NuevoComentario (int codigousuarioemisor, int codigopincomentado, Comentarios comentario);

}
