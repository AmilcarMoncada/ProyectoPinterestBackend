package hn.is501.proyecto.pinterest.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int CodigoEstadoCivil;

    @Column(name="tipoestadocivil")
    private String TipoEstadoCivil;

    @JsonManagedReference("uest")
    @OneToMany(mappedBy = "estadoCivilUsuario")
    private List<Usuarios> EstadoCivilUsuarios;

}
