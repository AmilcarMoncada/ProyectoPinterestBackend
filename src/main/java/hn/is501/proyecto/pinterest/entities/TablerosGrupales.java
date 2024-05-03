package hn.is501.proyecto.pinterest.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "TBL_TABLEROSGRUPALES")
public class TablerosGrupales {
    
    @Id
    @Column(name="codigotablerogrupal")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int CodigoTableroGrupal;

    @Column(name="nombretablerogrupal")
    private String NombreTableroGrupal;

    @OneToOne
    @JoinColumn(name ="codigotableroanidado", referencedColumnName = "codigotablero")
    private Tableros tableroAnidado;

    @ManyToOne
    @JoinColumn(name = "codigousuariocreador", referencedColumnName = "codigousuario")
    private Usuarios usuarioTableroGrupal;
    
}
