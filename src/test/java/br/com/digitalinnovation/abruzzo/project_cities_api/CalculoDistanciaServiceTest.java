package br.com.digitalinnovation.abruzzo.project_cities_api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.data.Offset.offset;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.BDDMockito.given;


import java.util.Arrays;
import java.util.List;

import br.com.digitalinnovation.abruzzo.project_cities_api.dao.CityRepository;
import br.com.digitalinnovation.abruzzo.project_cities_api.model.City;
import br.com.digitalinnovation.abruzzo.project_cities_api.services.CalculoDistanciaService;
import br.com.digitalinnovation.abruzzo.project_cities_api.services.EarthRadius;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.geo.Point;

@SpringBootTest
class CalculoDistanciaServiceTest {

    @Autowired
    private CalculoDistanciaService service;

    @MockBean
    private CityRepository cityRepository;

    private City saoCarlos;
    private City ibate;

    @BeforeEach
    public void setUp() {
        ibate = new City(4929L, "Ibaté", 26, 3519303, "-21.95840072631836,-47.98820114135742", new Point(-21.95840072631836, -47.98820114135742));
        saoCarlos = new City(5254L, "São Carlos", 26, 3548906, "-22.01740074157715,-47.88600158691406", new Point(-22.01740074157715, -47.88600158691406));
    }

    @Test
    public void deveriaCalcularDistanciaUsandoMatematicaPuraPelosIdsCidadesMetros() {
        given(cityRepository.findAllById(anyList())).willReturn(Arrays.asList(ibate, saoCarlos));
        Double distance = this.service.calculaDistanciaEntreCidadesUsandoMatematicaPura(4929L, 5254L, EarthRadius.METERS);
        assertThat(distance).isEqualTo(12426.810463475855);
    }

    @Test
    public void deveriaCalcularDistanciaUsandoMatematicaPuraPelosIdsCidadesPorKM() {
        given(cityRepository.findAllById(anyList())).willReturn(Arrays.asList(ibate, saoCarlos));
        Double distance = service.calculaDistanciaEntreCidadesUsandoMatematicaPura(4929L, 5254L, EarthRadius.KILOMETERS);
        assertThat(distance).isCloseTo(12.426, offset(0.001d));
    }

    @Test
    public void deveriaCalcularDistanciaUsandoMatematicaPuraPelosIdsCidadesPorMilhas() {
        given(cityRepository.findAllById(anyList())).willReturn(Arrays.asList(ibate, saoCarlos));
        Double distance = service.calculaDistanciaEntreCidadesUsandoMatematicaPura(4929L, 5254L, EarthRadius.MILES);
        assertThat(distance).isCloseTo(7.71, offset(0.01d));
    }


    @Test
    public void deveriaCalcularDistanciaUsandoMatematicaPuraPelosNomesCidadesMetros() {
        List<City> cidades = cityRepository.findCitiesByName("Ibaté", "São Carlos");
        Double distance = this.service.calculaDistanciaEntreCidadesUsandoMatematicaPura(
                cidades.get(0).getNome(),
                cidades.get(1).getNome(), EarthRadius.METERS);
        assertThat(distance).isEqualTo(12426.810463475855);
    }


    @Test
    public void deveriaCalcularDistanciaUsandoMatematicaPuraPelosNomesCidadesPorKM() {
        List<City> cidades = cityRepository.findCitiesByName("Ibaté", "São Carlos");
        Double distance = this.service.calculaDistanciaEntreCidadesUsandoMatematicaPura(cidades.get(0).getNome(),
                cidades.get(1).getNome(), EarthRadius.KILOMETERS);
        assertThat(distance).isEqualTo(12426.810463475855);
    }


    @Test
    public void deveriaCalcularDistanciaUsandoMatematicaPuraPelosNomesCidadesPorMilhas() {
        List<City> cidades = cityRepository.findCitiesByName("Ibaté", "São Carlos");
        Double distance = this.service.calculaDistanciaEntreCidadesUsandoMatematicaPura(
                cidades.get(0).getNome(),
                cidades.get(1).getNome(),
                EarthRadius.MILES);
        assertThat(distance).isCloseTo(7.71, offset(0.01d));
    }


    @Test
    public void deveriaCalcularDistanciaPorPontosKM() {
        given(cityRepository.findAllById(anyList())).willReturn(Arrays.asList(ibate, saoCarlos));
        Double distance = service.calculaDistanciaEntreCidades_ByPostgresExtension_EarthDistance(4929L, 5254L);
        assertThat(distance).isEqualTo(12426.810463475855);
    }

}