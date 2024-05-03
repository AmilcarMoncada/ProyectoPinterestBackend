package hn.is501.proyecto.pinterest.entities;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name="TBL_SEGUIDORES")
public class Seguidores {
    
    @Id
    @Column(name="codigoseguidor")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int CodigoSeguidor;

    @Column(name="fechacomienzoseguir")
    private LocalDate FechaComienzoSeguir;

    @ManyToOne
    @JsonManagedReference("useguidos")
    @JoinColumn(name = "codigousuarioseguido", referencedColumnName = "codigousuario")
    private Usuarios usuarioSeguido;

    @ManyToOne
    @JsonManagedReference("useguidor")
    @JoinColumn(name = "codigousuarioseguidor", referencedColumnName = "codigousuario")
    private Usuarios usuarioSeguidor;
}
