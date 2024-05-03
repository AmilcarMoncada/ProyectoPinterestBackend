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
@Table(name="TBL_TRABAJOS")
public class Trabajos {
    
    @Id
    @Column(name="codigotrabajo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int CodigoTrabajo;

    @Column(name="nombretrabajo")
    private String NombreTrabajo;

    @Column(name="descripciontrabajo")
    private String DescripcionTrabajo;

    @JsonManagedReference("utrabajoanc")
    @OneToMany(mappedBy = "trabajoActual")
    private List<Usuarios> trabajoActualUsuarios;

      @JsonManagedReference("utrabajoant")
    @OneToMany(mappedBy = "trabajoAnterior")
    private List<Usuarios> trabajoAnteriorUsuarios;

}
