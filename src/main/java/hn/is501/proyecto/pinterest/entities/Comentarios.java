package hn.is501.proyecto.pinterest.entities;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="TBL_COMENTARIOS")
public class Comentarios {
    
    @Id
    @Column(name = "codigocomentario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int CodigoComentario;
    
    @ManyToOne
    //@JsonBackReference("compin")
    @JsonIgnore
    @JoinColumn(name = "codigopincomentado", referencedColumnName = "codigopin")
    private Pines pinComentado;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "codigocomentarioanterior", referencedColumnName = "codigocomentario")
    private Comentarios comentarioAnterior;

    @Column(name = "comentario")
    private String Comentario;

    @Column(name = "fechayhoracomentario")
    private LocalDate FechayHoraComentario;

    @ManyToOne
    //@JsonBackReference("ucon")
    @JsonIgnore
    @JoinColumn(name = "codigousuarioemisorcomentario", referencedColumnName = "codigousuario")
    private Usuarios usuarioEmisorComentario;

}
