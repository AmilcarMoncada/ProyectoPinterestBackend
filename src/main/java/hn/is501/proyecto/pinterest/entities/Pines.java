package hn.is501.proyecto.pinterest.entities;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name="TBL_PINES")
public class Pines {
    
    @Id
    @Column(name = "codigopin")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int CodigoPin;

     //@JsonBackReference("upin")
    @ManyToOne
    @JoinColumn(name = "codigousuariocreadorpin", referencedColumnName = "codigousuario")
    private Usuarios usuarioPin;

    @Column(name = "nombrepin")
    private String NombrePin;

    @Column(name = "fechacreacionpin")
    private LocalDate FechaCreacionPin;

    @Column(name="pin")
    private String Pin;

    @Column(name = "dimensionespin")
    private String DimensionesPin;

    @ManyToOne
    @JsonBackReference("pinest")
    @JoinColumn(name = "codigoestadopin", referencedColumnName = "codigoestadopin")
    private EstadoPin estadoPin;

    @JsonBackReference("tabpin")
    @ManyToMany(mappedBy = "pinesEnTablero")
    private List<Tableros> tablerosPin;

    @JsonBackReference("compin")
    @OneToMany(mappedBy = "pinComentado")
    private List<Comentarios> comentariosPin;
}
