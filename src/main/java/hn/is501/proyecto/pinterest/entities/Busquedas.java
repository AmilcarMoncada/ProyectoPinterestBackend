package hn.is501.proyecto.pinterest.entities;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="TBL_BUSQUEDAS")
public class Busquedas {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="codigobusqueda")
    private int CodigoBusqueda;

    @Column(name="fechabusqueda")
    private LocalDate FechaBusqueda;

    @ManyToOne
    @JsonManagedReference("ubusqueda")
    @JoinColumn(name = "codigousuariodebusqueda", referencedColumnName = "codigousuario")
    private Usuarios usuarioBusqueda;

    //@JsonManagedReference("ubus")
    @ManyToMany(mappedBy = "BusquedasRealizadas")
    private List<Usuarios> UsuariosBuscados;

    @ManyToMany(mappedBy = "BusquedaRealizadas")
    private List<Perfiles> PerfilesBuscados;
}
