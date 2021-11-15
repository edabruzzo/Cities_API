package br.com.digitalinnovation.abruzzo.project_cities_api.controller;


import br.com.digitalinnovation.abruzzo.project_cities_api.services.CalculoDistanciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/distances"})
public class DistanciaController {

    @Autowired
    private CalculoDistanciaService calculoDistanciaService;


    @GetMapping("/by-points")
    public Double calculaDistanciaEntreCidades_ByPostgresExtension_EarthDistance(@RequestParam(name = "from") final Long idCidade1,
                                                                                 @RequestParam(name = "to") final Long idCidade2) {
        return calculoDistanciaService.calculaDistanciaEntreCidades_ByPostgresExtension_EarthDistance(idCidade1, idCidade2);
    }


    @GetMapping("/by-cube")
    public Double calculaDistanciaEntreCidades_ByPostgresExtension_Cube(@RequestParam(name = "x1") double x1,
                                                                        @RequestParam(name = "y1") double y1,
                                                                        @RequestParam(name = "x2") double x2,
                                                                        @RequestParam(name = "y2") double y2){
        return calculoDistanciaService.calculaDistanciaEntreCidades_ByPostgresExtension_Cube(x1, y1, x2, y2);
    }


}
