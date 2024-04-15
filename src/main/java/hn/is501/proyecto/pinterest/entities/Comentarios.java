package hn.is501.proyecto.pinterest.entities;

import java.time.LocalDate;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
    private int CodigoComentario;
    
    @ManyToOne
    @JoinColumn(name = "codigopincomentado", referencedColumnName = "codigopin")
    private Pines pinComentado;

    @ManyToOne
    @JoinColumn(name = "codigocomentarioanterior", referencedColumnName = "codigocomentario")
    private Comentarios comentarioAnterior;

    @Column(name = "comentario")
    private String Comentario;

    @Column(name = "fechayhoracomentario")
    private LocalDate FechayHoraComentario;

    @ManyToOne
    @JoinColumn(name = "codigousuarioemisorcomentario", referencedColumnName = "codigousuario")
    private Usuarios usuarioEmisorComentario;

}
