package hn.is501.proyecto.pinterest.entities;

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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="TBL_LUGARES")
public class Lugares {
    
    @Id
    @Column(name="codigolugar")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int CodigoLugar;
    
    @ManyToOne
    @JsonBackReference("lugtip")
    @JoinColumn(name = "codigotipolugar", referencedColumnName = "codigotipolugar")
    private TipoLugar tipoLugares;
    
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "codigolugarpadre", referencedColumnName = "codigolugar")
    private Lugares lugarPadre;

    @Column(name="nombrelugar")
    private String NombreLugar;

    @Column(name="latitud")
    private String Latitud;

    @Column(name="altitud")
    private String Altitud;

    @JsonManagedReference("ulugnac")
    @OneToMany(mappedBy = "lugarNacimiento")
    private List<Usuarios> lugarNacimientoUsuarios;

    @JsonManagedReference("ulugdom")
    @OneToMany(mappedBy = "lugarDomicilio")
    private List<Usuarios> lugarDomicilioUsuarios;

}
