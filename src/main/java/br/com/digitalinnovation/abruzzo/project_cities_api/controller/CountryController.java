/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.digitalinnovation.abruzzo.project_cities_api.controller;

import br.com.digitalinnovation.abruzzo.project_cities_api.DAO.CountryRepository;
import br.com.digitalinnovation.abruzzo.project_cities_api.MODEL.Pais;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public List<Pais> findAll(){

        return repository.findAll();

    }
}
