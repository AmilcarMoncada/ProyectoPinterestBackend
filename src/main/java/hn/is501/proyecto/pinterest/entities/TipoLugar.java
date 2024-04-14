package hn.is501.proyecto.pinterest.entities;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
    private int CodigoTipoLugar;

    @Column(name= "tipolugar")
    private String TipoLugar;

    @OneToMany(mappedBy = "tipoLugares")
    private List<Lugares> lugares;
}
