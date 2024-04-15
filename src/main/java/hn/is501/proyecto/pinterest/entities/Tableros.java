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

@Entity
@Data
@Table(name="TBL_TABLEROS")
public class Tableros {
    
    @Id
    @Column(name="codigotablero")
    private int CodigoTablero;

    @Column(name="nombretablero")
    private String NombreTablero;

    @Column(name="fechacreaciontablero")
    private LocalDate FechaCreacionTablero;

    @Lob
    @Column(name="fotopresentaciontablero")
    private byte[] FotoPresentacionTablero;

    @ManyToOne
    @JoinColumn(name = "codigousuariocreadortablero", referencedColumnName = "codigousuario")
    private Usuarios usuarioCreadorTablero;

    @OneToOne
    @JoinColumn(name="codigotableromostradoenperfil", referencedColumnName = "codigoperfil")
    private Perfiles PerfilTablero;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="TBL_TABLEROSXPINES",
    joinColumns = @JoinColumn(name="codigotablerodelpin"),
    inverseJoinColumns = @JoinColumn(name="codigopinentablero"))
    private List<Pines> pinesEnTablero;
}
