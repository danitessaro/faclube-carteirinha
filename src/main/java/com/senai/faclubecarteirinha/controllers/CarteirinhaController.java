package com.senai.faclubecarteirinha.controllers;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.faclubecarteirinha.models.Carteirinha;
import com.senai.faclubecarteirinha.services.CarteirinhaService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/faclube-carteirinha")
public class CarteirinhaController {
    CarteirinhaService service;
    
    public CarteirinhaController(CarteirinhaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Carteirinha>> getCarteirinhas() {
        List<Carteirinha> carteirinhas = this.service.getCarteirinhas();
        return new ResponseEntity<>(carteirinhas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carteirinha> getCarteirinha(@PathVariable Long id) {
        return new ResponseEntity<>(this.service.getCarteirinhaById(id), HttpStatus.OK);
    }


    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<Carteirinha> getCarteirinha(@PathVariable String cpf) {
        return new ResponseEntity<>(this.service.getCarteirinhaByCpf(cpf), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Carteirinha> saveCarteirinha(@RequestBody Carteirinha carteirinha) {
        Carteirinha carteirinhaSave = this.service.save(carteirinha);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("carteirinha", "/faclube-carteirinha" + carteirinhaSave.getId().toString());
        return new ResponseEntity<>(carteirinhaSave, httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carteirinha> updateCarteirinha(@PathVariable Long id, @RequestBody Carteirinha carteirinha) {
        this.service.update(id, carteirinha);
        return new ResponseEntity<>(this.service.getCarteirinhaById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Carteirinha> deleteCarteirinha(@PathVariable Long id) {
        this.service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    
}
