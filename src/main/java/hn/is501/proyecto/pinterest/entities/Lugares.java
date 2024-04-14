package hn.is501.proyecto.pinterest.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
    private int CodigoLugar;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "codigotipolugar", referencedColumnName = "codigotipolugar")
    private TipoLugar tipoLugares;
    
    @ManyToOne
    @JoinColumn(name = "codigolugarpadre", referencedColumnName = "codigolugar")
    private Lugares lugarPadre;

    @Column(name="nombrelugar")
    private String NombreLugar;

    @Column(name="latitud")
    private String Latitud;

    @Column(name="altitud")
    private String Altitud;

    @OneToMany(mappedBy = "lugarNacimiento")
    private List<Usuarios> lugarNacimientoUsuarios;

    @OneToMany(mappedBy = "lugarDomicilio")
    private List<Usuarios> lugarDomicilioUsuarios;

}
