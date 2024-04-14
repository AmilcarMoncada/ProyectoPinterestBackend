package hn.is501.proyecto.pinterest.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name= "TBL_ESTADOPIN")
public class EstadoPin {
    
    @Id
    @Column(name="codigoestadopin")
    private int CodigoEstadoPin;

    @Column(name="estadopin")
    private String EstadoPin;
    
}
