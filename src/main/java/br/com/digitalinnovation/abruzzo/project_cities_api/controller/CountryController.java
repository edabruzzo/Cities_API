/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.digitalinnovation.abruzzo.project_cities_api.controller;

import br.com.digitalinnovation.abruzzo.project_cities_api.dao.CountryRepository;
import br.com.digitalinnovation.abruzzo.project_cities_api.model.Country;
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
@RequestMapping({"/countries"})
public class CountryController {

    @Autowired
    private CountryRepository repository;

    @GetMapping
    public Page<Country> findAll(Pageable pageable) {
        return (Page<Country>) this.repository.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity findCountryById(@PathVariable Long id) {
        Optional<Country> optional = this.repository.findById(id);
        if (optional.isPresent()) return ResponseEntity.ok().body(optional.get());
        else return (ResponseEntity) ResponseEntity.notFound().build();
    }

}
