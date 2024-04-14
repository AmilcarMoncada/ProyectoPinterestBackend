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
@Table(name="TBL_ESTADOCIVIL")
public class EstadoCivil {
    
    @Id
    @Column(name="codigoestadocivil")
    private int CodigoEstadoCivil;

    @Column(name="tipoestadocivil")
    private String TipoEstadoCivil;

    @OneToMany(mappedBy = "estadoCivilUsuario")
    private List<Usuarios> EstadoCivilUsuarios;

}
