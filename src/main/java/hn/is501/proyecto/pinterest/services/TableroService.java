package hn.is501.proyecto.pinterest.services;

import java.util.List;

import hn.is501.proyecto.pinterest.entities.Perfiles;
import hn.is501.proyecto.pinterest.entities.Pines;
import hn.is501.proyecto.pinterest.entities.Tableros;


public interface TableroService {
    
    public Perfiles CrearTablero (int codigousuario, Tableros tablero);

    public Perfiles EliminarTablero (int codigousuario, int codigotablero);

    public Tableros MostrarTablero (int codigotablero);

    public Tableros AgregarPinTablero (int codigopin, int codigotablero);

    public List<Tableros> tablerosCreadosPorUsuario(int codigousuario);

    public List<Pines> pinesdetablero(int codigotablero);
}
