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

@Data
@Entity
@Table(name="TBL_TIPOLUGAR")
public class TipoLugar {
    
    @Id
    @Column(name = "codigotipolugar")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int CodigoTipoLugar;

    @Column(name= "tipolugar")
    private String TipoLugar;

    @JsonManagedReference("lugtip")
    @OneToMany(mappedBy = "tipoLugares")
    private List<Lugares> lugares;
}
