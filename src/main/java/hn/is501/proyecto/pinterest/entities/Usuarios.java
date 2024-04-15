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
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="TBL_USUARIOS")
public class Usuarios {
    
    @Id
    @Column(name="codigousuario")
    private int CodigoUsuario;

    @Column(name="nombres")
    private String Nombres;

    @Column(name="apellidos")
    private String Apellidos;

    @Column(name="correo")
    private String Correo;

    @Column(name="fechanacimiento")
    private LocalDate FechaNacimiento;

    @ManyToOne
    @JoinColumn(name = "codigolugarnacimiento", referencedColumnName = "codigolugar")
    private Lugares lugarNacimiento;

    @Column(name="fechacreacioncuenta")
    private LocalDate FechaCreacionCuenta;

    @ManyToOne
    @JoinColumn(name = "codigolugardomicilio", referencedColumnName = "codigolugar")
    private Lugares lugarDomicilio;

    @ManyToOne
    @JoinColumn(name = "codigotrabajoactual", referencedColumnName = "codigotrabajo")
    private Trabajos trabajoActual;

    @ManyToOne
    @JoinColumn(name = "codigotrabajoanterior", referencedColumnName = "codigotrabajo")
    private Trabajos trabajoAnterior;

    @Column(name="genero")
    private String Genero;

    @ManyToOne
    @JoinColumn(name = "codigoestadocivil", referencedColumnName = "codigoestadocivil")
    private EstadoCivil estadoCivilUsuario;

    @OneToMany(mappedBy = "usuarioSeguido")
    private List<Seguidores> usuariosSeguidos;

    @OneToMany(mappedBy = "usuarioSeguidor")
    private List<Seguidores> usuariosSeguidores;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="TBL_BUSQUEDAXUSUARIO",
    joinColumns = @JoinColumn(name="codigousuario"),
    inverseJoinColumns = @JoinColumn(name="codigobusqueda"))
    private List<Busquedas> BusquedasRealizadas;

    @OneToOne (mappedBy = "usuarioPerfil")
    private Perfiles perfilUsuario; 

    @OneToMany(mappedBy = "usuarioCreadorTablero")
    private List<Tableros> tablerosCreados ;

    @OneToMany(mappedBy = "usuarioTableroGrupal")
    private List<TablerosGrupales> tablerosGrupalesCreados;

    @OneToMany(mappedBy = "usuarioPin")
    private List<Pines> pinesCreados;

    @OneToMany(mappedBy = "usuarioEmisorComentario")
    private List<Comentarios> comentariosUsuario;
    
    @OneToMany(mappedBy = "usuarioEmisorMensaje")
    private List<Mensajes> mensajesEnviados;

    @OneToMany(mappedBy = "usuarioReceptorMensaje")
    private List<Mensajes> mensajesRecibidos;
}
