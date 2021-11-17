package br.com.digitalinnovation.abruzzo.project_cities_api.services;

import br.com.digitalinnovation.abruzzo.project_cities_api.dao.CityRepository;
import br.com.digitalinnovation.abruzzo.project_cities_api.model.City;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CalculoDistanciaServiceTest_REST_Calls {

    @Mock
    private RestTemplate restTemplate;

    @Autowired
    private CityRepository cityRepository;

    @InjectMocks
    private CalculoDistanciaService service = new CalculoDistanciaService();

    //@Test
    public void quandoFazUmaChamadaParaApiComMockitoDeveriaCalcularADistanciaPorCube() {
        Double distancia = 12750470.8979053;
        Mockito.when(restTemplate.getForEntity("http://localhost:8080/distances/by-cube?x1=-25.4195003509521&y1=-49.2645988464355&x2=-2.5419500350952e+17&y2=-4.92645988464354e+17",
                        Double.class))
                .thenReturn(new ResponseEntity(distancia, HttpStatus.OK));
        assertThat(distancia).isEqualTo(12750470.8979053);
    }


    //@Test
    public void quandoFazUmaChamadaParaApiComMockitoDeveriaDevolverListaCidadesPorRaio() {

        List<Object> listaCidadesProximas = cityRepository.retornaListaCidades_RaioDistancia_ByPoint("Curitiba",5.2);
        Mockito.when(restTemplate.getForEntity("http://localhost:8080/distances/Curitiba/5.2", List.class))
                .thenReturn(new ResponseEntity(listaCidadesProximas, HttpStatus.OK));
        assertThat(listaCidadesProximas.size()).isEqualTo(2);
    }


    //@Test
    public void quandoFazUmaChamadaParaApiComMockitoDeveriaCalcularADistanciaPorPoyntsId() {
        Double distancia = 1882.24783482189;
        Mockito.when(restTemplate.getForEntity("http://localhost:8080/distances/by-points?from=616&to=278",
                        Double.class))
                .thenReturn(new ResponseEntity(distancia, HttpStatus.OK));
        assertThat(distancia).isEqualTo(1882.24783482189);
    }




}
