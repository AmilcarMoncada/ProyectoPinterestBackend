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
@Table(name="TBL_MENSAJES")
public class Mensajes {
    
    @Id
    @Column(name="codigomensaje")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int CodigoMensaje;

   
    //@JsonBackReference("umenenv")
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "codigousuarioemisor", referencedColumnName = "codigousuario")
    private Usuarios usuarioEmisorMensaje;

    //@JsonBackReference("umenrec")
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "codigousuarioreceptor", referencedColumnName = "codigousuario")
    private Usuarios usuarioReceptorMensaje;

    @Column(name="mensaje")
    private String Mensaje;

    @Column(name="horamensajeenviado")
    private LocalDate HoraMensajeEnviado;

    @Column(name="horamensajerecibido")
    private LocalDate HoraMensajeRecibido;
    
    @Column(name="horamensajeleido")
    private LocalDate HoraMensajeLeido;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "codigomensajeanterior", referencedColumnName = "codigomensaje")
    private Mensajes mensajeAnterior;

}
