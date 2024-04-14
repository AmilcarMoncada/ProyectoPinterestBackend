package hn.is501.proyecto.pinterest.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="TBL_TIPOSDEPERFILES")
public class TipoPerfil {
    
    @Id
    @Column(name="codigotipoperfil")
    private int CodigoTipoPerfil;


    @Column(name="tipoperfil")
    private String TipoPerfil;

    @Column(name="descripciontipoperfil")
    private String DescripcionnTipoPerfil;

    @OneToMany(mappedBy = "tipoPerfil")
    private List<Perfiles> TipoPerfiles; 

}
