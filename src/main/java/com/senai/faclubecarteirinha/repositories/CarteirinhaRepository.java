package com.senai.faclubecarteirinha.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.senai.faclubecarteirinha.models.Carteirinha;

@Repository
public interface CarteirinhaRepository extends CrudRepository<Carteirinha, Long> {

    Carteirinha findByCpf(@Param("cpf") String cpf);
    
}
