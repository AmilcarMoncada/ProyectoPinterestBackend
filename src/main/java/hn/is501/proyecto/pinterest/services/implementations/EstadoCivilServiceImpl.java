package hn.is501.proyecto.pinterest.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.is501.proyecto.pinterest.entities.EstadoCivil;
import hn.is501.proyecto.pinterest.repositories.EstadoCivilRepository;
import hn.is501.proyecto.pinterest.services.EstadoCivilService;

@Service
public class EstadoCivilServiceImpl implements EstadoCivilService{

    @Autowired
    private EstadoCivilRepository estadoCivilRepository;

    @Override
    public EstadoCivil CrearEstadoCivil(EstadoCivil estadoCivil) {
        return this.estadoCivilRepository.save(estadoCivil);
    }
    
}
