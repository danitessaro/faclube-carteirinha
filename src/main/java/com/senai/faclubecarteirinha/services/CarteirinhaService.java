package com.senai.faclubecarteirinha.services;

import java.util.List;

import com.senai.faclubecarteirinha.models.Carteirinha;

public interface CarteirinhaService {

    List<Carteirinha> getCarteirinhas();

    Carteirinha getCarteirinhaById(Long id);

    Carteirinha getCarteirinhaByCpf(String cpf);

    Carteirinha save(Carteirinha carteirinha);

    void update(Long id, Carteirinha carteirinha);

    void delete(Long id);
    
    
}
