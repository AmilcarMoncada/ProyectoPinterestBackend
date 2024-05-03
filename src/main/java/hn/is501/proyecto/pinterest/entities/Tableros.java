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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="TBL_TABLEROS")
public class Tableros {
    
    @Id
    @Column(name="codigotablero")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int CodigoTablero;

    @Column(name="nombretablero")
    private String NombreTablero;

    @Column(name="fechacreaciontablero")
    private LocalDate FechaCreacionTablero;

    @Column(name="fotopresentaciontablero")
    private String FotoPresentacionTablero;

    //@JsonManagedReference("utab")
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "codigousuariocreadortablero", referencedColumnName = "codigousuario")
    private Usuarios usuarioCreadorTablero;

     //@JsonManagedReference("pertab")
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="codigotableromostradoenperfil", referencedColumnName = "codigoperfil")
    private Perfiles PerfilTablero;

    @ManyToMany
    @JsonManagedReference("tabpin")
    @JoinTable(name="TBL_TABLEROSXPINES",
    joinColumns = @JoinColumn(name="codigotablerodelpin"),
    inverseJoinColumns = @JoinColumn(name="codigopinentablero"))
    private List<Pines> pinesEnTablero;

    
}
