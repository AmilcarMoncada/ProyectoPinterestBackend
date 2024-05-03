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
@Table(name= "TBL_ESTADOPIN")
public class EstadoPin {
    
    @Id
    @Column(name="codigoestadopin")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int CodigoEstadoPin;

    @Column(name="estadopin")
    private String EstadoPin;
    
    @JsonManagedReference("pinest")
    @OneToMany(mappedBy = "estadoPin")
    private List<Pines> pines;
}
