package hn.is501.proyecto.pinterest.services;

import hn.is501.proyecto.pinterest.entities.Mensajes;

public interface MensajeService {
    
     public Mensajes NuevoMensaje (int codigousuarioemisor, int codigousuarioreceptor, Mensajes mensaje);
}
