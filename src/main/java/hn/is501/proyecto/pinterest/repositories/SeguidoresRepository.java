package hn.is501.proyecto.pinterest.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hn.is501.proyecto.pinterest.entities.Seguidores;

@Repository
public interface SeguidoresRepository extends CrudRepository<Seguidores, Integer>{
    
}
