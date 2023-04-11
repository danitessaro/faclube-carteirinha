package com.senai.faclubecarteirinha.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.senai.faclubecarteirinha.models.Carteirinha;
import com.senai.faclubecarteirinha.repositories.CarteirinhaRepository;

@Service
public class CarteirinhaServiceImpl implements CarteirinhaService {
    CarteirinhaRepository repository;

    public CarteirinhaServiceImpl(CarteirinhaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Carteirinha> getCarteirinhas() {
        List<Carteirinha> carteirinhas = new ArrayList<>();
        this.repository.findAll().forEach(carteirinhas::add);
        return carteirinhas;
    }

    @Override
    public Carteirinha getCarteirinhaById(Long id) {
        return this.repository.findById(id).get();
    }

    @Override
    public Carteirinha getCarteirinhaByCpf(String cpf) {
        // if (cpf.isEmpty() || cpf.length() != 11) {
        //     // retorna erro
        // }
        return this.repository.findByCpf(cpf);
    }

    @Override
    public Carteirinha save(Carteirinha carteirinha) {
        return this.repository.save(carteirinha);
    }

    @Override
    public void update(Long id, Carteirinha carteirinha) {
        Carteirinha carteirinhaDb = this.repository.findById(id).get();
        carteirinhaDb.setNome(carteirinha.getNome());
        carteirinhaDb.setCpf(carteirinha.getCpf());
        carteirinhaDb.setDataNascimento(carteirinha.getDataNascimento());
        carteirinhaDb.setEnderecoCep(carteirinha.getEnderecoCep());
        carteirinhaDb.setEnderecoRua(carteirinha.getEnderecoRua());
        carteirinhaDb.setEnderecoNumero(carteirinha.getEnderecoNumero());
        carteirinhaDb.setEnderecoComplemento(carteirinha.getEnderecoComplemento());
        carteirinhaDb.setEnderecoBairro(carteirinha.getEnderecoBairro());
        carteirinhaDb.setEnderecoCidade(carteirinha.getEnderecoCidade());
        carteirinhaDb.setEnderecoUf(carteirinha.getEnderecoUf());
        this.repository.save(carteirinhaDb);
    }

    @Override
    public void delete(Long id) {
        this.repository.deleteById(id);
    }


    
}
