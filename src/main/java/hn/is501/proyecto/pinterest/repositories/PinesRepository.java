package hn.is501.proyecto.pinterest.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hn.is501.proyecto.pinterest.entities.Pines;

@Repository
public interface PinesRepository extends CrudRepository<Pines, Integer>{
    
}
