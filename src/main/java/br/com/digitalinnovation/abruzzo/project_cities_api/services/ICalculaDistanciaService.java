package br.com.digitalinnovation.abruzzo.project_cities_api.services;

public interface ICalculaDistanciaService {

    Double calculaDistanciaEntreCidades_ByPostgresExtension_EarthDistance(Long idCidade1, Long idCidade2);
    Double calculaDistanciaEntreCidades_ByPostgresExtension_Cube(double x1, double y1, double x2, double y2);

}
