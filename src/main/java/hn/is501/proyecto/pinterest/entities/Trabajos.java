package hn.is501.proyecto.pinterest.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="TBL_TRABAJOS")
public class Trabajos {
    
    @Id
    @Column(name="codigotrabajo")
    private int CodigoTrabajo;

    @Column(name="nombretrabajo")
    private String NombreTrabajo;

    @Column(name="descripciontrabajo")
    private String DescripcionTrabajo;

    @OneToMany(mappedBy = "trabajoActual")
    private List<Usuarios> trabajoActualUsuarios;

    @OneToMany(mappedBy = "trabajoAnterior")
    private List<Usuarios> trabajoAnteriorUsuarios;

}
