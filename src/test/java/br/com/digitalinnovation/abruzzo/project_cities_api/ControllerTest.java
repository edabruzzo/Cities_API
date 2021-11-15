package br.com.digitalinnovation.abruzzo.project_cities_api;

import br.com.digitalinnovation.abruzzo.project_cities_api.MODEL.Country;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ControllerTest extends AbstractControllerTest{

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void getCountriesList() throws Exception {
        String uri = "/countries";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Country[] Countrylist = super.mapFromJson(content, Country[].class);
        assertTrue(Countrylist.length > 0);
    }


    @Test
    public void createCountry() throws Exception {
        String uri = "/countries";
        Country Country = new Country();
        Country.setId(264L);
        Country.setNome("Conchinchina");
        String inputJson = super.mapToJson(Country);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "O país foi criado com sucesso");
    }
    @Test
    public void updateCountry() throws Exception {
        String uri = "/Countries/264";
        Country Country = new Country();
        Country.setNome("Moldavia");
        String inputJson = super.mapToJson(Country);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "O País foi atualizado com sucesso!");
    }


    @Test
    public void deleteCountry() throws Exception {
        String uri = "/country/264";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "País foi deletado com sucesso !");
    }

}
