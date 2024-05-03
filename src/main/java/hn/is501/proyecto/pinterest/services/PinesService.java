package hn.is501.proyecto.pinterest.services;

import java.util.List;

import hn.is501.proyecto.pinterest.entities.Perfiles;
import hn.is501.proyecto.pinterest.entities.Pines;

public interface PinesService {
    
    public Perfiles CrearPin(int codigousuario, Pines pin, int codigotablero);

    public Perfiles EliminarPin(int codigousuario, int codigopin);

    public List<Pines> MostrarPines();

    public List<Pines> pinesCreadosPorUsuario(int codigousuario);
}
