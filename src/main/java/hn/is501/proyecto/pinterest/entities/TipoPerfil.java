package hn.is501.proyecto.pinterest.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int CodigoTipoPerfil;

    @Column(name="tipoperfil")
    private String TipoPerfil;

    @Column(name="descripciontipoperfil")
    private String DescripcionnTipoPerfil;

      @JsonManagedReference("pertip")
    @OneToMany(mappedBy = "tipoPerfil")
    private List<Perfiles> TipoPerfiles; 

}
