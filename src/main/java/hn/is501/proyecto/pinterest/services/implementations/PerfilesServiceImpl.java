package hn.is501.proyecto.pinterest.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.is501.proyecto.pinterest.entities.Perfiles;
import hn.is501.proyecto.pinterest.repositories.PerfilesRepository;
import hn.is501.proyecto.pinterest.services.PerfilesService;

@Service
public class PerfilesServiceImpl implements PerfilesService{

  @Autowired
private PerfilesRepository perfilesRepository;

    @Override
    public List<Perfiles> mostrarPerfiles() {
        return (List<Perfiles>) this.perfilesRepository.findAll();
    }
    
    
}
