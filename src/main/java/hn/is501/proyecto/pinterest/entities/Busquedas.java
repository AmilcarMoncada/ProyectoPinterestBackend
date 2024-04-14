package hn.is501.proyecto.pinterest.entities;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="TBL_BUSQUEDAS")
public class Busquedas {
    
    @Id
    @Column(name="codigobusqueda")
    private int CodigoBusqueda;

    @Column(name="fechabusqueda")
    private LocalDate FechaBusqueda;

    @ManyToOne
    @JoinColumn(name = "codigousuariodebusqueda", referencedColumnName = "codigousuario")
    private Usuarios usuarioBusqueda;

    @JsonBackReference
    @ManyToMany
    private List<Usuarios> UsuariosBuscados;
}
