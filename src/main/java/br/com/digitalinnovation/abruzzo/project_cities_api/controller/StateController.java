/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.digitalinnovation.abruzzo.project_cities_api.controller;

import br.com.digitalinnovation.abruzzo.project_cities_api.DAO.StateRepository;
import br.com.digitalinnovation.abruzzo.project_cities_api.MODEL.Estado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Page;

import java.util.Optional;

/**
 * @author emmanuel
 */

@RestController
@RequestMapping({"/states"})
public class StateController {

    @Autowired
    private StateRepository repository;

    @GetMapping
    public Page<Estado> findAll(Pageable pageable) {
        return (Page<Estado>) this.repository.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity findEstateById(@PathVariable Long id) {
        Optional<Estado> optional = this.repository.findById(id);
        if (optional.isPresent()) return ResponseEntity.ok().body(optional.get());
        else return (ResponseEntity) ResponseEntity.notFound().build();
    }

}
