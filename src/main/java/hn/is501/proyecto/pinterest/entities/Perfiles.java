package hn.is501.proyecto.pinterest.entities;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="TBL_PERFILES")
public class Perfiles {
    
    @Id
    @Column(name="codigoperfil")
    private int CodigoPerfil;

    @OneToOne
    @JoinColumn(name="codigousuariodelperfil", referencedColumnName = "codigousuario")
    private Usuarios usuarioPerfil;

    @ManyToOne
    @JoinColumn(name="codigotipoperfil", referencedColumnName = "codigotipoperfil")
    private TipoPerfil tipoPerfil;

    @Lob
    @Column(name="fotoperfil")
    private byte[] FotoPerfil;

    @Column(name="pasatiempos")
    private String Pasatiempos;

    @Column(name="ultimaconexion")
    private LocalDate UltimaConexion;

    @OneToOne(mappedBy = "PerfilTablero")
    private Tableros TableroMostrado;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="TBL_BUSQUEDAXPERFIL",
    joinColumns = @JoinColumn(name="codigoperfilbuscado"),
    inverseJoinColumns = @JoinColumn(name="codigobusqueda"))
    private List<Busquedas> BusquedaRealizadas;

}
