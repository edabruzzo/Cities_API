/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.digitalinnovation.abruzzo.project_cities_api.controller;

import br.com.digitalinnovation.abruzzo.project_cities_api.DAO.CountryRepository;
import br.com.digitalinnovation.abruzzo.project_cities_api.MODEL.Country;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Page;

import java.util.Optional;

/**
 *
 * @author emmanuel
 */

@RestController
@RequestMapping({"/countries"})
public class CountryController {

    private CountryRepository repository;

    public CountryController(CountryRepository countryRepository) {
        this.repository = countryRepository;
    }

    @GetMapping
    public Page<Country> findAll(Pageable pageable){
        return (Page<Country>) repository.findAll(pageable);
    }

    @GetMapping("/{id}")
    public Country findCountryById(@PathVariable Long id){
        Optional<Country> optional = Optional.of(repository.getById(id));
        return optional.get();
    }

}
