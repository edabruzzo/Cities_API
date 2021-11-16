package br.com.digitalinnovation.abruzzo.project_cities_api.controller;


import br.com.digitalinnovation.abruzzo.project_cities_api.model.City;
import br.com.digitalinnovation.abruzzo.project_cities_api.services.CalculoDistanciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/distances"})
public class DistanciaController {

    @Autowired
    private CalculoDistanciaService calculoDistanciaService;


    @GetMapping("/{nomeCidadeFrom}/{raioDistancia}")
    public ResponseEntity<Object> retornaListaCidades_RaioDistancia_ByPoint(@PathVariable(name = "nomeCidadeFrom") String nomeCidadeFrom,
                                                                @PathVariable(name = "raioDistancia") String raioDistancia) {
        double raioDistanciaParsed = Double.parseDouble(raioDistancia);
        List<Object> resposta = calculoDistanciaService.retornaListaCidades_RaioDistancia_ByPoint(nomeCidadeFrom, raioDistanciaParsed);
        if (resposta.size()>0) return ResponseEntity.ok().body(resposta);
        else return (ResponseEntity) ResponseEntity.notFound().build();


    }


    @GetMapping("/by-points")
    public Double calculaDistanciaEntreCidades_ByPostgresExtension_EarthDistance(@RequestParam(name = "from") final Long idCidade1,
                                                                                 @RequestParam(name = "to") final Long idCidade2) {
        return calculoDistanciaService.calculaDistanciaEntreCidades_ByPostgresExtension_EarthDistance(idCidade1, idCidade2);
    }


    @GetMapping("/by-cube")
    public Double calculaDistanciaEntreCidades_ByPostgresExtension_Cube(@RequestParam(name = "x1") double x1,
                                                                        @RequestParam(name = "y1") double y1,
                                                                        @RequestParam(name = "x2") double x2,
                                                                        @RequestParam(name = "y2") double y2) {
        return calculoDistanciaService.calculaDistanciaEntreCidades_ByPostgresExtension_Cube(x1, y1, x2, y2);
    }


}
