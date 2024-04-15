package hn.is501.proyecto.pinterest.entities;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
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
    private int CodigoPin;

    @ManyToOne
    @JoinColumn(name = "codigousuariocreadorpin", referencedColumnName = "codigousuario")
    private Usuarios usuarioPin;

    @Column(name = "nombrepin")
    private String NombrePin;

    @Column(name = "fechacreacionpin")
    private LocalDate FechaCreacionPin;

    @Lob
    @Column(name="pin")
    private byte[] Pin;

    @Column(name = "dimensionespin")
    private String DimensionesPin;

    @ManyToOne
    @JoinColumn(name = "codigoestadopin", referencedColumnName = "codigoestadopin")
    private EstadoPin estadoPin;

    @JsonBackReference
    @ManyToMany(mappedBy = "pinesEnTablero")
    private List<Tableros> tablerosPin;

    @OneToMany(mappedBy = "pinComentado")
    private List<Comentarios> comentariosPin;
}
