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
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;
import java.lang.String;

@Data
@Entity
@Table(name="TBL_USUARIOS")
public class Usuarios implements Serializable{
    
    @Id
    private int codigousuario;

    private String nombres;

    @Column(name="apellidos")
    private String Apellidos;

    private String correo;

    @Column(name="password")
    private String Password;

    @Column(name="fechanacimiento")
    private LocalDate FechaNacimiento;

    @ManyToOne
    @JsonBackReference("ulugnac")
    @JoinColumn(name = "codigolugarnacimiento", referencedColumnName = "codigolugar")
    private Lugares lugarNacimiento;

    @Column(name="fechacreacioncuenta")
    private LocalDate FechaCreacionCuenta;

    @ManyToOne
    @JsonBackReference("ulugdom")
    @JoinColumn(name = "codigolugardomicilio", referencedColumnName = "codigolugar")
    private Lugares lugarDomicilio;

    @ManyToOne
    @JsonBackReference("utrabajoact")
    @JoinColumn(name = "codigotrabajoactual", referencedColumnName = "codigotrabajo")
    private Trabajos trabajoActual;

    @ManyToOne
    @JsonBackReference("utrabajoant")
    @JoinColumn(name = "codigotrabajoanterior", referencedColumnName = "codigotrabajo")
    private Trabajos trabajoAnterior;

    @Column(name="genero")
    private String Genero;

    @ManyToOne
    @JsonBackReference("uest")
    @JoinColumn(name = "codigoestadocivil", referencedColumnName = "codigoestadocivil")
    private EstadoCivil estadoCivilUsuario;

    @JsonBackReference("useguidos")
    @OneToMany(mappedBy = "usuarioSeguido")
    private List<Seguidores> usuariosSeguidos;

    @JsonBackReference("useguidor")
    @OneToMany(mappedBy = "usuarioSeguidor")
    private List<Seguidores> usuariosSeguidores;

    //@JsonbACKReference("ubus")
    @ManyToMany
    @JsonIgnore
    @JoinTable(name="TBL_BUSQUEDAXUSUARIO",
    joinColumns = @JoinColumn(name="codigousuario"),
    inverseJoinColumns = @JoinColumn(name="codigobusqueda"))
    private List<Busquedas> BusquedasRealizadas;

    @OneToOne (mappedBy = "usuarioPerfil")
    private Perfiles perfilUsuario; 

    //@JsonBackReference("utab")
    @JsonIgnore
    @OneToMany(mappedBy = "usuarioCreadorTablero")
    private List<Tableros> tablerosCreados ;

    //@JsonBackReference("upin")
    @JsonIgnore
    @OneToMany(mappedBy = "usuarioPin")
    private List<Pines> pinesCreados;

    //@JsonManagedReference("ucon")
    @OneToMany(mappedBy = "usuarioEmisorComentario")
    private List<Comentarios> comentariosUsuario;
    
    //@JsonManagedReference("umenenv")
    @OneToMany(mappedBy = "usuarioEmisorMensaje")
    private List<Mensajes> mensajesEnviados;

    //@JsonManagedReference("umenrec")
    @OneToMany(mappedBy = "usuarioReceptorMensaje")
    private List<Mensajes> mensajesRecibidos;

    @JsonBackReference("ubusqueda")
    @OneToMany(mappedBy = "usuarioBusqueda")
    private List<Busquedas> busquedaUsuarios;
}
