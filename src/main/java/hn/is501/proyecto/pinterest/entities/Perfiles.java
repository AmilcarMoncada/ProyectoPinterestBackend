package hn.is501.proyecto.pinterest.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
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
}
