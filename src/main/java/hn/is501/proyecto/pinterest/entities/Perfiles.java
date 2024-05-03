package hn.is501.proyecto.pinterest.entities;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="TBL_PERFILES")
public class Perfiles {
    
    @Id
    @Column(name="codigoperfil")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int CodigoPerfil;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name="codigousuariodelperfil", referencedColumnName = "codigousuario")
    private Usuarios usuarioPerfil;

    @ManyToOne
    @JsonBackReference("pertip")
    @JoinColumn(name="codigotipoperfil", referencedColumnName = "codigotipoperfil")
    private TipoPerfil tipoPerfil;

    @Column(name="fotoperfil")
    private String FotoPerfil;

    @Column(name="pasatiempos")
    private String Pasatiempos;

    @Column(name="ultimaconexion")
    private LocalDate UltimaConexion;

    //@JsonBackReference("pertab")
    @JsonIgnore
    @OneToMany(mappedBy = "PerfilTablero")
    private List<Tableros> TablerosMostrados;

    @ManyToMany
    @JsonIgnore
    @JoinTable(name="TBL_BUSQUEDAXPERFIL",
    joinColumns = @JoinColumn(name="codigoperfilbuscado"),
    inverseJoinColumns = @JoinColumn(name="codigobusqueda"))
    private List<Busquedas> BusquedaRealizadas;

}
